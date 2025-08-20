package net.nausicaea.paraburdoo.block;

import com.mojang.serialization.MapCodec;
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
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.nausicaea.paraburdoo.Paraburdoo;
import net.nausicaea.paraburdoo.fluid.FluidFallbackBlock;
import net.nausicaea.paraburdoo.mixin.accessor.SettingsAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

public abstract class CauldronFallbackBlock extends LeveledCauldronBlock implements PolymerBlock {
    protected CauldronFallbackBlock(Settings settings, Biome.Precipitation precipitation, CauldronBehavior.CauldronBehaviorMap behaviorMap) {
        super(precipitation, behaviorMap, settings);
    }

    public static CauldronFallbackBlock create(Settings settings, Biome.Precipitation precipitation, CauldronBehavior.CauldronBehaviorMap behaviorMap, Block fallback) {
        if (PolymerBlockResourceUtils.getBlocksLeft(BlockModelType.FULL_BLOCK) > 0) {
            return new Textured(settings, precipitation, behaviorMap);
        } else {
            return new Fallback(settings, precipitation, behaviorMap, fallback);
        }
    }

    private static class Textured extends CauldronFallbackBlock implements PolymerTexturedBlock {
        private final BlockState blockState;

        public Textured(Settings settings, Biome.Precipitation precipitation, CauldronBehavior.CauldronBehaviorMap behaviorMap) {
            super(settings, precipitation, behaviorMap);

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

    private static class Fallback extends CauldronFallbackBlock implements BlockWithElementHolder {
        private final @NotNull Block fallback;

        public Fallback(Settings settings, Biome.Precipitation precipitation, CauldronBehavior.CauldronBehaviorMap behaviorMap, @Nullable Block fallback) {
            super(settings, precipitation, behaviorMap);
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

