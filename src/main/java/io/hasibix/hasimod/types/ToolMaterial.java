package io.hasibix.hasimod.types;

import org.jetbrains.annotations.NotNull;

import net.minecraft.recipe.Ingredient;

public record ToolMaterial(float attackDamage, int durability, int enchantability, int miningLevel,
		float miningSpeedMultiplier, @NotNull Ingredient repairIngredient) implements net.minecraft.item.ToolMaterial {
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
	public @NotNull Ingredient getRepairIngredient() {
		return this.repairIngredient;
	}
}
