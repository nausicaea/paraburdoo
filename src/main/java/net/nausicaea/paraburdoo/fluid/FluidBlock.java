package net.nausicaea.paraburdoo.fluid;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.nausicaea.paraburdoo.block.TexturedBlock;
import net.nausicaea.paraburdoo.mixin.accessor.SettingsAccessor;
import xyz.nucleoid.packettweaker.PacketContext;

public class FluidBlock extends TexturedBlock implements PolymerTexturedBlock {
    private final Fluid fluid;

    public FluidBlock(Fluid fluid, AbstractBlock.Settings settings) {
        super(settings);
        this.fluid = fluid;
    }
}
