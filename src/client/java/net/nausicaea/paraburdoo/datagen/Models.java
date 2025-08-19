package net.nausicaea.paraburdoo.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.nausicaea.paraburdoo.block.ModBlocks;
import net.nausicaea.paraburdoo.item.ModItems;

public class Models extends FabricModelProvider {
    public Models(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerSimpleCubeAll(ModBlocks.PURIFIED_GRAVEL);
        generator.registerBuiltinWithParticle(ModBlocks.SLUDGE, SimpleFluidRenderHandler.WATER_STILL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(ModItems.SLUDGE_BUCKET, net.minecraft.client.data.Models.GENERATED);
    }
}
