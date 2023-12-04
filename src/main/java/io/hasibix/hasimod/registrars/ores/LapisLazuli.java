package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.LAPIS_LAZULI;

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

public class LapisLazuli implements Registrar {
	// Helpers
	private static List<Identifier> getLapisLazuliUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getLapisLazuliUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_LAPIS_LAZULI_TEXTURE);
	}

	// Items
	public static final Item LAPIS_LAZULI_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_apple")),
			new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 9600, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 4800, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 9600, 2), 1.0F).build())
					.rarity(Rarity.COMMON));
	public static final Item LAPIS_LAZULI_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.lapis_lazuli_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.lapis_lazuli_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(
					Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.lapis_lazuli_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID,
							"smithing_template.lapis_lazuli_upgrade.additions_slot_description"))),
			getLapisLazuliUpgradeEmptyBaseSlotTextures(), getLapisLazuliUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings());

	// Materials
	public static final ArmorMaterial LAPIS_LAZULI_ARMOR_MATERIAL = new ArmorMaterial(33, 25,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, HasiMOD.MOD_ID + ":lapis_lazuli", 2,
			Ingredient.ofItems(LAPIS_LAZULI), 0);
	public static final ToolMaterial LAPIS_LAZULI_TOOL_MATERIAL = new ToolMaterial(2, 363, 25, MiningLevels.IRON, 4,
			Ingredient.ofItems(LAPIS_LAZULI));

	// Armors
	public static final Item LAPIS_LAZULI_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_helmet")), LAPIS_LAZULI_ARMOR_MATERIAL,
			Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LAPIS_LAZULI_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_chestplate")),
			LAPIS_LAZULI_ARMOR_MATERIAL, Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LAPIS_LAZULI_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_leggings")), LAPIS_LAZULI_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LAPIS_LAZULI_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_boots")), LAPIS_LAZULI_ARMOR_MATERIAL,
			Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON));

	// Tools
	public static final Item LAPIS_LAZULI_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_axe")), Item.ToolItem.Type.AXE,
			LAPIS_LAZULI_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LAPIS_LAZULI_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_hoe")), Item.ToolItem.Type.HOE,
			LAPIS_LAZULI_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LAPIS_LAZULI_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_pickaxe")), Item.ToolItem.Type.PICKAXE,
			LAPIS_LAZULI_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LAPIS_LAZULI_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_shovel")), Item.ToolItem.Type.SHOVEL,
			LAPIS_LAZULI_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LAPIS_LAZULI_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_sword")), Item.ToolItem.Type.SWORD,
			LAPIS_LAZULI_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Lists
	public static List<Item> LAPIS_LAZULI_ITEMS = List.of(LAPIS_LAZULI_APPLE, LAPIS_LAZULI_UPGRADE);
	public static List<Item> LAPIS_LAZULI_ARMORS = List.of(LAPIS_LAZULI_HELMET, LAPIS_LAZULI_CHESTPLATE,
			LAPIS_LAZULI_LEGGINGS, LAPIS_LAZULI_BOOTS);
	public static List<Item> LAPIS_LAZULI_TOOLS = List.of(LAPIS_LAZULI_AXE, LAPIS_LAZULI_HOE, LAPIS_LAZULI_PICKAXE,
			LAPIS_LAZULI_SHOVEL, LAPIS_LAZULI_SWORD);

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : LAPIS_LAZULI_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : LAPIS_LAZULI_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : LAPIS_LAZULI_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, LAPIS_LAZULI_UPGRADE.getRaw().get(), 2)
					.input('#', Items.CARBON.getRaw().get()).input('C', net.minecraft.item.Items.STONE)
					.input('S', LAPIS_LAZULI_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(LAPIS_LAZULI_UPGRADE.getRaw().get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.getRaw().get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.COMBAT, LAPIS_LAZULI_HELMET.getRaw().get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_HELMET.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.getRaw().get()),
					Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.getRaw().get()), Ingredient.ofItems(LAPIS_LAZULI),
					RecipeCategory.COMBAT, LAPIS_LAZULI_CHESTPLATE.getRaw().get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_CHESTPLATE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.getRaw().get()),
					Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.getRaw().get()), Ingredient.ofItems(LAPIS_LAZULI),
					RecipeCategory.COMBAT, LAPIS_LAZULI_LEGGINGS.getRaw().get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_LEGGINGS.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.getRaw().get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.COMBAT, LAPIS_LAZULI_BOOTS.getRaw().get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_BOOTS.getIdentifier().getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.getRaw().get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_AXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_AXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.getRaw().get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_HOE.getRaw().get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_HOE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.getRaw().get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_PICKAXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_PICKAXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.getRaw().get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_SHOVEL.getRaw().get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_SHOVEL.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.getRaw().get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_SWORD.getRaw().get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_SWORD.getIdentifier().getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> lapis_lazuli_all = new ArrayList<>();

		for (Item i : LAPIS_LAZULI_ITEMS) {
			lapis_lazuli_all.add(i.getRaw().get());
		}
		for (Item i : LAPIS_LAZULI_ARMORS) {
			lapis_lazuli_all.add(i.getRaw().get());
		}
		for (Item i : LAPIS_LAZULI_TOOLS) {
			lapis_lazuli_all.add(i.getRaw().get());
		}

		lapis_lazuli_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
