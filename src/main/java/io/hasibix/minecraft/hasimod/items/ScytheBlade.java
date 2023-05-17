package io.hasibix.minecraft.hasimod.items;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.potion.PotionUtil;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScytheBlade extends Item {
	public List<StatusEffectInstance> effects = new ArrayList<>();

	public ScytheBlade() {
		super(new Item.Settings().maxCount(16).rarity(Rarity.RARE));
		this.effects = getEffectsFromNbt(this.getDefaultStack()) != null ? getEffectsFromNbt(this.getDefaultStack())
				: this.effects;
	}

	@Nullable
	public static List<StatusEffectInstance> getEffectsFromNbt(ItemStack itemStack) {
		NbtCompound tag = itemStack.getNbt();
		List<StatusEffectInstance> effects = new ArrayList<>();
		if (tag != null && tag.contains("CustomPotionEffects")) {
			NbtList effectsTag = tag.getList("CustomPotionEffects", 10);
			for (int i = 0; i < effectsTag.size(); i++) {
				NbtCompound effectTag = effectsTag.getCompound(i);
				if (effectTag.contains("Id") && effectTag.contains("Amplifier") && effectTag.contains("Duration")
						&& effectTag.contains("Ambient") && effectTag.contains("ShowParticles")
						&& effectTag.contains("ShowIcon")) {
					Identifier effectId = Identifier.tryParse(effectTag.getString("Id"));
					int duration = effectTag.getInt("Duration");
					int amplifier = effectTag.getInt("Amplifier");
					boolean ambient = effectTag.getBoolean("Ambient");
					boolean showParticles = effectTag.getBoolean("ShowParticles");
					boolean showIcon = effectTag.getBoolean("ShowIcon");

					if (effectId != null) {
						StatusEffectInstance effectInstance = new StatusEffectInstance(
								Registries.STATUS_EFFECT.get(effectId), duration, amplifier, ambient, showParticles,
								showIcon);
						if (effectInstance != null) {
							effects.add(effectInstance);
						}
					}
				}
			}
		}
		return effects;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		PotionUtil.buildTooltip(stack, tooltip, 0.125f);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity user = (PlayerEntity) entity;
			ItemStack itemStack = user.getStackInHand(hand);
			world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE,
					SoundCategory.NEUTRAL, 0.5F, 1F);
			user.getItemCooldownManager().set(this, 5);
			if (!world.isClient) {
				io.hasibix.minecraft.hasimod.projectiles.ScytheBlade scytheBlade = new io.hasibix.minecraft.hasimod.projectiles.ScytheBlade(
						world, user);
				scytheBlade.effects = this.effects;
				scytheBlade.damageAmount = 16;
				scytheBlade.createExplosion = false;
				scytheBlade.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
				world.spawnEntity(scytheBlade);
			}

			user.incrementStat(Stats.USED.getOrCreateStat(this));
			if (!user.getAbilities().creativeMode) {
				itemStack.decrement(1);
			}

			return TypedActionResult.success(itemStack, world.isClient());
		}
		return null;
	}
}
