package io.hasibix.minecraft.hasimod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class CrackedMythrilOre extends Block {

	public CrackedMythrilOre() {
		super(Settings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(45).requiresTool());
	}
}
