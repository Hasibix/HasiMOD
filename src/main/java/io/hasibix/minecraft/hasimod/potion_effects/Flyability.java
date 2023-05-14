package io.hasibix.minecraft.hasimod.potion_effects;

import java.util.Map;

import io.hasibix.minecraft.hasimod.procedures.FlyabilityEffectExpires;
import io.hasibix.minecraft.hasimod.procedures.FlyabilityEffectUpdateTick;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;

public class Flyability extends StatusEffect {
	public boolean isAlreadyAllowedToFly = false;
	public boolean creativeModeUpdated = false;

	public Flyability() {
		super(StatusEffectCategory.BENEFICIAL, 0x462E97);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		World world = entity.world;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		Map<String, Boolean> newValues = FlyabilityEffectUpdateTick.execute(
				com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build(),
				this.isAlreadyAllowedToFly, this.creativeModeUpdated);
		this.isAlreadyAllowedToFly = newValues.get("isAlreadyAllowedToFly");
		this.creativeModeUpdated = newValues.get("creativeModeUpdated");
	}

	@Override
	public void onRemoved(LivingEntity entity, AttributeContainer attributeContainer, int amplifier) {
		super.onRemoved(entity, attributeContainer, amplifier);
		World world = entity.world;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		Map<String, Boolean> newValues = FlyabilityEffectExpires.execute(
				com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
		this.isAlreadyAllowedToFly = newValues.get("isAlreadyAllowedToFly");
		this.creativeModeUpdated = newValues.get("creativeModeUpdated");
	}
}
