package net.sirvicx.caesium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sirvicx.caesium.Caesium;

import java.awt.*;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Caesium.MOD_ID);

    public static final Supplier<CreativeModeTab> CAESIUM_ITEMS_TAB = CREATIVE_MODE_TAB.register("caesium_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RAW_PEBBER.get()))
                    .title(Component.translatable("creativetab.caesium.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_PEBBER);
                        output.accept(ModItems.PEBBER);
                        output.accept(ModItems.PEBBER_BLOCK);
                        output.accept(ModItems.RAW_PEBBER_BLOCK);
                        output.accept(ModItems.PEBBER_PICKAXE);
                        output.accept(ModItems.PEBBER_SWORD);
                        output.accept(ModItems.PEBBER_HELMET);
                        output.accept(ModItems.PEBBER_CHESTPLATE);
                        output.accept(ModItems.PEBBER_LEGGINGS);
                        output.accept(ModItems.PEBBER_BOOTS);
                        output.accept(ModItems.EYE_DROPS);
                        output.accept(ModItems.PEBBER_SHOVEL);
                        output.accept(ModItems.PEBBER_HOE);
                        output.accept(ModItems.PEBBER_AXE);
                        output.accept(ModItems.PEBBER_ESSENCE);
                    })
                    .build() );

    public static void register(IEventBus bus){
        CREATIVE_MODE_TAB.register(bus);
    }




}
