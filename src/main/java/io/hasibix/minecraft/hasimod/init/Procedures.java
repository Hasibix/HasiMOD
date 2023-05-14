package io.hasibix.minecraft.hasimod.init;

import io.hasibix.minecraft.hasimod.procedures.AfterDrinkingBlocksiCola;
import io.hasibix.minecraft.hasimod.procedures.AfterDrinkingMantaCola;
import io.hasibix.minecraft.hasimod.procedures.AfterDrinkingSevenColaCola;
import io.hasibix.minecraft.hasimod.procedures.AfterEatingMythrilApple;
import io.hasibix.minecraft.hasimod.procedures.FlyabilityEffectExpires;
import io.hasibix.minecraft.hasimod.procedures.FlyabilityEffectUpdateTick;
import io.hasibix.minecraft.hasimod.procedures.MythrilOreDestroyedByExplosion;
import io.hasibix.minecraft.hasimod.procedures.MythrilScytheLivingEntityIsHitWithTool;
import io.hasibix.minecraft.hasimod.procedures.MythrilScytheRightclicked;

public class Procedures {
	public static void load() {
		new AfterEatingMythrilApple();
		new MythrilOreDestroyedByExplosion();
		new FlyabilityEffectUpdateTick();
		new FlyabilityEffectExpires();
		new MythrilScytheRightclicked();
		new MythrilScytheLivingEntityIsHitWithTool();
		new AfterDrinkingSevenColaCola();
		new AfterDrinkingBlocksiCola();
		new AfterDrinkingMantaCola();
	}
}
