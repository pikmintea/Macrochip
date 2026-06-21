package com.pikmintea.macrochip.item;

import com.pikmintea.macrochip.Macrochip;
import com.pikmintea.macrochip.block.ModBlocks;
import com.pikmintea.macrochip.fluid.ModFluids;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Macrochip.MODID);

    // =========================
    // RAW MATERIALS
    // =========================
    public static final DeferredItem<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SILICA_DUST = ITEMS.register("silica_dust",
            () -> new Item(new Item.Properties()));

    // =========================
    // GASES (Item Form)
    // =========================
    public static final DeferredItem<Item> HYDROGEN_GAS = ITEMS.register("hydrogen_gas",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OXYGEN_GAS = ITEMS.register("oxygen_gas",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHLORINE_GAS = ITEMS.register("chlorine_gas",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HYDROGEN_CHLORIDE_GAS = ITEMS.register("hydrogen_chloride_gas",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CARBON_MONOXIDE_GAS = ITEMS.register("carbon_monoxide_gas",
            () -> new Item(new Item.Properties()));

    // =========================
    // LIQUIDS (Item Form)
    // =========================
    public static final DeferredItem<Item> TRICHLOROSILANE = ITEMS.register("trichlorosilane",
            () -> new Item(new Item.Properties()));

    // =========================
    // SILICON PRODUCTION CHAIN
    // =========================
    public static final DeferredItem<Item> METALLURGICAL_SILICON = ITEMS.register("metallurgical_silicon",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ULTRA_PURE_SILICON = ITEMS.register("ultra_pure_silicon",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SILICON_CRYSTAL_ROD = ITEMS.register("silicon_crystal_rod",
            () -> new Item(new Item.Properties()));

    // =========================
    // WAFERS (END PROGRESSION)
    // =========================
    public static final DeferredItem<Item> BASIC_SILICON_WAFER = ITEMS.register("basic_silicon_wafer",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MINECRAFT_GRADE_SILICON_WAFER = ITEMS.register("minecraft_grade_silicon_wafer",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MILITARY_GRADE_SILICON_WAFER = ITEMS.register("military_grade_silicon_wafer",
            () -> new Item(new Item.Properties()));

    // =========================
    // MACHINE BLOCK ITEMS
    // =========================
    public static final DeferredItem<BlockItem> MACHINE_CASING = ITEMS.registerSimpleBlockItem(ModBlocks.MACHINE_CASING);
    public static final DeferredItem<BlockItem> CHEMICAL_REACTOR = ITEMS.registerSimpleBlockItem(ModBlocks.CHEMICAL_REACTOR);
    public static final DeferredItem<BlockItem> ELECTRIC_ARC_FURNACE = ITEMS.registerSimpleBlockItem(ModBlocks.ELECTRIC_ARC_FURNACE);
    public static final DeferredItem<BlockItem> DISTILLATION_TOWER = ITEMS.registerSimpleBlockItem(ModBlocks.DISTILLATION_TOWER);
    public static final DeferredItem<BlockItem> ELECTROLYSIS_CHAMBER = ITEMS.registerSimpleBlockItem(ModBlocks.ELECTROLYSIS_CHAMBER);
    public static final DeferredItem<BlockItem> EVAPORATION_BASIN = ITEMS.registerSimpleBlockItem(ModBlocks.EVAPORATION_BASIN);
    public static final DeferredItem<BlockItem> CRYSTAL_GROWTH_FURNACE = ITEMS.registerSimpleBlockItem(ModBlocks.CRYSTAL_GROWTH_FURNACE);
    public static final DeferredItem<BlockItem> PRECISION_SAW = ITEMS.registerSimpleBlockItem(ModBlocks.PRECISION_SAW);
    public static final DeferredItem<BlockItem> EXTREME_PRECISION_LASER = ITEMS.registerSimpleBlockItem(ModBlocks.EXTREME_PRECISION_LASER);
    public static final DeferredItem<BlockItem> INDUSTRIAL_PLASMA_SLICER = ITEMS.registerSimpleBlockItem(ModBlocks.INDUSTRIAL_PLASMA_SLICER);

    // =========================
    // FLUID BUCKETS
    // =========================
    public static final DeferredItem<Item> HYDROGEN_GAS_BUCKET = ITEMS.register("hydrogen_gas_bucket",
            () -> new BucketItem(ModFluids.HYDROGEN_GAS.get(), new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> OXYGEN_GAS_BUCKET = ITEMS.register("oxygen_gas_bucket",
            () -> new BucketItem(ModFluids.OXYGEN_GAS.get(), new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> CHLORINE_GAS_BUCKET = ITEMS.register("chlorine_gas_bucket",
            () -> new BucketItem(ModFluids.CHLORINE_GAS.get(), new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> HYDROGEN_CHLORIDE_GAS_BUCKET = ITEMS.register("hydrogen_chloride_gas_bucket",
            () -> new BucketItem(ModFluids.HYDROGEN_CHLORIDE_GAS.get(), new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> CARBON_MONOXIDE_GAS_BUCKET = ITEMS.register("carbon_monoxide_gas_bucket",
            () -> new BucketItem(ModFluids.CARBON_MONOXIDE_GAS.get(), new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> TRICHLOROSILANE_BUCKET = ITEMS.register("trichlorosilane_bucket",
            () -> new BucketItem(ModFluids.TRICHLOROSILANE_SOURCE.get(), new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
