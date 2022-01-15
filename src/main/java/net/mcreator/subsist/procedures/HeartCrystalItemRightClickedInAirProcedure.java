package net.mcreator.subsist.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.subsist.network.SubsistModVariables;
import net.mcreator.subsist.init.SubsistModItems;

public class HeartCrystalItemRightClickedInAirProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Crystal1 = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < 60) {
			{
				double _setval = (entity.getCapability(SubsistModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SubsistModVariables.PlayerVariables())).LastSavedMaxHealth + 2;
				entity.getCapability(SubsistModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LastSavedMaxHealth = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						("attribute @p minecraft:generic.max_health base set " + new java.text.DecimalFormat("##.##")
								.format((entity.getCapability(SubsistModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SubsistModVariables.PlayerVariables())).LastSavedMaxHealth)));
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(SubsistModItems.HEART_CRYSTAL_ITEM);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7a\u00A7oYou feel Stronger!"), (true));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7a\u00A7oYou have reached the maximum health!"), (true));
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performCommand(
					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(),
							null).withSuppressedOutput(),
					("say LastSavedMaxHealth is: "
							+ new java.text.DecimalFormat("##.##").format((entity.getCapability(SubsistModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SubsistModVariables.PlayerVariables())).LastSavedMaxHealth)));
	}
}
