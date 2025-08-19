package net.nausicaea.paraburdoo.fluid;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nausicaea.paraburdoo.Paraburdoo;

import java.util.function.Supplier;

public abstract class ModFluids {
    public static final FlowableFluid FLOWING_SLUDGE = register("flowing_sludge", SludgeFluid.Flowing::new);
    public static final FlowableFluid SLUDGE = register("sludge", SludgeFluid.Still::new);

    private static <T extends Fluid> T register(String name, Supplier<T> fluidFactory) {
        RegistryKey<Fluid> fluidKey = RegistryKey.of(RegistryKeys.FLUID, Identifier.of(Paraburdoo.MOD_ID, name));

        T fluid = fluidFactory.get();

        Registry.register(Registries.FLUID, fluidKey, fluid);

        return fluid;
    }

    public static void registerAll() {
        Paraburdoo.LOGGER.info("Registering fluids");
    }
}
