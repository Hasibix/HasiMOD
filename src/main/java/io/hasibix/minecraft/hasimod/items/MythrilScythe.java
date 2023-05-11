package io.hasibix.minecraft.hasimod.items;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import io.hasibix.minecraft.hasimod.procedures.MythrilScytheRightclicked;
import io.hasibix.minecraft.hasimod.procedures.MythrilScytheLivingEntityIsHitWithTool;
import io.hasibix.minecraft.hasimod.init.CreativeTabs;
import io.hasibix.minecraft.hasimod.init.Items;

public class MythrilScythe extends SwordItem {
	public MythrilScythe() {
		super(new Tier() {
			public int getUses() {
				return 6280;
			}

			public float getSpeed() {
				return 24f;
			}

			public float getAttackDamageBonus() {
				return 148f;
			}

			public int getLevel() {
				return 20;
			}

			public int getEnchantmentValue() {
				return 140;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.MYTHRIL_GEM));
			}
		}, 3, 96f, new Item.Properties().tab(CreativeTabs.TAB_HASI_MOD).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Level world = entity.level;
		MythrilScytheLivingEntityIsHitWithTool.execute(com.google.common.collect.ImmutableMap
				.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).build());
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		MythrilScytheRightclicked.execute(com.google.common.collect.ImmutableMap.<String, Object>builder()
				.put("x", entity.getX()).put("y", entity.getY()).put("z", entity.getZ()).put("world", world)
				.put("entity", entity).build());
		return ar;
	}
}
