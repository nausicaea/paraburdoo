package net.nausicaea.paraburdoo.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;

// TODO: implement FluidModificationItem as seen in BucketItem
public class PolymerBucketItem extends SimplePolymerItem {
    private final Fluid fluid;

    public PolymerBucketItem(Fluid fluid, Item.Settings settings) {
        super(settings);
        this.fluid = fluid;
    }
}
