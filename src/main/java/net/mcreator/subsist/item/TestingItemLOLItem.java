
package net.mcreator.subsist.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class TestingItemLOLItem extends Item {
	public TestingItemLOLItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("testing_item_lol");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
