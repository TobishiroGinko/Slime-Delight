package org.hiedacamellia.slime_delight.registry;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.hiedacamellia.slime_delight.SlimeDelight;

public class ItemGroupRegistry {
    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(SlimeDelight.MODID, "main"));
    public static final ItemGroup CasualnessDelightTab = Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.SlimeDelight.main"))
            .icon(() -> new ItemStack(ItemRegistry.SliceGrassBlockCake.get()))
            .build());
    public static void register() {

    }
}
