package io.hasibix.hasimod.types;

import org.jetbrains.annotations.NotNull;

import net.minecraft.item.ArmorItem.Type;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public final class ArmorMaterial implements net.minecraft.item.ArmorMaterial {
	private final int durability;
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

	public ArmorMaterial(int durability, int enchantability, @NotNull SoundEvent equipSound, float knockbackResistance,
			@NotNull String name, int protection, Ingredient repairIngredient, float toughness) {
		this.durability = durability;
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
		switch (type) {
		case HELMET:
			return this.durability * 1;
		case CHESTPLATE:
			return this.durability * 3;
		case LEGGINGS:
			return this.durability * 2;
		case BOOTS:
			return this.durability * 1;
		default:
			return this.durability;
		}
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getProtection(Type type) {
		switch (type) {
		case HELMET:
			return this.protection * 1;
		case CHESTPLATE:
			return this.protection * 3;
		case LEGGINGS:
			return this.protection * 2;
		case BOOTS:
			return this.protection * 1;
		default:
			return this.protection;
		}
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}
}
