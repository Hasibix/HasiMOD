package io.hasibix.minecraft.hasimod.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import io.hasibix.minecraft.hasimod.HasiMOD;
import io.hasibix.minecraft.hasimod.items.BlocksiCola;
import io.hasibix.minecraft.hasimod.items.CarbonatedWater;
import io.hasibix.minecraft.hasimod.items.EmptyCan;
import io.hasibix.minecraft.hasimod.items.MantaCola;
import io.hasibix.minecraft.hasimod.items.MythrilApple;
import io.hasibix.minecraft.hasimod.items.MythrilArmor;
import io.hasibix.minecraft.hasimod.items.MythrilAxe;
import io.hasibix.minecraft.hasimod.items.MythrilDust;
import io.hasibix.minecraft.hasimod.items.MythrilGem;
import io.hasibix.minecraft.hasimod.items.MythrilHoe;
import io.hasibix.minecraft.hasimod.items.MythrilPickaxe;
import io.hasibix.minecraft.hasimod.items.MythrilScythe;
import io.hasibix.minecraft.hasimod.items.MythrilShovel;
import io.hasibix.minecraft.hasimod.items.MythrilSword;
import io.hasibix.minecraft.hasimod.items.SevenColaCola;

public class Items {
	public static Item MYTHRIL_APPLE;
	public static Item MYTHRIL_AXE;
	public static Item MYTHRIL_PICKAXE;
	public static Item MYTHRIL_SWORD;
	public static Item MYTHRIL_SHOVEL;
	public static Item MYTHRIL_HOE;
	public static Item MYTHRIL_SCYTHE;
	public static Item MYTHRIL_ARMOR_HELMET;
	public static Item MYTHRIL_ARMOR_CHESTPLATE;
	public static Item MYTHRIL_ARMOR_LEGGINGS;
	public static Item MYTHRIL_ARMOR_BOOTS;
	public static Item MYTHRIL_DUST;
	public static Item MYTHRIL_GEM;
	public static Item CRACKED_MYTHRIL_ORE;
	public static Item MYTHRIL_ORE;
	public static Item MYTHRIL_BLOCK;
	public static Item EMPTY_CAN;
	public static Item SEVEN_COLA_COLA;
	public static Item BLOCKSI_COLA;
	public static Item MANTA_COLA;
	public static Item CARBONATED_WATER;

	public static void load() {
		MYTHRIL_APPLE = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_apple"),
				new MythrilApple());
		MYTHRIL_AXE = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_axe"),
				new MythrilAxe());
		MYTHRIL_PICKAXE = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_pickaxe"),
				new MythrilPickaxe());
		MYTHRIL_SWORD = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_sword"),
				new MythrilSword());
		MYTHRIL_SHOVEL = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_shovel"),
				new MythrilShovel());
		MYTHRIL_HOE = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_hoe"),
				new MythrilHoe());
		MYTHRIL_SCYTHE = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_scythe"),
				new MythrilScythe());
		MYTHRIL_ARMOR_HELMET = Registry.register(Registry.ITEM,
				new ResourceLocation(HasiMOD.MOD_ID, "mythril_armor_helmet"), new MythrilArmor.Helmet());
		MYTHRIL_ARMOR_CHESTPLATE = Registry.register(Registry.ITEM,
				new ResourceLocation(HasiMOD.MOD_ID, "mythril_armor_chestplate"), new MythrilArmor.Chestplate());
		MYTHRIL_ARMOR_LEGGINGS = Registry.register(Registry.ITEM,
				new ResourceLocation(HasiMOD.MOD_ID, "mythril_armor_leggings"), new MythrilArmor.Leggings());
		MYTHRIL_ARMOR_BOOTS = Registry.register(Registry.ITEM,
				new ResourceLocation(HasiMOD.MOD_ID, "mythril_armor_boots"), new MythrilArmor.Boots());
		MYTHRIL_DUST = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_dust"),
				new MythrilDust());
		MYTHRIL_GEM = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_gem"),
				new MythrilGem());
		CRACKED_MYTHRIL_ORE = Registry.register(Registry.ITEM,
				new ResourceLocation(HasiMOD.MOD_ID, "cracked_mythril_ore"),
				new BlockItem(Blocks.CRACKED_MYTHRIL_ORE, new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD)));
		MYTHRIL_ORE = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_ore"),
				new BlockItem(Blocks.MYTHRIL_ORE, new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD)));
		MYTHRIL_BLOCK = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "mythril_block"),
				new BlockItem(Blocks.MYTHRIL_BLOCK, new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD)));
		EMPTY_CAN = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "empty_can"), new EmptyCan());
		SEVEN_COLA_COLA = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "seven_cola_cola"),
				new SevenColaCola());
		BLOCKSI_COLA = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "blocksi_cola"),
				new BlocksiCola());
		MANTA_COLA = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "manta_cola"),
				new MantaCola());
		CARBONATED_WATER = Registry.register(Registry.ITEM, new ResourceLocation(HasiMOD.MOD_ID, "carbonated_water"),
				new CarbonatedWater());
	}
}
