package io.hasibix.hasimod.datagen.providers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class BlockLootTableProvider extends FabricBlockLootTableProvider {
	private static List<Consumer<BlockLootTableProvider>> lootTables = new ArrayList<>();

	public BlockLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		for (Consumer<BlockLootTableProvider> i : lootTables) {
			i.accept(this);
		}
	}

	public static void addLootTables(Consumer<BlockLootTableProvider> consumer) {
		lootTables.add(consumer);
	}
}
