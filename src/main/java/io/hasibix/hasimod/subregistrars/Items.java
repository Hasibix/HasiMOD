package io.hasibix.hasimod.subregistrars;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;

import java.util.List;
import java.util.Objects;

import io.hasibix.hasimod.HasiMOD;
import io.hasibix.hasimod.datagen.providers.ModelProvider;
import io.hasibix.hasimod.datagen.providers.RecipeProvider;
import io.hasibix.hasimod.init.Tabs;
import io.hasibix.hasimod.types.Item;
import io.hasibix.hasimod.types.Registrar;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

public class Items implements Registrar {
	// Helpers
	private static List<Identifier> getUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getIronUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	private static List<Identifier> getGoldenUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	private static List<Identifier> getDiamondUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_DIAMOND_TEXTURE);
	}

	// Items
	public static final Item CARBON = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "carbon")),
			new FabricItemSettings().rarity(Rarity.UNCOMMON));

	// Templates
	public static final Item TEMPLATE_HELMET = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_helmet")), new FabricItemSettings());
	public static final Item TEMPLATE_CHESTPLATE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_chestplate")), new FabricItemSettings());
	public static final Item TEMPLATE_LEGGINGS = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_leggings")), new FabricItemSettings());
	public static final Item TEMPLATE_BOOTS = new Item(
			Objects.requireNonNull(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_boots"))),
			new FabricItemSettings());
	public static final Item TEMPLATE_AXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_axe")), new FabricItemSettings());
	public static final Item TEMPLATE_HOE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_hoe")), new FabricItemSettings());
	public static final Item TEMPLATE_PICKAXE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_pickaxe")), new FabricItemSettings());
	public static final Item TEMPLATE_SHOVEL = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_shovel")), new FabricItemSettings());
	public static final Item TEMPLATE_SWORD = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "template_sword")), new FabricItemSettings());

	// Smithing Templates
	public static final Item IRON_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.iron_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.iron_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "iron_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.iron_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.iron_upgrade.additions_slot_description"))),
			getUpgradeEmptyBaseSlotTextures(), getIronUpgradeEmptyAdditionsSlotTextures(), new FabricItemSettings());
	public static final Item GOLDEN_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "golden_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.golden_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.golden_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "golden_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.golden_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.golden_upgrade.additions_slot_description"))),
			getUpgradeEmptyBaseSlotTextures(), getGoldenUpgradeEmptyAdditionsSlotTextures(), new FabricItemSettings());
	public static final Item DIAMOND_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.diamond_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.diamond_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "diamond_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.diamond_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.diamond_upgrade.additions_slot_description"))),
			getUpgradeEmptyBaseSlotTextures(), getDiamondUpgradeEmptyAdditionsSlotTextures(), new FabricItemSettings());

	// Foods
	public static final Item IRON_APPLE = new Item(Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "iron_apple")),
			new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 2), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 4800, 2), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 9600, 2), 1.0f)
							.alwaysEdible().build())
					.rarity(Rarity.EPIC));
	public static final Item DIAMOND_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "diamond_apple")),
			new FabricItemSettings().fireproof()
					.food(new FoodComponent.Builder().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 4800, 2), 1.0f)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0f)
							.alwaysEdible().build())
					.rarity(Rarity.EPIC));
	public static final Item NETHERITE_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "netherite_apple")),
			new FabricItemSettings().fireproof().food(new FoodComponent.Builder().hunger(3).saturationModifier(12.8F)
					.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 4), 1.0f)
					.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 9600, 0), 1.0f)
					.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 4800, 2), 1.0f)
					.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 4800, 2), 1.0f).alwaysEdible().build())
					.rarity(Rarity.EPIC));

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			t.register(CARBON.getRaw().get(), Models.GENERATED);

			t.register(TEMPLATE_HELMET.getRaw().get(), Models.GENERATED);
			t.register(TEMPLATE_CHESTPLATE.getRaw().get(), Models.GENERATED);
			t.register(TEMPLATE_LEGGINGS.getRaw().get(), Models.GENERATED);
			t.register(TEMPLATE_BOOTS.getRaw().get(), Models.GENERATED);
			t.register(TEMPLATE_AXE.getRaw().get(), Models.GENERATED);
			t.register(TEMPLATE_HOE.getRaw().get(), Models.GENERATED);
			t.register(TEMPLATE_PICKAXE.getRaw().get(), Models.GENERATED);
			t.register(TEMPLATE_SHOVEL.getRaw().get(), Models.GENERATED);
			t.register(TEMPLATE_SWORD.getRaw().get(), Models.GENERATED);

			t.register(IRON_UPGRADE.getRaw().get(), Models.GENERATED);
			t.register(GOLDEN_UPGRADE.getRaw().get(), Models.GENERATED);
			t.register(DIAMOND_UPGRADE.getRaw().get(), Models.GENERATED);

			t.register(IRON_APPLE.getRaw().get(), Models.GENERATED);
			t.register(DIAMOND_APPLE.getRaw().get(), Models.GENERATED);
			t.register(NETHERITE_APPLE.getRaw().get(), Models.GENERATED);
		});

		RecipeProvider.addRecipes(t -> {
			RecipeProvider.offerSmelting(t, List.of(net.minecraft.item.Items.COAL, net.minecraft.item.Items.CHARCOAL),
					RecipeCategory.MISC, CARBON.getRaw().get(), 0.8F, 100, CARBON.getIdentifier().getPath());
			RecipeProvider.offerBlasting(t, List.of(net.minecraft.item.Items.COAL, net.minecraft.item.Items.CHARCOAL),
					RecipeCategory.MISC, CARBON.getRaw().get(), 1.2F, 60, CARBON.getIdentifier().getPath());

			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_HELMET.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STRING).input('L', net.minecraft.item.Items.LEATHER_HELMET)
					.pattern("SSS").pattern("SLS").pattern("SSS").offerTo(t, TEMPLATE_HELMET.getIdentifier().getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_CHESTPLATE.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STRING).input('L', net.minecraft.item.Items.LEATHER_CHESTPLATE)
					.pattern("SSS").pattern("SLS").pattern("SSS")
					.offerTo(t, TEMPLATE_CHESTPLATE.getIdentifier().getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_LEGGINGS.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STRING).input('L', net.minecraft.item.Items.LEATHER_LEGGINGS)
					.pattern("SSS").pattern("SLS").pattern("SSS")
					.offerTo(t, TEMPLATE_LEGGINGS.getIdentifier().getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_BOOTS.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STRING).input('L', net.minecraft.item.Items.LEATHER_BOOTS)
					.pattern("SSS").pattern("SLS").pattern("SSS").offerTo(t, TEMPLATE_BOOTS.getIdentifier().getPath());

			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TEMPLATE_AXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('T', net.minecraft.item.Items.STRING)
					.input('L', net.minecraft.item.Items.LEATHER).pattern("TL").pattern("TS").pattern(" S")
					.offerTo(t, TEMPLATE_AXE.getIdentifier().getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TEMPLATE_HOE.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('T', net.minecraft.item.Items.STRING)
					.input('L', net.minecraft.item.Items.LEATHER).pattern("TL").pattern(" S").pattern(" S")
					.offerTo(t, TEMPLATE_HOE.getIdentifier().getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TEMPLATE_PICKAXE.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('T', net.minecraft.item.Items.STRING)
					.input('L', net.minecraft.item.Items.LEATHER).pattern("TLT").pattern(" S ").pattern(" S ")
					.offerTo(t, TEMPLATE_PICKAXE.getIdentifier().getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TEMPLATE_SHOVEL.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('L', net.minecraft.item.Items.LEATHER)
					.pattern("L").pattern("S").pattern("S").offerTo(t, TEMPLATE_SHOVEL.getIdentifier().getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, TEMPLATE_SWORD.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.LEATHER),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.LEATHER))
					.input('S', net.minecraft.item.Items.STICK).input('T', net.minecraft.item.Items.STRING)
					.input('L', net.minecraft.item.Items.LEATHER).pattern("T").pattern("L").pattern("S")
					.offerTo(t, TEMPLATE_SWORD.getIdentifier().getPath());

			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, IRON_UPGRADE.getRaw().get(), 2)
					.input('#', CARBON.getRaw().get()).input('C', net.minecraft.item.Items.STONE)
					.input('S', IRON_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(IRON_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(IRON_UPGRADE.getRaw().get()))
					.offerTo(t);
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GOLDEN_UPGRADE.getRaw().get(), 2)
					.input('#', CARBON.getRaw().get()).input('C', net.minecraft.item.Items.STONE)
					.input('S', GOLDEN_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(GOLDEN_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(GOLDEN_UPGRADE.getRaw().get()))
					.offerTo(t);
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, DIAMOND_UPGRADE.getRaw().get(), 2)
					.input('#', CARBON.getRaw().get()).input('C', net.minecraft.item.Items.DEEPSLATE)
					.input('S', DIAMOND_UPGRADE.getRaw().get()).pattern("#S#").pattern("#C#").pattern("###")
					.criterion(RecipeProvider.hasItem(DIAMOND_UPGRADE.getRaw().get()),
							RecipeProvider.conditionsFromItem(DIAMOND_UPGRADE.getRaw().get()))
					.offerTo(t);

			ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, IRON_APPLE.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.IRON_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.IRON_INGOT))
					.input('A', net.minecraft.item.Items.APPLE).input('M', net.minecraft.item.Items.IRON_INGOT)
					.pattern("MMM").pattern("MAM").pattern("MMM").offerTo(t, IRON_APPLE.getIdentifier().getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, DIAMOND_APPLE.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.DIAMOND),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.DIAMOND))
					.input('A', net.minecraft.item.Items.APPLE).input('M', net.minecraft.item.Items.DIAMOND)
					.pattern("MMM").pattern("MAM").pattern("MMM").offerTo(t, DIAMOND_APPLE.getIdentifier().getPath());
			ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, NETHERITE_APPLE.getRaw().get())
					.criterion(RecipeProvider.hasItem(net.minecraft.item.Items.NETHERITE_INGOT),
							RecipeProvider.conditionsFromItem(net.minecraft.item.Items.NETHERITE_INGOT))
					.input('A', net.minecraft.item.Items.APPLE).input('M', net.minecraft.item.Items.NETHERITE_INGOT)
					.pattern("MMM").pattern("MAM").pattern("MMM").offerTo(t, NETHERITE_APPLE.getIdentifier().getPath());
		});
	}

	@Override
	public void registerTabs() {
		Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, CARBON.getRaw().get(), IRON_APPLE.getRaw().get(),
				DIAMOND_APPLE.getRaw().get(), NETHERITE_APPLE.getRaw().get(), TEMPLATE_HELMET.getRaw().get(),
				TEMPLATE_CHESTPLATE.getRaw().get(), TEMPLATE_LEGGINGS.getRaw().get(), TEMPLATE_BOOTS.getRaw().get(),
				TEMPLATE_AXE.getRaw().get(), TEMPLATE_SWORD.getRaw().get(), TEMPLATE_AXE.getRaw().get(),
				TEMPLATE_HOE.getRaw().get(), TEMPLATE_PICKAXE.getRaw().get(), TEMPLATE_SHOVEL.getRaw().get(),
				IRON_UPGRADE.getRaw().get(), GOLDEN_UPGRADE.getRaw().get(), DIAMOND_UPGRADE.getRaw().get());
	}
}
