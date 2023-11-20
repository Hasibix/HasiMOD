package io.hasibix.hasimod.types;

import io.hasibix.hasimod.HasiMOD;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class FloatingItems {
	public static final TagKey<Item> FLOATING_ITEMS_TAG = TagKey.of(RegistryKeys.ITEM,
			Identifier.of(HasiMOD.MOD_ID, "floating_items"));
}
