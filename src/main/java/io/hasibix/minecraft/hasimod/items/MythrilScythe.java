package io.hasibix.minecraft.hasimod.items;

import io.hasibix.minecraft.hasimod.abstract_items.Scythe;
import io.hasibix.minecraft.hasimod.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Rarity;

public class MythrilScythe extends Scythe {
	public MythrilScythe() {
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
				return 148f;
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
		}, 3, 96f, new Item.Settings().fireproof().rarity(Rarity.EPIC), 40);
	}
}
