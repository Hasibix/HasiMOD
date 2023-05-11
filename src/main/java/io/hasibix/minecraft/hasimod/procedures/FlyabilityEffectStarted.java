package io.hasibix.minecraft.hasimod.procedures;

import java.util.Map;

import io.hasibix.minecraft.hasimod.HasiMOD;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class FlyabilityEffectStarted {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HasiMOD.LOGGER.warn("Failed to load dependency entity for procedure FlyabilityEffectStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!(entity instanceof PlayerEntity _plr ? _plr.getAbilities().creativeMode : false)) {
			if (entity instanceof PlayerEntity _player) {
				_player.getAbilities().allowFlying = true;
				_player.sendAbilitiesUpdate();
			}
		}
	}
}
