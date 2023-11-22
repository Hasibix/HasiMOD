package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.COPPER_INGOT;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.hasibix.hasimod.HasiMOD;
import io.hasibix.hasimod.datagen.providers.ItemTagProvider;
import io.hasibix.hasimod.datagen.providers.ModelProvider;
import io.hasibix.hasimod.datagen.providers.RecipeProvider;
import io.hasibix.hasimod.init.Tabs;
import io.hasibix.hasimod.subregistrars.Items;
import io.hasibix.hasimod.types.ArmorMaterial;
import io.hasibix.hasimod.types.Item;
import io.hasibix.hasimod.types.Registrar;
import io.hasibix.hasimod.types.ToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

public class Copper implements Registrar {
	private static List<Identifier> getCopperUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getCopperUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item COPPER_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(12).saturationModifier(15)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
							.build())
					.rarity(Rarity.EPIC)));

	public static final Item COPPER_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.copper_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.copper_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "copper_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.copper_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.copper_upgrade.additions_slot_description"))),
					getCopperUpgradeEmptyBaseSlotTextures(), getCopperUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial COPPER_ARMOR_MATERIAL = new ArmorMaterial(4096, 50,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.2F, HasiMOD.MOD_ID + ":copper", 12,
			Ingredient.ofItems(COPPER_INGOT), 6.0F);
	public static final ToolMaterial COPPER_TOOL_MATERIAL = new ToolMaterial(1.0F, 4096, 50, 4, 18.0F,
			Ingredient.ofItems(COPPER_INGOT));

	// Items
	// Armors
	public static final Item COPPER_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_helmet")), new ArmorItem(COPPER_ARMOR_MATERIAL,
					Type.HELMET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item COPPER_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_chestplate")), new ArmorItem(
					COPPER_ARMOR_MATERIAL, Type.CHESTPLATE, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item COPPER_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_leggings")), new ArmorItem(
					COPPER_ARMOR_MATERIAL, Type.LEGGINGS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item COPPER_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_boots")),
			new ArmorItem(COPPER_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	// Tools
	public static final Item COPPER_AXE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_axe")),
			new AxeItem(COPPER_TOOL_MATERIAL, 18, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item COPPER_HOE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_hoe")),
			new HoeItem(COPPER_TOOL_MATERIAL, 4, 8.0F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item COPPER_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_pickaxe")),
			new PickaxeItem(COPPER_TOOL_MATERIAL, 12, 2.4F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item COPPER_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_shovel")),
			new ShovelItem(COPPER_TOOL_MATERIAL, 12, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item COPPER_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "copper_sword")),
			new SwordItem(COPPER_TOOL_MATERIAL, 14, 3.2F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	public static List<Item> COPPER_ITEMS = List.of(COPPER_APPLE, COPPER_UPGRADE);
	public static List<Item> COPPER_ARMORS = List.of(COPPER_HELMET, COPPER_CHESTPLATE, COPPER_LEGGINGS, COPPER_BOOTS);
	public static List<Item> COPPER_TOOLS = List.of(COPPER_AXE, COPPER_HOE, COPPER_PICKAXE, COPPER_SHOVEL,
			COPPER_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : COPPER_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : COPPER_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : COPPER_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, COPPER_INGOT);

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, COPPER_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, COPPER_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, COPPER_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, COPPER_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, COPPER_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, COPPER_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, COPPER_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, COPPER_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, COPPER_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, COPPER_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, COPPER_UPGRADE.raw.get(), 2).input('#', COPPER_INGOT)
					.input('C', net.minecraft.item.Items.END_STONE).input('S', COPPER_UPGRADE.raw.get()).pattern("#S#")
					.pattern("#C#").pattern("###").criterion(RecipeProvider.hasItem(COPPER_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(COPPER_UPGRADE.raw.get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.COMBAT, COPPER_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.COMBAT, COPPER_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.COMBAT, COPPER_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.COMBAT, COPPER_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(COPPER_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(COPPER_INGOT),
							RecipeCategory.TOOLS, COPPER_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(COPPER_INGOT), RecipeProvider.conditionsFromItem(COPPER_INGOT))
					.offerTo(t, COPPER_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> copper_all = new ArrayList<>();

		for (Item i : COPPER_ITEMS) {
			copper_all.add(i.raw.get());
		}
		for (Item i : COPPER_ARMORS) {
			copper_all.add(i.raw.get());
		}
		for (Item i : COPPER_TOOLS) {
			copper_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] copper_all_array = copper_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, copper_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, copper_all_array);
	}
}
