package io.hasibix.hasimod.subregistrars;

import io.hasibix.hasimod.types.Registrar;

public class Blocks implements Registrar {
	@Override
	public void registerBlocks() {
		System.out.println("Hello world");
	}

	@Override
	public void registerTabs() {
		System.out.println("Hello world");
	}
}
