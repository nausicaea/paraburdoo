package net.nausicaea.paraburdoo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.nausicaea.paraburdoo.Paraburdoo;

import java.util.concurrent.CompletableFuture;

public class EnUsLanguage extends FabricLanguageProvider {
    public EnUsLanguage(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder builder) {
        Paraburdoo.LOGGER.debug("add en_us translations");
        builder.add("item_group.paraburdoo", "Paraburdoo");
        builder.add("block.paraburdoo.purified_gravel", "Purified Gravel");
        builder.add("item.paraburdoo.purified_gravel", "Purified Gravel");
    }
}
