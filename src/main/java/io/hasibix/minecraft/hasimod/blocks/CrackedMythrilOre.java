package io.hasibix.minecraft.hasimod.block;

import io.hasibix.minecraft.hasimod.init.Blocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;

public class CrackedMythrilOre extends Block {

	public CrackedMythrilOre() {
		super(Settings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(45)
				.requiresTool());
	}

	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CRACKED_MYTHRIL_ORE, RenderLayer.getSolid());
	}
}
