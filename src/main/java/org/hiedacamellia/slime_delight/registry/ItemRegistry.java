package org.hiedacamellia.slime_delight.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.hiedacamellia.slime_delight.SlimeDelight;
import org.hiedacamellia.slime_delight.item.FoodList;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.Arrays;
import java.util.function.Supplier;

public enum ItemRegistry {
    SliceGrassBlockCake("slice_grass_block_cake",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.GrassBlockCakeSlice))),
    GrassBlockCake("grass_block_cake",
            ()->new BlockItem(BlockRegistry.GrassBlockCake.get(), new FabricItemSettings().maxCount(1))),
    LargeBowl("large_bowl",
            ()->new BlockItem(BlockRegistry.LargeBowl.get(), new FabricItemSettings().maxCount(1))),
    NetherBrickBowl("nether_brick_bowl",
            ()->new ConsumableItem(new FabricItemSettings().maxCount(16))),
    LavaLargeBowl("lava_large_bowl",
            ()->new BlockItem(BlockRegistry.LavaLargeBowl.get(), new FabricItemSettings().maxCount(1))),
    BowlOfNetherStew("bowl_of_nether_stew",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.BowlOfNetherStew).recipeRemainder(ItemRegistry.NetherBrickBowl.get()).maxCount(1))),
    GoldenSlimeBall("golden_slime_ball",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.GoldenSlimeBall))),
    NetherStew("nether_stew",
            ()->new BlockItem(BlockRegistry.NetherStew.get(), new FabricItemSettings().maxCount(1))),
    BurntFish("burnt_fish",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.BurntFish))),
    BurntPotato("burnt_potato",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.BurntPotato))),
    SlimePockyBox("slime_pocky_box",
            ()->new BlockItem(BlockRegistry.SlimePockyBox.get(), new FabricItemSettings())),
    SlimePocky("slime_pocky",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.SlimePocky))),
    SlimeRice("slime_rice",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.SlimeRice).recipeRemainder(Items.BOWL))),
    MagmaCreamRice("magma_cream_rice",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.MagmaCreamRice).recipeRemainder(Items.BOWL))),
    BowlOfGoo("bowl_of_goo",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.BowlOfGoo).recipeRemainder(Items.BOWL))),
    PorcelainPlate("porcelain_plate",
            ()->new BlockItem(BlockRegistry.PorcelainPlate.get(), new FabricItemSettings())),
    ReversedPorcelainPlate("reversed_porcelain_plate",
            ()->new BlockItem(BlockRegistry.ReversedPorcelainPlate.get(), new FabricItemSettings())),
    SlimePudding("slime_pudding",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.SlimePudding).recipeRemainder(ItemRegistry.PorcelainPlate.get()))),
    MagmaCreamPudding("magma_cream_pudding",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.MagmaCreamPudding).recipeRemainder(ItemRegistry.PorcelainPlate.get()))),
    GelatinCandy("gelatin_candy",
            ()->new ConsumableItem(new FabricItemSettings().food(FoodList.GelatinCandy))),
    ;
    private final String pathName;
    private final Supplier<Item> itemSupplier;
    private final Integer burnTime;
    private Item item;

    private ItemRegistry(String pathName, Supplier itemSupplier) {
        this(pathName, itemSupplier, (Integer)null);
    }

    private ItemRegistry(String pathName, Supplier itemSupplier, Integer burnTime) {
        this.pathName = pathName;
        this.itemSupplier = itemSupplier;
        this.burnTime = burnTime;
    }

    public static void register() {
        for (ItemRegistry value : values()) {
            Registry.register(Registries.ITEM, new Identifier(SlimeDelight.MODID, value.pathName), value.get());
            if (value.burnTime != null && value.burnTime > 0) {
                FuelRegistry.INSTANCE.add(value.get(), value.burnTime);
            }
        }
        ItemGroupEvents.modifyEntriesEvent(ItemGroupRegistry.ITEM_GROUP).register(entries -> entries.addAll(
                Arrays.stream(values()).map(item -> item.get().getDefaultStack()).toList()));
    }

    public Item get() {
        if (this.item == null) {
            this.item = (Item)this.itemSupplier.get();
        }

        return this.item;
    }

    public String getId() {
        return Registries.ITEM.getId(this.get()).toString();
    }
}
