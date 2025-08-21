package net.nausicaea.paraburdoo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.nausicaea.paraburdoo.Paraburdoo;
import net.nausicaea.paraburdoo.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class BlockLootTables extends FabricBlockLootTableProvider {
    public BlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        Paraburdoo.LOGGER.debug("add loot table for {}", ModBlocks.PURIFIED_GRAVEL);
        addDrop(ModBlocks.PURIFIED_GRAVEL);
        addDrop(ModBlocks.SLUDGE_CAULDRON, Items.CAULDRON);
    }
}
