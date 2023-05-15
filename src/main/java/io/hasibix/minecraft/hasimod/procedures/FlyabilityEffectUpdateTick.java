package io.hasibix.minecraft.hasimod.procedures;

import java.util.Map;

import io.hasibix.minecraft.hasimod.HasiMOD;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class FlyabilityEffectUpdateTick {
	public static Map<String, Boolean> execute(Map<String, Object> dependencies, boolean expired,
			boolean allowFlyingOld, boolean creativeModeOld) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HasiMOD.LOGGER.warn("Failed to load dependency entity for procedure FlyabilityEffectStartedapplied!");
			return null;
		}
		Entity entity = (Entity) dependencies.get("entity");
		PlayerEntity player = entity instanceof PlayerEntity ? (PlayerEntity) entity : null;
		boolean allowFlying = player != null ? player.getAbilities().allowFlying : false;
		boolean creativeMode = player != null ? player.getAbilities().creativeMode : false;

		if (!expired) {
			if (creativeModeOld != creativeMode && !creativeMode && !allowFlyingOld && !allowFlying) {
				player.getAbilities().allowFlying = true;
				player.sendAbilitiesUpdate();
				allowFlying = true;
			} else if (creativeModeOld != creativeMode && creativeMode && !allowFlyingOld && !allowFlying) {
				player.getAbilities().allowFlying = false;
				player.sendAbilitiesUpdate();
				allowFlying = false;
			}
		}

		Map<String, Boolean> map = com.google.common.collect.ImmutableMap.<String, Boolean>builder()
				.put("allowFlying", allowFlying).put("creativeMode", creativeMode).build();
		return map;
	}
}
