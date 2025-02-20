package com.seiram.eclipserpg.item;

import com.seiram.eclipserpg.EclipseRPG;

import com.seiram.eclipserpg.entity.ModEntities;
import com.seiram.eclipserpg.item.custom.ChiselItem;
import com.seiram.eclipserpg.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EclipseRPG.MOD_ID);


    //real mod items;


    public static final DeferredItem<Item> ATHLANTIUM = ITEMS.register("athlantium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ATHLANTIUM = ITEMS.register("raw_athlantium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ATHLANTIUM_GEM = ITEMS.register("athlantium_gem",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ECLIPTON = ITEMS.register("eclipton",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ECLIPTON = ITEMS.register("raw_eclipton",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RUBIDIUM = ITEMS.register("rubidium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_RUBIDIUM = ITEMS.register("raw_rubidium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DINBAR = ITEMS.register("dinbar",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_DINBAR = ITEMS.register("raw_dinbar",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.eclipserpg.radish.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> BISMUTH_SWORD = ITEMS.register("bismuth_sword",
            () -> new SwordItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.BISMUTH, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> BISMUTH_PICKAXE = ITEMS.register("bismuth_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BISMUTH, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> BISMUTH_SHOVEL = ITEMS.register("bismuth_shovel",
            () -> new ShovelItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.BISMUTH, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> BISMUTH_AXE = ITEMS.register("bismuth_axe",
            () -> new AxeItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.BISMUTH, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> BISMUTH_HOE = ITEMS.register("bismuth_hoe",
            () -> new HoeItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.BISMUTH, 0F, -3.0f))));
public static final DeferredItem<Item> INFECTED_SPAWN_EGG = ITEMS.register("infected_spawn_egg",
        () -> new DeferredSpawnEggItem(ModEntities.INFECTED, 0x31afaf, 0xffac00,
                new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
