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

public class Andesite implements Registrar {
	// Helpers
	public static final TagKey<net.minecraft.item.Item> ANDESITE_ALLOY = TagKey.of(RegistryKeys.ITEM,
			Identifier.of(HasiMOD.MOD_ID, "andesite_alloy"));

	private static List<Identifier> getAndesiteUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getAndesiteUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	public static final Item ANDESITE_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_apple")),
			new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 4800, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 9600, 0), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 4800, 2), 1.0F).build())
					.rarity(Rarity.COMMON));
	public static final Item ANDESITE_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.andesite_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.andesite_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "andesite_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.andesite_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.andesite_upgrade.additions_slot_description"))),
			getAndesiteUpgradeEmptyBaseSlotTextures(), getAndesiteUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings());

	// Materials
	public static final ArmorMaterial ANDESITE_ARMOR_MATERIAL = new ArmorMaterial(48, 8,
			SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, HasiMOD.MOD_ID + ":andesite", 2, Ingredient.fromTag(ANDESITE_ALLOY),
			0);
	public static final ToolMaterial ANDESITE_TOOL_MATERIAL = new ToolMaterial(3, 528, 8, MiningLevels.IRON, 6,
			Ingredient.fromTag(ANDESITE_ALLOY));

	// Armors
	public static final Item ANDESITE_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_helmet")), ANDESITE_ARMOR_MATERIAL,
			Type.HELMET, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ANDESITE_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_chestplate")), ANDESITE_ARMOR_MATERIAL,
			Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ANDESITE_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_leggings")), ANDESITE_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ANDESITE_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_boots")), ANDESITE_ARMOR_MATERIAL,
			Type.BOOTS, new FabricItemSettings().rarity(Rarity.COMMON));

	// Tools
	public static final Item ANDESITE_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_axe")), Item.ToolItem.Type.AXE,
			ANDESITE_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ANDESITE_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_hoe")), Item.ToolItem.Type.HOE,
			ANDESITE_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ANDESITE_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_pickaxe")), Item.ToolItem.Type.PICKAXE,
			ANDESITE_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ANDESITE_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_shovel")), Item.ToolItem.Type.SHOVEL,
			ANDESITE_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item ANDESITE_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "andesite_sword")), Item.ToolItem.Type.SWORD,
			ANDESITE_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Lists
	public static List<Item> ANDESITE_ITEMS = List.of(ANDESITE_APPLE, ANDESITE_UPGRADE);
	public static List<Item> ANDESITE_ARMORS = List.of(ANDESITE_HELMET, ANDESITE_CHESTPLATE, ANDESITE_LEGGINGS,
			ANDESITE_BOOTS);
	public static List<Item> ANDESITE_TOOLS = List.of(ANDESITE_AXE, ANDESITE_HOE, ANDESITE_PICKAXE, ANDESITE_SHOVEL,
			ANDESITE_SWORD);

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : ANDESITE_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : ANDESITE_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : ANDESITE_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> andesite_all = new ArrayList<>();

		for (Item i : ANDESITE_ITEMS) {
			andesite_all.add(i.getRaw().get());
		}
		for (Item i : ANDESITE_ARMORS) {
			andesite_all.add(i.getRaw().get());
		}
		for (Item i : ANDESITE_TOOLS) {
			andesite_all.add(i.getRaw().get());
		}

		andesite_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
