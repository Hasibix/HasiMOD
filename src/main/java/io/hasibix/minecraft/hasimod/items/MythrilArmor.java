package io.hasibix.minecraft.hasimod.items;

import io.hasibix.minecraft.hasimod.init.Items;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Rarity;

public abstract class MythrilArmor extends ArmorItem {
	public MythrilArmor(EquipmentSlot slot, Item.Settings properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlot slot) {
				return new int[] { 13, 15, 16, 11 }[slot.getEntitySlotId()] * 150;
			}

			@Override
			public int getProtectionAmount(EquipmentSlot slot) {
				return new int[] { 20, 60, 50, 20 }[slot.getEntitySlotId()];
			}

			@Override
			public int getEnchantability() {
				return 90;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.ofStacks(new ItemStack(Items.MYTHRIL_GEM));
			}

			@Environment(EnvType.CLIENT)
			@Override
			public String getName() {
				return "mythril";
			}

			@Override
			public float getToughness() {
				return 8f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.5f;
			}
		}, slot, properties);
	}

	public static class Helmet extends MythrilArmor {

		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Settings().fireproof().rarity(Rarity.EPIC));
		}

	}

	public static class Chestplate extends MythrilArmor {

		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Settings().fireproof().rarity(Rarity.EPIC));
		}

	}

	public static class Leggings extends MythrilArmor {

		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Settings().fireproof().rarity(Rarity.EPIC));
		}

	}

	public static class Boots extends MythrilArmor {

		public Boots() {
			super(EquipmentSlot.FEET, new Item.Settings().fireproof().rarity(Rarity.EPIC));
		}

	}
}
