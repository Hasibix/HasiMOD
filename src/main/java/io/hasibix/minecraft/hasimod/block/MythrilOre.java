package io.hasibix.minecraft.hasimod.block;

import java.util.HashMap;
import java.util.Map;

import io.hasibix.minecraft.hasimod.init.Blocks;
import io.hasibix.minecraft.hasimod.procedures.MythrilOreDestroyedByExplosion;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
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
		Map<String, Object> dependencies = new HashMap<String, Object>();
		dependencies.put("x", blockPos.getX());
		dependencies.put("y", blockPos.getY());
		dependencies.put("z", blockPos.getZ());
		dependencies.put("world", world);

		MythrilOreDestroyedByExplosion.execute(dependencies);
	}

	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.MYTHRIL_ORE, RenderLayer.getSolid());
	}
}
