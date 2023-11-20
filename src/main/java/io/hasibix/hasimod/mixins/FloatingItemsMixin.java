package io.hasibix.hasimod.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.hasibix.hasimod.others.Tags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(ItemEntity.class)
public abstract class FloatingItemsMixin extends Entity {
	@Shadow
	public abstract ItemStack getStack();

	protected FloatingItemsMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(at = @At("TAIL"), method = "tick()V")
	private void dropItem(CallbackInfo info) {
		if (getStack().isIn(Tags.FLOATING_ITEMS_TAG)) {
			if (!hasNoGravity() && !getWorld().isClient && !getStack().isEmpty()) {
				setNoGravity(true);
			}
			this.setVelocity(this.getVelocity().multiply(1.0D, 0.96D, 1.0D));
		}
	}
}
