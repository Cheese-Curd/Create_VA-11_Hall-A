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

	public static void registerItems() {}
}
