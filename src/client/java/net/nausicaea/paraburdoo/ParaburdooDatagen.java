package net.nausicaea.paraburdoo;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.nausicaea.paraburdoo.datagen.*;

public class ParaburdooDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(Models::new);
        pack.addProvider(EnUsLanguage::new);
        pack.addProvider(Recipes::new);
        pack.addProvider(BlockLootTables::new);
        pack.addProvider(FluidTags::new);
    }

}
