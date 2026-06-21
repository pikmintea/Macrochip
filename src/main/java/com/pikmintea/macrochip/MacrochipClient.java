package com.pikmintea.macrochip;

import com.pikmintea.macrochip.fluid.ModFluidTypes;
import com.pikmintea.macrochip.fluid.ModFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(modid = Macrochip.MODID, value = Dist.CLIENT)
public class MacrochipClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.HYDROGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.OXYGEN_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.CHLORINE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.HYDROGEN_CHLORIDE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.CARBON_MONOXIDE_GAS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.TRICHLOROSILANE_SOURCE.get(), RenderType.translucent());
        });
    }

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/hydrogen_gas_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/hydrogen_gas_flow");
            }

            @Override
            public int getTintColor() {
                return 0x50C8E8FF;
            }
        }, ModFluidTypes.HYDROGEN_GAS.get());

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/oxygen_gas_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/oxygen_gas_flow");
            }

            @Override
            public int getTintColor() {
                return 0x50B8D8FF;
            }
        }, ModFluidTypes.OXYGEN_GAS.get());

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/chlorine_gas_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/chlorine_gas_flow");
            }

            @Override
            public int getTintColor() {
                return 0x50D0FFA0;
            }
        }, ModFluidTypes.CHLORINE_GAS.get());

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/hydrogen_chloride_gas_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/hydrogen_chloride_gas_flow");
            }

            @Override
            public int getTintColor() {
                return 0x50F0FFA0;
            }
        }, ModFluidTypes.HYDROGEN_CHLORIDE_GAS.get());

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/carbon_monoxide_gas_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/carbon_monoxide_gas_flow");
            }

            @Override
            public int getTintColor() {
                return 0x50D0D0D0;
            }
        }, ModFluidTypes.CARBON_MONOXIDE_GAS.get());

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/trichlorosilane_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(Macrochip.MODID, "block/trichlorosilane_flow");
            }

            @Override
            public int getTintColor() {
                return 0xFFA0E8E8;
            }
        }, ModFluidTypes.TRICHLOROSILANE.get());
    }
}
