package io.github.cheesecurd.vallhalla.items;

import io.github.cheesecurd.vallhalla.VallHalla;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

public class ModItems
{
	public static Item createItem(String itemName, Item item)
	{
		return Registry.register(Registry.ITEM, new ResourceLocation("vallhalla", itemName), item);
	}

	public static Item createDrink(String itemName, Integer adelhyde, Integer bronson, Integer delta, Integer flan, Integer karmo, Integer effectAmplifier, Integer effectProb, Item returnItem, MobEffectInstance[] extraEffects)
	{

		Drinkables item = new Drinkables(new FabricItemSettings()
							.food(Drinkables.createAlcohol(adelhyde, bronson, delta, flan, karmo, effectAmplifier, effectProb, extraEffects))
							.group(VallHalla.VALLHALLA_TAB)
							.maxCount(1));

		item.setReturnItem(returnItem);

		return Registry.register(Registry.ITEM, new ResourceLocation("vallhalla", itemName), item);
	}
	// Main stuff

	public static final Item ingredient_can = createItem("ingredient_can",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(20)));
	public static final Item adelhyde = createItem("adelhyde",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(20))); // Sweetness
	public static final Item bronson_extract = createItem("bronson_extract",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(20))); // Bitterness
	public static final Item powdered_delta = createItem("powdered_delta",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(20))); // Sourness
	public static final Item flanergide = createItem("flanergide",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(20))); // Spiciness
	public static final Item karmotrine = createItem("karmotrine",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(20))); // Alcohol

	public static final Item shaker_icon = createItem("shaker_icon", // This is only the icon, the item has 0 purpose, hence the '_icon'
			new Item(new FabricItemSettings().maxCount(1)));

	// Glasses

	public static final Item mug = createItem("mug",
			new Item(new FabricItemSettings().group(VallHalla.VALLHALLA_TAB)));
	public static final Item collins_glass = createItem("collins_glass",
			new Item(new FabricItemSettings().group(VallHalla.VALLHALLA_TAB)));
	public static final Item coupe_glass = createItem("coupe_glass",
			new Item(new FabricItemSettings().group(VallHalla.VALLHALLA_TAB)));
	public static final Item hurricane_glass = createItem("hurricane_glass",
			new Item(new FabricItemSettings().group(VallHalla.VALLHALLA_TAB)));
	public static final Item rocks_glass = createItem("rocks_glass",
			new Item(new FabricItemSettings().group(VallHalla.VALLHALLA_TAB)));
	public static final Item tumbler_glass = createItem("tumbler_glass",
			new Item(new FabricItemSettings().group(VallHalla.VALLHALLA_TAB)));
	public static final Item tiki_mug = createItem("tiki_mug",
			new Item(new FabricItemSettings().group(VallHalla.VALLHALLA_TAB)));

	// Drinks

	// I hate Java.
	private static final MobEffectInstance[] noEffects = {};
	private static final MobEffectInstance[] speedEffect = {new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, 0)};

	// B
	public static final Item bad_touch = createDrink(
			"bad_touch",
			0,
			2,
			2,
			2,
			4,
			0,
			1,
			collins_glass,
			noEffects);
	public static final Item beer = createDrink(
			"beer",
			1,
			2,
			1,
			2,
			4,
			0,
			1,
			mug,
			noEffects);
	public static final Item bleeding_jane = createDrink(
			"bleeding_jane",
			0,
			1,
			3,
			3,
			0,
			0,
			1,
			coupe_glass,
			noEffects);
	public static final Item bloom_light = createDrink(
			"bloom_light",
			4,
			0,
			1,
			2,
			3,
			0,
			1,
			coupe_glass,
			noEffects);
	public static final Item blue_fairy = createDrink(
			"blue_fairy",
			4,
			0,
			0,
			1,
			0,
			0,
			1,
			collins_glass,
			noEffects);
	public static final Item brandtini = createDrink(
			"brandtini",
			6,
			0,
			3,
			0,
			1,
			0,
			1,
			coupe_glass,
			noEffects);
	// C
	public static final Item cobalt_velvet = createDrink(
			"cobalt_velvet",
			2,
			0,
			0,
			3,
			5,
			0,
			1,
			tumbler_glass,
			noEffects);
	public static final Item crevice_spike = createDrink(
			"crevice_spike",
			0,
			0,
			2,
			4,
			0,
			0,
			1,
			rocks_glass,
			noEffects);
	// F
	public static final Item flaming_moai = createDrink(
			"flaming_moai",
			1,
			2,
			2,
			3,
			5,
			0,
			1,
			tiki_mug,
			noEffects);
	public static final Item fluffy_dream = createDrink(
			"fluffy_dream",
			3,
			0,
			3,
			0,
			0,
			0,
			1,
			hurricane_glass,
			noEffects);
	public static final Item fringe_weaver = createDrink(
			"fringe_weaver",
			1,
			0,
			0,
			0,
			9,
			1,
			1,
			coupe_glass,
			noEffects);
	public static final Item frothy_water = createDrink(
			"frothy_water",
			1,
			1,
			1,
			1,
			0,
			0,
			1,
			mug,
			noEffects);
	// G
	public static final Item grizzly_temple = createDrink(
			"grizzly_temple",
			3,
			3,
			3,
			0,
			1,
			0,
			1,
			coupe_glass,
			noEffects);
	public static final Item gut_punch = createDrink(
			"gut_punch",
			0,
			5,
			0,
			1,
			0,
			1,
			1,
			rocks_glass,
			noEffects);
	// M
	public static final Item marsblast = createDrink(
			"marsblast",
			0,
			6,
			1,
			4,
			2,
			1,
			1,
			collins_glass,
			noEffects);
	public static final Item mercuryblast = createDrink(
			"mercuryblast",
			1,
			1,
			3,
			3,
			2,
			0,
			1,
			collins_glass,
			noEffects);
	public static final Item moonblast = createDrink(
			"moonblast",
			6,
			0,
			1,
			1,
			2,
			0,
			1,
			collins_glass,
			noEffects);
	// P
	public static final Item piano_man = createDrink(
			"piano_man",
			2,
			3,
			5,
			5,
			3,
			1,
			1,
			hurricane_glass,
			noEffects);
	public static final Item piano_woman = createDrink(
			"piano_woman",
			5,
			5,
			2,
			3,
			3,
			0,
			1,
			hurricane_glass,
			noEffects);
	public static final Item pile_driver = createDrink(
			"pile_driver",
			0,
			0,
			1,
			0,
			4,
			0,
			1,
			rocks_glass,
			noEffects);
	// S
	public static final Item sparkle_star = createDrink(
			"sparkle_star",
			2,
			0,
			1,
			0,
			0,
			0,
			1,
			hurricane_glass,
			noEffects);

	public static final Item sugar_rush = createDrink(
			"sugar_rush",
			2,
			0,
			1,
			0,
			0,
			0,
			1,
			collins_glass,
			speedEffect);
	public static final Item sun_cloud = createDrink(
			"sun_cloud",
			2,
			2,
			0,
			0,
			0,
			0,
			1,
			tumbler_glass,
			noEffects);
	public static final Item suplex = createDrink(
			"suplex",
			0,
			4,
			0,
			3,
			3,
			0,
			1,
			rocks_glass,
			noEffects);
	// Z
	public static final Item zen_star = createDrink(
			"zen_star",
			4,
			4,
			4,
			4,
			4,
			0,
			1,
			tumbler_glass,
			noEffects);

	// Tooltips
	// no idea what I'm going :3
	//TooltipModifier.REGISTRY.registry(adelhyde, new ItemDescription.Modifier(adelhyde, TooltipHelper.Palette.STANDARD_CREATE);


	public static void registerItems() {}
}
