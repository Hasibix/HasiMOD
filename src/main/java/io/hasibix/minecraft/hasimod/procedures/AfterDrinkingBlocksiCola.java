package io.hasibix.minecraft.hasimod.procedures;

import java.util.Map;

import io.hasibix.minecraft.hasimod.HasiMOD;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class AfterDrinkingBlocksiCola {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HasiMOD.LOGGER.warn("Failed to load dependency entity for procedure AfterDrinkingBlocksiCola!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 80, 5, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 24000, 10, (false), (false)));
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 24000, 10, (false), (false)));
	}
}
