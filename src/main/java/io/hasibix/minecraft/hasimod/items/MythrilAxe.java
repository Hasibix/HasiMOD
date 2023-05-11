package io.hasibix.minecraft.hasimod.items;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import io.hasibix.minecraft.hasimod.init.CreativeTabs;
import io.hasibix.minecraft.hasimod.init.Items;

public class MythrilAxe extends AxeItem {
	public MythrilAxe() {
		super(new Tier() {
			public int getUses() {
				return 6280;
			}

			public float getSpeed() {
				return 24f;
			}

			public float getAttackDamageBonus() {
				return 88f;
			}

			public int getLevel() {
				return 20;
			}

			public int getEnchantmentValue() {
				return 140;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.MYTHRIL_GEM));
			}
		}, 1, -3f, new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD).fireResistant());
	}
}
