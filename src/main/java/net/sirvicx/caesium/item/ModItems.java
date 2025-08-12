package net.sirvicx.caesium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sirvicx.caesium.Caesium;
import net.sirvicx.caesium.block.ModBlocks;

public class ModItems {
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Caesium.MOD_ID);

        public static final DeferredItem<Item> RAW_PEBBER = ITEMS.registerItem(
                "raw_pebber",
                Item::new,
        new Item.Properties().stacksTo(32)
        );
        public static final DeferredItem<Item> PEBBER = ITEMS.registerItem(
                "pebber",
                Item::new,
                new Item.Properties().stacksTo(64)
        );
         public static final DeferredItem<BlockItem> PEBBER_BLOCK = ITEMS.register(
                 "pebber_block",
                 (registryName -> new BlockItem(ModBlocks.PEBBER_BLOCK.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName)))));

    public static final DeferredItem<BlockItem> RAW_PEBBER_BLOCK = ITEMS.register(
            "raw_pebber_block",
            (registryName -> new BlockItem(ModBlocks.RAW_PEBBER_BLOCK.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName)))));

    public static void register(IEventBus eventBus){
            ITEMS.register(eventBus);
        }



}
