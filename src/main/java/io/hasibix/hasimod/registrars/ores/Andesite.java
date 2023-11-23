package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;

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
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

public class Andesite implements Registrar {
	@Nullable
	public static final net.minecraft.item.Item ANDESITE_ALLOY = Registries.ITEM
			.get(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("create", "andesite_alloy")));

	private static List<Identifier> getAndesiteUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getAndesiteUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item ANDESITE_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_apple")),
			new net.minecraft.item.Item(
					new FabricItemSettings()
							.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
									.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 4800, 2), 1.0F)
									.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 9600, 0),
											1.0F)
									.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 4800, 2), 1.0F).build())
							.rarity(Rarity.COMMON)));

	public static final Item ANDESITE_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.andesite_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.andesite_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "andesite_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.andesite_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.andesite_upgrade.additions_slot_description"))),
					getAndesiteUpgradeEmptyBaseSlotTextures(), getAndesiteUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial ANDESITE_ARMOR_MATERIAL = new ArmorMaterial(48, 8,
			SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, HasiMOD.MOD_ID + ":andesite", 2, Ingredient.ofItems(ANDESITE_ALLOY),
			0);
	public static final ToolMaterial ANDESITE_TOOL_MATERIAL = new ToolMaterial(3, 528, 8, MiningLevels.IRON, 6,
			Ingredient.ofItems(ANDESITE_ALLOY));

	// Items
	// Armors
	public static final Item ANDESITE_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_helmet")),
			new ArmorItem(ANDESITE_ARMOR_MATERIAL, Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ANDESITE_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_chestplate")),
			new ArmorItem(ANDESITE_ARMOR_MATERIAL, Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ANDESITE_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_leggings")),
			new ArmorItem(ANDESITE_ARMOR_MATERIAL, Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ANDESITE_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_boots")),
			new ArmorItem(ANDESITE_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON)));

	// Tools
	public static final Item ANDESITE_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_axe")),
			new AxeItem(ANDESITE_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ANDESITE_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_hoe")),
			new HoeItem(ANDESITE_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ANDESITE_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_pickaxe")),
			new PickaxeItem(ANDESITE_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ANDESITE_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_shovel")),
			new ShovelItem(ANDESITE_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ANDESITE_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_sword")),
			new SwordItem(ANDESITE_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON)));

	public static List<Item> ANDESITE_ITEMS = List.of(ANDESITE_APPLE, ANDESITE_UPGRADE);
	public static List<Item> ANDESITE_ARMORS = List.of(ANDESITE_HELMET, ANDESITE_CHESTPLATE, ANDESITE_LEGGINGS,
			ANDESITE_BOOTS);
	public static List<Item> ANDESITE_TOOLS = List.of(ANDESITE_AXE, ANDESITE_HOE, ANDESITE_PICKAXE, ANDESITE_SHOVEL,
			ANDESITE_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : ANDESITE_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : ANDESITE_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : ANDESITE_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, ANDESITE_ALLOY);
		ItemTagProvider.addTo(ItemTags.TRIM_MATERIALS, ANDESITE_ALLOY);

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, ANDESITE_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ANDESITE_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ANDESITE_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ANDESITE_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ANDESITE_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, ANDESITE_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, ANDESITE_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, ANDESITE_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, ANDESITE_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, ANDESITE_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ANDESITE_UPGRADE.raw.get(), 2)
					.input('#', ANDESITE_ALLOY).input('C', net.minecraft.item.Items.END_STONE)
					.input('S', ANDESITE_UPGRADE.raw.get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(ANDESITE_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(ANDESITE_UPGRADE.raw.get()))
					.offerTo(t);

			assert ANDESITE_ALLOY != null;
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ANDESITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(ANDESITE_ALLOY),
							RecipeCategory.COMBAT, ANDESITE_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(ANDESITE_ALLOY),
							RecipeProvider.conditionsFromItem(ANDESITE_ALLOY))
					.offerTo(t, ANDESITE_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ANDESITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(ANDESITE_ALLOY),
							RecipeCategory.COMBAT, ANDESITE_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(ANDESITE_ALLOY),
							RecipeProvider.conditionsFromItem(ANDESITE_ALLOY))
					.offerTo(t, ANDESITE_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ANDESITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(ANDESITE_ALLOY),
							RecipeCategory.COMBAT, ANDESITE_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(ANDESITE_ALLOY),
							RecipeProvider.conditionsFromItem(ANDESITE_ALLOY))
					.offerTo(t, ANDESITE_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ANDESITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(ANDESITE_ALLOY),
							RecipeCategory.COMBAT, ANDESITE_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(ANDESITE_ALLOY),
							RecipeProvider.conditionsFromItem(ANDESITE_ALLOY))
					.offerTo(t, ANDESITE_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ANDESITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(ANDESITE_ALLOY),
							RecipeCategory.TOOLS, ANDESITE_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(ANDESITE_ALLOY),
							RecipeProvider.conditionsFromItem(ANDESITE_ALLOY))
					.offerTo(t, ANDESITE_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ANDESITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(ANDESITE_ALLOY),
							RecipeCategory.TOOLS, ANDESITE_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(ANDESITE_ALLOY),
							RecipeProvider.conditionsFromItem(ANDESITE_ALLOY))
					.offerTo(t, ANDESITE_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ANDESITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(ANDESITE_ALLOY),
							RecipeCategory.TOOLS, ANDESITE_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(ANDESITE_ALLOY),
							RecipeProvider.conditionsFromItem(ANDESITE_ALLOY))
					.offerTo(t, ANDESITE_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ANDESITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(ANDESITE_ALLOY),
							RecipeCategory.TOOLS, ANDESITE_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(ANDESITE_ALLOY),
							RecipeProvider.conditionsFromItem(ANDESITE_ALLOY))
					.offerTo(t, ANDESITE_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ANDESITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(ANDESITE_ALLOY),
							RecipeCategory.TOOLS, ANDESITE_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(ANDESITE_ALLOY),
							RecipeProvider.conditionsFromItem(ANDESITE_ALLOY))
					.offerTo(t, ANDESITE_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> andesite_all = new ArrayList<>();

		for (Item i : ANDESITE_ITEMS) {
			andesite_all.add(i.raw.get());
		}
		for (Item i : ANDESITE_ARMORS) {
			andesite_all.add(i.raw.get());
		}
		for (Item i : ANDESITE_TOOLS) {
			andesite_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] andesite_all_array = andesite_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, andesite_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, andesite_all_array);
	}
}
