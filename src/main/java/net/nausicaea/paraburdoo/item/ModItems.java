package net.nausicaea.paraburdoo.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nausicaea.paraburdoo.Paraburdoo;
import net.nausicaea.paraburdoo.fluid.ModFluids;

import java.util.function.Function;

public abstract class ModItems {
    public static final Item SLUDGE_BUCKET = register(
        "sludge_bucket",
        s -> new PolymerBucketItem(ModFluids.SLUDGE, s),
        new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)
    );

    private static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Paraburdoo.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerAll() {
        Paraburdoo.LOGGER.info("Registering items");
    }
}
