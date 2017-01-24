package com.wumple.palimpsest;

import net.minecraft.world.World;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.init.Items;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.Logger;

public class filledMapPalimpsestRecipe implements IRecipe {
	
	public static void init() {
		GameRegistry.addRecipe(new filledMapPalimpsestRecipe());
	}

	private CraftingSearchResults getStuff(InventoryCrafting inv) {
		int i = 0;
		ItemStack mapItemStack = null;

		for (int j = 0; j < inv.getSizeInventory(); ++j) {
			ItemStack itemstack1 = inv.getStackInSlot(j);

			if (itemstack1 != null) {
				if (itemstack1.getItem() == Items.filled_map) {
					if (mapItemStack != null) {
						return null;
					}

					mapItemStack = itemstack1;
				} else {
					if (itemstack1.getItem() != Items.redstone) {
						return null;
					}

					i += itemstack1.stackSize;
				}
			}
		}

		int numToUse = 0;
		if (mapItemStack != null) {
			numToUse = Math.min(i, mapItemStack.stackSize);
		}

		return new CraftingSearchResults(numToUse, mapItemStack);
	}

	public boolean matches(InventoryCrafting inv, World worldIn) {

		CraftingSearchResults results = this.getStuff(inv);

		return results != null && results.mapItemStack() != null && results.numToUse() > 0;
	}

	public ItemStack getCraftingResult(InventoryCrafting inv) {

		CraftingSearchResults results = this.getStuff(inv);

		if (results != null && results.mapItemStack() != null && results.numToUse() > 0) {
			ItemStack itemstack2 = new ItemStack(Items.map, 1);

			return itemstack2;
		} else {
			return null;
		}
	}

	public int getRecipeSize() {
		return 9;
	}

	public ItemStack getRecipeOutput() {
		return null;
	}

	/*
	 * public ItemStack[] getRemainingItems(InventoryCrafting inv) {
	 * CraftingSearchResults results = this.getStuff(inv);
	 * 
	 * ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];
	 * 
	 * for (int i = 0; i < aitemstack.length; ++i) { ItemStack itemstack =
	 * inv.getStackInSlot(i);
	 * 
	 * if (itemstack != null && itemstack.getItem().hasContainerItem()) {
	 * aitemstack[i] = new ItemStack(itemstack.getItem().getContainerItem()); }
	 * }
	 * 
	 * return aitemstack; }
	 */
}
