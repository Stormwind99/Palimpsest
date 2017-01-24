package com.wumple.palimpsest;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

	public static final String MODID = "Palimpsest";
	public static final String MODNAME = "Palimpsest";
	public static final String VERSION = "1.0.2";

	@Instance
	public static Main instance = new Main();

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		GameRegistry.addShapelessRecipe(new ItemStack(Items.writable_book, 1),
				new Object[] { new ItemStack(Items.writable_book, 1), new ItemStack(Items.redstone, 1), });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.book, 1),
				new Object[] { new ItemStack(Items.enchanted_book, 1), new ItemStack(Items.redstone, 1), });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.map, 1),
				new Object[] { new ItemStack(Items.map, 1), new ItemStack(Items.redstone, 1), });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.book, 1),
				new Object[] { new ItemStack(Items.written_book, 1), new ItemStack(Items.redstone, 1), });

		filledMapPalimpsestRecipe.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}
}