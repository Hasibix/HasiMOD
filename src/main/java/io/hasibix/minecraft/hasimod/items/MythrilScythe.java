package io.hasibix.minecraft.hasimod.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;

import io.hasibix.minecraft.hasimod.init.Items;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtByte;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtInt;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MythrilScythe extends SwordItem {
	private List<StatusEffectInstance> effects = new ArrayList<>();

	public List<StatusEffectInstance> getEffects() {
		return effects;
	}

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
	}

	@Override
	public void postProcessNbt(NbtCompound nbt) {
		this.effects = getEffectsFromNbt(nbt);
	}

	private static List<StatusEffectInstance> getEffectsFromNbt(NbtCompound tag) {
		List<StatusEffectInstance> effects = new ArrayList<>();
		if (tag != null && tag.contains("CustomPotionEffects")) {
			NbtList effectsTag = tag.getList("CustomPotionEffects", 10);
			for (int i = 0; i < effectsTag.size(); i++) {
				NbtCompound effectTag = effectsTag.getCompound(i);
				if (effectTag.contains("Id")) {
					Identifier effectId = null;
					int amplifier = 0;
					int duration = 20;
					boolean ambient = false;
					boolean showParticles = true;
					boolean showIcon = true;
					if (effectTag.contains("Id")) {
						if (effectTag.get("Id") instanceof NbtString) {
							effectId = Identifier.tryParse(effectTag.getString("Id"));
						}
					}
					if (effectTag.contains("Amplifier")) {
						if (effectTag.get("Amplifier") instanceof NbtInt) {
							amplifier = effectTag.getInt("Amplifier");
						}
					}
					if (effectTag.contains("Duration")) {
						if (effectTag.get("Duration") instanceof NbtInt) {
							duration = effectTag.getInt("Duration");
						}
					}
					if (effectTag.contains("Ambient")) {
						if (effectTag.get("Ambient") instanceof NbtByte) {
							ambient = effectTag.getBoolean("Ambient");
						}
					}
					if (effectTag.contains("ShowParticles")) {
						if (effectTag.get("ShowParticles") instanceof NbtByte) {
							showParticles = effectTag.getBoolean("ShowParticles");
						}
					}
					if (effectTag.contains("ShowIcon")) {
						if (effectTag.get("ShowIcon") instanceof NbtByte) {
							showIcon = effectTag.getBoolean("ShowIcon");
						}
					}
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
		buildTooltip(this.effects, tooltip, Text.translatable("effect.none").formatted(Formatting.GRAY));
	}

	@SuppressWarnings("rawtypes")
	private static void buildTooltip(List<StatusEffectInstance> statusEffects, List<Text> list, Text NONE_TEXT) {
		ArrayList<Pair<EntityAttribute, EntityAttributeModifier>> list2 = Lists.newArrayList();
		if (statusEffects.isEmpty()) {
			list.add(NONE_TEXT);
		} else {
			for (StatusEffectInstance statusEffectInstance : statusEffects) {
				MutableText mutableText = Text.translatable(statusEffectInstance.getTranslationKey());
				StatusEffect statusEffect = statusEffectInstance.getEffectType();
				Map<EntityAttribute, EntityAttributeModifier> map = statusEffect.getAttributeModifiers();
				if (!map.isEmpty()) {
					for (Map.Entry<EntityAttribute, EntityAttributeModifier> entry : map.entrySet()) {
						EntityAttributeModifier entityAttributeModifier = entry.getValue();
						EntityAttributeModifier entityAttributeModifier2 = new EntityAttributeModifier(
								entityAttributeModifier.getName(),
								statusEffect.adjustModifierAmount(statusEffectInstance.getAmplifier(),
										entityAttributeModifier),
								entityAttributeModifier.getOperation());
						list2.add(new Pair<EntityAttribute, EntityAttributeModifier>(entry.getKey(),
								entityAttributeModifier2));
					}
				}
				if (statusEffectInstance.getAmplifier() > 0) {
					mutableText = Text.translatable("potion.withAmplifier", mutableText,
							Text.translatable("potion.potency." + (statusEffectInstance.getAmplifier() + 1)));
				}
				if (statusEffectInstance.getDuration() > 20) {
					mutableText = Text.translatable("potion.withDuration", mutableText, StatusEffectUtil
							.durationToString(statusEffectInstance, statusEffectInstance.getDuration() / 20));
				}
				list.add(mutableText.formatted(statusEffect.getCategory().getFormatting()));
			}
		}
		if (!list2.isEmpty()) {
			list.add(ScreenTexts.EMPTY);
			list.add(Text.translatable("potion.whenDrank").formatted(Formatting.DARK_PURPLE));
			for (Pair pair : list2) {
				EntityAttributeModifier entityAttributeModifier3 = (EntityAttributeModifier) pair.getSecond();
				double d = entityAttributeModifier3.getValue();
				double e = entityAttributeModifier3.getOperation() == EntityAttributeModifier.Operation.MULTIPLY_BASE
						|| entityAttributeModifier3.getOperation() == EntityAttributeModifier.Operation.MULTIPLY_TOTAL
								? entityAttributeModifier3.getValue() * 100.0
								: entityAttributeModifier3.getValue();
				if (d > 0.0) {
					list.add(Text
							.translatable("attribute.modifier.plus." + entityAttributeModifier3.getOperation().getId(),
									ItemStack.MODIFIER_FORMAT.format(e),
									Text.translatable(((EntityAttribute) pair.getFirst()).getTranslationKey()))
							.formatted(Formatting.BLUE));
					continue;
				}
				if (!(d < 0.0))
					continue;
				list.add(Text
						.translatable("attribute.modifier.take." + entityAttributeModifier3.getOperation().getId(),
								ItemStack.MODIFIER_FORMAT.format(e *= -1.0),
								Text.translatable(((EntityAttribute) pair.getFirst()).getTranslationKey()))
						.formatted(Formatting.RED));
			}
		}
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
				for (int i = 0; i < 40; i++) {
					float value = -1F + (i * 0.05F);
					io.hasibix.minecraft.hasimod.projectiles.ScytheBlade scytheBlade = new io.hasibix.minecraft.hasimod.projectiles.ScytheBlade(
							world, user);
					scytheBlade.setEffects(this.effects);
					scytheBlade.setDamageAmount(16);
					scytheBlade.setCreateExplosion(5);
					scytheBlade.setVelocity(user, user.getPitch(), (user.getYaw() * value), 0.0F, 1.5F, 0F);
					world.spawnEntity(scytheBlade);
				}
			}

			user.incrementStat(Stats.USED.getOrCreateStat(this));
			if (!user.getAbilities().creativeMode) {
				itemStack.setDamage(itemStack.getDamage() + 16);
			}

			return TypedActionResult.success(itemStack, world.isClient());
		}
		return super.use(world, entity, hand);
	}
}
