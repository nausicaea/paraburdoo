package net.nausicaea.paraburdoo;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;

import net.nausicaea.paraburdoo.block.ModBlocks;
import net.nausicaea.paraburdoo.fluid.ModFluids;
import net.nausicaea.paraburdoo.fluid.ModPolyfactoryFluids;
import net.nausicaea.paraburdoo.item.ModItemGroups;
import net.nausicaea.paraburdoo.item.ModItems;
import net.nausicaea.paraburdoo.tag.ModTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Paraburdoo implements ModInitializer {
	public static final String MOD_ID = "paraburdoo";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        ModFluids.registerAll();
        ModPolyfactoryFluids.registerAll();
        ModItems.registerAll();
        ModBlocks.registerAll();
        ModItemGroups.registerAll();
        ModTags.registerAll();
        PolymerResourcePackUtils.addModAssets(MOD_ID);

		LOGGER.info("Initialization complete");
	}
}
