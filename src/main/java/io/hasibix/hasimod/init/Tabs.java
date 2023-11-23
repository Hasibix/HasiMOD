package io.hasibix.hasimod.init;

import io.hasibix.hasimod.HasiMOD;
import io.hasibix.hasimod.registrars.ores.Lonsdaleite;
import io.hasibix.hasimod.types.Registrar;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Tabs {
	public static RegistryKey<ItemGroup> TAB_HASIMOD_ALL;
	public static RegistryKey<ItemGroup> TAB_HASIMOD_ORES;

	public static void init() {
		Registry.register(Registries.ITEM_GROUP, Identifier.of(HasiMOD.MOD_ID, "hasimod_all"),
				FabricItemGroup.builder().icon(() -> new ItemStack(net.minecraft.item.Items.END_CRYSTAL))
						.displayName(Text.translatable("itemGroup." + HasiMOD.MOD_ID + ".hasimod_all")).build());
		Registry.register(Registries.ITEM_GROUP, Identifier.of(HasiMOD.MOD_ID, "hasimod_ores"),
				FabricItemGroup.builder().icon(() -> new ItemStack(Lonsdaleite.LONSDALEITE_GEM.raw.get()))
						.displayName(Text.translatable("itemGroup." + HasiMOD.MOD_ID + ".hasimod_ores")).build());

		TAB_HASIMOD_ALL = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(HasiMOD.MOD_ID, "hasimod_all"));
		TAB_HASIMOD_ORES = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(HasiMOD.MOD_ID, "hasimod_ores"));

		Registrars.subregistrars.forEach(Registrar::registerTabs);
		Registrars.ores.forEach(Registrar::registerTabs);
	}

	public static void addContentsTo(RegistryKey<ItemGroup> tab, ItemConvertible... content) {
		ItemGroupEvents.modifyEntriesEvent(tab).register(contents -> {
			for (ItemConvertible i : content) {
				contents.add(i);
			}
		});
	}
}
