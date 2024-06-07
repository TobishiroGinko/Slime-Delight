package org.hiedacamellia.slime_delight.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.hiedacamellia.slime_delight.registry.BlockRegistry;
import org.hiedacamellia.slime_delight.registry.EffectRegistry;

public class LavaLargeBowl extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE;
    public LavaLargeBowl(FabricBlockSettings settings) {
        super(settings);
        this.setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canPlaceAt(level, currentPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        return level.getBlockState(pos.down()).isSolid();
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(hand);

        if(heldItem.getItem() == Items.BUCKET){
            if (!player.isCreative()) {
                player.setStackInHand(hand,Items.LAVA_BUCKET.getDefaultStack());
            }
            world.setBlockState(pos, BlockRegistry.LargeBowl.get().getDefaultState(), 3);
            world.updateListeners(pos, state, world.getBlockState(pos), 3);
            return ActionResult.SUCCESS;
            }else{
            player.addStatusEffect(new StatusEffectInstance(EffectRegistry.Burnt.get(), 20 * 10, 1));
            world.setBlockState(pos, BlockRegistry.LargeBowl.get().getDefaultState(), 3);
            world.updateListeners(pos, state, world.getBlockState(pos), 3);
            return ActionResult.SUCCESS;
        }}
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    static {
        SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
    }
}
