package io.hasibix.minecraft.hasimod.items;

import io.hasibix.minecraft.hasimod.procedures.ScytheBladeRightclicked;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScytheBlade extends Item {
	public ScytheBlade() {
		super(new Item.Settings().maxCount(16).rarity(Rarity.RARE));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
		return ScytheBladeRightclicked.execute(this, hand, com.google.common.collect.ImmutableMap.<String, Object>builder().put(null).build());
	}
}
