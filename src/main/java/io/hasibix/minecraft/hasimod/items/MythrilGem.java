package io.hasibix.minecraft.hasimod.items;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import io.hasibix.minecraft.hasimod.init.CreativeTabs;

public class MythrilGem extends Item {
	public MythrilGem() {
		super(new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD).stacksTo(64).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
