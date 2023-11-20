package io.hasibix.hasimod.datagen.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import io.hasibix.hasimod.utils.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.TagKey;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
	private static final List<Pair<TagKey<Item>, Item>> items = new ArrayList<>();

	public ItemTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}

	@Override
	protected void configure(WrapperLookup arg) {
		for (Pair<TagKey<Item>, Item> i : items) {
			getOrCreateTagBuilder(i.first).add(i.second);
		}
	}

	public static void addTo(TagKey<Item> tag, Item item) {
		items.add(Pair.of(tag, item));
	}
}
