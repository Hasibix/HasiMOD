package io.hasibix.hasimod.types;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class Block {
	public static final List<Block> blocks = new ArrayList<>();

	public enum FabricRenderLayer {
		SOLID, TRANSLUCENT, CUTOUT, CUTOUT_MIPPED
	}

	@NotNull
	public final Identifier identifier;
	@NotNull
	public final Supplier<net.minecraft.block.Block> raw;
	@NotNull
	public final FabricRenderLayer renderLayer;
	@NotNull
	public final Supplier<BlockItem> blockItem;

	public Block(@NotNull Identifier identifier, @NotNull FabricRenderLayer renderLayer, @NotNull Settings settings,
			@NotNull net.minecraft.item.Item.Settings itemSettings) {
		this.identifier = identifier;
		this.raw = Suppliers.memoize(
				() -> Registry.register(Registries.BLOCK, identifier, new net.minecraft.block.Block(settings)));
		this.renderLayer = renderLayer;
		this.blockItem = Suppliers
				.memoize(() -> Registry.register(Registries.ITEM, identifier, new BlockItem(raw.get(), itemSettings)));
		blocks.add(this);
	}
}
