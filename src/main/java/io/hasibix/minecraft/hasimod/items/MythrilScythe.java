package io.hasibix.minecraft.hasimod.items;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import io.hasibix.minecraft.hasimod.init.Items;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
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
		this.effects = getEffectsFromNbt(this.getDefaultStack()) != null ? getEffectsFromNbt(this.getDefaultStack())
				: this.effects;
	}

	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		PotionUtil.buildTooltip(stack, tooltip, 0.125f);
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
	public boolean postHit(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
		boolean retval = super.postHit(itemstack, target, attacker);
		double x = target.getX();
		double y = target.getY();
		double z = target.getZ();
		World world = target.world;
		if (world instanceof ServerWorld _level) {
			LightningEntity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
			entityToSpawn.move(MovementType.SELF, Vec3d.ofCenter(new BlockPos(x, y, z)));
			_level.spawnEntity(entityToSpawn);
		}
		Vec3d direction = target.getPos().subtract(attacker.getPos()).normalize();
		target.addVelocity(direction.getX() * -1.5, direction.getY() * -1.5, direction.getZ() * -1.5);
		return retval;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity user = (PlayerEntity) entity;
			ItemStack itemStack = user.getStackInHand(hand);
			world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE,
					SoundCategory.NEUTRAL, 0.5F, 1F);
			user.getItemCooldownManager().set(this, 20);
			if (!world.isClient) {
				for (float i = -1F; i < 1F; i += 0.05F) {
					io.hasibix.minecraft.hasimod.projectiles.ScytheBlade scytheBlade = new io.hasibix.minecraft.hasimod.projectiles.ScytheBlade(
							world, user);
					scytheBlade.damageAmount = 48;
					scytheBlade.effects = this.effects;
					scytheBlade.setVelocity(user, user.getPitch(), (user.getYaw() * i), 0.0F, 1.5F, 0F);
					world.spawnEntity(scytheBlade);
				}
			}

			user.incrementStat(Stats.USED.getOrCreateStat(this));
			if (!user.getAbilities().creativeMode) {
				itemStack.setDamage(itemStack.getDamage() + 16);
			}

			return TypedActionResult.success(itemStack, world.isClient());
		}
		return null;
	}
}
