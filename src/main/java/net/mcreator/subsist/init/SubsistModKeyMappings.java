
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.subsist.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fmlclient.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.subsist.network.AccessoriesmenubindMessage;
import net.mcreator.subsist.SubsistMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SubsistModKeyMappings {
	public static final KeyMapping ACCESSORIESMENUBIND = new KeyMapping("key.subsist.accessoriesmenubind", GLFW.GLFW_KEY_I, "key.categories.misc");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(ACCESSORIESMENUBIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == ACCESSORIESMENUBIND.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						SubsistMod.PACKET_HANDLER.sendToServer(new AccessoriesmenubindMessage(0, 0));
						AccessoriesmenubindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
