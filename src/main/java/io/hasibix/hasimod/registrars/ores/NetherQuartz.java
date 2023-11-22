package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;
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

public class NetherQuartz implements Registrar {
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
	public static final Item NETHER_QUARTZ_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(12).saturationModifier(15)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 4), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
							.build())
					.rarity(Rarity.EPIC)));

	public static final Item NETHER_QUARTZ_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.nether_quartz_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.nether_quartz_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("upgrade",
							Identifier.of(HasiMOD.MOD_ID, "nether_quartz_upgrade"))).formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.nether_quartz_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.nether_quartz_upgrade.additions_slot_description"))),
					getNetherQuartzUpgradeEmptyBaseSlotTextures(), getNetherQuartzUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial NETHER_QUARTZ_ARMOR_MATERIAL = new ArmorMaterial(4096, 50,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.2F, HasiMOD.MOD_ID + ":nether_quartz", 12,
			Ingredient.ofItems(QUARTZ), 6.0F);
	public static final ToolMaterial NETHER_QUARTZ_TOOL_MATERIAL = new ToolMaterial(1.0F, 4096, 50, 4, 18.0F,
			Ingredient.ofItems(QUARTZ));

	// Items
	// Armors
	public static final Item NETHER_QUARTZ_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_helmet")),
			new ArmorItem(NETHER_QUARTZ_ARMOR_MATERIAL, Type.HELMET,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item NETHER_QUARTZ_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_chestplate")),
			new ArmorItem(NETHER_QUARTZ_ARMOR_MATERIAL, Type.CHESTPLATE,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item NETHER_QUARTZ_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_leggings")),
			new ArmorItem(NETHER_QUARTZ_ARMOR_MATERIAL, Type.LEGGINGS,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item NETHER_QUARTZ_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_boots")),
			new ArmorItem(NETHER_QUARTZ_ARMOR_MATERIAL, Type.BOOTS,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	// Tools
	public static final Item NETHER_QUARTZ_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_axe")),
			new AxeItem(NETHER_QUARTZ_TOOL_MATERIAL, 18, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item NETHER_QUARTZ_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_hoe")), new HoeItem(
					NETHER_QUARTZ_TOOL_MATERIAL, 4, 8.0F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item NETHER_QUARTZ_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_pickaxe")), new PickaxeItem(
					NETHER_QUARTZ_TOOL_MATERIAL, 12, 2.4F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item NETHER_QUARTZ_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_shovel")), new ShovelItem(
					NETHER_QUARTZ_TOOL_MATERIAL, 12, 2, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item NETHER_QUARTZ_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "nether_quartz_sword")), new SwordItem(
					NETHER_QUARTZ_TOOL_MATERIAL, 14, 3.2F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	public static List<Item> NETHER_QUARTZ_ITEMS = List.of(NETHER_QUARTZ_APPLE, NETHER_QUARTZ_UPGRADE);
	public static List<Item> NETHER_QUARTZ_ARMORS = List.of(NETHER_QUARTZ_HELMET, NETHER_QUARTZ_CHESTPLATE,
			NETHER_QUARTZ_LEGGINGS, NETHER_QUARTZ_BOOTS);
	public static List<Item> NETHER_QUARTZ_TOOLS = List.of(NETHER_QUARTZ_AXE, NETHER_QUARTZ_HOE, NETHER_QUARTZ_PICKAXE,
			NETHER_QUARTZ_SHOVEL, NETHER_QUARTZ_SWORD);

	// Others
	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : NETHER_QUARTZ_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : NETHER_QUARTZ_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : NETHER_QUARTZ_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, QUARTZ);

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, NETHER_QUARTZ_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, NETHER_QUARTZ_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, NETHER_QUARTZ_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, NETHER_QUARTZ_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, NETHER_QUARTZ_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, NETHER_QUARTZ_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, NETHER_QUARTZ_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, NETHER_QUARTZ_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, NETHER_QUARTZ_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, NETHER_QUARTZ_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, NETHER_QUARTZ_UPGRADE.raw.get(), 2).input('#', QUARTZ)
					.input('C', net.minecraft.item.Items.END_STONE).input('S', NETHER_QUARTZ_UPGRADE.raw.get())
					.pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(NETHER_QUARTZ_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(NETHER_QUARTZ_UPGRADE.raw.get()))
					.offerTo(t);

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(NETHER_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, NETHER_QUARTZ_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, NETHER_QUARTZ_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(NETHER_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, NETHER_QUARTZ_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, NETHER_QUARTZ_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(NETHER_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, NETHER_QUARTZ_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, NETHER_QUARTZ_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(NETHER_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.COMBAT, NETHER_QUARTZ_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, NETHER_QUARTZ_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(NETHER_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, NETHER_QUARTZ_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, NETHER_QUARTZ_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(NETHER_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, NETHER_QUARTZ_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, NETHER_QUARTZ_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(NETHER_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, NETHER_QUARTZ_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, NETHER_QUARTZ_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(NETHER_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, NETHER_QUARTZ_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, NETHER_QUARTZ_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(NETHER_QUARTZ_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(QUARTZ),
							RecipeCategory.TOOLS, NETHER_QUARTZ_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(QUARTZ), RecipeProvider.conditionsFromItem(QUARTZ))
					.offerTo(t, NETHER_QUARTZ_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> nether_quartz_all = new ArrayList<>();

		for (Item i : NETHER_QUARTZ_ITEMS) {
			nether_quartz_all.add(i.raw.get());
		}
		for (Item i : NETHER_QUARTZ_ARMORS) {
			nether_quartz_all.add(i.raw.get());
		}
		for (Item i : NETHER_QUARTZ_TOOLS) {
			nether_quartz_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] nether_quartz_all_array = nether_quartz_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, nether_quartz_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, nether_quartz_all_array);
	}
}
