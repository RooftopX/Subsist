
package net.mcreator.subsist.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class HellstoneRawItem extends Item {
	public HellstoneRawItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("hellstone_raw");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
