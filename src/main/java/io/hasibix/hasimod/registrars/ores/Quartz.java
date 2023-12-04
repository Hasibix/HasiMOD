package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.LAPIS_LAZULI;
import static net.minecraft.item.Items.QUARTZ;

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

public class Quartz implements Registrar {
	// Helpers
	private static List<Identifier> getQuartzUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getQuartzUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_QUARTZ_TEXTURE);
	}

	// Items
	public static final Item QUARTZ_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_apple")),
			new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 9600, 0), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 2), 1.0F).build())
					.rarity(Rarity.COMMON));
	public static final Item QUARTZ_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.quartz_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.quartz_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "quartz_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.quartz_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.quartz_upgrade.additions_slot_description"))),
			getQuartzUpgradeEmptyBaseSlotTextures(), getQuartzUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings());

	// Materials
	public static final ArmorMaterial QUARTZ_ARMOR_MATERIAL = new ArmorMaterial(33, 8,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, HasiMOD.MOD_ID + ":quartz", 2, Ingredient.ofItems(LAPIS_LAZULI),
			0);
	public static final ToolMaterial QUARTZ_TOOL_MATERIAL = new ToolMaterial(2, 363, 8, MiningLevels.IRON, 4,
			Ingredient.ofItems(LAPIS_LAZULI));

	// Armors
	public static final Item QUARTZ_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_helmet")), QUARTZ_ARMOR_MATERIAL, Type.HELMET,
			new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item QUARTZ_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_chestplate")), QUARTZ_ARMOR_MATERIAL,
			Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item QUARTZ_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_leggings")), QUARTZ_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item QUARTZ_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_boots")), QUARTZ_ARMOR_MATERIAL, Type.BOOTS,
			new FabricItemSettings().rarity(Rarity.COMMON));

	// Tools
	public static final Item QUARTZ_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_axe")), Item.ToolItem.Type.AXE,
			QUARTZ_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item QUARTZ_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_hoe")), Item.ToolItem.Type.HOE,
			QUARTZ_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item QUARTZ_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_pickaxe")), Item.ToolItem.Type.PICKAXE,
			QUARTZ_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item QUARTZ_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_shovel")), Item.ToolItem.Type.SHOVEL,
			QUARTZ_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item QUARTZ_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_sword")), Item.ToolItem.Type.SWORD,
			QUARTZ_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Lists
	public static List<Item> QUARTZ_ITEMS = List.of(QUARTZ_APPLE, QUARTZ_UPGRADE);
	public static List<Item> QUARTZ_ARMORS = List.of(QUARTZ_HELMET, QUARTZ_CHESTPLATE, QUARTZ_LEGGINGS, QUARTZ_BOOTS);
	public static List<Item> QUARTZ_TOOLS = List.of(QUARTZ_AXE, QUARTZ_HOE, QUARTZ_PICKAXE, QUARTZ_SHOVEL,
			QUARTZ_SWORD);

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : QUARTZ_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : QUARTZ_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : QUARTZ_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, QUARTZ_UPGRADE.getRaw().get(), 2)
					.input('#', Items.CARBON.getRaw().get()).input('C', net.minecraft.item.Items.NETHERRACK)
					.input('S', QUARTZ_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(QUARTZ_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(QUARTZ_UPGRADE.getRaw().get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.getRaw().get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, QUARTZ_HELMET.getRaw().get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_HELMET.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.getRaw().get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, QUARTZ_CHESTPLATE.getRaw().get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_CHESTPLATE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.getRaw().get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, QUARTZ_LEGGINGS.getRaw().get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_LEGGINGS.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.getRaw().get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, QUARTZ_BOOTS.getRaw().get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_BOOTS.getIdentifier().getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.getRaw().get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_AXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_AXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.getRaw().get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_HOE.getRaw().get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_HOE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.getRaw().get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_PICKAXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_PICKAXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.getRaw().get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_SHOVEL.getRaw().get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_SHOVEL.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.getRaw().get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_SWORD.getRaw().get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_SWORD.getIdentifier().getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> quartz_all = new ArrayList<>();

		for (Item i : QUARTZ_ITEMS) {
			quartz_all.add(i.getRaw().get());
		}
		for (Item i : QUARTZ_ARMORS) {
			quartz_all.add(i.getRaw().get());
		}
		for (Item i : QUARTZ_TOOLS) {
			quartz_all.add(i.getRaw().get());
		}

		quartz_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
