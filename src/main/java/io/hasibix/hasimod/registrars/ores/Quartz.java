package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.LAPIS_LAZULI;
import static net.minecraft.item.Items.QUARTZ;

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

public class Quartz implements Registrar {
	private static List<Identifier> getNetherQuartzUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getNetherQuartzUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item QUARTZ_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_apple")),
			new net.minecraft.item.Item(new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 9600, 0), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 2), 1.0F).build())
					.rarity(Rarity.COMMON)));

	public static final Item QUARTZ_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.quartz_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.quartz_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "quartz_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.quartz_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.quartz_upgrade.additions_slot_description"))),
					getNetherQuartzUpgradeEmptyBaseSlotTextures(), getNetherQuartzUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial QUARTZ_ARMOR_MATERIAL = new ArmorMaterial(33, 8,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, HasiMOD.MOD_ID + ":lapis_lazuli", 2,
			Ingredient.ofItems(LAPIS_LAZULI), 0);
	public static final ToolMaterial QUARTZ_TOOL_MATERIAL = new ToolMaterial(2, 363, 8, MiningLevels.IRON, 4,
			Ingredient.ofItems(LAPIS_LAZULI));

	// Items
	// Armors
	public static final Item QUARTZ_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_helmet")),
			new ArmorItem(QUARTZ_ARMOR_MATERIAL, Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item QUARTZ_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_chestplate")),
			new ArmorItem(QUARTZ_ARMOR_MATERIAL, Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item QUARTZ_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_leggings")),
			new ArmorItem(QUARTZ_ARMOR_MATERIAL, Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item QUARTZ_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_boots")),
			new ArmorItem(QUARTZ_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON)));

	// Tools
	public static final Item QUARTZ_AXE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_axe")),
			new AxeItem(QUARTZ_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item QUARTZ_HOE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_hoe")),
			new HoeItem(QUARTZ_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item QUARTZ_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_pickaxe")),
			new PickaxeItem(QUARTZ_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item QUARTZ_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_shovel")),
			new ShovelItem(QUARTZ_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item QUARTZ_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "quartz_sword")),
			new SwordItem(QUARTZ_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON)));

	public static List<Item> QUARTZ_ITEMS = List.of(QUARTZ_APPLE, QUARTZ_UPGRADE);
	public static List<Item> QUARTZ_ARMORS = List.of(QUARTZ_HELMET, QUARTZ_CHESTPLATE, QUARTZ_LEGGINGS, QUARTZ_BOOTS);
	public static List<Item> QUARTZ_TOOLS = List.of(QUARTZ_AXE, QUARTZ_HOE, QUARTZ_PICKAXE, QUARTZ_SHOVEL,
			QUARTZ_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : QUARTZ_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : QUARTZ_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : QUARTZ_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, QUARTZ);

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, QUARTZ_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, QUARTZ_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, QUARTZ_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, QUARTZ_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, QUARTZ_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, QUARTZ_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, QUARTZ_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, QUARTZ_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, QUARTZ_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, QUARTZ_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, QUARTZ_UPGRADE.raw.get(), 2).input('#', QUARTZ)
					.input('C', net.minecraft.item.Items.END_STONE).input('S', QUARTZ_UPGRADE.raw.get()).pattern("#S#")
					.pattern("#C#").pattern("###").criterion(RecipeProvider.hasItem(QUARTZ_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(QUARTZ_UPGRADE.raw.get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, QUARTZ_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, QUARTZ_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, QUARTZ_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, QUARTZ_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, QUARTZ_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, QUARTZ_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> quartz_all = new ArrayList<>();

		for (Item i : QUARTZ_ITEMS) {
			quartz_all.add(i.raw.get());
		}
		for (Item i : QUARTZ_ARMORS) {
			quartz_all.add(i.raw.get());
		}
		for (Item i : QUARTZ_TOOLS) {
			quartz_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] quartz_all_array = quartz_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, quartz_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, quartz_all_array);
	}
}
