package io.hasibix.hasimod.types;

public interface Registrar {
	public default void registerAll() {
		this.registerBlocks();
		this.registerFluids();
		this.registerItems();
		this.registerStatusEffects();
	}

	public default void registerBlocks() {
	}

	public default void registerFluids() {
	}

	public default void registerItems() {
	}

	public default void registerTabs() {
	}

	public default void registerStatusEffects() {
	}
}
