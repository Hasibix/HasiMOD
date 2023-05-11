package io.hasibix.minecraft.hasimod.ore_generations;

import io.hasibix.minecraft.hasimod.HasiMOD;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class MythrilOre {
	public static final ResourceKey<PlacedFeature> PLACED_FEATURE = ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(HasiMOD.MOD_ID, "mythril_ore_generation"));
	public static void load() {
	    BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Decoration.UNDERGROUND_ORES, PLACED_FEATURE);
	}
}
