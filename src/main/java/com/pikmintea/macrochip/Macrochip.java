package com.pikmintea.macrochip;

import com.pikmintea.macrochip.block.ModBlocks;
import com.pikmintea.macrochip.fluid.ModFluidTypes;
import com.pikmintea.macrochip.fluid.ModFluids;
import com.pikmintea.macrochip.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Macrochip.MODID)
public class Macrochip {
    public static final String MODID = "macrochip";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Blocks BLOCKS = ModBlocks.BLOCKS;
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MACROCHIP_TAB = CREATIVE_MODE_TABS.register("macrochip", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.macrochip"))
            .icon(() -> new ItemStack(ModItems.SILICON_CRYSTAL_ROD.get()))
            .build());

    public Macrochip(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.register(modEventBus);
        ModFluidTypes.FLUID_TYPES.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == MACROCHIP_TAB.getKey()) {
            // Raw Materials
            event.accept(ModItems.SALT);
            event.accept(ModItems.SILICA_DUST);

            // Silicon Chain
            event.accept(ModItems.METALLURGICAL_SILICON);
            event.accept(ModItems.ULTRA_PURE_SILICON);
            event.accept(ModItems.TRICHLOROSILANE);
            event.accept(ModItems.SILICON_CRYSTAL_ROD);

            // Gases (item form)
            event.accept(ModItems.HYDROGEN_GAS);
            event.accept(ModItems.OXYGEN_GAS);
            event.accept(ModItems.CHLORINE_GAS);
            event.accept(ModItems.HYDROGEN_CHLORIDE_GAS);
            event.accept(ModItems.CARBON_MONOXIDE_GAS);

            // Wafers
            event.accept(ModItems.BASIC_SILICON_WAFER);
            event.accept(ModItems.MINECRAFT_GRADE_SILICON_WAFER);
            event.accept(ModItems.MILITARY_GRADE_SILICON_WAFER);

            // Machines (block items)
            event.accept(ModItems.MACHINE_CASING);
            event.accept(ModItems.CHEMICAL_REACTOR);
            event.accept(ModItems.ELECTRIC_ARC_FURNACE);
            event.accept(ModItems.DISTILLATION_TOWER);
            event.accept(ModItems.ELECTROLYSIS_CHAMBER);
            event.accept(ModItems.EVAPORATION_BASIN);
            event.accept(ModItems.CRYSTAL_GROWTH_FURNACE);
            event.accept(ModItems.PRECISION_SAW);
            event.accept(ModItems.EXTREME_PRECISION_LASER);
            event.accept(ModItems.INDUSTRIAL_PLASMA_SLICER);

            // Fluid Buckets
            event.accept(ModItems.HYDROGEN_GAS_BUCKET);
            event.accept(ModItems.OXYGEN_GAS_BUCKET);
            event.accept(ModItems.CHLORINE_GAS_BUCKET);
            event.accept(ModItems.HYDROGEN_CHLORIDE_GAS_BUCKET);
            event.accept(ModItems.CARBON_MONOXIDE_GAS_BUCKET);
            event.accept(ModItems.TRICHLOROSILANE_BUCKET);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
