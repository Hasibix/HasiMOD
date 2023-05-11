package io.hasibix.minecraft.hasimod.items;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import io.hasibix.minecraft.hasimod.init.CreativeTabs;

public class MythrilDust extends Item {
	public MythrilDust() {
		super(new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD).stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
