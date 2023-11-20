package io.hasibix.hasimod.types;

import org.jetbrains.annotations.NotNull;

import net.minecraft.recipe.Ingredient;

public final class ToolMaterial implements net.minecraft.item.ToolMaterial {
	private final float attackDamage;
	private final int durability;
	private final int enchantability;
	private final int miningLevel;
	private final float miningSpeedMultiplier;
	@NotNull
	private final Ingredient repairIngredient;

	public ToolMaterial(float attackDamage, int durability, int enchantability, int miningLevel,
			float miningSpeedMultiplier, @NotNull Ingredient repairIngredient) {
		this.attackDamage = attackDamage;
		this.durability = durability;
		this.enchantability = enchantability;
		this.miningLevel = miningLevel;
		this.miningSpeedMultiplier = miningSpeedMultiplier;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getDurability() {
		return this.durability;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public int getMiningLevel() {
		return this.miningLevel;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return this.miningSpeedMultiplier;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}
}
