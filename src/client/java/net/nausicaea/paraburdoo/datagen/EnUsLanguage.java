package net.nausicaea.paraburdoo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EnUsLanguage extends FabricLanguageProvider {
    public EnUsLanguage(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder builder) {
        builder.add("tag.fluid.paraburdoo.sludge", "Sludge");
        builder.add("fluid_type.paraburdoo.sludge", "Sludge");
        builder.add("item_group.paraburdoo", "Paraburdoo");
        builder.add("item.paraburdoo.purified_gravel", "Purified Gravel");
        builder.add("item.paraburdoo.sludge_bucket", "Sludge Bucket");
    }
}
