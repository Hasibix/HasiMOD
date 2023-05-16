package io.hasibix.minecraft.hasimod.init;

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
import io.hasibix.minecraft.hasimod.items.ScytheBlade;
import io.hasibix.minecraft.hasimod.items.SevenColaCola;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class Items {
	public static Item MYTHRIL_APPLE;
	public static Item MYTHRIL_AXE;
	public static Item MYTHRIL_PICKAXE;
	public static Item MYTHRIL_SWORD;
	public static Item MYTHRIL_SHOVEL;
	public static Item MYTHRIL_HOE;
	public static Item MYTHRIL_SCYTHE;
	public static Item MYTHRIL_HELMET;
	public static Item MYTHRIL_CHESTPLATE;
	public static Item MYTHRIL_LEGGINGS;
	public static Item MYTHRIL_BOOTS;
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
	public static Item SCYTHE_BLADE;

	public static void load() {
		MYTHRIL_APPLE = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_apple"),
				new MythrilApple());
		MYTHRIL_AXE = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_axe"),
				new MythrilAxe());
		MYTHRIL_PICKAXE = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_pickaxe"),
				new MythrilPickaxe());
		MYTHRIL_SWORD = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_sword"),
				new MythrilSword());
		MYTHRIL_SHOVEL = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_shovel"),
				new MythrilShovel());
		MYTHRIL_HOE = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_hoe"),
				new MythrilHoe());
		MYTHRIL_SCYTHE = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_scythe"),
				new MythrilScythe());
		MYTHRIL_HELMET = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_armor_helmet"),
				new MythrilArmor.Helmet());
		MYTHRIL_CHESTPLATE = Registry.register(Registries.ITEM,
				new Identifier(HasiMOD.MOD_ID, "mythril_armor_chestplate"), new MythrilArmor.Chestplate());
		MYTHRIL_LEGGINGS = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_armor_leggings"),
				new MythrilArmor.Leggings());
		MYTHRIL_BOOTS = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_armor_boots"),
				new MythrilArmor.Boots());
		MYTHRIL_DUST = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_dust"),
				new MythrilDust());
		MYTHRIL_GEM = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_gem"),
				new MythrilGem());
		CRACKED_MYTHRIL_ORE = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "cracked_mythril_ore"),
				new BlockItem(Blocks.CRACKED_MYTHRIL_ORE, new Item.Settings().rarity(Rarity.EPIC)));
		MYTHRIL_ORE = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_ore"),
				new BlockItem(Blocks.MYTHRIL_ORE, new Item.Settings().rarity(Rarity.EPIC)));
		MYTHRIL_BLOCK = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "mythril_block"),
				new BlockItem(Blocks.MYTHRIL_BLOCK, new Item.Settings().fireproof().rarity(Rarity.EPIC)));
		EMPTY_CAN = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "empty_can"), new EmptyCan());
		SEVEN_COLA_COLA = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "seven_cola_cola"),
				new SevenColaCola());
		BLOCKSI_COLA = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "blocksi_cola"),
				new BlocksiCola());
		MANTA_COLA = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "manta_cola"), new MantaCola());
		CARBONATED_WATER = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "carbonated_water"),
				new CarbonatedWater());
		SCYTHE_BLADE = Registry.register(Registries.ITEM, new Identifier(HasiMOD.MOD_ID, "scythe_blade_item"),
				new ScytheBlade());

		ItemGroupEvents.modifyEntriesEvent(CreativeTabs.TAB_HASI_MOD).register(contents -> {
			contents.add(MYTHRIL_APPLE);
			contents.add(MYTHRIL_AXE);
			contents.add(MYTHRIL_PICKAXE);
			contents.add(MYTHRIL_SWORD);
			contents.add(MYTHRIL_SHOVEL);
			contents.add(MYTHRIL_HOE);
			contents.add(MYTHRIL_SCYTHE);
			contents.add(MYTHRIL_HELMET);
			contents.add(MYTHRIL_CHESTPLATE);
			contents.add(MYTHRIL_LEGGINGS);
			contents.add(MYTHRIL_BOOTS);
			contents.add(MYTHRIL_DUST);
			contents.add(MYTHRIL_GEM);
			contents.add(CRACKED_MYTHRIL_ORE);
			contents.add(MYTHRIL_ORE);
			contents.add(MYTHRIL_BLOCK);
			contents.add(EMPTY_CAN);
			contents.add(SEVEN_COLA_COLA);
			contents.add(BLOCKSI_COLA);
			contents.add(MANTA_COLA);
			contents.add(CARBONATED_WATER);
			contents.add(SCYTHE_BLADE);
		});
	}

}
