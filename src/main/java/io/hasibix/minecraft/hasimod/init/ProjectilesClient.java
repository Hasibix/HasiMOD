package io.hasibix.minecraft.hasimod.init;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class ProjectilesClient {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void load() {
		EntityRendererRegistry.register(Projectiles.SCYTHE_BLADE, (context) -> new FlyingItemEntityRenderer(context));
	}
}
