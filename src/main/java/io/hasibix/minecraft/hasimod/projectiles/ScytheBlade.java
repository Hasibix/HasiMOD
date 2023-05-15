package io.hasibix.minecraft.hasimod.projectiles;

import java.util.List;

import io.hasibix.minecraft.hasimod.init.Items;
import io.hasibix.minecraft.hasimod.init.Projectiles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ScytheBlade extends ThrownItemEntity {
	public int damageAmount = 0;
	public List<StatusEffect> effects;
	public ScytheBlade(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public ScytheBlade(World world, LivingEntity livingEntity) {
		super(Projectiles.SCYTHE_BLADE, livingEntity, world);
	}

	public ScytheBlade(World world, double x, double y, double z) {
		super(Projectiles.SCYTHE_BLADE, x, y, z, world);
	}
	
	@Override
	protected Item getDefaultItem() {
		return Items.SCYTHE_BLADE;
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		Entity entity = entityHitResult.getEntity();
		entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float) this.damageAmount * 2);
		if (entity instanceof LivingEntity livingEntity) {
			effects.forEach((e) -> {
				livingEntity.addStatusEffect((new StatusEffectInstance(e, 20 * damageAmount, damageAmount)));
			});
		}
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		if (!this.world.isClient) {
			this.world.sendEntityStatus(this, (byte) 3);
			this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 4.0f, World.ExplosionSourceType.MOB);
			this.kill();
		}
	}
}
