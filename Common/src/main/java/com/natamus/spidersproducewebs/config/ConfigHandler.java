package com.natamus.spidersproducewebs.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.spidersproducewebs.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 1, max = 256) public static int maxDistanceToSpiderBlocks = 32;
	@Entry(min = 1, max = 72000) public static int spiderWebProduceDelayTicks = 12000;

	public static void initConfig() {
		configMetaData.put("maxDistanceToSpiderBlocks", Arrays.asList(
			"The maximum distance in blocks the player can be away from a spider in order for the it to produce a web periodically."
		));
		configMetaData.put("spiderWebProduceDelayTicks", Arrays.asList(
			"The delay in between spiders producing a web in ticks (1 second = 20 ticks)."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}