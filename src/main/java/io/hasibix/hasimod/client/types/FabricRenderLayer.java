package io.hasibix.hasimod.client.types;

import io.hasibix.hasimod.types.Block;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public enum FabricRenderLayer {
	SOLID {
		@Override
		public RenderLayer getRenderLayer() {
			return RenderLayer.getSolid();
		}
	},
	TRANSLUCENT {
		@Override
		public RenderLayer getRenderLayer() {
			return RenderLayer.getTranslucent();
		}
	},
	CUTOUT {
		@Override
		public RenderLayer getRenderLayer() {
			return RenderLayer.getCutout();
		}
	},
	CUTOUT_MIPPED {
		@Override
		public RenderLayer getRenderLayer() {
			return RenderLayer.getCutoutMipped();
		}
	};

	public abstract RenderLayer getRenderLayer();

	public static FabricRenderLayer from(Block.FabricRenderLayer renderLayer) {
		switch (renderLayer) {
		case SOLID:
			return SOLID;
		case TRANSLUCENT:
			return TRANSLUCENT;
		case CUTOUT:
			return CUTOUT;
		case CUTOUT_MIPPED:
			return CUTOUT_MIPPED;
		default:
			return SOLID;
		}
	}

	public static void addBlockToLayer(Block block) {
		BlockRenderLayerMap.INSTANCE.putBlock(block.raw.get(), from(block.renderLayer).getRenderLayer());
	}
}
