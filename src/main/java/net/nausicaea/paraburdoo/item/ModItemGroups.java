package net.nausicaea.paraburdoo.item;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nausicaea.paraburdoo.Paraburdoo;
import net.nausicaea.paraburdoo.block.ModBlocks;

public abstract class ModItemGroups {
    public static final RegistryKey<ItemGroup> PARABURDOO_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Paraburdoo.MOD_ID, "item_group"));

    public static void registerAll() {
        Paraburdoo.LOGGER.info("Registering item groups");

        PolymerItemGroupUtils.registerPolymerItemGroup(
            PARABURDOO_KEY,
            PolymerItemGroupUtils.builder()
                .displayName(Text.translatable("item_group.paraburdoo"))
                .icon(() -> new ItemStack(Items.RAW_IRON))
                .entries((context, entries) -> {
                    entries.add(ModBlocks.PURIFIED_GRAVEL.asItem());
                })
                .build()
        );
    }
}
