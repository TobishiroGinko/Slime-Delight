package org.hiedacamellia.slime_delight.event;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.hiedacamellia.slime_delight.registry.BlockRegistry;
import org.hiedacamellia.slime_delight.registry.ItemRegistry;

public class LavaLargeBowlEvent {
    public static ActionResult onUseBlock(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        // 获取被点击的方块状态
        BlockState blockState = world.getBlockState(hitResult.getBlockPos());
        // 检查方块是否是我们想要监听的那种类型及其特定的状态
        if (blockState.isOf(BlockRegistry.LargeBowl.get())) {
            // 玩家蹲下检查
            if (player.isSneaking()) {
                world.removeBlock(hitResult.getBlockPos(), false);
                player.getInventory().offerOrDrop(new ItemStack(ItemRegistry.LargeBowl.get()));
                return ActionResult.SUCCESS; // 表示事件已被处理
            }
        }
        if (blockState.isOf(BlockRegistry.LavaLargeBowl.get())) {
            // 玩家蹲下检查
            if (player.isSneaking()) {
                world.removeBlock(hitResult.getBlockPos(), false);
                player.getInventory().offerOrDrop(new ItemStack(ItemRegistry.LavaLargeBowl.get()));
                return ActionResult.SUCCESS; // 表示事件已被处理
            }
        }
        return ActionResult.PASS; // 未处理，继续传递给其他监听器
    }
}
