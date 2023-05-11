package io.hasibix.minecraft.hasimod.init;

import io.hasibix.minecraft.hasimod.HasiMOD;
import io.hasibix.minecraft.hasimod.potion_effects.Flyability;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PotionEffects {
	public static StatusEffect FLYABILITY;
	
	public static void load() {
		FLYABILITY = Registry.register(Registries.STATUS_EFFECT, new Identifier(HasiMOD.MOD_ID, "flyability"),
				new Flyability());
	}
}
