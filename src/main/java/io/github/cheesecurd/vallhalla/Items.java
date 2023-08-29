package io.github.cheesecurd.vallhalla;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class Items
{
	public static Item createItem(String itemName, Item item)
	{
		return Registry.register(Registry.ITEM, new ResourceLocation("vallhalla", itemName), item);
	}

	public static void registerItems() {}
}
