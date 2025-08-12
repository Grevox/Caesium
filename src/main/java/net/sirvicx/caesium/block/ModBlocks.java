package net.sirvicx.caesium.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sirvicx.caesium.Caesium;


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




    public static void register(IEventBus bob){
        BLOCKS.register(bob);
    }
}
