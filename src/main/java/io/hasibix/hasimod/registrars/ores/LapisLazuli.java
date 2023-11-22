package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.LAPIS_LAZULI;

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

public class LapisLazuli implements Registrar {
	private static List<Identifier> getLapisLazuliUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getLapisLazuliUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item LAPIS_LAZULI_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(12).saturationModifier(15)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
							.build())
					.rarity(Rarity.EPIC)));

	public static final Item LAPIS_LAZULI_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_upgrade_smithing_template")),
			new SmithingTemplateItem(
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
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.lapis_lazuli_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.lapis_lazuli_upgrade.additions_slot_description"))),
					getLapisLazuliUpgradeEmptyBaseSlotTextures(), getLapisLazuliUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial LAPIS_LAZULI_ARMOR_MATERIAL = new ArmorMaterial(4096, 50,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.2F, HasiMOD.MOD_ID + ":lapis_lazuli", 12,
			Ingredient.ofItems(LAPIS_LAZULI), 6.0F);
	public static final ToolMaterial LAPIS_LAZULI_TOOL_MATERIAL = new ToolMaterial(1.0F, 4096, 50, 4, 18.0F,
			Ingredient.ofItems(LAPIS_LAZULI));

	// Items
	// Armors
	public static final Item LAPIS_LAZULI_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_helmet")),
			new ArmorItem(LAPIS_LAZULI_ARMOR_MATERIAL, Type.HELMET,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LAPIS_LAZULI_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_chestplate")),
			new ArmorItem(LAPIS_LAZULI_ARMOR_MATERIAL, Type.CHESTPLATE,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LAPIS_LAZULI_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_leggings")),
			new ArmorItem(LAPIS_LAZULI_ARMOR_MATERIAL, Type.LEGGINGS,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LAPIS_LAZULI_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_boots")), new ArmorItem(
					LAPIS_LAZULI_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	// Tools
	public static final Item LAPIS_LAZULI_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_axe")),
			new AxeItem(LAPIS_LAZULI_TOOL_MATERIAL, 18, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LAPIS_LAZULI_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_hoe")),
			new HoeItem(LAPIS_LAZULI_TOOL_MATERIAL, 4, 8.0F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LAPIS_LAZULI_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_pickaxe")), new PickaxeItem(
					LAPIS_LAZULI_TOOL_MATERIAL, 12, 2.4F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LAPIS_LAZULI_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_shovel")), new ShovelItem(
					LAPIS_LAZULI_TOOL_MATERIAL, 12, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LAPIS_LAZULI_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lapis_lazuli_sword")), new SwordItem(
					LAPIS_LAZULI_TOOL_MATERIAL, 14, 3.2F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	public static List<Item> LAPIS_LAZULI_ITEMS = List.of(LAPIS_LAZULI_APPLE, LAPIS_LAZULI_UPGRADE);
	public static List<Item> LAPIS_LAZULI_ARMORS = List.of(LAPIS_LAZULI_HELMET, LAPIS_LAZULI_CHESTPLATE,
			LAPIS_LAZULI_LEGGINGS, LAPIS_LAZULI_BOOTS);
	public static List<Item> LAPIS_LAZULI_TOOLS = List.of(LAPIS_LAZULI_AXE, LAPIS_LAZULI_HOE, LAPIS_LAZULI_PICKAXE,
			LAPIS_LAZULI_SHOVEL, LAPIS_LAZULI_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : LAPIS_LAZULI_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : LAPIS_LAZULI_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : LAPIS_LAZULI_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, LAPIS_LAZULI);

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, LAPIS_LAZULI_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, LAPIS_LAZULI_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, LAPIS_LAZULI_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, LAPIS_LAZULI_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, LAPIS_LAZULI_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, LAPIS_LAZULI_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, LAPIS_LAZULI_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, LAPIS_LAZULI_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, LAPIS_LAZULI_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, LAPIS_LAZULI_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, LAPIS_LAZULI_UPGRADE.raw.get(), 2).input('#', LAPIS_LAZULI)
					.input('C', net.minecraft.item.Items.END_STONE).input('S', LAPIS_LAZULI_UPGRADE.raw.get())
					.pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(LAPIS_LAZULI_UPGRADE.raw.get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.COMBAT, LAPIS_LAZULI_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.COMBAT, LAPIS_LAZULI_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.COMBAT, LAPIS_LAZULI_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.COMBAT, LAPIS_LAZULI_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LAPIS_LAZULI_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(LAPIS_LAZULI),
							RecipeCategory.TOOLS, LAPIS_LAZULI_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(LAPIS_LAZULI), RecipeProvider.conditionsFromItem(LAPIS_LAZULI))
					.offerTo(t, LAPIS_LAZULI_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> lapis_lazuli_all = new ArrayList<>();

		for (Item i : LAPIS_LAZULI_ITEMS) {
			lapis_lazuli_all.add(i.raw.get());
		}
		for (Item i : LAPIS_LAZULI_ARMORS) {
			lapis_lazuli_all.add(i.raw.get());
		}
		for (Item i : LAPIS_LAZULI_TOOLS) {
			lapis_lazuli_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] lapis_lazuli_all_array = lapis_lazuli_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, lapis_lazuli_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, lapis_lazuli_all_array);
	}
}
