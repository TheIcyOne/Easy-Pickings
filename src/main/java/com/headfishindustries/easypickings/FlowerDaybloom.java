package com.headfishindustries.easypickings;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlowerDaybloom extends BlockBush{
	
	public static final FlowerDaybloom INSTANCE = new FlowerDaybloom();
	public static final ItemBlock TWINSTANCE = (ItemBlock) new ItemBlock(FlowerDaybloom.INSTANCE).setRegistryName(new ResourceLocation(EasyPickings.MODID + ":flower_daybloom"));

	public FlowerDaybloom() {
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.setRegistryName(new ResourceLocation(EasyPickings.MODID + ":flower_daybloom"));
		this.setUnlocalizedName("shit_flowr");
		this.setHardness(1.0F);
	}
	
	@Override
	 public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
		if (rand.nextInt(216000) == 1337){
			worldIn.setBlockState(pos, Blocks.DEADBUSH.getDefaultState());
		}
	    }

}
