package io.hasibix.minecraft.hasimod.damage_sources;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.EntityDamageSource;

public class ScytheBlade extends EntityDamageSource {
	public ScytheBlade(Entity source) {
		super("scythe_blade", source);
	}
}
