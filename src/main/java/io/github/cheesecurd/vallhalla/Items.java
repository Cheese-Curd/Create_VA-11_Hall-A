package io.github.cheesecurd.vallhalla;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class Items
{
	public static Item createItem(String itemName, Item item)
	{
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

	// Drinks

	public static final Item bad_touch = createItem("bad_touch",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(1)));
	public static final Item cobalt_velvet = createItem("cobalt_velvet",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(1)));
	public static final Item fluffy_dream = createItem("fluffy_dream",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(1)));
	public static final Item fringe_weaver = createItem("fringe_weaver",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(1)));
	public static final Item piano_man = createItem("piano_man",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(1)));
	public static final Item piano_woman = createItem("piano_woman",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(1)));
	public static final Item piledriver = createItem("piledriver",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(1)));
	public static final Item sugar_rush = createItem("sugar_rush",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(1)));
	public static final Item sun_cloud = createItem("sun_cloud",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(20)));
	public static final Item zen_star = createItem("zen_star",
			new Item(new FabricItemSettings()
					.group(VallHalla.VALLHALLA_TAB)
					.maxCount(1)));

	public static void registerItems() {}
}
