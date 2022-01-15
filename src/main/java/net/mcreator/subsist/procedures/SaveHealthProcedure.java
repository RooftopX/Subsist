package net.mcreator.subsist.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.subsist.network.SubsistModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SaveHealthProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		Entity entity = event.getPlayer();
		execute(event, entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt
				? _livEnt.getMaxHealth()
				: -1) != (entity.getCapability(SubsistModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SubsistModVariables.PlayerVariables())).LastSavedMaxHealth) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						("attribute @p minecraft:generic.max_health base set " + new java.text.DecimalFormat("##.##")
								.format((entity.getCapability(SubsistModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SubsistModVariables.PlayerVariables())).LastSavedMaxHealth)));
		}
	}
}
