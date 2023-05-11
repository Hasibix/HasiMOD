package io.hasibix.minecraft.hasimod.procedures;

import java.util.Map;

import io.hasibix.minecraft.hasimod.HasiMOD;
import io.hasibix.minecraft.hasimod.init.PotionEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class AfterEatingMythrilApple {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HasiMOD.LOGGER.warn("Failed to load dependency entity for procedure AfterEatingMythrilApple!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 24000, 20, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 24000, 15, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 24000, 5, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST	, 24000, 5, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 24000, 20, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 24000, 50, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 24000, 15, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(PotionEffects.FLYABILITY, 24000, 1, (false), (false)));
	}
}
