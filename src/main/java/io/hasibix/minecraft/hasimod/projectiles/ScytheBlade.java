package io.hasibix.minecraft.hasimod.projectiles;

import io.hasibix.minecraft.hasimod.init.Items;
import io.hasibix.minecraft.hasimod.init.Projectiles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ScytheBlade extends ThrownItemEntity {
	public int damageAmount;
	public ScytheBlade(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
		this.damageAmount = 3;
	}

	public ScytheBlade(World world, LivingEntity livingEntity, int damageAmount) {
		super(Projectiles.SCYTHE_BLADE, livingEntity, world);
		this.damageAmount = damageAmount;
	}

	public ScytheBlade(World world, double d, double e, double f,  int damageAmount) {
		super(Projectiles.SCYTHE_BLADE, d, e, f, world);
		this.damageAmount = damageAmount;
	}
	
	@Override
	protected Item getDefaultItem() {
		return Items.SCYTHE_BLADE;
	}
	
	@Override
	protected ItemStack getItem() {
		return Items.SCYTHE_BLADE.getDefaultStack();
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		Entity entity = entityHitResult.getEntity();
		entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float) this.damageAmount);
		if (entity instanceof LivingEntity livingEntity) {
			livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.HUNGER, 20 * damageAmount, damageAmount)));
			livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.DARKNESS, 20 * damageAmount, damageAmount)));
			livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * damageAmount, damageAmount)));
			livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * damageAmount, damageAmount)));
			livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.WITHER, 20 * damageAmount, damageAmount)));
		}
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		if (!this.world.isClient) {
			this.world.sendEntityStatus(this, (byte) 3);
			this.kill();
		}
	}
}
