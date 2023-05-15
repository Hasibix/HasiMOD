package io.hasibix.minecraft.hasimod.procedures;

import java.util.Map;

import io.hasibix.minecraft.hasimod.HasiMOD;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScytheBladeRightclicked {

	public static TypedActionResult<ItemStack> execute(io.hasibix.minecraft.hasimod.items.ScytheBlade instance,
			Hand hand, Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HasiMOD.LOGGER.warn("Failed to load dependency entity for procedure MythrilScytheRightclicked!");
			return null;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HasiMOD.LOGGER.warn("Failed to load dependency world for procedure MythrilScytheRightclicked!");
			return null;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HasiMOD.LOGGER.warn("Failed to load dependency x for procedure MythrilScytheRightclicked!");
			return null;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HasiMOD.LOGGER.warn("Failed to load dependency y for procedure MythrilScytheRightclicked!");
			return null;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HasiMOD.LOGGER.warn("Failed to load dependency z for procedure MythrilScytheRightclicked!");
			return null;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		double x = (double) dependencies.get("x");
		double y = (double) dependencies.get("y");
		double z = (double) dependencies.get("z");
		if (entity instanceof PlayerEntity) {
			PlayerEntity user = (PlayerEntity) entity;
			ItemStack itemStack = user.getStackInHand(hand);
			world.playSound(null, x, y, z, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.NEUTRAL, 0.5F, 1F);
			user.getItemCooldownManager().set(instance, 5);
			if (!world.isClient) {
				io.hasibix.minecraft.hasimod.projectiles.ScytheBlade scytheBlade = new io.hasibix.minecraft.hasimod.projectiles.ScytheBlade(
						world, user);
				scytheBlade.damageAmount = 16;
				scytheBlade.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
				world.spawnEntity(scytheBlade);
			}

			user.incrementStat(Stats.USED.getOrCreateStat(instance));
			if (!user.getAbilities().creativeMode) {
				itemStack.decrement(1);
			}

			return TypedActionResult.success(itemStack, world.isClient());
		}
		return null;
	}
}
