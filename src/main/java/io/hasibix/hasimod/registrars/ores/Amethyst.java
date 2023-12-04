package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.AMETHYST_SHARD;

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

public class Amethyst implements Registrar {
	// Helpers
	private static List<Identifier> getAmethystUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getAmethystUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_AMETHYST_SHARD_TEXTURE);
	}

	// Items
	public static final Item AMETHYST_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_apple")),
			new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 3600, 0), 1.0F).build())
					.rarity(Rarity.COMMON));
	public static final Item AMETHYST_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.amethyst_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.amethyst_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "amethyst_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.amethyst_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.amethyst_upgrade.additions_slot_description"))),
			getAmethystUpgradeEmptyBaseSlotTextures(), getAmethystUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings());

	// Materials
	public static final ArmorMaterial AMETHYST_ARMOR_MATERIAL = new ArmorMaterial(33, 12,
			SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, HasiMOD.MOD_ID + ":amethyst", 2, Ingredient.ofItems(AMETHYST_SHARD),
			0);
	public static final ToolMaterial AMETHYST_TOOL_MATERIAL = new ToolMaterial(2, 363, 12, MiningLevels.IRON, 4,
			Ingredient.ofItems(AMETHYST_SHARD));

	// Armors
	public static final Item AMETHYST_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_helmet")), AMETHYST_ARMOR_MATERIAL,
			Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item AMETHYST_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_chestplate")), AMETHYST_ARMOR_MATERIAL,
			Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item AMETHYST_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_leggings")), AMETHYST_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item AMETHYST_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_boots")), AMETHYST_ARMOR_MATERIAL,
			Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON));

	// Tools
	public static final Item AMETHYST_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_axe")), Item.ToolItem.Type.AXE,
			AMETHYST_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item AMETHYST_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_hoe")), Item.ToolItem.Type.HOE,
			AMETHYST_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item AMETHYST_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_pickaxe")), Item.ToolItem.Type.PICKAXE,
			AMETHYST_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item AMETHYST_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_shovel")), Item.ToolItem.Type.SHOVEL,
			AMETHYST_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item AMETHYST_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_sword")), Item.ToolItem.Type.SWORD,
			AMETHYST_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Lists
	public static List<Item> AMETHYST_ITEMS = List.of(AMETHYST_APPLE, AMETHYST_UPGRADE);
	public static List<Item> AMETHYST_ARMORS = List.of(AMETHYST_HELMET, AMETHYST_CHESTPLATE, AMETHYST_LEGGINGS,
			AMETHYST_BOOTS);
	public static List<Item> AMETHYST_TOOLS = List.of(AMETHYST_AXE, AMETHYST_HOE, AMETHYST_PICKAXE, AMETHYST_SHOVEL,
			AMETHYST_SWORD);

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : AMETHYST_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : AMETHYST_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : AMETHYST_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AMETHYST_UPGRADE.getRaw().get(), 2)
					.input('#', AMETHYST_SHARD).input('C', net.minecraft.item.Items.CALCITE)
					.input('S', AMETHYST_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(AMETHYST_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(AMETHYST_UPGRADE.getRaw().get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.getRaw().get()),
							Ingredient.ofItems(AMETHYST_SHARD), RecipeCategory.COMBAT, AMETHYST_HELMET.getRaw().get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_HELMET.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(AMETHYST_UPGRADE.getRaw().get()),
					Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.getRaw().get()), Ingredient.ofItems(AMETHYST_SHARD),
					RecipeCategory.COMBAT, AMETHYST_CHESTPLATE.getRaw().get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_CHESTPLATE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.getRaw().get()),
							Ingredient.ofItems(AMETHYST_SHARD), RecipeCategory.COMBAT, AMETHYST_LEGGINGS.getRaw().get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_LEGGINGS.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.getRaw().get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.COMBAT, AMETHYST_BOOTS.getRaw().get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_BOOTS.getIdentifier().getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.getRaw().get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.TOOLS, AMETHYST_AXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_AXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.getRaw().get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.TOOLS, AMETHYST_HOE.getRaw().get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_HOE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.getRaw().get()),
							Ingredient.ofItems(AMETHYST_SHARD), RecipeCategory.TOOLS, AMETHYST_PICKAXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_PICKAXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.getRaw().get()),
							Ingredient.ofItems(AMETHYST_SHARD), RecipeCategory.TOOLS, AMETHYST_SHOVEL.getRaw().get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_SHOVEL.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.getRaw().get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.TOOLS, AMETHYST_SWORD.getRaw().get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_SWORD.getIdentifier().getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> amethyst_all = new ArrayList<>();

		for (Item i : AMETHYST_ITEMS) {
			amethyst_all.add(i.getRaw().get());
		}
		for (Item i : AMETHYST_ARMORS) {
			amethyst_all.add(i.getRaw().get());
		}
		for (Item i : AMETHYST_TOOLS) {
			amethyst_all.add(i.getRaw().get());
		}

		amethyst_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
