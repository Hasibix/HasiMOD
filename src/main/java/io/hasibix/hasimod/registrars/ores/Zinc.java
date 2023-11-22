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

public class Zinc implements Registrar {
	@Nullable
	private static final net.minecraft.item.Item ZINC_INGOT = Registries.ITEM
			.get(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("create", "zinc_ingot")));

	private static List<Identifier> getZincUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getZincUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item ZINC_APPLE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(12).saturationModifier(15)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
							.build())
					.rarity(Rarity.EPIC)));

	public static final Item ZINC_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.zinc_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.zinc_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "zinc_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.zinc_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.zinc_upgrade.additions_slot_description"))),
					getZincUpgradeEmptyBaseSlotTextures(), getZincUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial ZINC_ARMOR_MATERIAL = new ArmorMaterial(4096, 50,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.2F, HasiMOD.MOD_ID + ":zinc", 12, Ingredient.ofItems(ZINC_INGOT),
			6.0F);
	public static final ToolMaterial ZINC_TOOL_MATERIAL = new ToolMaterial(1.0F, 4096, 50, 4, 18.0F,
			Ingredient.ofItems(ZINC_INGOT));

	// Items
	// Armors
	public static final Item ZINC_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_helmet")),
			new ArmorItem(ZINC_ARMOR_MATERIAL, Type.HELMET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item ZINC_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_chestplate")), new ArmorItem(ZINC_ARMOR_MATERIAL,
					Type.CHESTPLATE, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item ZINC_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_leggings")), new ArmorItem(ZINC_ARMOR_MATERIAL,
					Type.LEGGINGS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item ZINC_BOOTS = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_boots")),
			new ArmorItem(ZINC_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	// Tools
	public static final Item ZINC_AXE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_axe")),
			new AxeItem(ZINC_TOOL_MATERIAL, 18, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item ZINC_HOE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_hoe")),
			new HoeItem(ZINC_TOOL_MATERIAL, 4, 8.0F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item ZINC_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_pickaxe")),
			new PickaxeItem(ZINC_TOOL_MATERIAL, 12, 2.4F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item ZINC_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_shovel")),
			new ShovelItem(ZINC_TOOL_MATERIAL, 12, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item ZINC_SWORD = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "zinc_sword")),
			new SwordItem(ZINC_TOOL_MATERIAL, 14, 3.2F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	public static List<Item> ZINC_ITEMS = List.of(ZINC_APPLE, ZINC_UPGRADE);
	public static List<Item> ZINC_ARMORS = List.of(ZINC_HELMET, ZINC_CHESTPLATE, ZINC_LEGGINGS, ZINC_BOOTS);
	public static List<Item> ZINC_TOOLS = List.of(ZINC_AXE, ZINC_HOE, ZINC_PICKAXE, ZINC_SHOVEL, ZINC_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : ZINC_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : ZINC_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : ZINC_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, ZINC_INGOT);
		ItemTagProvider.addTo(ItemTags.TRIM_MATERIALS, ZINC_INGOT);

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, ZINC_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ZINC_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ZINC_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ZINC_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, ZINC_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, ZINC_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, ZINC_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, ZINC_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, ZINC_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, ZINC_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ZINC_UPGRADE.raw.get(), 2).input('#', ZINC_INGOT)
					.input('C', net.minecraft.item.Items.END_STONE).input('S', ZINC_UPGRADE.raw.get()).pattern("#S#")
					.pattern("#C#").pattern("###").criterion(RecipeProvider.hasItem(ZINC_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(ZINC_UPGRADE.raw.get()))
					.offerTo(t);

			assert ZINC_INGOT != null;
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ZINC_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(ZINC_INGOT),
							RecipeCategory.COMBAT, ZINC_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(ZINC_INGOT), RecipeProvider.conditionsFromItem(ZINC_INGOT))
					.offerTo(t, ZINC_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ZINC_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(ZINC_INGOT),
							RecipeCategory.COMBAT, ZINC_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(ZINC_INGOT), RecipeProvider.conditionsFromItem(ZINC_INGOT))
					.offerTo(t, ZINC_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ZINC_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(ZINC_INGOT),
							RecipeCategory.COMBAT, ZINC_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(ZINC_INGOT), RecipeProvider.conditionsFromItem(ZINC_INGOT))
					.offerTo(t, ZINC_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ZINC_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(ZINC_INGOT),
							RecipeCategory.COMBAT, ZINC_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(ZINC_INGOT), RecipeProvider.conditionsFromItem(ZINC_INGOT))
					.offerTo(t, ZINC_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ZINC_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(ZINC_INGOT),
							RecipeCategory.TOOLS, ZINC_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(ZINC_INGOT), RecipeProvider.conditionsFromItem(ZINC_INGOT))
					.offerTo(t, ZINC_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ZINC_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(ZINC_INGOT),
							RecipeCategory.TOOLS, ZINC_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(ZINC_INGOT), RecipeProvider.conditionsFromItem(ZINC_INGOT))
					.offerTo(t, ZINC_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ZINC_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(ZINC_INGOT),
							RecipeCategory.TOOLS, ZINC_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(ZINC_INGOT), RecipeProvider.conditionsFromItem(ZINC_INGOT))
					.offerTo(t, ZINC_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ZINC_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(ZINC_INGOT),
							RecipeCategory.TOOLS, ZINC_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(ZINC_INGOT), RecipeProvider.conditionsFromItem(ZINC_INGOT))
					.offerTo(t, ZINC_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(ZINC_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(ZINC_INGOT),
							RecipeCategory.TOOLS, ZINC_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(ZINC_INGOT), RecipeProvider.conditionsFromItem(ZINC_INGOT))
					.offerTo(t, ZINC_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> zinc_all = new ArrayList<>();

		for (Item i : ZINC_ITEMS) {
			zinc_all.add(i.raw.get());
		}
		for (Item i : ZINC_ARMORS) {
			zinc_all.add(i.raw.get());
		}
		for (Item i : ZINC_TOOLS) {
			zinc_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] zinc_all_array = zinc_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, zinc_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, zinc_all_array);
	}
}
