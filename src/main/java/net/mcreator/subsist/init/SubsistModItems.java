
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.subsist.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.subsist.item.HermesBootsItem;
import net.mcreator.subsist.item.HellstoneRawItem;
import net.mcreator.subsist.item.HellstoneIngotItem;
import net.mcreator.subsist.item.HeartCrystalItemItem;
import net.mcreator.subsist.item.CookedBlueTunaItem;
import net.mcreator.subsist.item.BlueTunaItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SubsistModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item BLUE_TUNA = register(new BlueTunaItem());
	public static final Item COOKED_BLUE_TUNA = register(new CookedBlueTunaItem());
	public static final Item HEART_CRYSTAL_ITEM = register(new HeartCrystalItemItem());
	public static final Item HEART_CRYSTAL = register(SubsistModBlocks.HEART_CRYSTAL, CreativeModeTab.TAB_FOOD);
	public static final Item HERMES_BOOTS_BOOTS = register(new HermesBootsItem.Boots());
	public static final Item HELLSTONE_ORE = register(SubsistModBlocks.HELLSTONE_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item HELLSTONE_RAW = register(new HellstoneRawItem());
	public static final Item HELLSTONE_INGOT = register(new HellstoneIngotItem());
	public static final Item HELLSTONEBRICK = register(SubsistModBlocks.HELLSTONEBRICK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item HELLSTONE_FURNACE = register(SubsistModBlocks.HELLSTONE_FURNACE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item HELLSTONE_FURNACE_ON = register(SubsistModBlocks.HELLSTONE_FURNACE_ON, CreativeModeTab.TAB_BUILDING_BLOCKS);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
