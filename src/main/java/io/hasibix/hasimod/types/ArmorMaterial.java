package io.hasibix.hasimod.types;

import java.util.EnumMap;

import org.jetbrains.annotations.NotNull;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Util;

public final class ArmorMaterial implements net.minecraft.item.ArmorMaterial {
	private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY;

	private final int durabilityMultiplier;
	private final int enchantability;
	@NotNull
	private final SoundEvent equipSound;
	private final float knockbackResistance;
	@NotNull
	private final String name;
	private final int protection;
	@NotNull
	private final Ingredient repairIngredient;
	private final float toughness;

	public ArmorMaterial(int durabilityMultiplier, int enchantability, @NotNull SoundEvent equipSound,
			float knockbackResistance, @NotNull String name, int protection, @NotNull Ingredient repairIngredient,
			float toughness) {
		this.durabilityMultiplier = durabilityMultiplier;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.knockbackResistance = knockbackResistance;
		this.name = name;
		this.protection = protection;
		this.repairIngredient = repairIngredient;
		this.toughness = toughness;
	}

	@Override
	public int getDurability(Type type) {
		return BASE_DURABILITY.get(type) * durabilityMultiplier;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public @NotNull SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public @NotNull String getName() {
		return this.name;
	}

	@Override
	public int getProtection(Type type) {
		return switch (type) {
		case HELMET, BOOTS -> this.protection;
		case CHESTPLATE -> this.protection * 3;
		case LEGGINGS -> this.protection * 2;
		};
	}

	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	static {
		BASE_DURABILITY = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
			map.put(ArmorItem.Type.BOOTS, 13);
			map.put(ArmorItem.Type.LEGGINGS, 15);
			map.put(ArmorItem.Type.CHESTPLATE, 16);
			map.put(ArmorItem.Type.HELMET, 11);
		});
	}
}
