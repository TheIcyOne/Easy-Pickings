package com.headfishindustries.easypickings;

import com.headfishindustries.easypickings.blocks.*;
import com.headfishindustries.easypickings.items.*;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.signature.BasicSignature;

public class StuffDefs {
	
	public FlowerNightshade BlockNightshade;
	public ItemBlock ItemNightshade;
	
	public FlowerDaybloom BlockDaybloom;
	public ItemBlock ItemDaybloom;
	
	public ItemUnstableGoo ItemUnstableGoo;

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
		
		//Unstable ingot and old ExU stuff
		this.ItemUnstableGoo = (com.headfishindustries.easypickings.items.ItemUnstableGoo) new ItemUnstableGoo().setRegistryName("unstable_goo");
	}
	
	public void registerBlocks(RegistryEvent.Register<Block> event){
			event.getRegistry().register(this.BlockDaybloom);
			event.getRegistry().register(this.BlockNightshade);
	}
	
	public void registerItems(RegistryEvent.Register<Item> event){
		event.getRegistry().register(this.ItemDaybloom);
		event.getRegistry().register(this.ItemNightshade);
		event.getRegistry().register(this.ItemUnstableGoo);
	}

}
