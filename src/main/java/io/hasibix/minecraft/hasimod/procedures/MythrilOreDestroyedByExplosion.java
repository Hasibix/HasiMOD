package io.hasibix.minecraft.hasimod.procedures;

import java.util.Map;

import io.hasibix.minecraft.hasimod.HasiMOD;
import io.hasibix.minecraft.hasimod.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MythrilOreDestroyedByExplosion {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HasiMOD.LOGGER.warn("Failed to load dependency world for procedure MythrilOreDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HasiMOD.LOGGER.warn("Failed to load dependency x for procedure MythrilOreDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HasiMOD.LOGGER.warn("Failed to load dependency y for procedure MythrilOreDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HasiMOD.LOGGER.warn("Failed to load dependency z for procedure MythrilOreDestroyedByExplosion!");
			return;
		}
		World world = (World) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x")
				: (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y")
				: (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z")
				: (double) dependencies.get("z");
		world.setBlockState(new BlockPos(x, y, z), Blocks.CRACKED_MYTHRIL_ORE.getDefaultState(), 3);
	}
}
