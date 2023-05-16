package io.hasibix.minecraft.hasimod.blocks;

import io.hasibix.minecraft.hasimod.procedures.MythrilOreDestroyedByExplosion;
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
		double x = blockPos.getX();
		double y = blockPos.getY();
		double z = blockPos.getZ();
		MythrilOreDestroyedByExplosion.execute(com.google.common.collect.ImmutableMap.<String, Object>builder()
				.put("x", x).put("y", y).put("z", z).put("world", world).build());
	}
}
