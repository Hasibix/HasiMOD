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

public class RoseQuartz implements Registrar {
	@Nullable
	public static final net.minecraft.item.Item ROSE_QUARTZ = Registries.ITEM
			.get(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("create", "rose_quartz")));

	private static List<Identifier> getRoseQuartzUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getRoseQuartzUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_QUARTZ_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item ROSE_QUARTZ_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_apple")),
			new net.minecraft.item.Item(new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 3600, 0), 1.0F).build())
					.rarity(Rarity.COMMON)));

	public static final Item ROSE_QUARTZ_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.rose_quartz_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.rose_quartz_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "rose_quartz_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.rose_quartz_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.rose_quartz_upgrade.additions_slot_description"))),
					getRoseQuartzUpgradeEmptyBaseSlotTextures(), getRoseQuartzUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial ROSE_QUARTZ_ARMOR_MATERIAL = new ArmorMaterial(33, 11,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, HasiMOD.MOD_ID + ":rose_quartz", 2,
			Ingredient.ofItems(ROSE_QUARTZ), 0);
	public static final ToolMaterial ROSE_QUARTZ_TOOL_MATERIAL = new ToolMaterial(2, 363, 11, MiningLevels.IRON, 4,
			Ingredient.ofItems(ROSE_QUARTZ));

	// Items
	// Armors
	public static final Item ROSE_QUARTZ_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_helmet")),
			new ArmorItem(ROSE_QUARTZ_ARMOR_MATERIAL, Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ROSE_QUARTZ_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_chestplate")),
			new ArmorItem(ROSE_QUARTZ_ARMOR_MATERIAL, Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ROSE_QUARTZ_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_leggings")),
			new ArmorItem(ROSE_QUARTZ_ARMOR_MATERIAL, Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ROSE_QUARTZ_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_boots")),
			new ArmorItem(ROSE_QUARTZ_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON)));

	// Tools
	public static final Item ROSE_QUARTZ_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_axe")),
			new AxeItem(ROSE_QUARTZ_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ROSE_QUARTZ_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_hoe")),
			new HoeItem(ROSE_QUARTZ_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ROSE_QUARTZ_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_pickaxe")),
			new PickaxeItem(ROSE_QUARTZ_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ROSE_QUARTZ_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_shovel")),
			new ShovelItem(ROSE_QUARTZ_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item ROSE_QUARTZ_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_sword")),
			new SwordItem(ROSE_QUARTZ_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON)));

	public static List<Item> ROSE_QUARTZ_ITEMS = List.of(ROSE_QUARTZ_APPLE, ROSE_QUARTZ_UPGRADE);
	public static List<Item> ROSE_QUARTZ_ARMORS = List.of(ROSE_QUARTZ_HELMET, ROSE_QUARTZ_CHESTPLATE,
			ROSE_QUARTZ_LEGGINGS, ROSE_QUARTZ_BOOTS);
	public static List<Item> ROSE_QUARTZ_TOOLS = List.of(ROSE_QUARTZ_AXE, ROSE_QUARTZ_HOE, ROSE_QUARTZ_PICKAXE,
			ROSE_QUARTZ_SHOVEL, ROSE_QUARTZ_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : ROSE_QUARTZ_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : ROSE_QUARTZ_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : ROSE_QUARTZ_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, ROSE_QUARTZ);
		ItemTagProvider.addTo(ItemTags.TRIM_MATERIALS, ROSE_QUARTZ);

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, ROSE_QUARTZ_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ROSE_QUARTZ_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ROSE_QUARTZ_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ROSE_QUARTZ_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ROSE_QUARTZ_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, ROSE_QUARTZ_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, ROSE_QUARTZ_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, ROSE_QUARTZ_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, ROSE_QUARTZ_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, ROSE_QUARTZ_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ROSE_QUARTZ_UPGRADE.raw.get(), 2)
					.input('#', ROSE_QUARTZ).input('C', net.minecraft.item.Items.END_STONE)
					.input('S', ROSE_QUARTZ_UPGRADE.raw.get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(ROSE_QUARTZ_UPGRADE.raw.get()))
					.offerTo(t);

			assert ROSE_QUARTZ != null;
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ROSE_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(ROSE_QUARTZ),
							RecipeCategory.COMBAT, ROSE_QUARTZ_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ), RecipeProvider.conditionsFromItem(ROSE_QUARTZ))
					.offerTo(t, ROSE_QUARTZ_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ROSE_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(ROSE_QUARTZ),
							RecipeCategory.COMBAT, ROSE_QUARTZ_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ), RecipeProvider.conditionsFromItem(ROSE_QUARTZ))
					.offerTo(t, ROSE_QUARTZ_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ROSE_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(ROSE_QUARTZ),
							RecipeCategory.COMBAT, ROSE_QUARTZ_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ), RecipeProvider.conditionsFromItem(ROSE_QUARTZ))
					.offerTo(t, ROSE_QUARTZ_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ROSE_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(ROSE_QUARTZ),
							RecipeCategory.COMBAT, ROSE_QUARTZ_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ), RecipeProvider.conditionsFromItem(ROSE_QUARTZ))
					.offerTo(t, ROSE_QUARTZ_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ROSE_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(ROSE_QUARTZ),
							RecipeCategory.TOOLS, ROSE_QUARTZ_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ), RecipeProvider.conditionsFromItem(ROSE_QUARTZ))
					.offerTo(t, ROSE_QUARTZ_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ROSE_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(ROSE_QUARTZ),
							RecipeCategory.TOOLS, ROSE_QUARTZ_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ), RecipeProvider.conditionsFromItem(ROSE_QUARTZ))
					.offerTo(t, ROSE_QUARTZ_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ROSE_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(ROSE_QUARTZ),
							RecipeCategory.TOOLS, ROSE_QUARTZ_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ), RecipeProvider.conditionsFromItem(ROSE_QUARTZ))
					.offerTo(t, ROSE_QUARTZ_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ROSE_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(ROSE_QUARTZ),
							RecipeCategory.TOOLS, ROSE_QUARTZ_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ), RecipeProvider.conditionsFromItem(ROSE_QUARTZ))
					.offerTo(t, ROSE_QUARTZ_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ROSE_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(ROSE_QUARTZ),
							RecipeCategory.TOOLS, ROSE_QUARTZ_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(ROSE_QUARTZ), RecipeProvider.conditionsFromItem(ROSE_QUARTZ))
					.offerTo(t, ROSE_QUARTZ_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> rose_quartz_all = new ArrayList<>();

		for (Item i : ROSE_QUARTZ_ITEMS) {
			rose_quartz_all.add(i.raw.get());
		}
		for (Item i : ROSE_QUARTZ_ARMORS) {
			rose_quartz_all.add(i.raw.get());
		}
		for (Item i : ROSE_QUARTZ_TOOLS) {
			rose_quartz_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] rose_quartz_all_array = rose_quartz_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, rose_quartz_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, rose_quartz_all_array);
	}
}
