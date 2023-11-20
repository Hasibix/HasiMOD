package io.hasibix.hasimod.utils;

import java.util.function.Predicate;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class WorldGen {
	public static void addFeature(RegistryKey<PlacedFeature> placedFeature,
			Predicate<BiomeSelectionContext> biomeSelection, GenerationStep.Feature type) {
		BiomeModifications.addFeature(biomeSelection, type, placedFeature);
	}
}
