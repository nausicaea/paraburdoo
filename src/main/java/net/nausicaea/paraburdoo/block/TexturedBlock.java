package net.nausicaea.paraburdoo.block;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.nausicaea.paraburdoo.mixin.accessor.SettingsAccessor;
import xyz.nucleoid.packettweaker.PacketContext;

public class TexturedBlock extends Block implements PolymerTexturedBlock {
    private final BlockState blockState;

    public TexturedBlock(Settings settings) {
        super(settings);
        var model = PolymerBlockModel.of(((SettingsAccessor) settings).getRegistryKey().getValue().withPrefixedPath("block/"));
        this.blockState = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, model);
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        return this.blockState;
    }
}
