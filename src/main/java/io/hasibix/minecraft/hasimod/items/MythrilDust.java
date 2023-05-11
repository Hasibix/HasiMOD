package io.hasibix.minecraft.hasimod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class MythrilDust extends Item {
	public MythrilDust() {
		super(new Item.Settings().maxCount(64).rarity(Rarity.EPIC));
	}

	@Override
	public int getMaxUseTime(ItemStack itemstack) {
		return 0;
	}
}
