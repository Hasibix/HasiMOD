package io.hasibix.minecraft.hasimod.items;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import io.hasibix.minecraft.hasimod.procedures.AfterEatingMythrilApple;
import io.hasibix.minecraft.hasimod.init.CreativeTabs;

public class MythrilApple extends Item {
	public MythrilApple() {
		super(new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD).stacksTo(64).fireResistant().rarity(Rarity.EPIC)
				.food((new FoodProperties.Builder()).nutrition(20).saturationMod(10f).alwaysEat()

						.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		AfterEatingMythrilApple.execute(
				com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
		return retval;
	}
}
