package io.hasibix.hasimod.client;

import io.hasibix.hasimod.client.init.Blocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import static io.hasibix.hasimod.HasiMOD.LOGGER;

@Environment(EnvType.CLIENT)
public class HasiMOD implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		LOGGER.info("[HasiMOD] Initializing HasiMOD on the client...");
		Blocks.init();
		LOGGER.info("[HasiMOD] Finished initializing HasiMOD on the client!");
	}
}