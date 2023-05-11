package io.hasibix.minecraft.hasimod.procedures;

import java.util.Map;

import io.hasibix.minecraft.hasimod.HasiMOD;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;

public class MythrilScytheRightclicked {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HasiMOD.LOGGER.warn("Failed to load dependency world for procedure MythrilScytheRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HasiMOD.LOGGER.warn("Failed to load dependency x for procedure MythrilScytheRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HasiMOD.LOGGER.warn("Failed to load dependency y for procedure MythrilScytheRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HasiMOD.LOGGER.warn("Failed to load dependency z for procedure MythrilScytheRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HasiMOD.LOGGER.warn("Failed to load dependency entity for procedure MythrilScytheRightclicked!");
			return;
		}
		World world = (World) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x")
				: (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y")
				: (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z")
				: (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		
		entity.damage(DamageSource.GENERIC, 2);
	}
}
