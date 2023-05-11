package io.hasibix.minecraft.hasimod.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CreativeTabs {
	public static ItemGroup TAB_HASI_MOD;

	public static void load() {
		TAB_HASI_MOD = FabricItemGroup.builder(new Identifier("hasimod", "hasi_mod"))
				.icon(() -> new ItemStack(Items.MYTHRIL_GEM)).build();
	}
}
