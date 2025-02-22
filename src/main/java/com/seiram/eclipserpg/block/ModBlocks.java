package com.seiram.eclipserpg.block;

import com.seiram.eclipserpg.EclipseRPG;

import com.seiram.eclipserpg.block.custom.*;
import com.seiram.eclipserpg.block.custom.FurnaceBlock;
import com.seiram.eclipserpg.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(EclipseRPG.MOD_ID);

    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock("bismuth_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


//bloques del mod seiram
    public static final DeferredBlock<Block> TESTING = registerBlock("testing", TestingBlock::new);

    public static final DeferredBlock<Block> PILON = registerBlock("pilon",
            () -> new Pilon(BlockBehaviour.Properties.of().noOcclusion()));


    public static final DeferredBlock<Block> CHAIR = registerBlock("chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion()));


    public static final DeferredBlock<Block> FURNACE = registerBlock("furnace",
            FurnaceBlock::new);
    public static final DeferredBlock<Block> CRUSHER = registerBlock("crusher", CrusherBlock::new);



    public static final DeferredBlock<Block> DINBAR_BLOCK = registerBlock("dinbar_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f)));
    public static final DeferredBlock<Block> ATLANTIUM_BLOCK = registerBlock("athlantium_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f)));
    public static final DeferredBlock<Block> RUBIDIUM_BLOCK = registerBlock("rubidium_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f)));
    public static final DeferredBlock<Block> ECLIPTON_BLOCK = registerBlock("eclipton_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f)));

//ores

    public static final DeferredBlock<Block> DINBAR_ORE = registerBlock("dianbar_ore",
            () -> new DinbarOre(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(DinbarOre.CLICKED) ? 15 : 0)));
    public static final DeferredBlock<Block> ATHLANTIUM_ORE = registerBlock("athlantium_ore",
            () -> new AthlantiumOre(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(AthlantiumOre.CLICKED) ? 15 : 0)));
    public static final DeferredBlock<Block> ECLIPTON_ORE = registerBlock("eclipton_ore",
            () -> new EcliptonOre(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(EcliptonOre.CLICKED) ? 15 : 0)));
    public static final DeferredBlock<Block> RUBIDIUM_ORE = registerBlock("rubidium_ore",
            () -> new RubidiumOre(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(RubidiumOre.CLICKED) ? 15 : 0)));


    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE = registerBlock("bismuth_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).noLootTable()));


    public static final DeferredBlock<StairBlock> BISMUTH_STAIRS = registerBlock("bismuth_stairs",
            () -> new StairBlock(ModBlocks.BISMUTH_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> BISMUTH_SLAB = registerBlock("bismuth_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> BISMUTH_PRESSURE_PLATE = registerBlock("bismuth_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> BISMUTH_BUTTON = registerBlock("bismuth_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> BISMUTH_FENCE = registerBlock("bismuth_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> BISMUTH_FENCE_GATE = registerBlock("bismuth_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> BISMUTH_WALL = registerBlock("bismuth_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> BISMUTH_DOOR = registerBlock("bismuth_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> BISMUTH_TRAPDOOR = registerBlock("bismuth_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> BISMUTH_LAMP = registerBlock("bismuth_lamp",
            () -> new BismuthLampBlock(BlockBehaviour.Properties.of().strength(2f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(BismuthLampBlock.CLICKED) ? 15 : 0)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
