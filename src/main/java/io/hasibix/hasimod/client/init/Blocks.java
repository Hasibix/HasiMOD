package io.hasibix.hasimod.client.init;

import io.hasibix.hasimod.client.types.FabricRenderLayer;
import io.hasibix.hasimod.types.Block;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Blocks {
	public static void init() {
		for (Block i : io.hasibix.hasimod.types.Block.blocks) {
			FabricRenderLayer.addBlockToLayer(i);
		}
	}
}
