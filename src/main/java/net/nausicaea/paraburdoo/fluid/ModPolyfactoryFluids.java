package net.nausicaea.paraburdoo.fluid;

import eu.pb4.polyfactory.entity.FactoryEntities;
import eu.pb4.polyfactory.fluid.FluidBehaviours;
import eu.pb4.polyfactory.fluid.FluidType;
import eu.pb4.polyfactory.fluid.shooting.ShootProjectileEntity;
import eu.pb4.polyfactory.other.FactoryRegistries;
import eu.pb4.polyfactory.other.FactorySoundEvents;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;
import net.nausicaea.paraburdoo.Paraburdoo;

public abstract class ModPolyfactoryFluids {
    public static final FluidType<Unit> SLUDGE = register("sludge", FluidType.of().density(100).fluid(Fluids.WATER).color(3694022).particle(new ItemStackParticleEffect(ParticleTypes.ITEM, Items.BLUE_STAINED_GLASS_PANE.getDefaultStack())).shootingBehavior(ShootProjectileEntity.ofSplash(FactoryEntities.WATER_SPLASH, 10, 300L, FactorySoundEvents.FLUID_SHOOT_WATER)).build());

    private static <T> FluidType<T> register(String name, FluidType<T> item) {
        return Registry.register(FactoryRegistries.FLUID_TYPES, Identifier.of(Paraburdoo.MOD_ID, name), item);
    }

    public static void registerAll() {
        // FluidBehaviours.addBlockStateConversions(Blocks.WATER.getDefaultState(), Blocks.AIR.getDefaultState(), WATER.ofBucket());
        // FluidBehaviours.addBlockStateConversions((BlockState)Blocks.WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), (BlockState)Blocks.WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 2), WATER.ofBottle());
        // FluidBehaviours.addBlockStateConversions((BlockState)Blocks.WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 2), (BlockState)Blocks.WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 1), WATER.ofBottle());
        // FluidBehaviours.addBlockStateConversions((BlockState)Blocks.WATER_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 1), Blocks.CAULDRON.getDefaultState(), WATER.ofBottle());

        FluidBehaviours.addItemToFluidLink(Items.WATER_BUCKET, SLUDGE.defaultInstance());
    }
}
