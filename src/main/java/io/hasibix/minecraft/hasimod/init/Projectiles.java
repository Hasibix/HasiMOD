package io.hasibix.minecraft.hasimod.init;

import io.hasibix.minecraft.hasimod.HasiMOD;
import io.hasibix.minecraft.hasimod.projectiles.ScytheBlade;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Projectiles {
	public static EntityType<ScytheBlade> SCYTHE_BLADE;

	public static void load() {
		SCYTHE_BLADE = Registry.register(Registries.ENTITY_TYPE, new Identifier(HasiMOD.MOD_ID, "scythe_blade"),
				FabricEntityTypeBuilder.<ScytheBlade>create(SpawnGroup.MISC, ScytheBlade::new)
						.dimensions(EntityDimensions.fixed(1.5F, 1.5F)).trackRangeBlocks(16).trackedUpdateRate(10)
						.build());
	}
}
