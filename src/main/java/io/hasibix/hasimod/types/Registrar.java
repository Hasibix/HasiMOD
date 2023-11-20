package io.hasibix.hasimod.types;

public interface Registrar {
	default void registerAll() {
		this.registerBlocks();
		this.registerFluids();
		this.registerItems();
		this.registerStatusEffects();
	}

	default void registerBlocks() {
	}

	default void registerFluids() {
	}

	default void registerItems() {
	}

	default void registerTabs() {
	}

	default void registerStatusEffects() {
	}
}
