package org.hiedacamellia.slime_delight.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.hiedacamellia.slime_delight.registry.BlockRegistry;
import org.hiedacamellia.slime_delight.registry.ItemRegistry;
import vectorwing.farmersdelight.common.block.FeastBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class NetherStewBlock extends FeastBlock {

    public static final int MAX_SERVING = 4;
    public static final IntProperty STEW_SERVING = IntProperty.of("servings", 0, 4);
    protected static final VoxelShape SHAPE;

    public NetherStewBlock(FabricBlockSettings settings) {
        super(settings, () -> ItemRegistry.BowlOfNetherStew.get(), true);
    }

    public IntProperty getServingsProperty() {
        return STEW_SERVING;
    }

    public int getMaxServings() {
        return 4;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, STEW_SERVING);
    }
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int servings = state.get(STEW_SERVING);
        if (level.isClient&&servings>1) {
            if(takeServing(level, pos, state, player, hand).isAccepted()){
                return ActionResult.SUCCESS;
            };
        }
        if(servings==1){
            takeServing(level, pos, state, player, hand);
            level.setBlockState(pos, BlockRegistry.LargeBowl.get().getDefaultState(), 3);
            level.updateListeners(pos, state, level.getBlockState(pos), 3);
            return ActionResult.SUCCESS;
        }
        return this.takeServing(level, pos, state, player, hand);
    }
    static {
        SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
    }
}
