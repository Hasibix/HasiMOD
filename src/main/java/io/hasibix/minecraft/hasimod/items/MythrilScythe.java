package io.hasibix.minecraft.hasimod.items;

import io.hasibix.minecraft.hasimod.init.Items;
import io.hasibix.minecraft.hasimod.procedures.MythrilScytheLivingEntityIsHitWithTool;
import io.hasibix.minecraft.hasimod.procedures.MythrilScytheRightclicked;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MythrilScythe extends SwordItem {
	public MythrilScythe() {
		super(new ToolMaterial() {
			@Override
			public int getDurability() {
				return 6280;
			}

			@Override
			public float getMiningSpeedMultiplier() {
				return 24f;
			}

			@Override
			public float getAttackDamage() {
				return 148f;
			}

			@Override
			public int getMiningLevel() {
				return 20;
			}

			@Override
			public int getEnchantability() {
				return 140;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.ofStacks(new ItemStack(Items.MYTHRIL_GEM));
			}
		}, 3, 96f, new Item.Settings().fireproof());
	}

	@Override
	public boolean postHit(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
		boolean retval = super.postHit(itemstack, target, attacker);
		double x = target.getX();
		double y = target.getY();
		double z = target.getZ();
		World world = target.world;
		MythrilScytheLivingEntityIsHitWithTool.execute(com.google.common.collect.ImmutableMap.<String, Object>builder()
				.put("world", world).put("x", x).put("y", y).put("z", z).build());
		return retval;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
		TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
		MythrilScytheRightclicked.execute(com.google.common.collect.ImmutableMap.<String, Object>builder()
				.put("x", entity.getX()).put("y", entity.getY()).put("z", entity.getZ()).put("world", world)
				.put("entity", entity).build());
		return ar;
	}
}
