package io.hasibix.minecraft.hasimod.items;

import io.hasibix.minecraft.hasimod.init.Items;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class SevenColaCola extends Item {
	public SevenColaCola() {
		super(new Item.Settings().maxCount(8).rarity(Rarity.EPIC)
				.food((new FoodComponent.Builder()).hunger(6).saturationModifier(4f).alwaysEdible().build()));
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

		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 80, 5, (false), (false)));
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 24000, 10, (false), (false)));
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 24000, 5, (false), (false)));
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 24000, 5, (false), (false)));

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
