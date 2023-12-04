package io.hasibix.hasimod.registrars.ores;

import static io.hasibix.hasimod.others.EmptySlotTextures.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.hasibix.hasimod.HasiMOD;
import io.hasibix.hasimod.datagen.providers.ModelProvider;
import io.hasibix.hasimod.init.Tabs;
import io.hasibix.hasimod.types.ArmorMaterial;
import io.hasibix.hasimod.types.Item;
import io.hasibix.hasimod.types.Registrar;
import io.hasibix.hasimod.types.ToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.data.client.Models;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.FoodComponent;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

public class RoseQuartz implements Registrar {
	// Helpers
	public static final TagKey<net.minecraft.item.Item> ROSE_QUARTZ = TagKey.of(RegistryKeys.ITEM,
			Identifier.of(HasiMOD.MOD_ID, "rose_quartz"));

	private static List<Identifier> getRoseQuartzUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getRoseQuartzUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	public static final Item ROSE_QUARTZ_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_apple")),
			new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 3600, 0), 1.0F).build())
					.rarity(Rarity.COMMON));

	public static final Item ROSE_QUARTZ_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_upgrade_smithing_template")),
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
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.rose_quartz_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.rose_quartz_upgrade.additions_slot_description"))),
			getRoseQuartzUpgradeEmptyBaseSlotTextures(), getRoseQuartzUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings());

	// Materials
	public static final ArmorMaterial ROSE_QUARTZ_ARMOR_MATERIAL = new ArmorMaterial(33, 11,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, HasiMOD.MOD_ID + ":rose_quartz", 2,
			Ingredient.fromTag(ROSE_QUARTZ), 0);
	public static final ToolMaterial ROSE_QUARTZ_TOOL_MATERIAL = new ToolMaterial(2, 363, 11, MiningLevels.IRON, 4,
			Ingredient.fromTag(ROSE_QUARTZ));

	// Armors
	public static final Item ROSE_QUARTZ_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_helmet")), ROSE_QUARTZ_ARMOR_MATERIAL,
			Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ROSE_QUARTZ_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_chestplate")), ROSE_QUARTZ_ARMOR_MATERIAL,
			Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ROSE_QUARTZ_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_leggings")), ROSE_QUARTZ_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ROSE_QUARTZ_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_boots")), ROSE_QUARTZ_ARMOR_MATERIAL,
			Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON));

	// Tools
	public static final Item ROSE_QUARTZ_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_axe")), Item.ToolItem.Type.AXE,
			ROSE_QUARTZ_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ROSE_QUARTZ_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_hoe")), Item.ToolItem.Type.HOE,
			ROSE_QUARTZ_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ROSE_QUARTZ_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_pickaxe")), Item.ToolItem.Type.PICKAXE,
			ROSE_QUARTZ_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ROSE_QUARTZ_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_shovel")), Item.ToolItem.Type.SHOVEL,
			ROSE_QUARTZ_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ROSE_QUARTZ_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "rose_quartz_sword")), Item.ToolItem.Type.SWORD,
			ROSE_QUARTZ_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Lists
	public static List<Item> ROSE_QUARTZ_ITEMS = List.of(ROSE_QUARTZ_APPLE, ROSE_QUARTZ_UPGRADE);
	public static List<Item> ROSE_QUARTZ_ARMORS = List.of(ROSE_QUARTZ_HELMET, ROSE_QUARTZ_CHESTPLATE,
			ROSE_QUARTZ_LEGGINGS, ROSE_QUARTZ_BOOTS);
	public static List<Item> ROSE_QUARTZ_TOOLS = List.of(ROSE_QUARTZ_AXE, ROSE_QUARTZ_HOE, ROSE_QUARTZ_PICKAXE,
			ROSE_QUARTZ_SHOVEL, ROSE_QUARTZ_SWORD);

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : ROSE_QUARTZ_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : ROSE_QUARTZ_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : ROSE_QUARTZ_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> rose_quartz_all = new ArrayList<>();

		for (Item i : ROSE_QUARTZ_ITEMS) {
			rose_quartz_all.add(i.getRaw().get());
		}
		for (Item i : ROSE_QUARTZ_ARMORS) {
			rose_quartz_all.add(i.getRaw().get());
		}
		for (Item i : ROSE_QUARTZ_TOOLS) {
			rose_quartz_all.add(i.getRaw().get());
		}

		rose_quartz_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
