package io.hasibix.minecraft.hasimod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.hasibix.minecraft.hasimod.init.Blocks;
import io.hasibix.minecraft.hasimod.init.CreativeTabs;
import io.hasibix.minecraft.hasimod.init.Items;
import io.hasibix.minecraft.hasimod.init.OreGenerations;
import io.hasibix.minecraft.hasimod.init.PotionEffects;
import io.hasibix.minecraft.hasimod.init.Projectiles;
import net.fabricmc.api.ModInitializer;

public class HasiMOD implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(HasiMOD.class);
	public static final String MOD_ID = "hasimod";

	@Override
	public void onInitialize() {
		LOGGER.info("[HasiMOD] Intializing HasiMOD...");
		Blocks.load();
		CreativeTabs.load();
		Items.load();
		OreGenerations.load();
		PotionEffects.load();
		Projectiles.load();
	}
}
