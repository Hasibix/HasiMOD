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

public class Brass implements Registrar {
	// Helpers
	public static final TagKey<net.minecraft.item.Item> BRASS_INGOT = TagKey.of(RegistryKeys.ITEM,
			Identifier.of(HasiMOD.MOD_ID, "brass_ingot"));

	private static List<Identifier> getBrassUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
				EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
				EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
	}

	private static List<Identifier> getBrassUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_INGOT_TEXTURE);
	}

	// Items
	public static final Item BRASS_APPLE = new Item(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_apple")),
			new FabricItemSettings()
					.food(new FoodComponent.Builder().alwaysEdible().hunger(2).saturationModifier(9.6F)
							.statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 4800, 2), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 9600, 0), 1.0F)
							.statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 4800, 2), 1.0F).build())
					.rarity(Rarity.COMMON));

	public static final Item BRASS_UPGRADE = new Item.SmithingTemplate(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_upgrade_smithing_template")),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.brass_upgrade.applies_to")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.brass_upgrade.ingredients")))
					.formatted(Formatting.BLUE),
			Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(HasiMOD.MOD_ID, "brass_upgrade")))
					.formatted(Formatting.GRAY),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.brass_upgrade.base_slot_description"))),
			Text.translatable(Util.createTranslationKey("item",
					Identifier.of(HasiMOD.MOD_ID, "smithing_template.brass_upgrade.additions_slot_description"))),
			getBrassUpgradeEmptyBaseSlotTextures(), getBrassUpgradeEmptyAdditionsSlotTextures(),
			new FabricItemSettings());

	// Materials
	public static final ArmorMaterial BRASS_ARMOR_MATERIAL = new ArmorMaterial(33, 10,
			SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, HasiMOD.MOD_ID + ":brass", 2, Ingredient.fromTag(BRASS_INGOT), 0);
	public static final ToolMaterial BRASS_TOOL_MATERIAL = new ToolMaterial(2, 363, 10, MiningLevels.IRON, 4,
			Ingredient.fromTag(BRASS_INGOT));

	// Armors
	public static final Item BRASS_HELMET = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_helmet")), BRASS_ARMOR_MATERIAL, Type.HELMET,
			new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item BRASS_CHESTPLATE = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_chestplate")), BRASS_ARMOR_MATERIAL,
			Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item BRASS_LEGGINGS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_leggings")), BRASS_ARMOR_MATERIAL,
			Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item BRASS_BOOTS = new Item.ArmorItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_boots")), BRASS_ARMOR_MATERIAL, Type.BOOTS,
			new FabricItemSettings().rarity(Rarity.COMMON));

	// Tools
	public static final Item BRASS_AXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_axe")), Item.ToolItem.Type.AXE,
			BRASS_TOOL_MATERIAL, 4, -3.1F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item BRASS_HOE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_hoe")), Item.ToolItem.Type.HOE,
			BRASS_TOOL_MATERIAL, 1, -1.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item BRASS_PICKAXE = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_pickaxe")), Item.ToolItem.Type.PICKAXE,
			BRASS_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item BRASS_SHOVEL = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_shovel")), Item.ToolItem.Type.SHOVEL,
			BRASS_TOOL_MATERIAL, 2, -3.0F, new FabricItemSettings().rarity(Rarity.COMMON));
	public static final Item BRASS_SWORD = new Item.ToolItem(
			Objects.requireNonNull(Identifier.of(HasiMOD.MOD_ID, "brass_sword")), Item.ToolItem.Type.SWORD,
			BRASS_TOOL_MATERIAL, 3, -2.4F, new FabricItemSettings().rarity(Rarity.COMMON));

	// Lists
	public static List<Item> BRASS_ITEMS = List.of(BRASS_APPLE, BRASS_UPGRADE);
	public static List<Item> BRASS_ARMORS = List.of(BRASS_HELMET, BRASS_CHESTPLATE, BRASS_LEGGINGS, BRASS_BOOTS);
	public static List<Item> BRASS_TOOLS = List.of(BRASS_AXE, BRASS_HOE, BRASS_PICKAXE, BRASS_SHOVEL, BRASS_SWORD);

	// Methods
	@Override
	public void registerItems() {
		// Datagen
		ModelProvider.addItems(t -> {
			for (Item i : BRASS_ITEMS) {
				t.register(i.getRaw().get(), Models.GENERATED);
			}
			for (Item i : BRASS_ARMORS) {
				t.registerArmor((ArmorItem) i.getRaw().get());
			}
			for (Item i : BRASS_TOOLS) {
				t.register(i.getRaw().get(), Models.HANDHELD);
			}
		});
	}

	@Override
	public void registerTabs() {
		List<net.minecraft.item.Item> brass_all = new ArrayList<>();

		for (Item i : BRASS_ITEMS) {
			brass_all.add(i.getRaw().get());
		}
		for (Item i : BRASS_ARMORS) {
			brass_all.add(i.getRaw().get());
		}
		for (Item i : BRASS_TOOLS) {
			brass_all.add(i.getRaw().get());
		}

		brass_all.forEach(t -> {
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ALL, t);
			Tabs.addContentsTo(Tabs.TAB_HASIMOD_ORES, t);
		});
	}
}
