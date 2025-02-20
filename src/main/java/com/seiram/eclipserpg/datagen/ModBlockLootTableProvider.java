package com.seiram.eclipserpg.datagen;

import com.seiram.eclipserpg.block.ModBlocks;
import com.seiram.eclipserpg.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        dropSelf(ModBlocks.FURNACE.get());
        dropSelf(ModBlocks.LOOM_CRAFTER.get());
        dropSelf(ModBlocks.CRUSHER.get());
        dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        dropSelf(ModBlocks.CHAIR.get());
        dropSelf(ModBlocks.PILON.get());

        dropSelf(ModBlocks.TESTING.get());

        dropSelf(ModBlocks.PILON.get());

        dropSelf(ModBlocks.DINBAR_BLOCK.get());

        dropSelf(ModBlocks.ATLANTIUM_BLOCK.get());

        dropSelf(ModBlocks.RUBIDIUM_BLOCK.get());

        dropSelf(ModBlocks.ECLIPTON_BLOCK.get());
        // dropSelf(ModBlocks.MAGIC_BLOCK.get());

        add(ModBlocks.ATHLANTIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.ATHLANTIUM_ORE.get(), ModItems.RAW_ATHLANTIUM.get()));
        add(ModBlocks.RUBIDIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBIDIUM_ORE.get(), ModItems.RAW_RUBIDIUM.get()));
        add(ModBlocks.ECLIPTON_ORE.get(),
                block -> createOreDrop(ModBlocks.ECLIPTON_ORE.get(), ModItems.RAW_ECLIPTON.get()));
        add(ModBlocks.DINBAR_ORE.get(),
                block -> createOreDrop(ModBlocks.DINBAR_ORE.get(), ModItems.RAW_DINBAR.get()));


        add(ModBlocks.BISMUTH_ORE.get(),
                block -> createOreDrop(ModBlocks.BISMUTH_ORE.get(), ModItems.RAW_BISMUTH.get()));
        add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(), ModItems.RAW_BISMUTH.get(), 2, 5));

        dropSelf(ModBlocks.BISMUTH_STAIRS.get());
        add(ModBlocks.BISMUTH_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BISMUTH_SLAB.get()));

        dropSelf(ModBlocks.BISMUTH_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.BISMUTH_BUTTON.get());

        dropSelf(ModBlocks.BISMUTH_FENCE.get());
        dropSelf(ModBlocks.BISMUTH_FENCE_GATE.get());
        dropSelf(ModBlocks.BISMUTH_WALL.get());
        dropSelf(ModBlocks.BISMUTH_TRAPDOOR.get());

        add(ModBlocks.BISMUTH_DOOR.get(),
                block -> createDoorTable(ModBlocks.BISMUTH_DOOR.get()));

        dropSelf(ModBlocks.BISMUTH_LAMP.get());

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
