package io.hasibix.hasimod.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.hasibix.hasimod.registrars.ores.Lonsdaleite;
import io.hasibix.hasimod.subregistrars.Blocks;
import io.hasibix.hasimod.subregistrars.Fluids;
import io.hasibix.hasimod.subregistrars.Items;
import io.hasibix.hasimod.subregistrars.StatusEffects;
import io.hasibix.hasimod.types.Registrar;

public class Registrars {
	public static List<Registrar> registrars = new ArrayList<>(
			Arrays.asList(new Blocks(), new Fluids(), new Items(), new StatusEffects(), new Lonsdaleite()));

	public static void init() {
		for (Registrar i : registrars) {
			i.registerAll();
		}
	}
}
