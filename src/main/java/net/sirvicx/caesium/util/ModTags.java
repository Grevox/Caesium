package net.sirvicx.caesium.util;

import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sirvicx.caesium.Caesium;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PEBBER_TOOL = createTag("needs_pebeber_tool");
        public static final TagKey<Block> INCORRECT_FOR_PEBBER_TOOL = createTag("incorrect_for_pebeber_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Caesium.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Caesium.MOD_ID, name));
        }
    }
}
