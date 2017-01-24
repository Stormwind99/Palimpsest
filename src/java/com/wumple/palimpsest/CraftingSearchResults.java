package com.wumple.palimpsest;

import net.minecraft.item.ItemStack;

public class CraftingSearchResults {
	private final int m_numToUse;
	private final ItemStack m_mapItemStack;

	public CraftingSearchResults(int numToUse, ItemStack mapItemStack) {
		m_numToUse = numToUse;
		m_mapItemStack = mapItemStack;
	}

	public int numToUse() {
		return m_numToUse;
	}

	public ItemStack mapItemStack() {
		return m_mapItemStack;
	}
}
