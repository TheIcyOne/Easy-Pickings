package com.headfishindustries.easypickings.blocks;

import com.headfishindustries.easypickings.EasyConfiggings;

import net.minecraft.creativetab.CreativeTabs;

public class FlowerNightshade extends FlowerDaybloom{

	int manaGen = EasyConfiggings.flowerSettings.nightshadeMana;
	int dedchance = 216000/2;
	
	public FlowerNightshade() {
		super();
		this.setCreativeTab(CreativeTabs.TOOLS);
		this.setUnlocalizedName("shitr_flowr");	
	}
	
	@Override
	protected int getDedchance(){
		return this.dedchance;
	}
	
	@Override
	protected int getManaGen() {
		return this.manaGen;
	}
}
