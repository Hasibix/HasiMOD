package io.hasibix.hasimod.datagen.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

public class RecipeProvider extends FabricRecipeProvider {
	private static final List<Consumer<Consumer<RecipeJsonProvider>>> recipes = new ArrayList<>();

	public RecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
		for (Consumer<Consumer<RecipeJsonProvider>> i : recipes) {
			i.accept(exporter);
		}
	}

	public static void addRecipes(Consumer<Consumer<RecipeJsonProvider>> consumer) {
		recipes.add(consumer);
	}
}
