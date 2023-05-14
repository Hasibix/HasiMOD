package io.hasibix.minecraft.hasimod;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

import io.hasibix.minecraft.hasimod.init.Blocks;
import io.hasibix.minecraft.hasimod.init.Projectiles;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Blocks.clientLoad();
		Projectiles.clientLoad();
	}
}
