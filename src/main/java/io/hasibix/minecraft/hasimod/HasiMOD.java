package io.hasibix.minecraft.hasimod;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.fabricmc.api.ModInitializer;

import io.hasibix.minecraft.hasimod.init.CreativeTabs;
import io.hasibix.minecraft.hasimod.init.PotionEffects;
import io.hasibix.minecraft.hasimod.init.Procedures;
import io.hasibix.minecraft.hasimod.init.Items;
import io.hasibix.minecraft.hasimod.init.OreGenerations;
import io.hasibix.minecraft.hasimod.init.Blocks;

public class HasiMOD implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "hasimod";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing HasiMOD");
		CreativeTabs.load();
		Blocks.load();
		Items.load();
		Procedures.load();
		PotionEffects.load();
		OreGenerations.load();
	}
}
