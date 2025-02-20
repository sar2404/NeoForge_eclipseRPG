package com.seiram.eclipserpg.block.custom;

import com.mojang.serialization.MapCodec;
import com.seiram.eclipserpg.world.inventory.TestUIMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import static com.ibm.icu.impl.ValidIdentifiers.Datatype.t;
import static net.minecraft.world.level.block.state.BlockBehaviour.simpleCodec;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;

import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class Pilon extends Block {
    public static final MapCodec<Pilon> CODEC = simpleCodec(Pilon::new);
    private static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0);
    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public Pilon(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(CLICKED, false));
    }

    @Override
    public MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    // Helper method to check for Diamond Blocks in a radius
    private boolean hasDiamondBlockNearby(Level level, BlockPos pos, int radius) {
        // Check the area around the Pilon (in a cubic radius)
        for (BlockPos offsetPos : BlockPos.betweenClosed(pos.offset(-radius, -radius, -radius), pos.offset(radius, radius, radius))) {
            BlockState state = level.getBlockState(offsetPos);
            if (state.is(Blocks.DIAMOND_BLOCK)) {
                return true;  // Found a Diamond Block nearby
            }
        }
        return false;  // No Diamond Block found
    }

    @Override
    public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
        super.useWithoutItem(blockstate, world, pos, entity, hit);

        if (entity instanceof ServerPlayer player) {
            // Check if there's a Diamond Block in the surrounding area
            if (hasDiamondBlockNearby(world, pos, 5)) {  // 5 is the radius to check for Diamond Blocks
                // Open the menu if a Diamond Block is found nearby
                player.openMenu(new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Testing");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        return new TestUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
                    }
                }, pos);
            }


        }

        return InteractionResult.SUCCESS;
    }
}









