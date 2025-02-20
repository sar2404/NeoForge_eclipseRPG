
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.seiram.eclipserpg.init;

import com.seiram.eclipserpg.EclipseRPG;
import com.seiram.eclipserpg.block.ModBlocks;
import com.seiram.eclipserpg.block.custom.entity.CrusherBlockEntity;
import com.seiram.eclipserpg.block.custom.entity.LoomCrafterBlockEntity;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import com.seiram.eclipserpg.block.custom.entity.FurnaceBlockEntity;


import static com.seiram.eclipserpg.init.FurnacetutorialModBlockEntities.CRUSHER;
import static com.seiram.eclipserpg.init.FurnacetutorialModBlockEntities.LOOM_CRAFTER;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class FurnacetutorialModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, EclipseRPG.MOD_ID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FURNACE = register("furnace", ModBlocks.FURNACE, FurnaceBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> LOOM_CRAFTER = register("loom_crafter", ModBlocks.LOOM_CRAFTER, LoomCrafterBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CRUSHER = register("crusher", ModBlocks.CRUSHER, CrusherBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FURNACE.get(), (blockEntity, side) -> ((FurnaceBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LOOM_CRAFTER.get(), (blockEntity, side) -> ((LoomCrafterBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CRUSHER.get(), (blockEntity, side) -> ((CrusherBlockEntity) blockEntity).getItemHandler());
	}
}
