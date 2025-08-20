package net.nausicaea.paraburdoo.block.cauldron;

import net.minecraft.block.cauldron.CauldronBehavior;

public abstract class ModCauldronBehaviors {
    // FIXME: properly implement cauldron behavior via CauldronBehavior::registerBehavior and CauldronBehavior::registerBucketBehavior
    public static final CauldronBehavior.CauldronBehaviorMap SLUDGE_CAULDRON_BEHAVIOR = CauldronBehavior.createMap("sludge");
}
