package io.github.cheesecurd.vallhalla.Item;

import com.simibubi.create.content.CreateItemGroup;

import io.github.cheesecurd.vallhalla.VallHalla;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;


public class ModItems
{
//	public static final Item adelhyde = registerItem("adelhyde",
//			new Item(new FabricItemSettings()
//					.maxCount(20)
//					.group(CreateItemGroup.TAB_BREWING)));


//	private static Item registerItem(String name, Item item)
//	{
//		return Registry.register(Registry.ITEM, new Identifier(VallHalla.ID, name), item);
//	}

	public static void registerModItems()
	{
		VallHalla.logVMessage("Eliana", "Registering mod items...");
	}
}
