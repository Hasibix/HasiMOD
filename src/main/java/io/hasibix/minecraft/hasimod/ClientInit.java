package io.hasibix.minecraft.hasimod;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

import io.hasibix.minecraft.hasimod.init.Blocks;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		Blocks.clientLoad();

	}
}
