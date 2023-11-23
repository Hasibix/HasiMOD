package io.hasibix.hasimod.registrars.ores;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.hasibix.hasimod.HasiMOD;
import io.hasibix.hasimod.datagen.providers.*;
import io.hasibix.hasimod.init.Tabs;
import io.hasibix.hasimod.others.Tags;
import io.hasibix.hasimod.others.WorldGen;
import io.hasibix.hasimod.subregistrars.Items;
import io.hasibix.hasimod.types.*;
import io.hasibix.hasimod.types.ArmorMaterial;
import io.hasibix.hasimod.types.Block.FabricRenderLayer;
import io.hasibix.hasimod.types.Item;
import io.hasibix.hasimod.types.ToolMaterial;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class Lonsdaleite implements Registrar {
	private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
	private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier(
			"item/empty_armor_slot_chestplate");
	private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier(
			"item/empty_armor_slot_leggings");
	private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
	private static final Identifier EMPTY_SLOT_HOE_TEXTURE = new Identifier("item/empty_slot_hoe");
	private static final Identifier EMPTY_SLOT_AXE_TEXTURE = new Identifier("item/empty_slot_axe");
	private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = new Identifier("item/empty_slot_sword");
	private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = new Identifier("item/empty_slot_shovel");
	private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier("item/empty_slot_pickaxe");
	private static final Identifier EMPTY_SLOT_GEM_TEXTURE = new Identifier("item/empty_slot_gem");

	private static List<Identifier> getLonsdaleiteUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getLonsdaleiteUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_GEM_TEXTURE);
	}

	// Blocks
	public static final Block LONSDALEITE_BLOCK = new Block(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_block")), FabricRenderLayer.SOLID,
			Settings.copy(Blocks.AMETHYST_BLOCK).strength(100, 2400),
			new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
	public static final Block LONSDALEITE_ORE = new Block(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_ore")), FabricRenderLayer.SOLID,
			Settings.copy(Blocks.AMETHYST_BLOCK).strength(-1, 5), new FabricItemSettings().rarity(Rarity.EPIC));

	public static final RegistryKey<PlacedFeature> LONSDALEITE_ORE_PLACED_KEY = RegistryKey
			.of(RegistryKeys.PLACED_FEATURE, Identifier.of(HasiMOD.MOD_ID, "ore_lonsdaleite"));

	// Items
	// Ingredients
	public static final Item LONSDALEITE_DUST = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_dust")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LONSDALEITE_GEM = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_gem")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	public static final Item LONSDALEITE_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(4).saturationModifier(14.4F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 5), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3600, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 9600, 0), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 3600, 3), 1.0F).build())
					.rarity(Rarity.EPIC)));

	public static final Item LONSDALEITE_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.lonsdaleite_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.lonsdaleite_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.lonsdaleite_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.lonsdaleite_upgrade.additions_slot_description"))),
					getLonsdaleiteUpgradeEmptyBaseSlotTextures(), getLonsdaleiteUpgradeEmptyAdditionsSlotTextures()));

	// Materials
	public static final ArmorMaterial LONSDALEITE_ARMOR_MATERIAL = new ArmorMaterial(99, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.2F, HasiMOD.MOD_ID + ":lonsdaleite", 6,
			Ingredient.ofItems(LONSDALEITE_GEM.raw.get()), 6.0F);
	public static final ToolMaterial LONSDALEITE_TOOL_MATERIAL = new ToolMaterial(6, 1089, 50, MiningLevels.NETHERITE,
			12, Ingredient.ofItems(LONSDALEITE_GEM.raw.get()));

	// Items
	// Armors
	public static final Item LONSDALEITE_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_helmet")), new ArmorItem(
					LONSDALEITE_ARMOR_MATERIAL, Type.HELMET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LONSDALEITE_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_chestplate")),
			new ArmorItem(LONSDALEITE_ARMOR_MATERIAL, Type.CHESTPLATE,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LONSDALEITE_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_leggings")),
			new ArmorItem(LONSDALEITE_ARMOR_MATERIAL, Type.LEGGINGS,
					new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
	public static final Item LONSDALEITE_BOOTS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_boots")), new ArmorItem(
					LONSDALEITE_ARMOR_MATERIAL, Type.BOOTS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

	// Tools
	public static final Item LONSDALEITE_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_axe")),
			new AxeItem(LONSDALEITE_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item LONSDALEITE_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_hoe")),
			new HoeItem(LONSDALEITE_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item LONSDALEITE_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_pickaxe")),
			new PickaxeItem(LONSDALEITE_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item LONSDALEITE_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_shovel")),
			new ShovelItem(LONSDALEITE_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON)));
	public static final Item LONSDALEITE_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_sword")),
			new SwordItem(LONSDALEITE_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON)));

	public static List<Block> LONSDALEITE_BLOCKS = List.of(LONSDALEITE_BLOCK, LONSDALEITE_ORE);
	public static List<Item> LONSDALEITE_ITEMS = List.of(LONSDALEITE_DUST, LONSDALEITE_GEM, LONSDALEITE_APPLE,
			LONSDALEITE_UPGRADE);
	public static List<Item> LONSDALEITE_ARMORS = List.of(LONSDALEITE_HELMET, LONSDALEITE_CHESTPLATE,
			LONSDALEITE_LEGGINGS, LONSDALEITE_BOOTS);
	public static List<Item> LONSDALEITE_TOOLS = List.of(LONSDALEITE_AXE, LONSDALEITE_HOE, LONSDALEITE_PICKAXE,
			LONSDALEITE_SHOVEL, LONSDALEITE_SWORD);

	// Others
	@Override
	public void registerBlocks() {
		ModelProvider.addBlocks(t -> {
			for (Block i : LONSDALEITE_BLOCKS) {
				t.registerSimpleCubeAll(i.raw.get());
			}
		});

		for (Block i : LONSDALEITE_BLOCKS) {
			ItemTagProvider.addTo(Tags.FLOATING_ITEMS_TAG, i.blockItem.get());
		}

		BlockTagProvider.addTo(BlockTags.PICKAXE_MINEABLE, LONSDALEITE_BLOCK.raw.get());
		BlockTagProvider.addTo(BlockTags.BEACON_BASE_BLOCKS, LONSDALEITE_BLOCK.raw.get());
		BlockTagProvider.addTo(BlockTags.DRAGON_IMMUNE, LONSDALEITE_BLOCK.raw.get());
		BlockTagProvider.addTo(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")),
				LONSDALEITE_BLOCK.raw.get());

		BlockTagProvider.addTo(BlockTags.PICKAXE_MINEABLE, LONSDALEITE_ORE.raw.get());
		BlockTagProvider.addTo(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")),
				LONSDALEITE_ORE.raw.get());

		WorldGen.addFeature(LONSDALEITE_ORE_PLACED_KEY, BiomeSelectors.foundInTheEnd(),
				GenerationStep.Feature.UNDERGROUND_ORES);

		BlockLootTableProvider.addLootTables(t -> {
			t.addDrop(LONSDALEITE_BLOCK.raw.get());
			t.addDrop(LONSDALEITE_ORE.raw.get(), LONSDALEITE_DUST.raw.get());
		});
	}

	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			for (Item i : LONSDALEITE_ITEMS) {
				t.register(i.raw.get(), Models.GENERATED);
			}
			for (Item i : LONSDALEITE_ARMORS) {
				t.registerArmor((ArmorItem) i.raw.get());
			}
			for (Item i : LONSDALEITE_TOOLS) {
				t.register(i.raw.get(), Models.HANDHELD);
			}
		});

		for (Item i : LONSDALEITE_ITEMS) {
			ItemTagProvider.addTo(Tags.FLOATING_ITEMS_TAG, i.raw.get());
		}
		for (Item i : LONSDALEITE_ARMORS) {
			ItemTagProvider.addTo(Tags.FLOATING_ITEMS_TAG, i.raw.get());
		}
		for (Item i : LONSDALEITE_TOOLS) {
			ItemTagProvider.addTo(Tags.FLOATING_ITEMS_TAG, i.raw.get());
		}

		ItemTagProvider.addTo(ItemTags.BEACON_PAYMENT_ITEMS, LONSDALEITE_GEM.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIM_MATERIALS, LONSDALEITE_GEM.raw.get());

		ItemTagProvider.addTo(ItemTags.CLUSTER_MAX_HARVESTABLES, LONSDALEITE_PICKAXE.raw.get());

		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, LONSDALEITE_HELMET.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, LONSDALEITE_CHESTPLATE.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, LONSDALEITE_LEGGINGS.raw.get());
		ItemTagProvider.addTo(ItemTags.TRIMMABLE_ARMOR, LONSDALEITE_BOOTS.raw.get());

		ItemTagProvider.addTo(ItemTags.AXES, LONSDALEITE_AXE.raw.get());
		ItemTagProvider.addTo(ItemTags.HOES, LONSDALEITE_HOE.raw.get());
		ItemTagProvider.addTo(ItemTags.PICKAXES, LONSDALEITE_PICKAXE.raw.get());
		ItemTagProvider.addTo(ItemTags.SHOVELS, LONSDALEITE_SHOVEL.raw.get());
		ItemTagProvider.addTo(ItemTags.SWORDS, LONSDALEITE_SWORD.raw.get());

		RecipeProvider.addRecipes(t -> {
			ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, LONSDALEITE_GEM.raw.get(), 1)
					.input(LONSDALEITE_DUST.raw.get()).input(LONSDALEITE_DUST.raw.get())
					.input(LONSDALEITE_DUST.raw.get()).input(net.minecraft.item.Items.NETHERITE_INGOT)
					.input(net.minecraft.item.Items.END_CRYSTAL).input(net.minecraft.item.Items.NETHERITE_INGOT)
					.input(net.minecraft.item.Items.DIAMOND).input(net.minecraft.item.Items.DIAMOND)
					.input(net.minecraft.item.Items.DIAMOND)
					.criterion(RecipeProvider.hasItem(LONSDALEITE_DUST.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_DUST.raw.get()))
					.group(LONSDALEITE_GEM.identifier.getPath()).offerTo(t);

			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, LONSDALEITE_UPGRADE.raw.get(), 2)
					.input('#', LONSDALEITE_GEM.raw.get()).input('C', net.minecraft.item.Items.END_STONE)
					.input('S', LONSDALEITE_UPGRADE.raw.get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(LONSDALEITE_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_UPGRADE.raw.get()))
					.offerTo(t);

			RecipeProvider.offerReversibleCompactingRecipesWithReverseRecipeGroup(t, RecipeCategory.MISC,
					LONSDALEITE_GEM.raw::get, RecipeCategory.DECORATIONS, LONSDALEITE_BLOCK.blockItem::get,
					LONSDALEITE_GEM.identifier.getPath() + "_from_" + LONSDALEITE_BLOCK.identifier.getPath(),
					LONSDALEITE_GEM.identifier.getPath());

			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.raw.get()),
					Ingredient.ofItems(Items.TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(LONSDALEITE_GEM.raw.get()),
					RecipeCategory.COMBAT, LONSDALEITE_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.raw.get()))
					.offerTo(t, LONSDALEITE_HELMET.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.raw.get()),
							Ingredient.ofItems(LONSDALEITE_GEM.raw.get()), RecipeCategory.COMBAT,
							LONSDALEITE_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.raw.get()))
					.offerTo(t, LONSDALEITE_CHESTPLATE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.raw.get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.raw.get()),
							Ingredient.ofItems(LONSDALEITE_GEM.raw.get()), RecipeCategory.COMBAT,
							LONSDALEITE_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.raw.get()))
					.offerTo(t, LONSDALEITE_LEGGINGS.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.raw.get()),
					Ingredient.ofItems(Items.TEMPLATE_BOOTS.raw.get()), Ingredient.ofItems(LONSDALEITE_GEM.raw.get()),
					RecipeCategory.COMBAT, LONSDALEITE_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.raw.get()))
					.offerTo(t, LONSDALEITE_BOOTS.identifier.getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.raw.get()),
					Ingredient.ofItems(Items.TEMPLATE_AXE.raw.get()), Ingredient.ofItems(LONSDALEITE_GEM.raw.get()),
					RecipeCategory.TOOLS, LONSDALEITE_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.raw.get()))
					.offerTo(t, LONSDALEITE_AXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.raw.get()),
					Ingredient.ofItems(Items.TEMPLATE_HOE.raw.get()), Ingredient.ofItems(LONSDALEITE_GEM.raw.get()),
					RecipeCategory.TOOLS, LONSDALEITE_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.raw.get()))
					.offerTo(t, LONSDALEITE_HOE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.raw.get()),
					Ingredient.ofItems(Items.TEMPLATE_PICKAXE.raw.get()), Ingredient.ofItems(LONSDALEITE_GEM.raw.get()),
					RecipeCategory.TOOLS, LONSDALEITE_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.raw.get()))
					.offerTo(t, LONSDALEITE_PICKAXE.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.raw.get()),
					Ingredient.ofItems(Items.TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(LONSDALEITE_GEM.raw.get()),
					RecipeCategory.TOOLS, LONSDALEITE_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.raw.get()))
					.offerTo(t, LONSDALEITE_SHOVEL.identifier.getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.raw.get()),
					Ingredient.ofItems(Items.TEMPLATE_SWORD.raw.get()), Ingredient.ofItems(LONSDALEITE_GEM.raw.get()),
					RecipeCategory.TOOLS, LONSDALEITE_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.raw.get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.raw.get()))
					.offerTo(t, LONSDALEITE_SWORD.identifier.getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> lonsdaleite_all = new ArrayList<>();

		for (Block i : LONSDALEITE_BLOCKS) {
			lonsdaleite_all.add(i.blockItem.get());
		}
		for (Item i : LONSDALEITE_ITEMS) {
			lonsdaleite_all.add(i.raw.get());
		}
		for (Item i : LONSDALEITE_ARMORS) {
			lonsdaleite_all.add(i.raw.get());
		}
		for (Item i : LONSDALEITE_TOOLS) {
			lonsdaleite_all.add(i.raw.get());
		}

		net.minecraft.item.Item[] lonsdaleite_all_array = lonsdaleite_all.toArray(new net.minecraft.item.Item[0]);

		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, lonsdaleite_all_array);
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, lonsdaleite_all_array);
	}
}
