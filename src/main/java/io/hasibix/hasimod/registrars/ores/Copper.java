package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.COPPER_INGOT;

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

public class Copper implements Registrar {
	// Helpers
	private static List<Identifier> getCopperUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getCopperUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	public static final Item COPPER_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_apple")),
			new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 4800, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 9600, 0), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 4800, 2), 1.0F).build())
					.rarity(Rarity.COMMON));
	public static final Item COPPER_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.copper_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.copper_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "copper_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.copper_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.copper_upgrade.additions_slot_description"))),
			getCopperUpgradeEmptyBaseSlotTextures(), getCopperUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings());

	// Materials
	public static final ArmorMaterial COPPER_ARMOR_MATERIAL = new ArmorMaterial(33, 9,
			SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, HasiMOD.MOD_ID + ":copper", 2, Ingredient.ofItems(COPPER_INGOT), 0);
	public static final ToolMaterial COPPER_TOOL_MATERIAL = new ToolMaterial(2, 363, 9, MiningLevels.IRON, 4,
			Ingredient.ofItems(COPPER_INGOT));

	// Armors
	public static final Item COPPER_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_helmet")), COPPER_ARMOR_MATERIAL, Type.HELMET,
			new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item COPPER_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_chestplate")), COPPER_ARMOR_MATERIAL,
			Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item COPPER_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_leggings")), COPPER_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item COPPER_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_boots")), COPPER_ARMOR_MATERIAL, Type.BOOTS,
			new FabricItemSettings().rarity(Rarity.COMMON));

	// Tools
	public static final Item COPPER_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_axe")), Item.ToolItem.Type.AXE,
			COPPER_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item COPPER_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_hoe")), Item.ToolItem.Type.HOE,
			COPPER_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item COPPER_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_pickaxe")), Item.ToolItem.Type.PICKAXE,
			COPPER_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item COPPER_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_shovel")), Item.ToolItem.Type.SHOVEL,
			COPPER_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item COPPER_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_sword")), Item.ToolItem.Type.SWORD,
			COPPER_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Methods
	public static List<Item> COPPER_ITEMS = List.of(COPPER_APPLE, COPPER_UPGRADE);
	public static List<Item> COPPER_ARMORS = List.of(COPPER_HELMET, COPPER_CHESTPLATE, COPPER_LEGGINGS, COPPER_BOOTS);
	public static List<Item> COPPER_TOOLS = List.of(COPPER_AXE, COPPER_HOE, COPPER_PICKAXE, COPPER_SHOVEL,
			COPPER_SWORD);

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : COPPER_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : COPPER_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : COPPER_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, COPPER_UPGRADE.getRaw().get(), 2)
					.input('#', Items.CARBON.getRaw().get()).input('C', net.minecraft.item.Items.STONE)
					.input('S', COPPER_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(COPPER_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(COPPER_UPGRADE.getRaw().get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.getRaw().get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.COMBAT, COPPER_HELMET.getRaw().get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_HELMET.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.getRaw().get()),
							Ingredient.ofItems(COPPER_INGOT), RecipeCategory.COMBAT, COPPER_CHESTPLATE.getRaw().get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_CHESTPLATE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.getRaw().get()),
							Ingredient.ofItems(COPPER_INGOT), RecipeCategory.COMBAT, COPPER_LEGGINGS.getRaw().get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_LEGGINGS.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.getRaw().get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.COMBAT, COPPER_BOOTS.getRaw().get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_BOOTS.getIdentifier().getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.getRaw().get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_AXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_AXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.getRaw().get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_HOE.getRaw().get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_HOE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.getRaw().get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_PICKAXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_PICKAXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.getRaw().get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_SHOVEL.getRaw().get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_SHOVEL.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.getRaw().get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_SWORD.getRaw().get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_SWORD.getIdentifier().getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> copper_all = new ArrayList<>();

		for (Item i : COPPER_ITEMS) {
			copper_all.add(i.getRaw().get());
		}
		for (Item i : COPPER_ARMORS) {
			copper_all.add(i.getRaw().get());
		}
		for (Item i : COPPER_TOOLS) {
			copper_all.add(i.getRaw().get());
		}

		copper_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
