package com.seiram.eclipserpg.item;

import com.seiram.eclipserpg.EclipseRPG;

import com.seiram.eclipserpg.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EclipseRPG.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.eclipserpg.bismuth_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);

                        output.accept(ModItems.DINBAR);
                        output.accept(ModItems.RAW_DINBAR);
                        output.accept(ModItems.ECLIPTON);
                        output.accept(ModItems.RAW_ECLIPTON);
                        output.accept(ModItems.RAW_RUBIDIUM);
                        output.accept(ModItems.RUBIDIUM);
                        output.accept(ModItems.ATHLANTIUM);
                        output.accept(ModItems.RAW_ATHLANTIUM);

                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.RADISH);

                        output.accept(ModItems.FROSTFIRE_ICE);
                        output.accept(ModItems.STARLIGHT_ASHES);

                        output.accept(ModItems.INFECTED_SPAWN_EGG);


                        output.accept(ModItems.BISMUTH_SWORD);
                        output.accept(ModItems.BISMUTH_PICKAXE);
                        output.accept(ModItems.BISMUTH_SHOVEL);
                        output.accept(ModItems.BISMUTH_AXE);
                        output.accept(ModItems.BISMUTH_HOE);
                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB = CREATIVE_MODE_TAB.register("bismuth_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(EclipseRPG.MOD_ID, "bismuth_items_tab"))
                    .title(Component.translatable("creativetab.eclipserpg.bismuth_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);

                        output.accept(ModBlocks.FURNACE);
                        output.accept(ModBlocks.CRUSHER);
                        output.accept(ModBlocks.LOOM_CRAFTER);
                        output.accept(ModBlocks.TESTING);
                        output.accept(ModBlocks.ATLANTIUM_BLOCK);
                        output.accept(ModBlocks.ATHLANTIUM_ORE);
                        output.accept(ModBlocks.ECLIPTON_ORE);
                        output.accept(ModBlocks.ECLIPTON_BLOCK);
                        output.accept(ModBlocks.RUBIDIUM_BLOCK);
                        output.accept(ModBlocks.RUBIDIUM_ORE);
                        output.accept(ModBlocks.DINBAR_BLOCK);
                        output.accept(ModBlocks.DINBAR_ORE);




                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);

                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModBlocks.BISMUTH_STAIRS);
                        output.accept(ModBlocks.BISMUTH_SLAB);

                        output.accept(ModBlocks.BISMUTH_PRESSURE_PLATE);
                        output.accept(ModBlocks.BISMUTH_BUTTON);

                        output.accept(ModBlocks.PILON);
                        output.accept(ModBlocks.CHAIR);
                        output.accept(ModBlocks.BISMUTH_FENCE);
                        output.accept(ModBlocks.BISMUTH_FENCE_GATE);
                        output.accept(ModBlocks.BISMUTH_WALL);

                        output.accept(ModBlocks.BISMUTH_DOOR);
                        output.accept(ModBlocks.BISMUTH_TRAPDOOR);

                        output.accept(ModBlocks.BISMUTH_LAMP);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
