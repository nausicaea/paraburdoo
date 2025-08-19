package net.nausicaea.paraburdoo.fluid;

import eu.pb4.polymer.core.api.block.SimplePolymerBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;

public class PolymerFluidBlock extends SimplePolymerBlock {
    private final Fluid fluid;

    public PolymerFluidBlock(Fluid fluid, AbstractBlock.Settings settings) {
        super(settings, Blocks.WATER);
        this.fluid = fluid;
    }
}
