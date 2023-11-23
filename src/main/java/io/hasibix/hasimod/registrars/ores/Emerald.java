package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
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

public class Emerald implements Registrar {
	private static List<Identifier> getEmeraldUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getEmeraldUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item EMERALD_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().food(new FoodComponent.Builder().alwaysEdible()
					.hunger(2).saturationModifier(9.6F)
					.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0F)
					.statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 3600, 2), 1.0F)
					.statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 9600, 0), 1.0F).build())
					.rarity(Rarity.COMMON)));

	public static final Item EMERALD_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.emerald_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.emerald_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "emerald_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.emerald_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.emerald_upgrade.additions_slot_description"))),
					getEmeraldUpgradeEmptyBaseSlotTextures(), getEmeraldUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial EMERALD_ARMOR_MATERIAL = new ArmorMaterial(33, 15,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, HasiMOD.MOD_ID + ":emerald", 2, Ingredient.ofItems(EMERALD), 0);
	public static final ToolMaterial EMERALD_TOOL_MATERIAL = new ToolMaterial(2, 363, 15, MiningLevels.IRON, 4,
			Ingredient.ofItems(EMERALD));

	// Items
	// Armors
	public static final Item EMERALD_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_helmet")),
			new ArmorItem(EMERALD_ARMOR_MATERIAL, Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item EMERALD_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_chestplate")),
			new ArmorItem(EMERALD_ARMOR_MATERIAL, Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item EMERALD_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_leggings")),
			new ArmorItem(EMERALD_ARMOR_MATERIAL, Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item EMERALD_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_boots")),
			new ArmorItem(EMERALD_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON)));

	// Tools
	public static final Item EMERALD_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_axe")),
			new AxeItem(EMERALD_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item EMERALD_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_hoe")),
			new HoeItem(EMERALD_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item EMERALD_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_pickaxe")),
			new PickaxeItem(EMERALD_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item EMERALD_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_shovel")),
			new ShovelItem(EMERALD_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item EMERALD_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "emerald_sword")),
			new SwordItem(EMERALD_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON)));

	public static List<Item> EMERALD_ITEMS = List.of(EMERALD_APPLE, EMERALD_UPGRADE);
	public static List<Item> EMERALD_ARMORS = List.of(EMERALD_HELMET, EMERALD_CHESTPLATE, EMERALD_LEGGINGS,
			EMERALD_BOOTS);
	public static List<Item> EMERALD_TOOLS = List.of(EMERALD_AXE, EMERALD_HOE, EMERALD_PICKAXE, EMERALD_SHOVEL,
			EMERALD_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : EMERALD_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : EMERALD_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : EMERALD_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, EMERALD_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, EMERALD_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, EMERALD_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, EMERALD_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, EMERALD_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, EMERALD_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, EMERALD_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, EMERALD_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, EMERALD_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, EMERALD_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, EMERALD_UPGRADE.raw.get(), 2).input('#', EMERALD)
					.input('C', net.minecraft.item.Items.END_STONE).input('S', EMERALD_UPGRADE.raw.get()).pattern("#S#")
					.pattern("#C#").pattern("###").criterion(RecipeProvider.hasItem(EMERALD_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(EMERALD_UPGRADE.raw.get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.COMBAT, EMERALD_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.COMBAT, EMERALD_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.COMBAT, EMERALD_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.COMBAT, EMERALD_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(EMERALD_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(EMERALD),
							RecipeCategory.TOOLS, EMERALD_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(EMERALD), RecipeProvider.conditionsFromItem(EMERALD))
					.offerTo(t, EMERALD_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> emerald_all = new ArrayList<>();

		for (Item i : EMERALD_ITEMS) {
			emerald_all.add(i.raw.get());
		}
		for (Item i : EMERALD_ARMORS) {
			emerald_all.add(i.raw.get());
		}
		for (Item i : EMERALD_TOOLS) {
			emerald_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] emerald_all_array = emerald_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, emerald_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, emerald_all_array);
	}
}
