package net.nausicaea.paraburdoo.fluid;

import eu.pb4.polyfactory.entity.FactoryEntities;
import eu.pb4.polyfactory.fluid.FluidBehaviours;
import eu.pb4.polyfactory.fluid.FluidType;
import eu.pb4.polyfactory.fluid.shooting.ShootProjectileEntity;
import eu.pb4.polyfactory.other.FactoryRegistries;
import eu.pb4.polyfactory.other.FactorySoundEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;
import net.nausicaea.paraburdoo.Paraburdoo;
import net.nausicaea.paraburdoo.block.ModBlocks;
import net.nausicaea.paraburdoo.item.ModItems;

public abstract class ModFluidTypes {
    public static final FluidType<Unit> SLUDGE = register(
        "sludge",
        FluidType.of()
            .density(300)
            .texture(Identifier.of(Paraburdoo.MOD_ID, "block/sludge_still"))
            .particle(new ItemStackParticleEffect(ParticleTypes.ITEM, Items.BROWN_STAINED_GLASS_PANE.getDefaultStack()))
            .shootingBehavior(ShootProjectileEntity.ofSplash(FactoryEntities.WATER_SPLASH, 10, 300L, FactorySoundEvents.FLUID_SHOOT_WATER))
            .build()
    );

    private static <T> FluidType<T> register(String name, FluidType<T> item) {
        return Registry.register(FactoryRegistries.FLUID_TYPES, Identifier.of(Paraburdoo.MOD_ID, name), item);
    }

    public static void registerAll() {
        FluidBehaviours.addBlockStateConversions(ModBlocks.SLUDGE.getDefaultState(), Blocks.AIR.getDefaultState(), SLUDGE.ofBucket());

        // FluidBehaviours.addBlockStateConversions(ModBlocks.SLUDGE_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), ModBlocks.SLUDGE_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 2), SLUDGE.ofBottle());
        // FluidBehaviours.addBlockStateConversions(ModBlocks.SLUDGE_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 2), ModBlocks.SLUDGE_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 1), SLUDGE.ofBottle());
        // FluidBehaviours.addBlockStateConversions(ModBlocks.SLUDGE_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 1), Blocks.CAULDRON.getDefaultState(), SLUDGE.ofBottle());

        FluidBehaviours.addItemToFluidLink(ModItems.SLUDGE_BUCKET, SLUDGE.defaultInstance());
    }
}
