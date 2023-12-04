package io.hasibix.hasimod.types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import com.google.common.base.Suppliers;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Like {@link io.hasibix.hasimod.types.Item}, this is a holder for
 * {@link net.minecraft.block.Block}. This class is used to automatically add to
 * registry and hold an instance of {@link net.minecraft.block.Block}.
 * {@link java.util.function.Supplier} is used for asynchronized usage.
 */
public class Block {
	// Helpers
	public static final List<Block> blocks = new ArrayList<>();

	public enum FabricRenderLayer {
		SOLID, TRANSLUCENT, CUTOUT, CUTOUT_MIPPED
	}

	// Variables
	protected final Identifier identifier;
	protected Supplier<net.minecraft.block.Block> raw;
	protected FabricRenderLayer renderLayer;
	protected Supplier<BlockItem> blockItem;

	protected Block(@NotNull Identifier identifier) {
		this.identifier = identifier;
	}

	public Block(@NotNull Identifier identifier, @NotNull FabricRenderLayer renderLayer, @NotNull Settings settings,
			@NotNull net.minecraft.item.Item.Settings itemSettings) {
		this(identifier);
		this.raw = Suppliers.memoize(
				() -> Registry.register(Registries.BLOCK, identifier, new net.minecraft.block.Block(settings)));
		this.renderLayer = renderLayer;
		this.blockItem = Suppliers
				.memoize(() -> Registry.register(Registries.ITEM, identifier, new BlockItem(raw.get(), itemSettings)));
		blocks.add(this);
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public Supplier<net.minecraft.block.Block> getRaw() {
		return raw;
	}

	public FabricRenderLayer getRenderLayer() {
		return renderLayer;
	}

	public Supplier<BlockItem> getBlockItem() {
		return blockItem;
	}
}
