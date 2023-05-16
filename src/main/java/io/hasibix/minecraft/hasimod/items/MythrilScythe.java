package io.hasibix.minecraft.hasimod.items;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import io.hasibix.minecraft.hasimod.init.Items;
import io.hasibix.minecraft.hasimod.procedures.MythrilScytheLivingEntityIsHitWithTool;
import io.hasibix.minecraft.hasimod.procedures.MythrilScytheRightclicked;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MythrilScythe extends SwordItem {
	public List<StatusEffectInstance> effects = new ArrayList<>();
	public MythrilScythe() {
		super(new ToolMaterial() {
			@Override
			public int getDurability() {
				return 6280;
			}

			@Override
			public float getMiningSpeedMultiplier() {
				return 24f;
			}

			@Override
			public float getAttackDamage() {
				return 148f;
			}

			@Override
			public int getMiningLevel() {
				return 20;
			}

			@Override
			public int getEnchantability() {
				return 140;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.ofStacks(new ItemStack(Items.MYTHRIL_GEM));
			}
		}, 3, 96f, new Item.Settings().fireproof().rarity(Rarity.EPIC));
		this.effects = getEffectsFromNbt(this.getDefaultStack()) != null  ? getEffectsFromNbt(this.getDefaultStack()) : this.effects;
	}
	
	@Nullable
	public static List<StatusEffectInstance> getEffectsFromNbt(ItemStack itemStack) {
		NbtCompound tag = itemStack.getNbt();
		List<StatusEffectInstance> effects = new ArrayList<>();
		if (tag != null && tag.contains("Effects")) {
			NbtList effectsTag = tag.getList("Effects", 10);
			for (int i = 0; i < effectsTag.size(); i++) {
				NbtCompound effectTag = effectsTag.getCompound(i);
				Identifier effectId = null;
				int amplifier = 0;
				int duration = 0;
				boolean ambient = false;
				boolean showParticles = false;
				boolean showIcon = false;
				if (effectTag.contains("Id")) {
					effectId = Identifier.tryParse(effectTag.getString("Id"));
				}
				if (effectTag.contains("Amplifier")) {
					amplifier = effectTag.getInt("Amplifier");
				}
				if (effectTag.contains("Duration")) {
					duration = effectTag.getInt("Duration");
				}
				if (effectTag.contains("Ambient")) {
					ambient = effectTag.getBoolean("Ambient");
				}
				if (effectTag.contains("ShowParticles")) {
					showParticles = effectTag.getBoolean("ShowParticles");
				}
				if (effectTag.contains("ShowIcon")) {
					showIcon = effectTag.getBoolean("ShowIcon");
				}
				if (effectId != null) {
					StatusEffectInstance effectInstance = new StatusEffectInstance(
							Registries.STATUS_EFFECT.get(effectId), duration, amplifier, ambient, showParticles,
							showIcon);
					effects.add(effectInstance);
				}
			}
		}
		return effects;
	}
	
	@Override
	public boolean postHit(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
		boolean retval = super.postHit(itemstack, target, attacker);
		double x = target.getX();
		double y = target.getY();
		double z = target.getZ();
		World world = target.world;
		MythrilScytheLivingEntityIsHitWithTool.execute(com.google.common.collect.ImmutableMap.<String, Object>builder()
				.put("world", world).put("x", x).put("y", y).put("z", z).build());
		return retval;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
		return MythrilScytheRightclicked.execute(this, hand,
				com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", entity.getX())
						.put("y", entity.getY()).put("z", entity.getZ()).put("world", world).put("entity", entity)
						.build());
	}
}
