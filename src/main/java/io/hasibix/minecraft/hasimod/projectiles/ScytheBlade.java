package io.hasibix.minecraft.hasimod.projectiles;

import java.util.ArrayList;
import java.util.List;

import io.hasibix.minecraft.hasimod.init.Items;
import io.hasibix.minecraft.hasimod.init.Projectiles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ScytheBlade extends ThrownItemEntity {
	public int damageAmount = 0;
	public List<StatusEffectInstance> effects = new ArrayList<>();

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
		entity.damage(new io.hasibix.minecraft.hasimod.damage_sources.ScytheBlade(this.getOwner()),
				(float) this.damageAmount * 2);
		if (entity instanceof LivingEntity livingEntity) {
			for(StatusEffectInstance effect : effects) {
				livingEntity.addStatusEffect(effect);
			}
		}
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		if (!this.world.isClient) {
			this.world.sendEntityStatus(this, (byte) 3);
			this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 2.0f,
					World.ExplosionSourceType.MOB);
			this.kill();
		}
	}
}
