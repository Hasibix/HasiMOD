package io.hasibix.minecraft.hasimod.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import io.hasibix.minecraft.hasimod.block.MythrilOre;
import io.hasibix.minecraft.hasimod.block.MythrilBlock;
import io.hasibix.minecraft.hasimod.block.CrackedMythrilOre;
import io.hasibix.minecraft.hasimod.HasiMOD;

public class Blocks {
	public static Block CRACKED_MYTHRIL_ORE;
	public static Block MYTHRIL_ORE;
	public static Block MYTHRIL_BLOCK;

	public static void load() {
		CRACKED_MYTHRIL_ORE = Registry.register(Registry.BLOCK,
				new ResourceLocation(HasiMOD.MOD_ID, "cracked_mythril_ore"), new CrackedMythrilOre());
		MYTHRIL_ORE = Registry.register(Registry.BLOCK, new ResourceLocation(HasiMOD.MOD_ID, "mythril_ore"),
				new MythrilOre());
		MYTHRIL_BLOCK = Registry.register(Registry.BLOCK, new ResourceLocation(HasiMOD.MOD_ID, "mythril_block"),
				new MythrilBlock());
	}

	public static void clientLoad() {
		CrackedMythrilOre.clientInit();
		MythrilOre.clientInit();
		MythrilBlock.clientInit();
	}
}
