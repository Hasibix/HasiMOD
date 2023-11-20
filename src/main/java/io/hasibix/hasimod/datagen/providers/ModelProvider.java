package io.hasibix.hasimod.datagen.providers;

import java.util.ArrayList;
import java.util.List;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModelProvider extends FabricModelProvider {
	private static final List<Consumer<ItemModelGenerator>> items = new ArrayList<>();
	private static final List<Consumer<BlockStateModelGenerator>> blocks = new ArrayList<>();

	public ModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		for (Consumer<BlockStateModelGenerator> i : blocks) {
			i.accept(blockStateModelGenerator);
		}
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		for (Consumer<ItemModelGenerator> i : items) {
			i.accept(itemModelGenerator);
		}
	}

	public static void addItems(Consumer<ItemModelGenerator> consumer) {
		items.add(consumer);
	}

	public static void addBlocks(Consumer<BlockStateModelGenerator> consumer) {
		blocks.add(consumer);
	}
}
