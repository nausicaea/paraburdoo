package net.nausicaea.paraburdoo.tag;

import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nausicaea.paraburdoo.Paraburdoo;

public abstract class ModTags {
    public static final TagKey<Fluid> SLUDGE = TagKey.of(RegistryKeys.FLUID, Identifier.of(Paraburdoo.MOD_ID, "sludge"));

    public static void registerAll() {
        Paraburdoo.LOGGER.info("Registering tags");
    }
}
