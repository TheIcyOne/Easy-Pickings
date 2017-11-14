package com.headfishindustries.easypickings.blocks;

import com.headfishindustries.easypickings.EasyPickings;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class BlockDefs {
	
	public FlowerNightshade BlockNightshade;
	public ItemBlock ItemNightshade;
	
	public FlowerDaybloom BlockDaybloom;
	public ItemBlock ItemDaybloom;

	public BlockDefs() {
		this.defBlocks();
	}
	
	private void defBlocks(){
		ResourceLocation daybloomRL = new ResourceLocation(EasyPickings.MODID, "flower_daybloom");
		this.BlockDaybloom = (FlowerDaybloom) new FlowerDaybloom().setRegistryName(daybloomRL);
		this.ItemDaybloom = (ItemBlock) new ItemBlock(BlockDaybloom).setRegistryName(daybloomRL);
		this.BlockNightshade = (FlowerNightshade) new FlowerNightshade().setRegistryName(new ResourceLocation(EasyPickings.MODID + ":flower_nightshade"));
		this.ItemNightshade = (ItemBlock) new ItemBlock(BlockNightshade).setRegistryName(new ResourceLocation(EasyPickings.MODID + ":flower_nightshade"));
	}
	
	public void registerBlocks(RegistryEvent.Register<Block> event){
		event.getRegistry().register(this.BlockDaybloom);
		event.getRegistry().register(this.BlockNightshade);
	}
	
	public void registerItems(RegistryEvent.Register<Item> event){
		event.getRegistry().register(this.ItemDaybloom);
		event.getRegistry().register(this.ItemNightshade);
	}

}
