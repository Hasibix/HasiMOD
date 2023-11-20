package io.hasibix.hasimod.types;

import org.jetbrains.annotations.NotNull;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class Item {
	@NotNull
	public final Identifier identifier;
	@NotNull
	public final Supplier<net.minecraft.item.Item> raw;

	public Item(@NotNull Identifier identifier, @NotNull net.minecraft.item.Item raw) {
		this.identifier = identifier;
		this.raw = Suppliers.memoize(() -> Registry.register(Registries.ITEM, identifier, raw));
	}
}
