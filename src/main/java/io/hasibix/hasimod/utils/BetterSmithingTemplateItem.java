package io.hasibix.hasimod.utils;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.World;

public final class BetterSmithingTemplateItem extends net.minecraft.item.Item {
	private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
	private static final String TRANSLATION_KEY = Util.createTranslationKey("item",
			new Identifier("smithing_template"));
	private static final Text INGREDIENTS_TEXT = Text
			.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.ingredients")))
			.formatted(TITLE_FORMATTING);
	private static final Text APPLIES_TO_TEXT = Text
			.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.applies_to")))
			.formatted(TITLE_FORMATTING);

	private final Text appliesToText;
	private final Text ingredientsText;
	private final Text titleText;
	private final Text baseSlotDescriptionText;
	private final Text additionsSlotDescriptionText;
	private final List<Identifier> emptyBaseSlotTextures;
	private final List<Identifier> emptyAdditionsSlotTextures;

	public BetterSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText,
			Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures,
			List<Identifier> emptyAdditionsSlotTextures, Settings settings) {
		super(settings);
		this.appliesToText = appliesToText;
		this.ingredientsText = ingredientsText;
		this.titleText = titleText;
		this.baseSlotDescriptionText = baseSlotDescriptionText;
		this.additionsSlotDescriptionText = additionsSlotDescriptionText;
		this.emptyBaseSlotTextures = emptyBaseSlotTextures;
		this.emptyAdditionsSlotTextures = emptyAdditionsSlotTextures;
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);
		tooltip.add(this.titleText);
		tooltip.add(ScreenTexts.EMPTY);
		tooltip.add(APPLIES_TO_TEXT);
		tooltip.add(ScreenTexts.space().append(this.appliesToText));
		tooltip.add(INGREDIENTS_TEXT);
		tooltip.add(ScreenTexts.space().append(this.ingredientsText));
	}

	public Text getBaseSlotDescription() {
		return this.baseSlotDescriptionText;
	}

	public Text getAdditionsSlotDescription() {
		return this.additionsSlotDescriptionText;
	}

	public List<Identifier> getEmptyBaseSlotTextures() {
		return this.emptyBaseSlotTextures;
	}

	public List<Identifier> getEmptyAdditionsSlotTextures() {
		return this.emptyAdditionsSlotTextures;
	}

	@Override
	public String getTranslationKey() {
		return TRANSLATION_KEY;
	}
}
