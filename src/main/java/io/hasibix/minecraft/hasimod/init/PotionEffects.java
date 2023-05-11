package io.hasibix.minecraft.hasimod.init;

import io.hasibix.minecraft.hasimod.HasiMOD;
import io.hasibix.minecraft.hasimod.items.MythrilApple;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import io.hasibix.minecraft.hasimod.potion_effects.Flyability;

public class PotionEffects {
	public static MobEffect FLYABILITY;
	
	public static void load() {
		FLYABILITY = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(HasiMOD.MOD_ID, "flyability"),
				new Flyability());
	}
}
