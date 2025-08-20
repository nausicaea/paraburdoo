package net.nausicaea.paraburdoo.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
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
import net.nausicaea.paraburdoo.fluid.FluidFallbackBlock;

import java.util.function.Function;

import static net.nausicaea.paraburdoo.block.cauldron.ModCauldronBehaviors.SLUDGE_CAULDRON_BEHAVIOR;

public abstract class ModBlocks {
    public static final Block PURIFIED_GRAVEL = registerWithItem(
            "purified_gravel",
            s -> TexturedFallbackBlock.create(s, Blocks.GRAVEL),
            AbstractBlock.Settings.copy(Blocks.GRAVEL)
    );
    public static final Block SLUDGE = register(
            "sludge",
            settings -> FluidFallbackBlock.create(settings, ModFluids.SLUDGE, Blocks.WATER),
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
    public static final Block SLUDGE_CAULDRON = register(
            "sludge_cauldron",
            s -> CauldronFallbackBlock.create(s, net.minecraft.world.biome.Biome.Precipitation.NONE, SLUDGE_CAULDRON_BEHAVIOR, Blocks.WATER_CAULDRON),
            AbstractBlock.Settings.copyShallow(Blocks.CAULDRON)
    );

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
