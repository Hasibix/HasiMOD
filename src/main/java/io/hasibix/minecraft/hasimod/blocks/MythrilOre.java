package io.hasibix.minecraft.hasimod.blocks;

import io.hasibix.minecraft.hasimod.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class MythrilOre extends Block {

	public MythrilOre() {
		super(Settings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK).dropsNothing().strength(-1, 10));
	}

	@Override
	public void onDestroyedByExplosion(World world, BlockPos blockPos, Explosion explosion) {
		world.setBlockState(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ()),
				Blocks.CRACKED_MYTHRIL_ORE.getDefaultState(), 3);
	}
}
