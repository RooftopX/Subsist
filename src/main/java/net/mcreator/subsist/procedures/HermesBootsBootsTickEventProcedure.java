package net.mcreator.subsist.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.subsist.init.SubsistModParticles;

public class HermesBootsBootsTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isSprinting()) {
			world.addParticle(SubsistModParticles.HERMESBOOTSCLOUD, x, (y + 0.3), z, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), "effect give @p speed 1 1 true");
			entity.getPersistentData().putDouble("ishermesactivated", 1);
			if (entity.getPersistentData().getDouble("tickCounter") < 2) {
				entity.getPersistentData().putDouble("tickCounter", (entity.getPersistentData().getDouble("tickCounter") + 1));
				if (entity.getPersistentData().getDouble("tickCounter") == 1 && entity.isOnGround() && world.isClientSide()
						&& entity.getPersistentData().getDouble("ishermesactivated") == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("subsist:hermesbootsound")), SoundSource.PLAYERS, 1,
									1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("subsist:hermesbootsound")),
									SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("tickCounter", 0);
				entity.getPersistentData().putDouble("ishermesactivated", 0);
			}
		} else {
			entity.getPersistentData().putDouble("tickCounter", 0);
			entity.getPersistentData().putDouble("ishermesactivated", 0);
		}
	}
}
