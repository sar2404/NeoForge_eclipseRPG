package com.seiram.eclipserpg.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class AthlantiumOre extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public AthlantiumOre(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CLICKED);
    }
    @Override
    public void attack(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        if (!pLevel.isClientSide()) {
            boolean currentState = pState.getValue(CLICKED);
            pLevel.setBlockAndUpdate(pPos, pState.setValue(CLICKED, !currentState));

            // Schedule the block to turn off after a few seconds (like Redstone Ore)
            if (!currentState) {
                ((ServerLevel) pLevel).scheduleTick(pPos, this, 80); // 40 ticks = 2 seconds
            }
        }
    }
    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(CLICKED)) {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(CLICKED, false));
        }
    }


}
