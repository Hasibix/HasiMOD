package io.hasibix.hasimod.subregistrars;

import java.util.Objects;

import io.hasibix.hasimod.HasiMOD;
import io.hasibix.hasimod.types.Registrar;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StatusEffects implements Registrar {
	private static final class FlyabilityEffect extends StatusEffect {
		private FlyabilityEffect() {
			super(StatusEffectCategory.BENEFICIAL, 0x462e97);
		}

		@Override
		public void onApplied(net.minecraft.entity.LivingEntity entity,
				net.minecraft.entity.attribute.AttributeContainer attributes, int amplifier) {
			System.out.println("Hello world");
		}

		@Override
		public void applyUpdateEffect(net.minecraft.entity.LivingEntity entity, int amplifier) {
			System.out.println("Hello world");
		}

		@Override
		public void onRemoved(net.minecraft.entity.LivingEntity entity,
				net.minecraft.entity.attribute.AttributeContainer attributes, int amplifier) {
			System.out.println("Hello world");
		}
	}

	public static final StatusEffect FLYABILITY = new FlyabilityEffect();

	@Override
	public void registerStatusEffects() {
		Registry.register(Registries.STATUS_EFFECT, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "flyability")),
				FLYABILITY);
	}
}