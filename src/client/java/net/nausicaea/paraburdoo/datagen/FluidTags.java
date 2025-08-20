package net.nausicaea.paraburdoo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.nausicaea.paraburdoo.Paraburdoo;
import net.nausicaea.paraburdoo.fluid.ModFluids;
import net.nausicaea.paraburdoo.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class FluidTags extends FabricTagProvider<Fluid> {
    public FluidTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.FLUID, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        Paraburdoo.LOGGER.debug("add data to fluid tag {}", net.minecraft.registry.tag.FluidTags.WATER);
        getOrCreateTagBuilder(net.minecraft.registry.tag.FluidTags.WATER)
                .add(ModFluids.FLOWING_SLUDGE)
                .add(ModFluids.SLUDGE)
                .setReplace(false);

        Paraburdoo.LOGGER.debug("add data to fluid tag {}", ModTags.SLUDGE);
        getOrCreateTagBuilder(ModTags.SLUDGE)
                .add(ModFluids.FLOWING_SLUDGE)
                .add(ModFluids.SLUDGE)
                .setReplace(false);
    }
}
