package io.hasibix.minecraft.hasimod.block;

import java.util.HashMap;
import java.util.Map;

import io.hasibix.minecraft.hasimod.init.Blocks;
import io.hasibix.minecraft.hasimod.procedures.MythrilOreDestroyedByExplosion;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class MythrilOre extends Block {

	public MythrilOre() {
		super(Properties.of(Material.AMETHYST).sound(SoundType.AMETHYST).noDrops().strength(-1)
				.explosionResistance(10));
	}

	@Override
	public void wasExploded(Level level, BlockPos blockPos, Explosion explosion) {
		Map<String, Object> dependencies = new HashMap<String, Object>();
		dependencies.put("x", blockPos.getX());
		dependencies.put("y", blockPos.getY());
		dependencies.put("z", blockPos.getZ());
		dependencies.put("world", level);

		MythrilOreDestroyedByExplosion.execute(dependencies);
	}

	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.MYTHRIL_ORE, RenderType.solid());
	}
}
