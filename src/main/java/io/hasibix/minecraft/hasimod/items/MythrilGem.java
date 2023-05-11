package io.hasibix.minecraft.hasimod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class MythrilGem extends Item {
	public MythrilGem() {
		super(new Item.Settings().maxCount(64).fireproof().rarity(Rarity.EPIC));
	}

	@Override
	public int getMaxUseTime(ItemStack itemstack) {
		return 0;
	}
}
