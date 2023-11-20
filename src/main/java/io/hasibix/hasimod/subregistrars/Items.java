package io.hasibix.hasimod.subregistrars;

import java.util.List;
import java.util.Objects;

import io.hasibix.hasimod.HasiMOD;
import io.hasibix.hasimod.datagen.providers.ModelProvider;
import io.hasibix.hasimod.datagen.providers.RecipeProvider;
import io.hasibix.hasimod.init.Tabs;
import io.hasibix.hasimod.types.Item;
import io.hasibix.hasimod.types.OverriderItem;
import io.hasibix.hasimod.types.Registrar;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

public class Items implements Registrar {
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
	private static final Identifier EMPTY_SLOT_DIAMOND_TEXTURE = new Identifier("item/empty_slot_diamond");
	private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = new Identifier("item/empty_slot_ingot");

	private static List<Identifier> getUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	// Templates
	public static final Item TEMPLATE_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_helmet")),
			new net.minecraft.item.Item(new FabricItemSettings()));
	public static final Item TEMPLATE_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_chestplate")),
			new net.minecraft.item.Item(new FabricItemSettings()));
	public static final Item TEMPLATE_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_leggings")),
			new net.minecraft.item.Item(new FabricItemSettings()));
	public static final Item TEMPLATE_BOOTS = new Item(
			Objects.requireNonNull(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_boots"))),
			new net.minecraft.item.Item(new FabricItemSettings()));

	public static final Item TEMPLATE_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_axe")),
			new net.minecraft.item.Item(new FabricItemSettings()));
	public static final Item TEMPLATE_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_hoe")),
			new net.minecraft.item.Item(new FabricItemSettings()));
	public static final Item TEMPLATE_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_pickaxe")),
			new net.minecraft.item.Item(new FabricItemSettings()));
	public static final Item TEMPLATE_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_shovel")),
			new net.minecraft.item.Item(new FabricItemSettings()));
	public static final Item TEMPLATE_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_sword")),
			new net.minecraft.item.Item(new FabricItemSettings()));

	public static final Item IRON_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.iron_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.iron_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "iron_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.iron_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.iron_upgrade.additions_slot_description"))),
					getUpgradeEmptyBaseSlotTextures(), List.of(EMPTY_SLOT_INGOT_TEXTURE)));
	public static final Item GOLDEN_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.golden_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.golden_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "golden_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.golden_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.golden_upgrade.additions_slot_description"))),
					getUpgradeEmptyBaseSlotTextures(), List.of(EMPTY_SLOT_INGOT_TEXTURE)));
	public static final Item DIAMOND_UPGRADE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_upgrade_smithing_template")),
			new SmithingTemplateItem(
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.diamond_upgrade.applies_to")))
							.formatted(Formatting.BLUE),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.diamond_upgrade.ingredients")))
							.formatted(Formatting.BLUE),
					Text.translatable(
							Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "diamond_upgrade")))
							.formatted(Formatting.GRAY),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID, "smithing_template.diamond_upgrade.base_slot_description"))),
					Text.translatable(Util.createTranslationKey("item",
							Identifier.of(HasiMOD.MOD_ID,
									"smithing_template.diamond_upgrade.additions_slot_description"))),
					getUpgradeEmptyBaseSlotTextures(), List.of(EMPTY_SLOT_DIAMOND_TEXTURE)));

	// Vanilla Ore Apples
	public static final Item IRON_APPLE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().hunger(4).saturationModifier(1.2f)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0f)
							.alwaysEdible().build())
					.rarity(Rarity.EPIC)));
	public static final OverriderItem GOLDEN_APPLE = new OverriderItem(
			net.minecraft.item.Item.getRawId(net.minecraft.item.Items.GOLDEN_APPLE), "minecraft:golden_apple",
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().hunger(8).saturationModifier(2.4f)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 800, 2), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 12000, 1), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 12000, 1), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 6), 1.0f)
							.alwaysEdible().build())
					.rarity(Rarity.EPIC)));
	public static final Item DIAMOND_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().hunger(16).saturationModifier(4.8f)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1600, 4), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 24000, 2), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 24000, 2), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 9600, 12), 1.0f)
							.alwaysEdible().build())
					.rarity(Rarity.EPIC)));
	public static final Item NETHERITE_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_apple")),
			new net.minecraft.item.Item(new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().hunger(32).saturationModifier(9.6f)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 3200, 8), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 48000, 4), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 48000, 4), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 19200, 24), 1.0f)
							.alwaysEdible().build())
					.rarity(Rarity.EPIC)));

	@Override
	public void registerItems() {
		ModelProvider.addItems(t -> {
			t.register(TEMPLATE_HELMET.raw.get(), Models.GENERATED);
			t.register(TEMPLATE_CHESTPLATE.raw.get(), Models.GENERATED);
			t.register(TEMPLATE_LEGGINGS.raw.get(), Models.GENERATED);
			t.register(TEMPLATE_BOOTS.raw.get(), Models.GENERATED);

			t.register(TEMPLATE_AXE.raw.get(), Models.GENERATED);
			t.register(TEMPLATE_HOE.raw.get(), Models.GENERATED);
			t.register(TEMPLATE_PICKAXE.raw.get(), Models.GENERATED);
			t.register(TEMPLATE_SHOVEL.raw.get(), Models.GENERATED);
			t.register(TEMPLATE_SWORD.raw.get(), Models.GENERATED);

			t.register(IRON_UPGRADE.raw.get(), Models.GENERATED);
			t.register(GOLDEN_UPGRADE.raw.get(), Models.GENERATED);
			t.register(DIAMOND_UPGRADE.raw.get(), Models.GENERATED);

			t.register(IRON_APPLE.raw.get(), Models.GENERATED);
			t.register(GOLDEN_APPLE.raw.get(), Models.GENERATED);
			t.register(DIAMOND_APPLE.raw.get(), Models.GENERATED);
			t.register(NETHERITE_APPLE.raw.get(), Models.GENERATED);
		});

		RecipeProvider.addRecipes(t -> {
			// Misc
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_HELMET.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STRING).input('L', net.minecraft.item.Items.LEATHER_HELMET)
					.pattern("SSS").pattern("SLS").pattern("SSS").offerTo(t, TEMPLATE_HELMET.identifier.getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_CHESTPLATE.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STRING).input('L', net.minecraft.item.Items.LEATHER_CHESTPLATE)
					.pattern("SSS").pattern("SLS").pattern("SSS").offerTo(t, TEMPLATE_CHESTPLATE.identifier.getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_LEGGINGS.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STRING).input('L', net.minecraft.item.Items.LEATHER_LEGGINGS)
					.pattern("SSS").pattern("SLS").pattern("SSS").offerTo(t, TEMPLATE_LEGGINGS.identifier.getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_BOOTS.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STRING).input('L', net.minecraft.item.Items.LEATHER_BOOTS)
					.pattern("SSS").pattern("SLS").pattern("SSS").offerTo(t, TEMPLATE_BOOTS.identifier.getPath());

			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TEMPLATE_AXE.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('T', net.minecraft.item.Items.STRING)
					.input('L', net.minecraft.item.Items.LEATHER).pattern("TL").pattern("TS").pattern(" S")
					.offerTo(t, TEMPLATE_AXE.identifier.getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TEMPLATE_HOE.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('T', net.minecraft.item.Items.STRING)
					.input('L', net.minecraft.item.Items.LEATHER).pattern("TL").pattern(" S").pattern(" S")
					.offerTo(t, TEMPLATE_HOE.identifier.getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TEMPLATE_PICKAXE.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('T', net.minecraft.item.Items.STRING)
					.input('L', net.minecraft.item.Items.LEATHER).pattern("TLT").pattern(" S ").pattern(" S ")
					.offerTo(t, TEMPLATE_PICKAXE.identifier.getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TEMPLATE_SHOVEL.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('L', net.minecraft.item.Items.LEATHER)
					.pattern("L").pattern("S").pattern("S").offerTo(t, TEMPLATE_SHOVEL.identifier.getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_SWORD.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('T', net.minecraft.item.Items.STRING)
					.input('L', net.minecraft.item.Items.LEATHER).pattern("T").pattern("L").pattern("S")
					.offerTo(t, TEMPLATE_SWORD.identifier.getPath());

			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, IRON_UPGRADE.raw.get(), 2)
					.input('#', net.minecraft.item.Items.LEATHER).input('C', net.minecraft.item.Items.IRON_INGOT)
					.input('S', IRON_UPGRADE.raw.get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(IRON_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(IRON_UPGRADE.raw.get()))
					.offerTo(t);
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GOLDEN_UPGRADE.raw.get(), 2)
					.input('#', net.minecraft.item.Items.GOLD_INGOT).input('C', net.minecraft.item.Items.STONE)
					.input('S', GOLDEN_UPGRADE.raw.get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(GOLDEN_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(GOLDEN_UPGRADE.raw.get()))
					.offerTo(t);
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, DIAMOND_UPGRADE.raw.get(), 2)
					.input('#', net.minecraft.item.Items.DIAMOND).input('C', net.minecraft.item.Items.DEEPSLATE)
					.input('S', DIAMOND_UPGRADE.raw.get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(DIAMOND_UPGRADE.raw.get()),
							RecipeProvider.conditionsFromItem(DIAMOND_UPGRADE.raw.get()))
					.offerTo(t);

			ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, IRON_APPLE.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.input('A', net.minecraft.item.Items.APPLE).input('M', net.minecraft.item.Items.IRON_INGOT)
					.pattern("MMM").pattern("MAM").pattern("MMM").offerTo(t, IRON_APPLE.identifier.getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, DIAMOND_APPLE.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.input('A', net.minecraft.item.Items.APPLE).input('M', net.minecraft.item.Items.DIAMOND)
					.pattern("MMM").pattern("MAM").pattern("MMM").offerTo(t, DIAMOND_APPLE.identifier.getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, NETHERITE_APPLE.raw.get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.input('A', net.minecraft.item.Items.APPLE).input('M', net.minecraft.item.Items.NETHERITE_INGOT)
					.pattern("MMM").pattern("MAM").pattern("MMM").offerTo(t, NETHERITE_APPLE.identifier.getPath());

			// Armors
			// Iron
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(IRON_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_HELMET.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.IRON_HELMET)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_helmet")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(IRON_UPGRADE.raw.get()),
							Ingredient.ofItems(TEMPLATE_CHESTPLATE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.IRON_CHESTPLATE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_chestplate")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(IRON_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_LEGGINGS.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.IRON_LEGGINGS)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_leggings")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(IRON_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_BOOTS.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.IRON_BOOTS)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_boots")).getPath()
							+ "_smithing");

			// Gold
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(GOLDEN_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_HELMET.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.GOLD_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.GOLDEN_HELMET)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.GOLD_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.GOLD_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_helmet")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(GOLDEN_UPGRADE.raw.get()),
							Ingredient.ofItems(TEMPLATE_CHESTPLATE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.GOLD_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.GOLDEN_CHESTPLATE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.GOLD_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.GOLD_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_chestplate")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(GOLDEN_UPGRADE.raw.get()),
							Ingredient.ofItems(TEMPLATE_LEGGINGS.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.GOLD_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.GOLDEN_LEGGINGS)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.GOLD_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.GOLD_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_leggings")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(GOLDEN_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_BOOTS.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.GOLD_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.GOLDEN_BOOTS)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.GOLD_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.GOLD_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_boots")).getPath()
							+ "_smithing");

			// Diamond
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(DIAMOND_UPGRADE.raw.get()),
					Ingredient.ofItems(TEMPLATE_HELMET.raw.get()), Ingredient.ofItems(net.minecraft.item.Items.DIAMOND),
					RecipeCategory.COMBAT, net.minecraft.item.Items.DIAMOND_HELMET)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_helmet")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(DIAMOND_UPGRADE.raw.get()),
							Ingredient.ofItems(TEMPLATE_CHESTPLATE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.DIAMOND), RecipeCategory.COMBAT,
							net.minecraft.item.Items.DIAMOND_CHESTPLATE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_chestplate")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(DIAMOND_UPGRADE.raw.get()),
							Ingredient.ofItems(TEMPLATE_LEGGINGS.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.DIAMOND), RecipeCategory.COMBAT,
							net.minecraft.item.Items.DIAMOND_LEGGINGS)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_leggings")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(DIAMOND_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_BOOTS.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.DIAMOND), RecipeCategory.COMBAT,
							net.minecraft.item.Items.DIAMOND_BOOTS)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_boots")).getPath()
							+ "_smithing");

			// Netherite
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.ofItems(TEMPLATE_HELMET.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.NETHERITE_HELMET)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_helmet")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.ofItems(TEMPLATE_CHESTPLATE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.NETHERITE_CHESTPLATE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_chestplate")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.ofItems(TEMPLATE_LEGGINGS.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.NETHERITE_LEGGINGS)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_leggings")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.ofItems(TEMPLATE_BOOTS.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.NETHERITE_BOOTS)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_boots")).getPath()
							+ "_smithing");

			// Tools
			// Iron
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(IRON_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_AXE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.IRON_AXE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.offerTo(t,
							Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_axe")).getPath() + "_smithing");
		});
		RecipeProvider.addRecipes(t -> {
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(IRON_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_HOE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.IRON_HOE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.offerTo(t,
							Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_hoe")).getPath() + "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(IRON_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_PICKAXE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.IRON_PICKAXE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_pickaxe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(IRON_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_SHOVEL.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.IRON_SHOVEL)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_shovel")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(IRON_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_SWORD.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.IRON_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.IRON_SWORD)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_sword")).getPath()
							+ "_smithing");

			// Gold
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(GOLDEN_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_AXE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.GOLD_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.GOLDEN_AXE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.GOLD_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.GOLD_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_axe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(GOLDEN_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_HOE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.GOLD_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.GOLDEN_HOE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.GOLD_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.GOLD_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_hoe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(GOLDEN_UPGRADE.raw.get()),
							Ingredient.ofItems(TEMPLATE_PICKAXE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.GOLD_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.GOLDEN_PICKAXE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.GOLD_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.GOLD_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_pickaxe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(GOLDEN_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_SHOVEL.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.GOLD_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.GOLDEN_SHOVEL)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.GOLD_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.GOLD_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_shovel")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(GOLDEN_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_SWORD.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.GOLD_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.GOLDEN_SWORD)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.GOLD_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.GOLD_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_sword")).getPath()
							+ "_smithing");

			// Diamond
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(DIAMOND_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_AXE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.DIAMOND), RecipeCategory.TOOLS,
							net.minecraft.item.Items.DIAMOND_AXE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_axe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(DIAMOND_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_HOE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.DIAMOND), RecipeCategory.TOOLS,
							net.minecraft.item.Items.DIAMOND_HOE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_hoe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(DIAMOND_UPGRADE.raw.get()),
							Ingredient.ofItems(TEMPLATE_PICKAXE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.DIAMOND), RecipeCategory.TOOLS,
							net.minecraft.item.Items.DIAMOND_PICKAXE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_pickaxe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(DIAMOND_UPGRADE.raw.get()),
					Ingredient.ofItems(TEMPLATE_SHOVEL.raw.get()), Ingredient.ofItems(net.minecraft.item.Items.DIAMOND),
					RecipeCategory.TOOLS, net.minecraft.item.Items.DIAMOND_SHOVEL)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_shovel")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(DIAMOND_UPGRADE.raw.get()), Ingredient.ofItems(TEMPLATE_SWORD.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.DIAMOND), RecipeCategory.COMBAT,
							net.minecraft.item.Items.DIAMOND_SWORD)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_sword")).getPath()
							+ "_smithing");

			// Netherite
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.ofItems(TEMPLATE_AXE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.NETHERITE_AXE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_axe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.ofItems(TEMPLATE_HOE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.NETHERITE_HOE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_hoe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.ofItems(TEMPLATE_PICKAXE.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.NETHERITE_PICKAXE)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_pickaxe")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.ofItems(TEMPLATE_SHOVEL.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_INGOT), RecipeCategory.TOOLS,
							net.minecraft.item.Items.NETHERITE_SHOVEL)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_shovel")).getPath()
							+ "_smithing");
			SmithingTransformRecipeJsonBuilder
					.create(Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.ofItems(TEMPLATE_SWORD.raw.get()),
							Ingredient.ofItems(net.minecraft.item.Items.NETHERITE_INGOT), RecipeCategory.COMBAT,
							net.minecraft.item.Items.NETHERITE_SWORD)
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.offerTo(t, Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_sword")).getPath()
							+ "_smithing");
		});
	}

	@Override
	public void registerTabs() {
		Tabs.addContentsTo(ItemGroups.FOOD_AND_DRINK, IRON_APPLE.raw.get(), GOLDEN_APPLE.raw.get(),
				DIAMOND_APPLE.raw.get(), NETHERITE_APPLE.raw.get());
		Tabs.addContentsTo(ItemGroups.COMBAT, TEMPLATE_HELMET.raw.get(), TEMPLATE_CHESTPLATE.raw.get(),
				TEMPLATE_LEGGINGS.raw.get(), TEMPLATE_BOOTS.raw.get(), TEMPLATE_SWORD.raw.get());
		Tabs.addContentsTo(ItemGroups.TOOLS, TEMPLATE_AXE.raw.get(), TEMPLATE_HOE.raw.get(), TEMPLATE_PICKAXE.raw.get(),
				TEMPLATE_SHOVEL.raw.get());
	}
}
