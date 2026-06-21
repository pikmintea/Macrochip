package com.pikmintea.macrochip.block;

import com.pikmintea.macrochip.Macrochip;
import com.pikmintea.macrochip.block.multiblock.MultiblockMachineBlock;
import com.pikmintea.macrochip.block.multiblock.MultiblockPattern;
import com.pikmintea.macrochip.fluid.ModFluids;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Macrochip.MODID);

    // =========================
    // MACHINE CASING
    // =========================
    public static final DeferredBlock<Block> MACHINE_CASING = BLOCKS.register("machine_casing",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(3.5f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

    // =========================
    // MACHINES (Multiblocks)
    // =========================
    public static final DeferredBlock<MultiblockMachineBlock> CHEMICAL_REACTOR = registerMachine(
            "chemical_reactor", () -> cubeShell(1, MACHINE_CASING.get()));

    public static final DeferredBlock<MultiblockMachineBlock> ELECTRIC_ARC_FURNACE = registerMachine(
            "electric_arc_furnace", () -> cubeShell(1, MACHINE_CASING.get()));

    public static final DeferredBlock<MultiblockMachineBlock> DISTILLATION_TOWER = registerMachine(
            "distillation_tower", () -> new MultiblockPattern()
                    .where(0, 1, 0, MACHINE_CASING.get())
                    .where(0, 2, 0, MACHINE_CASING.get())
                    .where(0, 3, 0, MACHINE_CASING.get()));

    public static final DeferredBlock<MultiblockMachineBlock> ELECTROLYSIS_CHAMBER = registerMachine(
            "electrolysis_chamber", () -> boxShell(1, 1, 1, MACHINE_CASING.get()));

    public static final DeferredBlock<MultiblockMachineBlock> EVAPORATION_BASIN = registerMachine(
            "evaporation_basin", () -> platform(1, MACHINE_CASING.get()));

    public static final DeferredBlock<MultiblockMachineBlock> CRYSTAL_GROWTH_FURNACE = registerMachine(
            "crystal_growth_furnace", () -> new MultiblockPattern()
                    .where(0, 1, 0, MACHINE_CASING.get())
                    .where(0, 2, 0, MACHINE_CASING.get())
                    .where(0, 3, 0, MACHINE_CASING.get())
                    .where(-1, 1, 0, MACHINE_CASING.get()).where(1, 1, 0, MACHINE_CASING.get())
                    .where(0, 1, -1, MACHINE_CASING.get()).where(0, 1, 1, MACHINE_CASING.get()));

    public static final DeferredBlock<MultiblockMachineBlock> PRECISION_SAW = registerMachine(
            "precision_saw", () -> boxShell(1, 0, 1, MACHINE_CASING.get()));

    public static final DeferredBlock<MultiblockMachineBlock> EXTREME_PRECISION_LASER = registerMachine(
            "extreme_precision_laser", () -> boxShell(1, 0, 1, MACHINE_CASING.get()));

    public static final DeferredBlock<MultiblockMachineBlock> INDUSTRIAL_PLASMA_SLICER = registerMachine(
            "industrial_plasma_slicer", () -> cubeShell(1, MACHINE_CASING.get()));

    // =========================
    // FLUID BLOCKS
    // =========================
    public static final DeferredBlock<LiquidBlock> TRICHLOROSILANE_BLOCK = BLOCKS.register("trichlorosilane_block",
            () -> new LiquidBlock(
                    ModFluids.TRICHLOROSILANE_SOURCE.get(),
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_CYAN)
                            .noLootTable()
                            .liquid()
                            .strength(100f)
                            .noCollission()
            ));

    // =========================
    // Pattern Helpers
    // =========================
    private static MultiblockPattern cubeShell(int radius, Block casing) {
        MultiblockPattern p = new MultiblockPattern();
        for (int x = -radius; x <= radius; x++)
            for (int y = -radius; y <= radius; y++)
                for (int z = -radius; z <= radius; z++)
                    if (x != 0 || y != 0 || z != 0)
                        if (Math.abs(x) == radius || Math.abs(y) == radius || Math.abs(z) == radius)
                            p.where(x, y, z, casing);
        return p;
    }

    private static MultiblockPattern boxShell(int rx, int ry, int rz, Block casing) {
        MultiblockPattern p = new MultiblockPattern();
        for (int x = -rx; x <= rx; x++)
            for (int y = -ry; y <= ry; y++)
                for (int z = -rz; z <= rz; z++)
                    if (x != 0 || y != 0 || z != 0)
                        if (Math.abs(x) == rx || Math.abs(y) == ry || Math.abs(z) == rz)
                            p.where(x, y, z, casing);
        return p;
    }

    private static MultiblockPattern platform(int radius, Block casing) {
        MultiblockPattern p = new MultiblockPattern();
        for (int x = -radius; x <= radius; x++)
            for (int z = -radius; z <= radius; z++)
                if (x != 0 || z != 0)
                    p.where(x, 0, z, casing);
        return p;
    }

    private static DeferredBlock<MultiblockMachineBlock> registerMachine(String name, Supplier<MultiblockPattern> patternSupplier) {
        return BLOCKS.register(name, () -> new MultiblockMachineBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.METAL)
                        .strength(3.5f)
                        .requiresCorrectToolForDrops()
                        .noOcclusion(),
                patternSupplier.get()));
    }
}
