package io.github.cheesecurd.vallhalla.blocks;

import io.github.cheesecurd.vallhalla.VallHalla;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
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

	// TODO: Finish this!
//	public static final PaymentRegisterBlock payment_register = createBlock("payment_register",
//			new PaymentRegisterBlock(new FabricBlockSettings(Material.METAL, MaterialColor.METAL)
//					.strength(5, 6)
//					.sound(SoundType.METAL));
//
//	BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL)
//		.requiresCorrectToolForDrops()
//					.strength(5.0F, 6.0F)
//					.sound(SoundType.METAL)));
}
