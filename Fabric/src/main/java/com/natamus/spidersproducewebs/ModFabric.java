package com.natamus.spidersproducewebs;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.fabric.callbacks.CollectivePlayerEvents;
import com.natamus.spidersproducewebs.events.SpiderEvent;
import com.natamus.spidersproducewebs.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		CollectivePlayerEvents.PLAYER_TICK.register((ServerLevel world, ServerPlayer player) -> {
			SpiderEvent.onPlayerTick(world, player);
		});
	}

	private static void setGlobalConstants() {

	}
}
