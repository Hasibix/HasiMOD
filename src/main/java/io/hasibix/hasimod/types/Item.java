package io.hasibix.hasimod.types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import com.google.common.base.Suppliers;

import io.hasibix.hasimod.utils.BetterSmithingTemplateItem;
import net.minecraft.item.*;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * Holder for {@link net.minecraft.item.Item}. This class is used to
 * automatically add to registry and hold an instance of
 * {@link net.minecraft.item.Item}. {@link java.util.function.Supplier} is used
 * for asynchronized usage.
 */
public class Item {
	// Helpers
	public static final List<Item> items = new ArrayList<>();

	// Variables
	protected final Identifier identifier;
	protected Supplier<net.minecraft.item.Item> raw;

	// Constructors
	protected Item(@NotNull Identifier identifier) {
		this.identifier = identifier;
		items.add(this);
	}

	public Item(@NotNull Identifier identifier, @NotNull net.minecraft.item.Item.Settings settings) {
		this(identifier);
		this.raw = Suppliers
				.memoize(() -> Registry.register(Registries.ITEM, identifier, new net.minecraft.item.Item(settings)));
	}

	// Getters
	public Identifier getIdentifier() {
		return identifier;
	}

	public Supplier<net.minecraft.item.Item> getRaw() {
		return raw;
	}

	// Subclasses
	public static final class ArmorItem extends Item {
		public ArmorItem(@NotNull Identifier identifier, @NotNull ArmorMaterial material,
				@NotNull net.minecraft.item.ArmorItem.Type type, net.minecraft.item.Item.@NotNull Settings settings) {
			super(identifier);
			this.raw = Suppliers.memoize(() -> Registry.register(Registries.ITEM, identifier,
					new net.minecraft.item.ArmorItem(material, type, settings)))::get;
		}
	}

	public static final class ToolItem extends Item {
		public enum Type {
			AXE, HOE, PICKAXE, SHOVEL, SWORD
		}

		public ToolItem(@NotNull Identifier identifier, @NotNull Type type, @NotNull ToolMaterial material,
				int attackDamage, float attackSpeed, net.minecraft.item.Item.@NotNull Settings settings) {
			super(identifier);
			this.raw = registerToolItem(identifier, type, material, attackDamage, attackSpeed, settings);
		}

		private static Supplier<net.minecraft.item.Item> registerToolItem(@NotNull Identifier identifier,
				@NotNull Type type, @NotNull ToolMaterial material, int attackDamage, float attackSpeed,
				@NotNull net.minecraft.item.Item.Settings settings) {
			return switch (type) {
			case AXE -> Suppliers.memoize(() -> Registry.register(Registries.ITEM, identifier,
					new AxeItem(material, attackDamage, attackSpeed, settings)));
			case HOE -> Suppliers.memoize(() -> Registry.register(Registries.ITEM, identifier,
					new HoeItem(material, attackDamage, attackSpeed, settings)));
			case PICKAXE -> Suppliers.memoize(() -> Registry.register(Registries.ITEM, identifier,
					new PickaxeItem(material, attackDamage, attackSpeed, settings)));
			case SHOVEL -> Suppliers.memoize(() -> Registry.register(Registries.ITEM, identifier,
					new ShovelItem(material, attackDamage, attackSpeed, settings)));
			case SWORD -> Suppliers.memoize(() -> Registry.register(Registries.ITEM, identifier,
					new SwordItem(material, attackDamage, attackSpeed, settings)));
			};
		}
	}

	public static final class SmithingTemplate extends Item {
		public SmithingTemplate(@NotNull Identifier identifier, Text appliesToText, Text ingredientsText,
				Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText,
				List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures,
				@NotNull net.minecraft.item.Item.Settings settings) {
			super(identifier);
			this.raw = Suppliers.memoize(() -> Registry.register(Registries.ITEM, identifier,
					new BetterSmithingTemplateItem(appliesToText, ingredientsText, titleText, baseSlotDescriptionText,
							additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures,
							settings)))::get;
		}
	}
}
