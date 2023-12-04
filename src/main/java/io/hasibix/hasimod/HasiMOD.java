package io.hasibix.hasimod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.hasibix.hasimod.init.Registrars;
import io.hasibix.hasimod.init.Tabs;
import net.fabricmc.api.ModInitializer;

public class HasiMOD implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("hasimod");
	public static final String MOD_ID = "hasimod";

	@Override
	public void onInitialize() {
		try {
			LOGGER.info("[HasiMOD] Initializing HasiMOD...");
			Registrars.init();
			Tabs.init();
			LOGGER.info("[HasiMOD] Finished initializing HasiMOD!");
		} catch (Exception e) {
			LOGGER.error("Something went wrong.", e);
		}
	}
}
