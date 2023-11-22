package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
import static net.minecraft.item.Items.REDSTONE;

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

public class Redstone implements Registrar {
	private static List<Identifier> getRedstoneUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getRedstoneUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	// Ingredients
	public static final Item REDSTONE_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(12).saturationModifier(15)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
							.build())
					.rarity(Rarity.EPIC)));

	public static final Item REDSTONE_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.redstone_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.redstone_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "redstone_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.redstone_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.redstone_upgrade.additions_slot_description"))),
					getRedstoneUpgradeEmptyBaseSlotTextures(), getRedstoneUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial REDSTONE_ARMOR_MATERIAL = new ArmorMaterial(4096, 50,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.2F, HasiMOD.MOD_ID + ":redstone", 12, Ingredient.ofItems(REDSTONE),
			6.0F);
	public static final ToolMaterial REDSTONE_TOOL_MATERIAL = new ToolMaterial(1.0F, 4096, 50, 4, 18.0F,
			Ingredient.ofItems(REDSTONE));

	// Items
	// Armors
	public static final Item REDSTONE_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_helmet")), new ArmorItem(
					REDSTONE_ARMOR_MATERIAL, Type.HELMET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item REDSTONE_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_chestplate")),
			new ArmorItem(REDSTONE_ARMOR_MATERIAL, Type.CHESTPLATE,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item REDSTONE_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_leggings")), new ArmorItem(
					REDSTONE_ARMOR_MATERIAL, Type.LEGGINGS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item REDSTONE_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_boots")), new ArmorItem(
					REDSTONE_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	// Tools
	public static final Item REDSTONE_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_axe")),
			new AxeItem(REDSTONE_TOOL_MATERIAL, 18, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item REDSTONE_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_hoe")),
			new HoeItem(REDSTONE_TOOL_MATERIAL, 4, 8.0F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item REDSTONE_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_pickaxe")), new PickaxeItem(
					REDSTONE_TOOL_MATERIAL, 12, 2.4F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item REDSTONE_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_shovel")),
			new ShovelItem(REDSTONE_TOOL_MATERIAL, 12, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item REDSTONE_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "redstone_sword")),
			new SwordItem(REDSTONE_TOOL_MATERIAL, 14, 3.2F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	public static List<Item> REDSTONE_ITEMS = List.of(REDSTONE_APPLE, REDSTONE_UPGRADE);
	public static List<Item> REDSTONE_ARMORS = List.of(REDSTONE_HELMET, REDSTONE_CHESTPLATE, REDSTONE_LEGGINGS,
			REDSTONE_BOOTS);
	public static List<Item> REDSTONE_TOOLS = List.of(REDSTONE_AXE, REDSTONE_HOE, REDSTONE_PICKAXE, REDSTONE_SHOVEL,
			REDSTONE_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : REDSTONE_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : REDSTONE_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : REDSTONE_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, REDSTONE);

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, REDSTONE_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, REDSTONE_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, REDSTONE_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, REDSTONE_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, REDSTONE_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, REDSTONE_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, REDSTONE_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, REDSTONE_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, REDSTONE_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, REDSTONE_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, REDSTONE_UPGRADE.raw.get(), 2).input('#', REDSTONE)
					.input('C', net.minecraft.item.Items.END_STONE).input('S', REDSTONE_UPGRADE.raw.get())
					.pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(REDSTONE_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(REDSTONE_UPGRADE.raw.get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.COMBAT, REDSTONE_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.COMBAT, REDSTONE_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.COMBAT, REDSTONE_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.COMBAT, REDSTONE_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(REDSTONE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(REDSTONE),
							RecipeCategory.TOOLS, REDSTONE_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(REDSTONE), RecipeProvider.conditionsFromItem(REDSTONE))
					.offerTo(t, REDSTONE_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> redstone_all = new ArrayList<>();

		for (Item i : REDSTONE_ITEMS) {
			redstone_all.add(i.raw.get());
		}
		for (Item i : REDSTONE_ARMORS) {
			redstone_all.add(i.raw.get());
		}
		for (Item i : REDSTONE_TOOLS) {
			redstone_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] redstone_all_array = redstone_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, redstone_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, redstone_all_array);
	}
}
