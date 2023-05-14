package io.hasibix.minecraft.hasimod.procedures;

import java.util.Map;

import io.hasibix.minecraft.hasimod.HasiMOD;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class FlyabilityEffectUpdateTick {
	public static Map<String, Boolean> execute(Map<String, Object> dependencies, boolean isAlreadyAllowedToFlyOld,
			boolean creativeModeUpdatedOld) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HasiMOD.LOGGER.warn("Failed to load dependency entity for procedure FlyabilityEffectStartedapplied!");
			return null;
		}
		boolean isAlreadyAllowedToFly = isAlreadyAllowedToFlyOld;
		boolean creativeModeUpdated = creativeModeUpdatedOld;
		Entity entity = (Entity) dependencies.get("entity");
		if (!(entity instanceof PlayerEntity _plr ? _plr.getAbilities().creativeMode : false) && !creativeModeUpdated) {
			creativeModeUpdated = true;
		} else {
			creativeModeUpdated = false;
		}
		if (creativeModeUpdated) {
			if (entity instanceof PlayerEntity _player) {
				if (_player.getAbilities().allowFlying == false && !isAlreadyAllowedToFly) {
					_player.getAbilities().allowFlying = true;
					_player.sendAbilitiesUpdate();
					isAlreadyAllowedToFly = true;
				}
			}
		}
		Map<String, Boolean> map = com.google.common.collect.ImmutableMap.<String, Boolean>builder()
				.put("isAlreadyAllowedToFly", isAlreadyAllowedToFly).put("creativeModeUpdated", creativeModeUpdated)
				.build();
		return map;
	}
}
