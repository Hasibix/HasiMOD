package io.hasibix.hasimod.datagen.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import io.hasibix.hasimod.utils.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.TagKey;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
	private static final List<Pair<TagKey<Block>, Block>> blocks = new ArrayList<>();

	public BlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(WrapperLookup arg) {
		for (Pair<TagKey<Block>, Block> i : blocks) {
			getOrCreateTagBuilder(i.first).add(i.second);
		}
	}

	public static void addTo(TagKey<Block> tag, Block block) {
		blocks.add(Pair.of(tag, block));
	}
}
