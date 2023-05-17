package io.hasibix.minecraft.hasimod.ore_generations;

import io.hasibix.minecraft.hasimod.HasiMOD;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class MythrilOre {
	public static final RegistryKey<PlacedFeature> PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE,
			new Identifier(HasiMOD.MOD_ID, "mythril_ore_generation"));

	public static void load() {
		BiomeModifications.create(new Identifier(HasiMOD.MOD_ID, "features")).add(ModificationPhase.ADDITIONS,
				BiomeSelectors.foundInTheEnd(),
				(biomeSelectionContext, biomeModificationContext) -> biomeModificationContext.getGenerationSettings()
						.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, PLACED_KEY));
	}
}
