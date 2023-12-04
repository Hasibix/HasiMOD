package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.EMERALD;

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

public class Emerald implements Registrar {
	// Helpers
	private static List<Identifier> getEmeraldUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getEmeraldUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_EMERALD_TEXTURE);
	}

	// Items
	public static final Item EMERALD_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_apple")),
			new FabricItemSettings().food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
					.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0F)
					.statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 3600, 2), 1.0F)
					.statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 9600, 0), 1.0F).build())
					.rarity(Rarity.COMMON));
	public static final Item EMERALD_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.emerald_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.emerald_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "emerald_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.emerald_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.emerald_upgrade.additions_slot_description"))),
			getEmeraldUpgradeEmptyBaseSlotTextures(), getEmeraldUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings());

	// Materials
	public static final ArmorMaterial EMERALD_ARMOR_MATERIAL = new ArmorMaterial(33, 15,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, HasiMOD.MOD_ID + ":emerald", 2, Ingredient.ofItems(EMERALD), 0);
	public static final ToolMaterial EMERALD_TOOL_MATERIAL = new ToolMaterial(2, 363, 15, MiningLevels.IRON, 4,
			Ingredient.ofItems(EMERALD));

	// Armors
	public static final Item EMERALD_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_helmet")), EMERALD_ARMOR_MATERIAL,
			Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item EMERALD_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_chestplate")), EMERALD_ARMOR_MATERIAL,
			Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item EMERALD_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_leggings")), EMERALD_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item EMERALD_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_boots")), EMERALD_ARMOR_MATERIAL, Type.BOOTS,
			new FabricItemSettings().rarity(Rarity.COMMON));

	// Tools
	public static final Item EMERALD_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_axe")), Item.ToolItem.Type.AXE,
			EMERALD_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item EMERALD_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_hoe")), Item.ToolItem.Type.HOE,
			EMERALD_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item EMERALD_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_pickaxe")), Item.ToolItem.Type.PICKAXE,
			EMERALD_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item EMERALD_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_shovel")), Item.ToolItem.Type.SHOVEL,
			EMERALD_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item EMERALD_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_sword")), Item.ToolItem.Type.SWORD,
			EMERALD_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Lists
	public static List<Item> EMERALD_ITEMS = List.of(EMERALD_APPLE, EMERALD_UPGRADE);
	public static List<Item> EMERALD_ARMORS = List.of(EMERALD_HELMET, EMERALD_CHESTPLATE, EMERALD_LEGGINGS,
			EMERALD_BOOTS);
	public static List<Item> EMERALD_TOOLS = List.of(EMERALD_AXE, EMERALD_HOE, EMERALD_PICKAXE, EMERALD_SHOVEL,
			EMERALD_SWORD);

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : EMERALD_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : EMERALD_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : EMERALD_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, EMERALD_UPGRADE.getRaw().get(), 2)
					.input('#', Items.CARBON.getRaw().get()).input('C', net.minecraft.item.Items.DEEPSLATE)
					.input('S', EMERALD_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(EMERALD_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(EMERALD_UPGRADE.getRaw().get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.getRaw().get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.COMBAT, EMERALD_HELMET.getRaw().get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_HELMET.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.getRaw().get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.COMBAT, EMERALD_CHESTPLATE.getRaw().get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_CHESTPLATE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.getRaw().get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.COMBAT, EMERALD_LEGGINGS.getRaw().get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_LEGGINGS.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.getRaw().get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.COMBAT, EMERALD_BOOTS.getRaw().get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_BOOTS.getIdentifier().getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.getRaw().get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_AXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_AXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.getRaw().get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_HOE.getRaw().get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_HOE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.getRaw().get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_PICKAXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_PICKAXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.getRaw().get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_SHOVEL.getRaw().get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_SHOVEL.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.getRaw().get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_SWORD.getRaw().get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_SWORD.getIdentifier().getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> emerald_all = new ArrayList<>();

		for (Item i : EMERALD_ITEMS) {
			emerald_all.add(i.getRaw().get());
		}
		for (Item i : EMERALD_ARMORS) {
			emerald_all.add(i.getRaw().get());
		}
		for (Item i : EMERALD_TOOLS) {
			emerald_all.add(i.getRaw().get());
		}

		emerald_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
