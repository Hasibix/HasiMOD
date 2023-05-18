package io.hasibix.minecraft.hasimod.items;

import io.hasibix.minecraft.hasimod.init.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
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

		entity.addStatusEffect(new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.HEALTH_BOOST, 24000,
				10, (false), (false)));
		entity.addStatusEffect(new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.STRENGTH, 24000, 5,
				(false), (false)));
		entity.addStatusEffect(
				new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.SPEED, 24000, 5, (false), (false)));
		entity.addStatusEffect(new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.JUMP_BOOST, 24000, 5,
				(false), (false)));
		entity.addStatusEffect(new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.REGENERATION, 24000,
				10, (false), (false)));
		entity.addStatusEffect(new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.INVISIBILITY, 24000,
				50, (false), (false)));
		entity.addStatusEffect(new StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.RESISTANCE, 24000, 5,
				(false), (false)));
		entity.addStatusEffect(new StatusEffectInstance(StatusEffects.FLYABILITY, 24000, 1, (false), (false)));

		return retval;
	}
}
