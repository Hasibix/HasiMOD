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

public class Brass implements Registrar {
	@Nullable
	private static final net.minecraft.item.Item BRASS_INGOT = Registries.ITEM
			.get(RegistryKey.of(RegistryKeys.ITEM, Identifier.of("create", "brass_ingot")));

	private static List<Identifier> getBrassUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getBrassUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item BRASS_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(12).saturationModifier(15)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
							.build())
					.rarity(Rarity.EPIC)));

	public static final Item BRASS_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.brass_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.brass_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "brass_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.brass_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.brass_upgrade.additions_slot_description"))),
					getBrassUpgradeEmptyBaseSlotTextures(), getBrassUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial BRASS_ARMOR_MATERIAL = new ArmorMaterial(4096, 50,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.2F, HasiMOD.MOD_ID + ":brass", 12, Ingredient.ofItems(BRASS_INGOT),
			6.0F);
	public static final ToolMaterial BRASS_TOOL_MATERIAL = new ToolMaterial(1.0F, 4096, 50, 4, 18.0F,
			Ingredient.ofItems(BRASS_INGOT));

	// Items
	// Armors
	public static final Item BRASS_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_helmet")),
			new ArmorItem(BRASS_ARMOR_MATERIAL, Type.HELMET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item BRASS_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_chestplate")), new ArmorItem(
					BRASS_ARMOR_MATERIAL, Type.CHESTPLATE, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item BRASS_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_leggings")), new ArmorItem(BRASS_ARMOR_MATERIAL,
					Type.LEGGINGS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item BRASS_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_boots")),
			new ArmorItem(BRASS_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	// Tools
	public static final Item BRASS_AXE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_axe")),
			new AxeItem(BRASS_TOOL_MATERIAL, 18, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item BRASS_HOE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_hoe")),
			new HoeItem(BRASS_TOOL_MATERIAL, 4, 8.0F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item BRASS_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_pickaxe")),
			new PickaxeItem(BRASS_TOOL_MATERIAL, 12, 2.4F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item BRASS_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_shovel")),
			new ShovelItem(BRASS_TOOL_MATERIAL, 12, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item BRASS_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_sword")),
			new SwordItem(BRASS_TOOL_MATERIAL, 14, 3.2F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	public static List<Item> BRASS_ITEMS = List.of(BRASS_APPLE, BRASS_UPGRADE);
	public static List<Item> BRASS_ARMORS = List.of(BRASS_HELMET, BRASS_CHESTPLATE, BRASS_LEGGINGS, BRASS_BOOTS);
	public static List<Item> BRASS_TOOLS = List.of(BRASS_AXE, BRASS_HOE, BRASS_PICKAXE, BRASS_SHOVEL, BRASS_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : BRASS_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : BRASS_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : BRASS_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, BRASS_INGOT);
		ItemTagProvider.addTo(ItemTags.TRIM_MATERIALS, BRASS_INGOT);

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, BRASS_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, BRASS_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, BRASS_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, BRASS_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, BRASS_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, BRASS_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, BRASS_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, BRASS_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, BRASS_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, BRASS_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BRASS_UPGRADE.raw.get(), 2).input('#', BRASS_INGOT)
					.input('C', net.minecraft.item.Items.END_STONE).input('S', BRASS_UPGRADE.raw.get()).pattern("#S#")
					.pattern("#C#").pattern("###").criterion(RecipeProvider.hasItem(BRASS_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(BRASS_UPGRADE.raw.get()))
					.offerTo(t);

			assert BRASS_INGOT != null;
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(BRASS_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(BRASS_INGOT),
							RecipeCategory.COMBAT, BRASS_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(BRASS_INGOT), RecipeProvider.conditionsFromItem(BRASS_INGOT))
					.offerTo(t, BRASS_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(BRASS_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(BRASS_INGOT),
							RecipeCategory.COMBAT, BRASS_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(BRASS_INGOT), RecipeProvider.conditionsFromItem(BRASS_INGOT))
					.offerTo(t, BRASS_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(BRASS_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(BRASS_INGOT),
							RecipeCategory.COMBAT, BRASS_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(BRASS_INGOT), RecipeProvider.conditionsFromItem(BRASS_INGOT))
					.offerTo(t, BRASS_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(BRASS_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(BRASS_INGOT),
							RecipeCategory.COMBAT, BRASS_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(BRASS_INGOT), RecipeProvider.conditionsFromItem(BRASS_INGOT))
					.offerTo(t, BRASS_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(BRASS_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(BRASS_INGOT),
							RecipeCategory.TOOLS, BRASS_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(BRASS_INGOT), RecipeProvider.conditionsFromItem(BRASS_INGOT))
					.offerTo(t, BRASS_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(BRASS_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(BRASS_INGOT),
							RecipeCategory.TOOLS, BRASS_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(BRASS_INGOT), RecipeProvider.conditionsFromItem(BRASS_INGOT))
					.offerTo(t, BRASS_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(BRASS_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(BRASS_INGOT),
							RecipeCategory.TOOLS, BRASS_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(BRASS_INGOT), RecipeProvider.conditionsFromItem(BRASS_INGOT))
					.offerTo(t, BRASS_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(BRASS_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(BRASS_INGOT),
							RecipeCategory.TOOLS, BRASS_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(BRASS_INGOT), RecipeProvider.conditionsFromItem(BRASS_INGOT))
					.offerTo(t, BRASS_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(BRASS_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(BRASS_INGOT),
							RecipeCategory.TOOLS, BRASS_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(BRASS_INGOT), RecipeProvider.conditionsFromItem(BRASS_INGOT))
					.offerTo(t, BRASS_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> brass_all = new ArrayList<>();

		for (Item i : BRASS_ITEMS) {
			brass_all.add(i.raw.get());
		}
		for (Item i : BRASS_ARMORS) {
			brass_all.add(i.raw.get());
		}
		for (Item i : BRASS_TOOLS) {
			brass_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] brass_all_array = brass_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, brass_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, brass_all_array);
	}
}
