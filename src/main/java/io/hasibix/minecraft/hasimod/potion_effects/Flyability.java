package io.hasibix.minecraft.hasimod.potion_effects;

import io.hasibix.minecraft.hasimod.procedures.FlyabilityEffectExpires;
import io.hasibix.minecraft.hasimod.procedures.FlyabilityEffectStarted;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;

public class Flyability extends StatusEffect {
	public Flyability() {
		super(
				StatusEffectCategory.BENEFICIAL,
				0x462E97
		);
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

		FlyabilityEffectStarted.execute(
				com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
	}

	@Override
	public void onRemoved(LivingEntity entity, AttributeContainer attributeContainer, int amplifier) {
		super.onRemoved(entity, attributeContainer, amplifier);
		World world = entity.world;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		FlyabilityEffectExpires.execute(
				com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
	}
}
