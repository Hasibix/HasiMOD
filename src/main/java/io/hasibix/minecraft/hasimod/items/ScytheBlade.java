package io.hasibix.minecraft.hasimod.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.Registries;
import net.minecraft.screen.ScreenTexts;
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
import net.minecraft.world.World;

public class ScytheBlade extends Item {
	private List<StatusEffectInstance> effects = new ArrayList<>();

	public List<StatusEffectInstance> getEffects() {
		return effects;
	}

	public ScytheBlade() {
		super(new Item.Settings().maxCount(16).rarity(Rarity.RARE));
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
							Text.translatable("potion.potency." + statusEffectInstance.getAmplifier()));
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
				scytheBlade.readNbtFromEffectList(this.effects);
				scytheBlade.setDamageAmount(16);
				scytheBlade.setCreateExplosion(false);
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
