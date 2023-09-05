package io.github.cheesecurd.vallhalla.blocks;

import io.github.cheesecurd.vallhalla.VallHalla;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PaymentRegisterBlock extends Block
{
	public PaymentRegisterBlock(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack held = player.getItemInHand(hand);

		if (!world.isClientSide) { // Drink sound
			world.playSound(
					null, // Player - if non-null, will play sound for every nearby player *except* the specified player
					pos, // The position of where the sound will come from
					VallHalla.MONEY_SOUND_EVENT, // The sound that will play
					SoundSource.PLAYERS, // This determines which of the volume sliders affect this sound
					1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
					1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
			);
		}

		return super.use(state, world, pos, player, hand, hit);
	}
}


