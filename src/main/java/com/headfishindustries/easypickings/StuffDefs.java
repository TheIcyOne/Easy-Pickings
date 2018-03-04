package com.headfishindustries.easypickings;

import com.headfishindustries.easypickings.blocks.*;
import com.headfishindustries.easypickings.blocks.fire.BlockAirImbuedFire;
import com.headfishindustries.easypickings.blocks.fire.ImbuedFireBase;
import com.headfishindustries.easypickings.items.*;
import com.headfishindustries.easypickings.items.armour.obsidian.ItemObsidianArmour;

import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;

public class StuffDefs {
	
	public FlowerNightshade BlockNightshade;
	public ItemBlock ItemNightshade;
	
	public FlowerDaybloom BlockDaybloom;
	public ItemBlock ItemDaybloom;
	
	public BlockAirImbuedFire BlockAirFire;
	
	public ItemUnstableGoo ItemUnstableGoo;
	
/*	public ItemObsidianArmour obsidianHat;
	public ItemObsidianArmour obsidianStomachGuard;
	public ItemObsidianArmour obsidianTrouser;
	public ItemObsidianArmour obsidianShoe;*/
	
	
	public StuffDefs() {
		this.defStuff();
	}
	
	private void defStuff(){
		
		//Flowers and stuff
		ResourceLocation daybloomRL = new ResourceLocation(EasyPickings.MODID, "flower_daybloom");
		ResourceLocation nightshadeRL = new ResourceLocation(EasyPickings.MODID, "flower_nightshade");
		
		this.BlockDaybloom = (FlowerDaybloom) new FlowerDaybloom().setRegistryName(daybloomRL);
		this.ItemDaybloom = (ItemBlock) new ItemBlock(BlockDaybloom).setRegistryName(daybloomRL);
		
		this.BlockNightshade = (FlowerNightshade) new FlowerNightshade().setRegistryName(nightshadeRL);
		this.ItemNightshade = (ItemBlock) new ItemBlock(BlockNightshade).setRegistryName(nightshadeRL);
		
		this.BlockAirFire = (BlockAirImbuedFire) new BlockAirImbuedFire();
		
		//Unstable ingot and old ExU stuff
		this.ItemUnstableGoo = (com.headfishindustries.easypickings.items.ItemUnstableGoo) new ItemUnstableGoo().setRegistryName("unstable_goo");
		
/*		this.obsidianHat = new ItemObsidianArmour(EntityEquipmentSlot.HEAD, "obsidian_helmet", ItemObsidianArmour.obsidianArmourMaterial);
		this.obsidianStomachGuard = new ItemObsidianArmour(EntityEquipmentSlot.CHEST, "obsidian_chestplate", ItemObsidianArmour.obsidianArmourMaterial);
		this.obsidianTrouser = new ItemObsidianArmour(EntityEquipmentSlot.LEGS, "obsidian_legs", ItemObsidianArmour.obsidianArmourMaterial);
		this.obsidianShoe = new ItemObsidianArmour(EntityEquipmentSlot.FEET, "obsidian_boots", ItemObsidianArmour.obsidianArmourMaterial); */
	}
	
	public void registerBlocks(RegistryEvent.Register<Block> event){
			event.getRegistry().register(this.BlockDaybloom);
			event.getRegistry().register(this.BlockNightshade);
			event.getRegistry().register(this.BlockAirFire);
	}
	
	public void registerItems(RegistryEvent.Register<Item> event){
		event.getRegistry().register(this.ItemDaybloom);
		event.getRegistry().register(this.ItemNightshade);
		event.getRegistry().register(this.ItemUnstableGoo);
		
/*		event.getRegistry().register(this.obsidianHat);
		event.getRegistry().register(this.obsidianStomachGuard);
		event.getRegistry().register(this.obsidianTrouser);
		event.getRegistry().register(this.obsidianShoe); */
	}

}
