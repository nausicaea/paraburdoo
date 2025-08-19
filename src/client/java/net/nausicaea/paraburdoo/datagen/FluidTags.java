package net.nausicaea.paraburdoo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.nausicaea.paraburdoo.fluid.ModFluids;
import net.nausicaea.paraburdoo.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class FluidTags extends FabricTagProvider<Fluid> {
    public FluidTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.FLUID, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(net.minecraft.registry.tag.FluidTags.WATER)
                .add(ModFluids.FLOWING_SLUDGE)
                .add(ModFluids.SLUDGE)
                .setReplace(false);
        getOrCreateTagBuilder(ModTags.SLUDGE)
                .add(ModFluids.FLOWING_SLUDGE)
                .add(ModFluids.SLUDGE)
                .setReplace(false);
    }
}
