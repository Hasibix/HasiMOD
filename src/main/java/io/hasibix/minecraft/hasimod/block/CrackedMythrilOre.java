package io.hasibix.minecraft.hasimod.block;

import io.hasibix.minecraft.hasimod.init.Blocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class CrackedMythrilOre extends Block {

	public CrackedMythrilOre() {
		super(Properties.of(Material.AMETHYST).sound(SoundType.AMETHYST).strength(35).explosionResistance(30)
				.requiresCorrectToolForDrops());
	}

	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CRACKED_MYTHRIL_ORE, RenderType.solid());
	}
}
