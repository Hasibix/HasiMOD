package io.hasibix.minecraft.hasimod;

import io.hasibix.minecraft.hasimod.init.BlocksClient;
import io.hasibix.minecraft.hasimod.init.ProjectilesClient;
import net.fabricmc.api.ClientModInitializer;

public class ClientInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlocksClient.load();
		ProjectilesClient.load();
	}
}
