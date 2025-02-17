package com.seiram.eclipserpg.datagen;

import com.seiram.eclipserpg.EclipseRPG;

import com.seiram.eclipserpg.block.ModBlocks;
import com.seiram.eclipserpg.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EclipseRPG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)

                .add(ModBlocks.ATLANTIUM_BLOCK.get())
                .add(ModBlocks.ATHLANTIUM_ORE.get())
                .add(ModBlocks.RUBIDIUM_BLOCK.get())
                .add(ModBlocks.RUBIDIUM_ORE.get())
                .add(ModBlocks.ECLIPTON_BLOCK.get())
                .add(ModBlocks.ECLIPTON_ORE.get())
                .add(ModBlocks.DINBAR_BLOCK.get())
                .add(ModBlocks.DINBAR_ORE.get())

                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())

                .add(ModBlocks.BISMUTH_LAMP.get())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ATHLANTIUM_ORE.get())
                .add(ModBlocks.ECLIPTON_ORE.get())
                .add(ModBlocks.RUBIDIUM_ORE.get())
                .add(ModBlocks.DINBAR_ORE.get())

                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BISMUTH_LAMP.get());

        tag(BlockTags.FENCES).add(ModBlocks.BISMUTH_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BISMUTH_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BISMUTH_WALL.get());

        tag(ModTags.Blocks.NEEDS_BISMUTH_TOOL)
                .add(ModBlocks.BISMUTH_LAMP.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL);
    }
}
