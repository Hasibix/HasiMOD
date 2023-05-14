package io.hasibix.minecraft.hasimod.init;

import io.hasibix.minecraft.hasimod.HasiMOD;
import io.hasibix.minecraft.hasimod.blocks.CrackedMythrilOre;
import io.hasibix.minecraft.hasimod.blocks.MythrilBlock;
import io.hasibix.minecraft.hasimod.blocks.MythrilOre;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Blocks {
	public static Block CRACKED_MYTHRIL_ORE;
	public static Block MYTHRIL_ORE;
	public static Block MYTHRIL_BLOCK;

	public static void load() {
		CRACKED_MYTHRIL_ORE = Registry.register(Registries.BLOCK,
				new Identifier(HasiMOD.MOD_ID, "cracked_mythril_ore"), new CrackedMythrilOre());
		MYTHRIL_ORE = Registry.register(Registries.BLOCK, new Identifier(HasiMOD.MOD_ID, "mythril_ore"),
				new MythrilOre());
		MYTHRIL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(HasiMOD.MOD_ID, "mythril_block"),
				new MythrilBlock());
	}

	public static void clientLoad() {
		CrackedMythrilOre.clientInit();
		MythrilOre.clientInit();
		MythrilBlock.clientInit();
	}
}
