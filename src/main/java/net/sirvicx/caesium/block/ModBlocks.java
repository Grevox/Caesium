package net.sirvicx.caesium.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sirvicx.caesium.Caesium;
import net.sirvicx.caesium.item.ModItems;

import java.util.Properties;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Caesium.MOD_ID);

    public static final DeferredBlock<Block> PEBBER_BLOCK = BLOCKS.register(
            "pebber_block",
            registryName -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
                    .sound(SoundType.METAL)
                    .destroyTime(5 * 20)
                    .strength(5)
                    .requiresCorrectToolForDrops()

            )
    );


    public static void caller(){
        registerBlockItem("pebber_block", PEBBER_BLOCK);
    }



    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, (registryName -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName)))));

    }


    public static void register(IEventBus bob){
        BLOCKS.register(bob);
    }
}
