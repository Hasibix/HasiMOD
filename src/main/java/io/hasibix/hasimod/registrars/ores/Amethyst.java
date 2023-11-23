package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.AMETHYST_SHARD;
import static net.minecraft.item.Items.EMERALD;

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
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

public class Amethyst implements Registrar {
	private static List<Identifier> getAmethystUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getAmethystUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item AMETHYST_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_apple")),
			new net.minecraft.item.Item(new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 3600, 0), 1.0F).build())
					.rarity(Rarity.COMMON)));

	public static final Item AMETHYST_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.amethyst_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.amethyst_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "amethyst_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.amethyst_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.amethyst_upgrade.additions_slot_description"))),
					getAmethystUpgradeEmptyBaseSlotTextures(), getAmethystUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial AMETHYST_ARMOR_MATERIAL = new ArmorMaterial(33, 12,
			SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, HasiMOD.MOD_ID + ":amethyst", 2,
			Ingredient.ofItems(AMETHYST_SHARD), 0);
	public static final ToolMaterial AMETHYST_TOOL_MATERIAL = new ToolMaterial(2, 363, 12, MiningLevels.IRON, 4,
			Ingredient.ofItems(AMETHYST_SHARD));

	// Items
	// Armors
	public static final Item AMETHYST_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_helmet")),
			new ArmorItem(AMETHYST_ARMOR_MATERIAL, Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item AMETHYST_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_chestplate")),
			new ArmorItem(AMETHYST_ARMOR_MATERIAL, Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item AMETHYST_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_leggings")),
			new ArmorItem(AMETHYST_ARMOR_MATERIAL, Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item AMETHYST_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_boots")),
			new ArmorItem(AMETHYST_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON)));

	// Tools
	public static final Item AMETHYST_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_axe")),
			new AxeItem(AMETHYST_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item AMETHYST_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_hoe")),
			new HoeItem(AMETHYST_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item AMETHYST_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_pickaxe")),
			new PickaxeItem(AMETHYST_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item AMETHYST_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_shovel")),
			new ShovelItem(AMETHYST_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item AMETHYST_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "amethyst_sword")),
			new SwordItem(AMETHYST_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON)));

	public static List<Item> AMETHYST_ITEMS = List.of(AMETHYST_APPLE, AMETHYST_UPGRADE);
	public static List<Item> AMETHYST_ARMORS = List.of(AMETHYST_HELMET, AMETHYST_CHESTPLATE, AMETHYST_LEGGINGS,
			AMETHYST_BOOTS);
	public static List<Item> AMETHYST_TOOLS = List.of(AMETHYST_AXE, AMETHYST_HOE, AMETHYST_PICKAXE, AMETHYST_SHOVEL,
			AMETHYST_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : AMETHYST_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : AMETHYST_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : AMETHYST_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, EMERALD);
		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, AMETHYST_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, AMETHYST_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, AMETHYST_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, AMETHYST_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, AMETHYST_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, AMETHYST_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, AMETHYST_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, AMETHYST_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, AMETHYST_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, AMETHYST_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AMETHYST_UPGRADE.raw.get(), 2)
					.input('#', AMETHYST_SHARD).input('C', net.minecraft.item.Items.END_STONE)
					.input('S', AMETHYST_UPGRADE.raw.get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(AMETHYST_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(AMETHYST_UPGRADE.raw.get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.COMBAT, AMETHYST_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.COMBAT, AMETHYST_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.COMBAT, AMETHYST_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.COMBAT, AMETHYST_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.TOOLS, AMETHYST_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.TOOLS, AMETHYST_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.TOOLS, AMETHYST_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.TOOLS, AMETHYST_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(AMETHYST_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(AMETHYST_SHARD),
							RecipeCategory.TOOLS, AMETHYST_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(AMETHYST_SHARD),
							RecipeProvider.conditionsFromItem(AMETHYST_SHARD))
					.offerTo(t, AMETHYST_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> amethyst_all = new ArrayList<>();

		for (Item i : AMETHYST_ITEMS) {
			amethyst_all.add(i.raw.get());
		}
		for (Item i : AMETHYST_ARMORS) {
			amethyst_all.add(i.raw.get());
		}
		for (Item i : AMETHYST_TOOLS) {
			amethyst_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] amethyst_all_array = amethyst_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, amethyst_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, amethyst_all_array);
	}
}
