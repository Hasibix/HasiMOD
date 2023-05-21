package io.hasibix.minecraft.hasimod.damage_sources;

import net.minecraft.entity.damage.DamageSource;

public class Scythe extends DamageSource {
	public Scythe() {
		super("scythe");
		this.setBypassesArmor().setBypassesProtection().setUnblockable();
	}
}
