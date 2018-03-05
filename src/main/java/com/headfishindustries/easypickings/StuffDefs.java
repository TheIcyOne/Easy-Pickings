package com.headfishindustries.easypickings;

import com.headfishindustries.easypickings.blocks.*;
import com.headfishindustries.easypickings.blocks.fire.*;
import com.headfishindustries.easypickings.items.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class StuffDefs {
	
	public FlowerNightshade blockNightshade;
	public ItemBlock itemNightshade;
	
	public FlowerDaybloom blockDaybloom;
	public ItemBlock itemDaybloom;
	
	public BlockAirImbuedFire blockAirFire;
	public BlockEarthImbuedFire blockEarthFire;
	public BlockFireImbuedFire blockFireFire;
	public BlockWaterImbuedFire blockWaterFire;
	public BlockOrderImbuedFire blockOrderFire;
	public BlockPerditionImbuedFire blockPerditionFire;
	public BlockWrathFire blockWrathFire;
	
	public ItemImbuedFire itemAirFire;
	public ItemImbuedFire itemEarthFire;
	public ItemImbuedFire itemFireFire;
	public ItemImbuedFire itemWaterFire;
	public ItemImbuedFire itemOrderFire;
	public ItemImbuedFire itemPerditionFire;
	public ItemImbuedFire itemWrathFire;
	
	public ItemUnstableGoo itemUnstableGoo;
	
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
		
		this.blockDaybloom = (FlowerDaybloom) new FlowerDaybloom().setRegistryName(daybloomRL);
		this.itemDaybloom = (ItemBlock) new ItemBlock(blockDaybloom).setRegistryName(daybloomRL);
		
		this.blockNightshade = (FlowerNightshade) new FlowerNightshade().setRegistryName(nightshadeRL);
		this.itemNightshade = (ItemBlock) new ItemBlock(blockNightshade).setRegistryName(nightshadeRL);
		
		this.blockAirFire = (BlockAirImbuedFire) new BlockAirImbuedFire();
		this.itemAirFire = new ItemImbuedFire(blockAirFire);
		this.blockEarthFire = (BlockEarthImbuedFire) new BlockEarthImbuedFire();
		this.itemEarthFire = new ItemImbuedFire(blockEarthFire);
		this.blockFireFire = (BlockFireImbuedFire) new BlockFireImbuedFire();
		this.itemFireFire = new ItemImbuedFire(blockFireFire);
		this.blockWaterFire = (BlockWaterImbuedFire) new BlockWaterImbuedFire();
		this.itemWaterFire = new ItemImbuedFire(blockWaterFire);
		this.blockPerditionFire = (BlockPerditionImbuedFire) new BlockPerditionImbuedFire();
		this.itemPerditionFire = new ItemImbuedFire(blockPerditionFire);
		this.blockOrderFire = (BlockOrderImbuedFire) new BlockOrderImbuedFire();
		this.itemOrderFire = new ItemImbuedFire(blockOrderFire);
		this.blockWrathFire = (BlockWrathFire) new BlockWrathFire();
		this.itemWrathFire = new ItemImbuedFire(blockWrathFire);
		
		//Unstable ingot and old ExU stuff
		this.itemUnstableGoo = (com.headfishindustries.easypickings.items.ItemUnstableGoo) new ItemUnstableGoo().setRegistryName("unstable_goo");
		
/*		this.obsidianHat = new ItemObsidianArmour(EntityEquipmentSlot.HEAD, "obsidian_helmet", ItemObsidianArmour.obsidianArmourMaterial);
		this.obsidianStomachGuard = new ItemObsidianArmour(EntityEquipmentSlot.CHEST, "obsidian_chestplate", ItemObsidianArmour.obsidianArmourMaterial);
		this.obsidianTrouser = new ItemObsidianArmour(EntityEquipmentSlot.LEGS, "obsidian_legs", ItemObsidianArmour.obsidianArmourMaterial);
		this.obsidianShoe = new ItemObsidianArmour(EntityEquipmentSlot.FEET, "obsidian_boots", ItemObsidianArmour.obsidianArmourMaterial); */
	}
	
	public void registerBlocks(RegistryEvent.Register<Block> event){
			event.getRegistry().register(this.blockDaybloom);
			event.getRegistry().register(this.blockNightshade);
			event.getRegistry().registerAll(
					this.blockAirFire,
					this.blockEarthFire,
					this.blockFireFire,
					this.blockOrderFire,
					this.blockPerditionFire,
					this.blockWaterFire,
					this.blockWrathFire);

	}
	
	public void registerItems(RegistryEvent.Register<Item> event){
		event.getRegistry().register(this.itemDaybloom);
		event.getRegistry().register(this.itemNightshade);
		event.getRegistry().register(this.itemUnstableGoo);
		
		event.getRegistry().registerAll(this.itemAirFire, this.itemEarthFire, this.itemFireFire, this.itemWaterFire, this.itemOrderFire, this.itemPerditionFire, this.itemWrathFire);
		
/*		event.getRegistry().register(this.obsidianHat);
		event.getRegistry().register(this.obsidianStomachGuard);
		event.getRegistry().register(this.obsidianTrouser);
		event.getRegistry().register(this.obsidianShoe); */
	}

}
