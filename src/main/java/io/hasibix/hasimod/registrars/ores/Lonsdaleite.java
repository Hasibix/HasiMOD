package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;

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
import io.hasibix.hasimod.types.Block.FabricRenderLayer;
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
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.FoodComponent;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
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
	// Helpers
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
	public static final Item LONSDALEITE_DUST = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_dust")),
			new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
	public static final Item LONSDALEITE_GEM = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_gem")),
			new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
	public static final Item LONSDALEITE_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_apple")),
			new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(4).saturationModifier(14.4F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 5), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 3600, 3), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 9600, 0), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 3600, 3), 1.0F).build())
					.rarity(Rarity.EPIC));
	public static final Item LONSDALEITE_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_upgrade_smithing_template")),
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
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.lonsdaleite_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.lonsdaleite_upgrade.additions_slot_description"))),
			getLonsdaleiteUpgradeEmptyBaseSlotTextures(), getLonsdaleiteUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings().rarity(Rarity.EPIC).fireproof());

	// Materials
	public static final ArmorMaterial LONSDALEITE_ARMOR_MATERIAL = new ArmorMaterial(99, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.2F, HasiMOD.MOD_ID + ":lonsdaleite", 6,
			Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), 6.0F);
	public static final ToolMaterial LONSDALEITE_TOOL_MATERIAL = new ToolMaterial(6, 1089, 50, MiningLevels.NETHERITE,
			12, Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()));

	// Armors
	public static final Item LONSDALEITE_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_helmet")), LONSDALEITE_ARMOR_MATERIAL,
			Type.HELMET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
	public static final Item LONSDALEITE_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_chestplate")), LONSDALEITE_ARMOR_MATERIAL,
			Type.CHESTPLATE, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
	public static final Item LONSDALEITE_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_leggings")), LONSDALEITE_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
	public static final Item LONSDALEITE_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_boots")), LONSDALEITE_ARMOR_MATERIAL,
			Type.BOOTS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));

	// Tools
	public static final Item LONSDALEITE_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_axe")), Item.ToolItem.Type.AXE,
			LONSDALEITE_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LONSDALEITE_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_hoe")), Item.ToolItem.Type.HOE,
			LONSDALEITE_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LONSDALEITE_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_pickaxe")), Item.ToolItem.Type.PICKAXE,
			LONSDALEITE_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LONSDALEITE_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_shovel")), Item.ToolItem.Type.SHOVEL,
			LONSDALEITE_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item LONSDALEITE_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "lonsdaleite_sword")), Item.ToolItem.Type.SWORD,
			LONSDALEITE_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Lists
	public static List<Block> LONSDALEITE_BLOCKS = List.of(LONSDALEITE_BLOCK, LONSDALEITE_ORE);
	public static List<Item> LONSDALEITE_ITEMS = List.of(LONSDALEITE_DUST, LONSDALEITE_GEM, LONSDALEITE_APPLE,
			LONSDALEITE_UPGRADE);
	public static List<Item> LONSDALEITE_ARMORS = List.of(LONSDALEITE_HELMET, LONSDALEITE_CHESTPLATE,
			LONSDALEITE_LEGGINGS, LONSDALEITE_BOOTS);
	public static List<Item> LONSDALEITE_TOOLS = List.of(LONSDALEITE_AXE, LONSDALEITE_HOE, LONSDALEITE_PICKAXE,
			LONSDALEITE_SHOVEL, LONSDALEITE_SWORD);

	// Methods
	@Override
	public void registerBlocks() {
		// Datagen
		ModelProvider.addBlocks(t -> {
			for (Block i : LONSDALEITE_BLOCKS) {
				t.registerSimpleCubeAll(i.getRaw().get());
			}
		});

		for (Block i : LONSDALEITE_BLOCKS) {
			ItemTagProvider.addTo(Tags.FLOATING_ITEMS_TAG, i.getBlockItem().get());
		}

		BlockTagProvider.addTo(BlockTags.PICKAXE_MINEABLE, LONSDALEITE_BLOCK.getRaw().get());
		BlockTagProvider.addTo(BlockTags.BEACON_BASE_BLOCKS, LONSDALEITE_BLOCK.getRaw().get());
		BlockTagProvider.addTo(BlockTags.DRAGON_IMMUNE, LONSDALEITE_BLOCK.getRaw().get());
		BlockTagProvider.addTo(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")),
				LONSDALEITE_BLOCK.getRaw().get());

		BlockTagProvider.addTo(BlockTags.PICKAXE_MINEABLE, LONSDALEITE_ORE.getRaw().get());
		BlockTagProvider.addTo(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")),
				LONSDALEITE_ORE.getRaw().get());

		WorldGen.addFeature(LONSDALEITE_ORE_PLACED_KEY, BiomeSelectors.foundInTheEnd(),
				GenerationStep.Feature.UNDERGROUND_ORES);

		BlockLootTableProvider.addLootTables(t -> {
			t.addDrop(LONSDALEITE_BLOCK.getRaw().get());
			t.addDrop(LONSDALEITE_ORE.getRaw().get(), LONSDALEITE_DUST.getRaw().get());
		});
	}

	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : LONSDALEITE_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : LONSDALEITE_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : LONSDALEITE_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});

		for (Item i : LONSDALEITE_ITEMS) {
			ItemTagProvider.addTo(Tags.FLOATING_ITEMS_TAG, i.getRaw().get());
		}
		for (Item i : LONSDALEITE_ARMORS) {
			ItemTagProvider.addTo(Tags.FLOATING_ITEMS_TAG, i.getRaw().get());
		}
		for (Item i : LONSDALEITE_TOOLS) {
			ItemTagProvider.addTo(Tags.FLOATING_ITEMS_TAG, i.getRaw().get());
		}

		RecipeProvider.addRecipes(t -> {
			ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, LONSDALEITE_GEM.getRaw().get(), 1)
					.input(LONSDALEITE_DUST.getRaw().get()).input(LONSDALEITE_DUST.getRaw().get())
					.input(LONSDALEITE_DUST.getRaw().get()).input(net.minecraft.item.Items.NETHERITE_INGOT)
					.input(net.minecraft.item.Items.END_CRYSTAL).input(net.minecraft.item.Items.NETHERITE_INGOT)
					.input(net.minecraft.item.Items.DIAMOND).input(net.minecraft.item.Items.DIAMOND)
					.input(net.minecraft.item.Items.DIAMOND)
					.criterion(RecipeProvider.hasItem(LONSDALEITE_DUST.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_DUST.getRaw().get()))
					.group(LONSDALEITE_GEM.getIdentifier().getPath()).offerTo(t);

			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, LONSDALEITE_UPGRADE.getRaw().get(), 2)
					.input('#', Items.CARBON.getRaw().get()).input('C', net.minecraft.item.Items.END_STONE)
					.input('S', LONSDALEITE_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(LONSDALEITE_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_UPGRADE.getRaw().get()))
					.offerTo(t);

			RecipeProvider.offerReversibleCompactingRecipesWithReverseRecipeGroup(t, RecipeCategory.MISC,
					LONSDALEITE_GEM.getRaw()::get, RecipeCategory.DECORATIONS, LONSDALEITE_BLOCK.getBlockItem()::get,
					LONSDALEITE_GEM.getIdentifier().getPath() + "_from_" + LONSDALEITE_BLOCK.getIdentifier().getPath(),
					LONSDALEITE_GEM.getIdentifier().getPath());

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HELMET.getRaw().get()),
							Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), RecipeCategory.COMBAT,
							LONSDALEITE_HELMET.getRaw().get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.getRaw().get()))
					.offerTo(t, LONSDALEITE_HELMET.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_CHESTPLATE.getRaw().get()),
							Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), RecipeCategory.COMBAT,
							LONSDALEITE_CHESTPLATE.getRaw().get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.getRaw().get()))
					.offerTo(t, LONSDALEITE_CHESTPLATE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_LEGGINGS.getRaw().get()),
							Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), RecipeCategory.COMBAT,
							LONSDALEITE_LEGGINGS.getRaw().get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.getRaw().get()))
					.offerTo(t, LONSDALEITE_LEGGINGS.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_BOOTS.getRaw().get()),
							Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), RecipeCategory.COMBAT,
							LONSDALEITE_BOOTS.getRaw().get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.getRaw().get()))
					.offerTo(t, LONSDALEITE_BOOTS.getIdentifier().getPath() + "_smithing");

			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_AXE.getRaw().get()),
							Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), RecipeCategory.TOOLS,
							LONSDALEITE_AXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.getRaw().get()))
					.offerTo(t, LONSDALEITE_AXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_HOE.getRaw().get()),
							Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), RecipeCategory.TOOLS,
							LONSDALEITE_HOE.getRaw().get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.getRaw().get()))
					.offerTo(t, LONSDALEITE_HOE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_PICKAXE.getRaw().get()),
							Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), RecipeCategory.TOOLS,
							LONSDALEITE_PICKAXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.getRaw().get()))
					.offerTo(t, LONSDALEITE_PICKAXE.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SHOVEL.getRaw().get()),
							Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), RecipeCategory.TOOLS,
							LONSDALEITE_SHOVEL.getRaw().get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.getRaw().get()))
					.offerTo(t, LONSDALEITE_SHOVEL.getIdentifier().getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(LONSDALEITE_UPGRADE.getRaw().get()),
							Ingredient.ofItems(Items.TEMPLATE_SWORD.getRaw().get()),
							Ingredient.ofItems(LONSDALEITE_GEM.getRaw().get()), RecipeCategory.TOOLS,
							LONSDALEITE_SWORD.getRaw().get())
					.criterion(RecipeProvider.hasItem(LONSDALEITE_GEM.getRaw().get()),
							RecipeProvider.conditionsFromItem(LONSDALEITE_GEM.getRaw().get()))
					.offerTo(t, LONSDALEITE_SWORD.getIdentifier().getPath() + "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> lonsdaleite_all = new ArrayList<>();

		for (Block i : LONSDALEITE_BLOCKS) {
			lonsdaleite_all.add(i.getBlockItem().get());
		}
		for (Item i : LONSDALEITE_ITEMS) {
			lonsdaleite_all.add(i.getRaw().get());
		}
		for (Item i : LONSDALEITE_ARMORS) {
			lonsdaleite_all.add(i.getRaw().get());
		}
		for (Item i : LONSDALEITE_TOOLS) {
			lonsdaleite_all.add(i.getRaw().get());
		}

		lonsdaleite_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
