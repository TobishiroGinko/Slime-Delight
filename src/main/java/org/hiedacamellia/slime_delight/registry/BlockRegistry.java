package org.hiedacamellia.slime_delight.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.hiedacamellia.slime_delight.SlimeDelight;
import org.hiedacamellia.slime_delight.block.*;

import java.util.function.Supplier;

public enum BlockRegistry {
    GrassBlockCake("grass_block_cake",
            ()->new GrassBlockCakeBlock(ItemRegistry.SliceGrassBlockCake.get())),
    LargeBowl("large_bowl",
            ()->new LargeBowl(FabricBlockSettings.copyOf(Blocks.CAKE).strength(0.5f,0.5f))),
    LavaLargeBowl("lava_large_bowl",
            ()->new LavaLargeBowl(FabricBlockSettings.copyOf(Blocks.CAKE).strength(0.5f,0.5f))),
    NetherStew("nether_stew",
            ()->new NetherStewBlock(FabricBlockSettings.copyOf(Blocks.CAKE).strength(0.5f,0.5f))),
    SlimePockyBox("slime_pocky_box",
            ()->new SlimePockyBoxBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL))),
    PorcelainPlate("porcelain_plate",
            ()->new PorcelainPlateBlock(FabricBlockSettings.create().strength(0.5f,0.0f))),
    ReversedPorcelainPlate("reversed_porcelain_plate",
            ()->new PorcelainPlateBlock(FabricBlockSettings.create().strength(0.5f,0.0f))),

    ;
    private final String pathName;
    private final Supplier<Block> blockSupplier;
    private Block block;
    private BlockRegistry(String pathName, Supplier blockSupplier){
        this.pathName=pathName;
        this.blockSupplier=blockSupplier;
    }
    public static void register() {
        for (BlockRegistry value : values()) {
            Registry.register(Registries.BLOCK, new Identifier(SlimeDelight.MODID, value.pathName), value.get());
        }
    }
    public Block get() {
        if (block == null) {
            block = blockSupplier.get();
        }

        return block;
    }

    public String getId() {
        return Registries.BLOCK.getId(get()).toString();
    }
}
