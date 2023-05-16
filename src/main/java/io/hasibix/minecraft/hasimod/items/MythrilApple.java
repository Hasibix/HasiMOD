package io.hasibix.minecraft.hasimod.items;

import io.hasibix.minecraft.hasimod.procedures.AfterEatingMythrilApple;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

public class MythrilApple extends Item {
	public MythrilApple() {
		super(new Item.Settings().maxCount(64).fireproof().rarity(Rarity.EPIC)
				.food((new FoodComponent.Builder()).hunger(20).saturationModifier(10f).alwaysEdible().build()));
	}

	@Override
	public int getMaxUseTime(ItemStack itemstack) {
		return 32;
	}

	@Override
	public ItemStack finishUsing(ItemStack itemstack, World world, LivingEntity entity) {
		ItemStack retval = super.finishUsing(itemstack, world, entity);

		AfterEatingMythrilApple.execute(
				com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
		return retval;
	}
}
