package io.github.cheesecurd.vallhalla.blocks;

import com.mojang.brigadier.LiteralMessage;
import io.github.cheesecurd.vallhalla.VallHalla;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;


public class PaymentRegisterBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public PaymentRegisterBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		// Thank you Mod Utils for these! (Blockbench Plugin)
		Direction dir = state.getValue(FACING);
		switch(dir) {
			case NORTH:
				return Stream.of(
						Block.box(2, 0, 1, 14, 0.25, 7),
						Block.box(2, 0, 8, 14, 0.5, 14),
						Block.box(2, 2.5, 9, 14, 9.5, 10.15)
				).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
			case SOUTH: // I am so sorry for these numbers
				return Stream.of(
						Block.box(2, 0, 9.028540000000001, 14, 0.25, 15.028540000000001),
						Block.box(2, 0, 2.028540000000001, 14, 0.5, 8.028540000000001),
						Block.box(2, 2.5, 5.878540000000003, 14, 9.5, 7.028540000000001)
				).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
			case EAST: // Once again
				return Stream.of(
						Block.box(9.06427, 0, 2.0642699999999996, 15.06427, 0.25, 14.06427),
						Block.box(2.0642699999999996, 0, 2.0642699999999996, 8.06427, 0.5, 14.06427),
						Block.box(5.914270000000001, 2.5, 2.0642699999999996, 7.06427, 9.5, 14.06427)
				).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
			case WEST: // Same here
				return Stream.of(
						Block.box(0.9357299999999986, 0, 2.0642699999999987, 6.935729999999999, 0.25, 14.06427),
						Block.box(7.9357299999999995, 0, 2.0642699999999987, 13.93573, 0.5, 14.06427),
						Block.box(8.93573, 2.5, 2.0642699999999987, 10.085729999999998, 9.5, 14.06427)
				).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
			default:
				return Shapes.block(); // Fall back, it should never do this
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
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
