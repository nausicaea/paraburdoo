package net.nausicaea.paraburdoo.fluid;

import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.virtualentity.api.BlockWithElementHolder;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.nausicaea.paraburdoo.Paraburdoo;
import net.nausicaea.paraburdoo.mixin.accessor.SettingsAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

public abstract class FluidFallbackBlock extends FluidBlock implements PolymerBlock {
    protected FluidFallbackBlock(Settings settings, FlowableFluid fluid) {
        super(fluid, settings);
    }

    public static FluidFallbackBlock create(Settings settings, FlowableFluid fluid, @Nullable Block fallback) {
        if (PolymerBlockResourceUtils.getBlocksLeft(BlockModelType.FULL_BLOCK) > 0) {
            return new Textured(settings, fluid);
        } else {
            return new Fallback(settings, fluid, fallback);
        }
    }

    private static class Textured extends FluidFallbackBlock implements PolymerTexturedBlock {
        private final BlockState blockState;

        public Textured(Settings settings, FlowableFluid fluid) {
            super(settings, fluid);

            var modelId = ((SettingsAccessor) settings).getRegistryKey().getValue().withPrefixedPath("block/");
            Paraburdoo.LOGGER.warn("requesting block model for {}", modelId);
            var model = PolymerBlockModel.of(modelId);
            this.blockState = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, model);
        }

        @Override
        public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
            return this.blockState;
        }
    }

    private static class Fallback extends FluidFallbackBlock implements BlockWithElementHolder {
        private final @NotNull Block fallback;

        public Fallback(Settings settings, FlowableFluid fluid, @Nullable Block fallback) {
            super(settings, fluid);
            if (fallback != null) {
                this.fallback = fallback;
            } else {
                this.fallback = Blocks.BARRIER;
            }
        }

        @Override
        public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
            return this.fallback.getDefaultState();
        }

        @Override
        public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
            BlockModel model = new BlockModel();
            ItemDisplayElement element = ItemDisplayElementUtil.createSimple(this.asItem());
            element.setScale(new Vector3f(2.0F));
            model.addElement(element);
            return model;
        }
    }
}
