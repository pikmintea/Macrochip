package com.pikmintea.macrochip.block.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class MultiblockPattern {
    private final List<Part> parts = new ArrayList<>();

    public MultiblockPattern where(int x, int y, int z, Block block) {
        parts.add(new Part(x, y, z, block));
        return this;
    }

    public boolean matches(Level level, BlockPos controllerPos) {
        for (Part part : parts) {
            BlockPos checkPos = controllerPos.offset(part.x, part.y, part.z);
            if (level.getBlockState(checkPos).getBlock() != part.block) {
                return false;
            }
        }
        return true;
    }

    public void place(Level level, BlockPos controllerPos) {
        for (Part part : parts) {
            BlockPos placePos = controllerPos.offset(part.x, part.y, part.z);
            if (level.isEmptyBlock(placePos)) {
                level.setBlock(placePos, part.block.defaultBlockState(), 3);
            }
        }
    }

    public void remove(Level level, BlockPos controllerPos) {
        for (Part part : parts) {
            BlockPos breakPos = controllerPos.offset(part.x, part.y, part.z);
            if (level.getBlockState(breakPos).getBlock() == part.block) {
                level.destroyBlock(breakPos, false);
            }
        }
    }

    private record Part(int x, int y, int z, Block block) {}
}
