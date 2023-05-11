package io.hasibix.minecraft.hasimod.items;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import io.hasibix.minecraft.hasimod.init.CreativeTabs;
import io.hasibix.minecraft.hasimod.init.Items;

public abstract class MythrilArmor extends ArmorItem {
	public MythrilArmor(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[] { 13, 15, 16, 11 }[slot.getIndex()] * 150;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[] { 20, 60, 50, 20 }[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 90;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.ARMOR_EQUIP_NETHERITE;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.MYTHRIL_GEM));
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
			super(EquipmentSlot.HEAD, new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD).fireResistant());
		}

	}

	public static class Chestplate extends MythrilArmor {

		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD).fireResistant());
		}

	}

	public static class Leggings extends MythrilArmor {

		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD).fireResistant());
		}

	}

	public static class Boots extends MythrilArmor {

		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD).fireResistant());
		}

	}
}
