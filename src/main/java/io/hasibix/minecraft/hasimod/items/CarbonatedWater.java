package io.hasibix.minecraft.hasimod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class CarbonatedWater extends Item {
	public CarbonatedWater() {
		super(new Item.Settings().maxCount(64).rarity(Rarity.RARE));
	}

	@Override
	public int getMaxUseTime(ItemStack itemstack) {
		return 0;
	}
}
