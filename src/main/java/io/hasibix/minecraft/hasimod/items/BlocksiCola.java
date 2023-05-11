package io.hasibix.minecraft.hasimod.items;

import io.hasibix.minecraft.hasimod.init.Items;
import io.hasibix.minecraft.hasimod.procedures.AfterDrinkingBlocksiCola;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BlocksiCola extends Item {
	public BlocksiCola() {
		super(new Item.Settings().maxCount(8).rarity(Rarity.EPIC)
				.food((new FoodComponent.Builder()).hunger(4).saturationModifier(2f).alwaysEdible().build()));
	}

	@Override
	public UseAction getUseAction(ItemStack itemstack) {
		return UseAction.DRINK;
	}

	@Override
	public int getMaxUseTime(ItemStack itemstack) {
		return 32;
	}

	@Override
	public ItemStack finishUsing(ItemStack itemstack, World world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.EMPTY_CAN);
		super.finishUsing(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		AfterDrinkingBlocksiCola.execute(
				com.google.common.collect.ImmutableMap.<String, Object>builder().put("entity", entity).build());
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof PlayerEntity player) {
				if (!player.getInventory().insertStack(retval))
					player.dropItem(retval, false);
			}
			return itemstack;
		}
	}
}
