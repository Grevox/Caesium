package net.sirvicx.caesium.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sirvicx.caesium.Caesium;
import net.sirvicx.caesium.block.ModBlocks;

import java.util.EnumMap;
import java.util.jar.Attributes;

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



    public static final DeferredItem<Item> EYE_DROPS = ITEMS.registerSimpleItem(
            "eye_drops",
            new Item.Properties().component(
                    DataComponents.CONSUMABLE,
                    Consumable.builder()
                            // Spend 2 seconds, or 40 ticks, to consume
                            .consumeSeconds(3f)
                            // Sets the animation to play while consuming
                            .animation(ItemUseAnimation.BLOCK)
                            // Play sound while consuming every tick
                            .sound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                            // Play sound once finished consuming
                            .soundAfterConsume(SoundEvents.ARMOR_EQUIP_CHAIN)
                            // Don't show particles while eating
                            // Can have multiple
                            .hasConsumeParticles(true)
                            .onConsume(
                                    // Teleports the entity randomly in a 50 block radius
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 7 * 20, 0))
                            )
                            .onConsume(
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 9 * 20, 1))
                            )
                            .build()
            )
    );
    public static final DeferredItem<Item> PEBBER_ESSENCE = ITEMS.registerSimpleItem(
            "pebber_essence",
            new Item.Properties().component(
                    DataComponents.CONSUMABLE,
                    Consumable.builder()
                            // Spend 2 seconds, or 40 ticks, to consume
                            .consumeSeconds(1f)
                            // Sets the animation to play while consuming
                            .animation(ItemUseAnimation.EAT)
                            // Play sound while consuming every tick
                            .sound(SoundEvents.AMBIENT_CAVE)
                            // Play sound once finished consuming
                            .soundAfterConsume(SoundEvents.SHIELD_BREAK)
                            // Don't show particles while eating
                            // Can have multiple
                            .hasConsumeParticles(true)
                            .onConsume(
                                    // Teleports the entity randomly in a 50 block radius
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 7 * 10, 0))
                            )
                            .onConsume(
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 9 * 10, 1))
                            )
                            .onConsume(
                                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SATURATION , 1 * 20, 0)
                                    ))
                            .build()
            )
    );




    public static final ToolMaterial PEBBER_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            350,
            9f,
            1f,
            999,
            Tags.Items.INGOTS_COPPER

    );
    public static final DeferredItem<Item> PEBBER_PICKAXE = ITEMS.registerItem(
            "pebber_pickaxe",
            props -> new Item(
                    props.pickaxe(
                            PEBBER_MATERIAL,
                            3,
                            -2.9f
                    )
            )
    );
    public static final DeferredItem<Item> PEBBER_SWORD = ITEMS.registerItem(
            "pebber_sword",
            props -> new Item(
                    props.sword(
                            PEBBER_MATERIAL,
                            7,
                            -2.5f
                    )
            )
    );
    public static final DeferredItem<Item> PEBBER_AXE = ITEMS.registerItem(
            "pebber_axe",
            props -> new Item(
                    props.axe(
                            PEBBER_MATERIAL,
                            8,
                            8
                    )
            )
    );
    public static final DeferredItem<Item> PEBBER_SHOVEL = ITEMS.registerItem(
            "pebber_shovel",
            props -> new Item(
                    props.shovel(
                            PEBBER_MATERIAL,
                            1,
                            0
                    )
            )
    );
    public static final DeferredItem<Item> PEBBER_HOE = ITEMS.registerItem(
            "pebber_hoe",
            props -> new Item(
                    props.hoe(
                            PEBBER_MATERIAL,
                            2,
                            1

                    )
            )
    );

    public static final ArmorMaterial PEBBER_ARMOR_MATERIAL = new ArmorMaterial(
            // The durability multiplier of the armor material.
            15,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 4);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 4);
            }),
            35,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            1,
            0.1f,
            // The tag that determines what items can repair this armor.
            Tags.Items.INGOTS_IRON,
            ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(Caesium.MOD_ID, "models/pebber"))
    );





    public static final DeferredItem<Item> PEBBER_HELMET = ITEMS.registerItem(
            "pebber_helmet",
            props -> new Item(
                    props.humanoidArmor(
                            // The material to use.
                            PEBBER_ARMOR_MATERIAL,
                            // The type of armor to create.
                            ArmorType.HELMET
                    )
            )
    );
    public static final DeferredItem<Item> PEBBER_CHESTPLATE = ITEMS.registerItem(
            "pebber_chestplate",
            props -> new Item(
                    props.humanoidArmor(
                            // The material to use.
                            PEBBER_ARMOR_MATERIAL,
                            // The type of armor to create.
                            ArmorType.CHESTPLATE
                    )
            )
    );
    public static final DeferredItem<Item> PEBBER_LEGGINGS = ITEMS.registerItem(
            "pebber_leggings",
            props -> new Item(
                    props.humanoidArmor(
                            // The material to use.
                            PEBBER_ARMOR_MATERIAL,
                            // The type of armor to create.
                            ArmorType.LEGGINGS
                    )
            )
    );
    public static final DeferredItem<Item> PEBBER_BOOTS = ITEMS.registerItem(
            "pebber_boots",
            props -> new Item(
                    props.humanoidArmor(
                            // The material to use.
                            PEBBER_ARMOR_MATERIAL,
                            // The type of armor to create.
                            ArmorType.BOOTS
                    )
            )
    );

    public static void register(IEventBus eventBus){
            ITEMS.register(eventBus);
        }



}
