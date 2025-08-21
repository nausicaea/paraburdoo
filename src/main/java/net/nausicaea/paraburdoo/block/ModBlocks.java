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

import java.util.function.Function;

public abstract class ModBlocks {
    public static final TexturedFallbackBlock PURIFIED_GRAVEL = register(
            "purified_gravel",
            s -> TexturedFallbackBlock.create(s, Blocks.GRAVEL),
            AbstractBlock.Settings.copy(Blocks.GRAVEL)
    );
    public static final TexturedFallbackBlock SLUDGE = register(
            "sludge",
            settings -> TexturedFallbackBlock.create(settings, Blocks.WATER),
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
    public static final TexturedFallbackBlock SLUDGE_CAULDRON = register(
            "sludge_cauldron",
            s -> TexturedFallbackBlock.create(s, Blocks.WATER_CAULDRON),
            AbstractBlock.Settings.copy(Blocks.WATER_CAULDRON)
    );

    private static <T extends Block> T register(String name, Function<AbstractBlock.Settings, T> blockFactory, AbstractBlock.Settings settings) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        T block = blockFactory.apply(settings.registryKey(blockKey));

        Registry.register(Registries.BLOCK, blockKey, block);

        return block;
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
