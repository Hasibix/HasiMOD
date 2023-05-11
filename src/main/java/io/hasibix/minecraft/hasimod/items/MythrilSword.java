package io.hasibix.minecraft.hasimod.items;

import io.hasibix.minecraft.hasimod.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MythrilSword extends SwordItem {
	public MythrilSword() {
		super(new ToolMaterial() {
			@Override
			public int getDurability() {
				return 6280;
			}

			@Override
			public float getMiningSpeedMultiplier() {
				return 24f;
			}

			@Override
			public float getAttackDamage() {
				return 58f;
			}

			@Override
			public int getMiningLevel() {
				return 20;
			}

			@Override
			public int getEnchantability() {
				return 140;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.ofStacks(new ItemStack(Items.MYTHRIL_GEM));
			}
		}, 3, -3f, new Item.Settings().fireproof());
	}
}
