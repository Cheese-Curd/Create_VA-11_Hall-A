package io.github.cheesecurd.vallhalla.items;

import io.github.cheesecurd.vallhalla.VallHalla;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModItems
{
	public static Item createItem(String itemName, Item item)
	{
		return Registry.register(Registry.ITEM, new ResourceLocation("vallhalla", itemName), item);
	}

	public static Item createDrink(String itemName, Integer effectTime, Integer effectAmplifier, Integer effectProb, ItemStack returnItem /*, MobEffectInstance[] extraEffects */)
	{
		Drinkables item = new Drinkables(new FabricItemSettings()
							.food(Drinkables.createAlcohol(effectTime, effectAmplifier, effectProb))
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

	// B
	public static final Item bad_touch = createDrink(
			"bad_touch",
			1000,
			0,
			1,
			new ItemStack(collins_glass));
	public static final Item beer = createDrink(
			"beer",
			1000,
			0,
			1,
			new ItemStack(mug));
	public static final Item bleeding_jane = createDrink(
			"bleeding_jane",
			1000,
			0,
			1,
			new ItemStack(coupe_glass));
	public static final Item bloom_light = createDrink(
			"bloom_light",
			1000,
			0,
			1,
			new ItemStack(coupe_glass));
	public static final Item blue_fairy = createDrink(
			"blue_fairy",
			1000,
			0,
			1,
			new ItemStack(collins_glass));
	public static final Item brandtini = createDrink(
			"brandtini",
			1000,
			0,
			1,
			new ItemStack(coupe_glass));
	// C
	public static final Item cobalt_velvet = createDrink(
			"cobalt_velvet",
			1000,
			0,
			1,
			new ItemStack(tumbler_glass));
	public static final Item crevice_spike = createDrink(
			"crevice_spike",
			1000,
			0,
			1,
			new ItemStack(rocks_glass));
	// F
	public static final Item flaming_moai = createDrink(
			"flaming_moai",
			1000,
			0,
			1,
			new ItemStack(tiki_mug));
	public static final Item fluffy_dream = createDrink(
			"fluffy_dream",
			1000,
			0,
			1,
			new ItemStack(hurricane_glass));
	public static final Item fringe_weaver = createDrink(
			"fringe_weaver",
			1000,
			0,
			1,
			new ItemStack(coupe_glass));
	public static final Item frothy_water = createDrink(
			"frothy_water",
			1000,
			0,
			1,
			new ItemStack(mug));
	// G
	public static final Item grizzly_temple = createDrink(
			"grizzly_temple",
			1000,
			0,
			1,
			new ItemStack(coupe_glass));
	public static final Item gut_punch = createDrink(
			"gut_punch",
			1000,
			0,
			1,
			new ItemStack(rocks_glass));
	// M
	public static final Item marsblast = createDrink(
			"marsblast",
			1000,
			0,
			1,
			new ItemStack(collins_glass));
	public static final Item mercuryblast = createDrink(
			"mercuryblast",
			1000,
			0,
			1,
			new ItemStack(collins_glass));
	public static final Item moonblast = createDrink(
			"moonblast",
			1000,
			0,
			1,
			new ItemStack(collins_glass));
	// P
	public static final Item piano_man = createDrink(
			"piano_man",
			1000,
			0,
			1,
			new ItemStack(hurricane_glass));
	public static final Item piano_woman = createDrink(
			"piano_woman",
			1000,
			0,
			1,
			new ItemStack(hurricane_glass));
	public static final Item pile_driver = createDrink(
			"pile_driver",
			1000,
			0,
			1,
			new ItemStack(rocks_glass));
	// S
	public static final Item sparkle_star = createDrink(
			"sparkle_star",
			1000,
			0,
			1,
			new ItemStack(hurricane_glass));
	public static final Item sugar_rush = createDrink(
			"sugar_rush",
			1000,
			0,
			1,
			new ItemStack(collins_glass));
	public static final Item sun_cloud = createDrink(
			"sun_cloud",
			1000,
			0,
			1,
			new ItemStack(tumbler_glass));
	public static final Item suplex = createDrink(
			"suplex",
			1000,
			0,
			1,
			new ItemStack(rocks_glass));
	// Z
	public static final Item zen_star = createDrink(
			"zen_star",
			1000,
			0,
			1,
			new ItemStack(tumbler_glass));

	// Tooltips
	// no idea what I'm going :3
	//TooltipModifier.REGISTRY.registry(adelhyde, new ItemDescription.Modifier(adelhyde, TooltipHelper.Palette.STANDARD_CREATE);


	public static void registerItems() {}
}
