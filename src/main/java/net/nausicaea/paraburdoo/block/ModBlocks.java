package net.nausicaea.paraburdoo.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nausicaea.paraburdoo.Paraburdoo;
import net.nausicaea.paraburdoo.fluid.ModFluids;
import net.nausicaea.paraburdoo.fluid.PolymerFluidBlock;

import java.util.function.Function;

public abstract class ModBlocks {
    public static final Block PURIFIED_GRAVEL = registerWithItem(
            "purified_gravel",
            PurifiedGravel::new,
            AbstractBlock.Settings.copy(Blocks.GRAVEL)
    );
    public static final Block SLUDGE = register(
            "sludge",
            settings -> new PolymerFluidBlock(ModFluids.SLUDGE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BROWN)
                    .replaceable()
                    .noCollision()
                    .strength(100.0F)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .dropsNothing()
                    .liquid()
                    .sounds(BlockSoundGroup.INTENTIONALLY_EMPTY)
    );
    // TODO: implement the sludge cauldron
    // public static final Block SLUDGE_CAULDRON = register(
    //         "sludge_cauldron",
    //         settings -> new LeveledCauldronBlock(Biome.Precipitation.RAIN, CauldronBehavior.WATER_CAULDRON_BEHAVIOR, settings),
    //         AbstractBlock.Settings.copyShallow(Blocks.CAULDRON)
    // );

    private static Block registerWithItem(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Items need to be registered with a different type of registry key, but the ID
        // can be the same.
        RegistryKey<Item> itemKey = keyOfItem(name);

        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, blockItem);

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Paraburdoo.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Paraburdoo.MOD_ID, name));
    }

    public static void registerAll() {
        Paraburdoo.LOGGER.info("Registering blocks");
    }
}
