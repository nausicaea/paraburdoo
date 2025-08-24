package net.nausicaea.paraburdoo.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.nausicaea.paraburdoo.Paraburdoo;
import net.nausicaea.paraburdoo.block.ModBlocks;
import net.nausicaea.paraburdoo.item.ModItems;

public class Models extends FabricModelProvider {
    public Models(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        Paraburdoo.LOGGER.debug("add block state model for {}", ModBlocks.PURIFIED_GRAVEL);
        generator.registerSimpleCubeAll(ModBlocks.PURIFIED_GRAVEL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        Paraburdoo.LOGGER.debug("add item model for {}", ModItems.PURIFIED_GRAVEL);
        generator.register(ModItems.PURIFIED_GRAVEL, net.minecraft.client.data.Models.GENERATED);
    }
}
