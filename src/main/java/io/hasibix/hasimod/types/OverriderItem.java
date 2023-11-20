package io.hasibix.hasimod.types;

import org.jetbrains.annotations.NotNull;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class OverriderItem {
	public final int rawId;
	@NotNull
	public final String id;
	@NotNull
	public final Supplier<net.minecraft.item.Item> raw;

	public OverriderItem(int rawId, @NotNull String id, @NotNull net.minecraft.item.Item raw) {
		this.rawId = rawId;
		this.id = id;
		this.raw = Suppliers.memoize(() -> Registry.register(Registries.ITEM, rawId, id, raw));
	}
}
