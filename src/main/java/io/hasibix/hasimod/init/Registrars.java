package io.hasibix.hasimod.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.hasibix.hasimod.registrars.ores.Lonsdaleite;
import io.hasibix.hasimod.registrars.ores.RoseQuartz;
import io.hasibix.hasimod.subregistrars.Blocks;
import io.hasibix.hasimod.subregistrars.Fluids;
import io.hasibix.hasimod.subregistrars.Items;
import io.hasibix.hasimod.subregistrars.StatusEffects;
import io.hasibix.hasimod.types.Registrar;

public class Registrars {
	public static List<Registrar> subregistrars = new ArrayList<>(
			Arrays.asList(new Blocks(), new Fluids(), new Items(), new StatusEffects()));

	// Registrars
	public static List<Registrar> ores = new ArrayList<>(Arrays.asList(new RoseQuartz(), new Lonsdaleite()));

	public static void init() {
		for (Registrar i : subregistrars) {
			i.registerAll();
		}
		// Registrars
		for (Registrar i : ores) {
			i.registerAll();
		}
	}
}
