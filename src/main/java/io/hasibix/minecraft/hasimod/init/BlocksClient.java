package io.hasibix.minecraft.hasimod.init;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BlocksClient {
	public static void load() {
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.MYTHRIL_BLOCK, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.CRACKED_MYTHRIL_ORE, RenderLayer.getSolid());
		BlockRenderLayerMap.INSTANCE.putBlock(Blocks.MYTHRIL_ORE, RenderLayer.getSolid());
	}
}
