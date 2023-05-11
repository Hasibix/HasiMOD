package io.hasibix.minecraft.hasimod.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

public class CreativeTabs {
	public static CreativeModeTab TAB_HASI_MOD;

	public static void load() {
		TAB_HASI_MOD = FabricItemGroupBuilder.create(new ResourceLocation("hasimod", "hasi_mod"))
				.icon(() -> new ItemStack(Items.MYTHRIL_GEM)).build();
	}
}
