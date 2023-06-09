package io.hasibix.minecraft.hasimod.status_effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class Flyability extends StatusEffect {
	public boolean expired = false;
	public boolean allowFlying = false;
	public boolean creativeMode = false;

	public Flyability() {
		super(StatusEffectCategory.BENEFICIAL, 0x462E97);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		PlayerEntity player = entity instanceof PlayerEntity ? (PlayerEntity) entity : null;
		boolean creativeMode = player != null ? player.getAbilities().creativeMode : false;

		if (!this.expired) {
			if (!this.allowFlying) {
				player.getAbilities().allowFlying = true;
				player.sendAbilitiesUpdate();
				this.allowFlying = true;
			}
			if (creativeMode && !this.creativeMode) {
				this.allowFlying = false;
				this.creativeMode = true;
			} else if (!creativeMode && this.creativeMode) {
				this.allowFlying = false;
				this.creativeMode = false;
			}
		}
	}

	@Override
	public void onRemoved(LivingEntity entity, AttributeContainer attributeContainer, int amplifier) {
		super.onRemoved(entity, attributeContainer, amplifier);

		if (!(entity instanceof PlayerEntity _plr ? _plr.getAbilities().creativeMode : false)) {
			((PlayerEntity) entity).getAbilities().allowFlying = false;
			((PlayerEntity) entity).sendAbilitiesUpdate();
			((PlayerEntity) entity).getAbilities().flying = false;
			((PlayerEntity) entity).sendAbilitiesUpdate();
		}
		this.expired = true;
		this.allowFlying = false;
		this.creativeMode = false;
	}
}
