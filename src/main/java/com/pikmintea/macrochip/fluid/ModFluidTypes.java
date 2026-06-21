package com.pikmintea.macrochip.fluid;

import com.pikmintea.macrochip.Macrochip;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, Macrochip.MODID);

    // Gases
    public static final DeferredHolder<FluidType, FluidType> HYDROGEN_GAS = registerGas("hydrogen_gas", 0x50C8E8FF);
    public static final DeferredHolder<FluidType, FluidType> OXYGEN_GAS = registerGas("oxygen_gas", 0x50B8D8FF);
    public static final DeferredHolder<FluidType, FluidType> CHLORINE_GAS = registerGas("chlorine_gas", 0x50D0FFA0);
    public static final DeferredHolder<FluidType, FluidType> HYDROGEN_CHLORIDE_GAS = registerGas("hydrogen_chloride_gas", 0x50F0FFA0);
    public static final DeferredHolder<FluidType, FluidType> CARBON_MONOXIDE_GAS = registerGas("carbon_monoxide_gas", 0x50D0D0D0);

    // Liquid
    public static final DeferredHolder<FluidType, FluidType> TRICHLOROSILANE = registerLiquid("trichlorosilane", 0xFFA0E8E8);

    private static DeferredHolder<FluidType, FluidType> registerGas(String name, int tint) {
        return FLUID_TYPES.register(name, () -> new FluidType(FluidType.Properties.create()
                .descriptionId("item.macrochip." + name)
                .density(-100)
                .viscosity(200)
                .temperature(300)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
        ));
    }

    private static DeferredHolder<FluidType, FluidType> registerLiquid(String name, int tint) {
        return FLUID_TYPES.register(name, () -> new FluidType(FluidType.Properties.create()
                .descriptionId("item.macrochip." + name)
                .density(1200)
                .viscosity(1500)
                .temperature(300)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BOTTLE_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BOTTLE_EMPTY)
        ));
    }
}
