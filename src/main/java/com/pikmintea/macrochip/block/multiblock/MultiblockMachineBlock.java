package com.pikmintea.macrochip.block.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MultiblockMachineBlock extends Block {
    private final MultiblockPattern pattern;

    public MultiblockMachineBlock(BlockBehaviour.Properties properties, MultiblockPattern pattern) {
        super(properties);
        this.pattern = pattern;
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!level.isClientSide && pattern != null) {
            pattern.place(level, pos);
        }
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!level.isClientSide && pattern != null && !state.is(newState.getBlock())) {
            pattern.remove(level, pos);
        }
    }
}
