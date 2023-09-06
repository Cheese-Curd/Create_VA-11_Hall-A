package io.github.cheesecurd.vallhalla.blocks;

import io.github.cheesecurd.vallhalla.VallHalla;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class ModBlocks
{
	public static PaymentRegisterBlock createBlock(String blockName, PaymentRegisterBlock block)
	{
		Registry.register(Registry.ITEM, new ResourceLocation("vallhalla", blockName), new BlockItem(block, new FabricItemSettings()
				.group(VallHalla.VALLHALLA_TAB)));
		return Registry.register(Registry.BLOCK, new ResourceLocation("vallhalla", blockName), block);
	}

	public static final PaymentRegisterBlock payment_register = createBlock("payment_register",
			new PaymentRegisterBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
					.requiresCorrectToolForDrops()
					.strength(5, 6)
					.sound(SoundType.METAL)));

	public static void registerBlocks() {}
}
