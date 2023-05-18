package io.hasibix.minecraft.hasimod.projectiles;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import io.hasibix.minecraft.hasimod.init.Items;
import io.hasibix.minecraft.hasimod.init.Projectiles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtByte;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtInt;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ScytheBlade extends ThrownItemEntity {
	@NotNull
	private int damageAmount = 10;
	@NotNull
	private float createExplosion = 2F;

	public float getCreateExplosion() {
		return createExplosion;
	}

	public void setCreateExplosion(float createExplosion) {
		this.createExplosion = createExplosion;
	}

	public int getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}

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
				if (effectTag.contains("Id")) {
					Identifier effectId = null;
					int amplifier = 0;
					int duration = 20;
					boolean ambient = false;
					boolean showParticles = true;
					boolean showIcon = true;
					if (effectTag.contains("Id")) {
						if (effectTag.get("Id") instanceof NbtString) {
							effectId = Identifier.tryParse(effectTag.getString("Id"));
						}
					}
					if (effectTag.contains("Amplifier")) {
						if (effectTag.get("Amplifier") instanceof NbtInt) {
							amplifier = effectTag.getInt("Amplifier");
						}
					}
					if (effectTag.contains("Duration")) {
						if (effectTag.get("Duration") instanceof NbtInt) {
							duration = effectTag.getInt("Duration");
						}
					}
					if (effectTag.contains("Ambient")) {
						if (effectTag.get("Ambient") instanceof NbtByte) {
							ambient = effectTag.getBoolean("Ambient");
						}
					}
					if (effectTag.contains("ShowParticles")) {
						if (effectTag.get("ShowParticles") instanceof NbtByte) {
							showParticles = effectTag.getBoolean("ShowParticles");
						}
					}
					if (effectTag.contains("ShowIcon")) {
						if (effectTag.get("ShowIcon") instanceof NbtByte) {
							showIcon = effectTag.getBoolean("ShowIcon");
						}
					}
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

	@Override
	public NbtCompound writeNbt(NbtCompound nbt) {
		NbtList effectsTag = new NbtList();
		for (StatusEffectInstance effect : this.effects) {
			NbtCompound effectTag = new NbtCompound();
			effectTag.putString("Id", Registries.STATUS_EFFECT.getId(effect.getEffectType()).toString());
			effectTag.putInt("Duration", effect.getDuration());
			effectTag.putInt("Amplifier", effect.getAmplifier());
			effectTag.putBoolean("Ambient", effect.isAmbient());
			effectTag.putBoolean("ShowParticles", effect.shouldShowParticles());
			effectTag.putBoolean("ShowIcon", effect.shouldShowIcon());
			effectsTag.add(effectTag);
		}

		if (!effectsTag.isEmpty()) {
			nbt.put("CustomPotionEffects", effectsTag);
		}

		return super.writeNbt(nbt);
	}

	public void setEffects(List<StatusEffectInstance> list) {
		NbtCompound nbt = new NbtCompound();
		NbtList effectsTag = new NbtList();
		for (StatusEffectInstance effect : list) {
			NbtCompound effectTag = new NbtCompound();
			effectTag.putString("Id", Registries.STATUS_EFFECT.getId(effect.getEffectType()).toString());
			effectTag.putInt("Duration", effect.getDuration());
			effectTag.putInt("Amplifier", effect.getAmplifier());
			effectTag.putBoolean("Ambient", effect.isAmbient());
			effectTag.putBoolean("ShowParticles", effect.shouldShowParticles());
			effectTag.putBoolean("ShowIcon", effect.shouldShowIcon());
			effectsTag.add(effectTag);
		}

		if (!effectsTag.isEmpty()) {
			nbt.put("CustomPotionEffects", effectsTag);
		}
		this.readNbt(nbt);
	}

	public List<StatusEffectInstance> getEffects() {
		return this.effects;
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
			this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0f,
					World.ExplosionSourceType.MOB);
			this.kill();
		}
	}
}
