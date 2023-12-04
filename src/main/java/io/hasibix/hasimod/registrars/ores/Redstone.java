package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.REDSTONE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.hasibix.hasimod.HasiMOD;
import io.hasibix.hasimod.datagen.providers.ModelProvider;
import io.hasibix.hasimod.datagen.providers.RecipeProvider;
import io.hasibix.hasimod.init.Tabs;
import io.hasibix.hasimod.subregistrars.Items;
import io.hasibix.hasimod.types.ArmorMaterial;
import io.hasibix.hasimod.types.Item;
import io.hasibix.hasimod.types.Registrar;
import io.hasibix.hasimod.types.ToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.FoodComponent;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

public class Redstone implements Registrar {
	// Helpers
	private static List<Identifier> getRedstoneUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getRedstoneUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_REDSTONE_DUST_TEXTURE);
	}

	// Items
	public static final Item REDSTONE_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_apple")),
			new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 4800, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 4800, 2), 1.0F).build())
					.rarity(Rarity.COMMON));
	public static final Item REDSTONE_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.redstone_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.redstone_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "redstone_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.redstone_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.redstone_upgrade.additions_slot_description"))),
			getRedstoneUpgradeEmptyBaseSlotTextures(), getRedstoneUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings());

	// Materials
	public static final ArmorMaterial REDSTONE_ARMOR_MATERIAL = new ArmorMaterial(33, 9,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, HasiMOD.MOD_ID + ":redstone", 2, Ingredient.ofItems(REDSTONE), 0);
	public static final ToolMaterial REDSTONE_TOOL_MATERIAL = new ToolMaterial(2, 363, 9, MiningLevels.IRON, 4,
			Ingredient.ofItems(REDSTONE));

	// Armors
	public static final Item REDSTONE_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_helmet")), REDSTONE_ARMOR_MATERIAL,
			Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item REDSTONE_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_chestplate")), REDSTONE_ARMOR_MATERIAL,
			Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item REDSTONE_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_leggings")), REDSTONE_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item REDSTONE_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_boots")), REDSTONE_ARMOR_MATERIAL,
			Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON));

	// Tools
	public static final Item REDSTONE_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_axe")), Item.ToolItem.Type.AXE,
			REDSTONE_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item REDSTONE_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_hoe")), Item.ToolItem.Type.HOE,
			REDSTONE_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item REDSTONE_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_pickaxe")), Item.ToolItem.Type.PICKAXE,
			REDSTONE_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item REDSTONE_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_shovel")), Item.ToolItem.Type.SHOVEL,
			REDSTONE_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item REDSTONE_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_sword")), Item.ToolItem.Type.SWORD,
			REDSTONE_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Lists
	public static List<Item> REDSTONE_ITEMS = List.of(REDSTONE_APPLE, REDSTONE_UPGRADE);
	public static List<Item> REDSTONE_ARMORS = List.of(REDSTONE_HELMET, REDSTONE_CHESTPLATE, REDSTONE_LEGGINGS,
			REDSTONE_BOOTS);
	public static List<Item> REDSTONE_TOOLS = List.of(REDSTONE_AXE, REDSTONE_HOE, REDSTONE_PICKAXE, REDSTONE_SHOVEL,
			REDSTONE_SWORD);

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : REDSTONE_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : REDSTONE_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : REDSTONE_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, REDSTONE_UPGRADE.getRaw().get(), 2)
					.input('#', Items.CARBON.getRaw().get()).input('C', net.minecraft.item.Items.STONE)
					.input('S', REDSTONE_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(REDSTONE_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(REDSTONE_UPGRADE.getRaw().get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.getRaw().get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.COMBAT, REDSTONE_HELMET.getRaw().get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_HELMET.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.getRaw().get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.COMBAT, REDSTONE_CHESTPLATE.getRaw().get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_CHESTPLATE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.getRaw().get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.COMBAT, REDSTONE_LEGGINGS.getRaw().get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_LEGGINGS.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.getRaw().get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.COMBAT, REDSTONE_BOOTS.getRaw().get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_BOOTS.getIdentifier().getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.getRaw().get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_AXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_AXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.getRaw().get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_HOE.getRaw().get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_HOE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.getRaw().get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_PICKAXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_PICKAXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.getRaw().get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_SHOVEL.getRaw().get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_SHOVEL.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.getRaw().get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_SWORD.getRaw().get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_SWORD.getIdentifier().getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> redstone_all = new ArrayList<>();

		for (Item i : REDSTONE_ITEMS) {
			redstone_all.add(i.getRaw().get());
		}
		for (Item i : REDSTONE_ARMORS) {
			redstone_all.add(i.getRaw().get());
		}
		for (Item i : REDSTONE_TOOLS) {
			redstone_all.add(i.getRaw().get());
		}

		redstone_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
