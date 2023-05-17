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
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ScytheBlade extends ThrownItemEntity {
	public int damageAmount = 0;
	public boolean createExplosion = true;
	private List<StatusEffectInstance> effects;

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
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);

		List<StatusEffectInstance> effects = new ArrayList<>();
		if (nbt != null && nbt.contains("CustomPotionEffects")) {
			NbtList effectsTag = nbt.getList("CustomPotionEffects", 10);
			for (int i = 0; i < effectsTag.size(); i++) {
				NbtCompound effectTag = effectsTag.getCompound(i);
				if (effectTag.contains("Id") && effectTag.contains("Amplifier") && effectTag.contains("Duration")
						&& effectTag.contains("Ambient") && effectTag.contains("ShowParticles")
						&& effectTag.contains("ShowIcon")) {
					Identifier effectId = Identifier.tryParse(effectTag.getString("Id"));
					int duration = effectTag.getInt("Duration");
					int amplifier = effectTag.getInt("Amplifier");
					boolean ambient = effectTag.getBoolean("Ambient");
					boolean showParticles = effectTag.getBoolean("ShowParticles");
					boolean showIcon = effectTag.getBoolean("ShowIcon");

					if (effectId != null) {
						StatusEffectInstance effectInstance = new StatusEffectInstance(
								Registries.STATUS_EFFECT.get(effectId), duration, amplifier, ambient, showParticles,
								showIcon);
						if (effectInstance != null) {
							effects.add(effectInstance);
						}
					}
				}
			}
		}
		this.effects = effects;
	}

	public List<StatusEffectInstance> getEffects() {
		return this.effects;
	}
	
	@Override
    public NbtCompound writeNbt(NbtCompound nbt) {
       return  super.writeNbt(nbt);
    }

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		Entity entity = entityHitResult.getEntity();
		entity.damage(new io.hasibix.minecraft.hasimod.damage_sources.ScytheBlade(this.getOwner()),
				(float) this.damageAmount * 2);
		if (entity instanceof LivingEntity livingEntity) {
			for (StatusEffectInstance effect : effects) {
				livingEntity.addStatusEffect(effect);
			}
		}
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		if (!this.world.isClient) {
			this.world.sendEntityStatus(this, (byte) 3);
			if (this.createExplosion) {
				this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 2.0f,
						World.ExplosionSourceType.MOB);
			}
			this.kill();
		}
	}
}
