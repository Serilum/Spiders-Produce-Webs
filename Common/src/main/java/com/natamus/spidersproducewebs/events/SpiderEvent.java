package com.natamus.spidersproducewebs.events;

import com.natamus.spidersproducewebs.config.ConfigHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;

public class SpiderEvent {
	public static void onPlayerTick(ServerLevel level, ServerPlayer player) {
		if (player.tickCount % ConfigHandler.spiderWebProduceDelayTicks != 0) {
			return;
		}
		
		BlockPos ppos = player.blockPosition();
		
		int r = ConfigHandler.maxDistanceToSpiderBlocks;
		for (Entity entity : level.getEntities(player, new AABB(ppos.getX()-r, ppos.getY()-r, ppos.getZ()-r, ppos.getX()+r, ppos.getY()+r, ppos.getZ()+r))) {
			if (entity instanceof Spider || entity instanceof CaveSpider) {
				BlockPos epos = entity.blockPosition();
				if (level.getBlockState(epos).getBlock().equals(Blocks.AIR)) {
					level.setBlockAndUpdate(epos, Blocks.COBWEB.defaultBlockState());
				}
			}
		}
	}
}
