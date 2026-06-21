package com.pikmintea.macrochip.fluid;

import com.pikmintea.macrochip.Macrochip;
import com.pikmintea.macrochip.block.ModBlocks;
import com.pikmintea.macrochip.item.ModItems;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, Macrochip.MODID);

    // Hydrogen Gas
    public static final DeferredHolder<Fluid, Fluid> HYDROGEN_GAS = FLUIDS.register("hydrogen_gas",
            () -> new BaseFlowingFluid.Source(hydrogenProperties()));
    public static final DeferredHolder<Fluid, Fluid> FLOWING_HYDROGEN_GAS = FLUIDS.register("flowing_hydrogen_gas",
            () -> new BaseFlowingFluid.Flowing(hydrogenProperties()));

    // Oxygen Gas
    public static final DeferredHolder<Fluid, Fluid> OXYGEN_GAS = FLUIDS.register("oxygen_gas",
            () -> new BaseFlowingFluid.Source(oxygenProperties()));
    public static final DeferredHolder<Fluid, Fluid> FLOWING_OXYGEN_GAS = FLUIDS.register("flowing_oxygen_gas",
            () -> new BaseFlowingFluid.Flowing(oxygenProperties()));

    // Chlorine Gas
    public static final DeferredHolder<Fluid, Fluid> CHLORINE_GAS = FLUIDS.register("chlorine_gas",
            () -> new BaseFlowingFluid.Source(chlorineProperties()));
    public static final DeferredHolder<Fluid, Fluid> FLOWING_CHLORINE_GAS = FLUIDS.register("flowing_chlorine_gas",
            () -> new BaseFlowingFluid.Flowing(chlorineProperties()));

    // Hydrogen Chloride Gas
    public static final DeferredHolder<Fluid, Fluid> HYDROGEN_CHLORIDE_GAS = FLUIDS.register("hydrogen_chloride_gas",
            () -> new BaseFlowingFluid.Source(hydrogenChlorideProperties()));
    public static final DeferredHolder<Fluid, Fluid> FLOWING_HYDROGEN_CHLORIDE_GAS = FLUIDS.register("flowing_hydrogen_chloride_gas",
            () -> new BaseFlowingFluid.Flowing(hydrogenChlorideProperties()));

    // Carbon Monoxide Gas
    public static final DeferredHolder<Fluid, Fluid> CARBON_MONOXIDE_GAS = FLUIDS.register("carbon_monoxide_gas",
            () -> new BaseFlowingFluid.Source(carbonMonoxideProperties()));
    public static final DeferredHolder<Fluid, Fluid> FLOWING_CARBON_MONOXIDE_GAS = FLUIDS.register("flowing_carbon_monoxide_gas",
            () -> new BaseFlowingFluid.Flowing(carbonMonoxideProperties()));

    // Trichlorosilane (Liquid)
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> TRICHLOROSILANE_SOURCE = FLUIDS.register("trichlorosilane",
            () -> new BaseFlowingFluid.Source(trichlorosilaneProperties()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> TRICHLOROSILANE_FLOWING = FLUIDS.register("flowing_trichlorosilane",
            () -> new BaseFlowingFluid.Flowing(trichlorosilaneProperties()));

    // Property helpers - use Supplier<?> to avoid forward reference issues
    private static BaseFlowingFluid.Properties hydrogenProperties() {
        return new BaseFlowingFluid.Properties(ModFluidTypes.HYDROGEN_GAS, HYDROGEN_GAS, FLOWING_HYDROGEN_GAS)
                .bucket(ModItems.HYDROGEN_GAS_BUCKET)
                .tickRate(10)
                .levelDecreasePerBlock(2);
    }

    private static BaseFlowingFluid.Properties oxygenProperties() {
        return new BaseFlowingFluid.Properties(ModFluidTypes.OXYGEN_GAS, OXYGEN_GAS, FLOWING_OXYGEN_GAS)
                .bucket(ModItems.OXYGEN_GAS_BUCKET)
                .tickRate(10)
                .levelDecreasePerBlock(2);
    }

    private static BaseFlowingFluid.Properties chlorineProperties() {
        return new BaseFlowingFluid.Properties(ModFluidTypes.CHLORINE_GAS, CHLORINE_GAS, FLOWING_CHLORINE_GAS)
                .bucket(ModItems.CHLORINE_GAS_BUCKET)
                .tickRate(10)
                .levelDecreasePerBlock(2);
    }

    private static BaseFlowingFluid.Properties hydrogenChlorideProperties() {
        return new BaseFlowingFluid.Properties(ModFluidTypes.HYDROGEN_CHLORIDE_GAS, HYDROGEN_CHLORIDE_GAS, FLOWING_HYDROGEN_CHLORIDE_GAS)
                .bucket(ModItems.HYDROGEN_CHLORIDE_GAS_BUCKET)
                .tickRate(10)
                .levelDecreasePerBlock(2);
    }

    private static BaseFlowingFluid.Properties carbonMonoxideProperties() {
        return new BaseFlowingFluid.Properties(ModFluidTypes.CARBON_MONOXIDE_GAS, CARBON_MONOXIDE_GAS, FLOWING_CARBON_MONOXIDE_GAS)
                .bucket(ModItems.CARBON_MONOXIDE_GAS_BUCKET)
                .tickRate(10)
                .levelDecreasePerBlock(2);
    }

    private static BaseFlowingFluid.Properties trichlorosilaneProperties() {
        return new BaseFlowingFluid.Properties(ModFluidTypes.TRICHLOROSILANE, TRICHLOROSILANE_SOURCE, TRICHLOROSILANE_FLOWING)
                .bucket(ModItems.TRICHLOROSILANE_BUCKET)
                .block(ModBlocks.TRICHLOROSILANE_BLOCK)
                .tickRate(5)
                .levelDecreasePerBlock(1)
                .explosionResistance(100f);
    }
}
