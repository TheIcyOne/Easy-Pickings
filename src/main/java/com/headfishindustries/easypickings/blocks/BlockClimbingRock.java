package com.headfishindustries.easypickings.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockClimbingRock extends Block{

	public BlockClimbingRock() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setUnlocalizedName("climbing_rock");
		this.setHardness(2f);
		this.setResistance(2f);
		this.setTickRandomly(true);
		}

	
	@Override
	 public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (worldIn.getBlockState(pos.up()).isFullBlock()) return;
		for (int x = -1; x<=1; x+=2) {
				if (worldIn.getBlockState(pos.add(x, 0, 0)).isOpaqueCube() && worldIn.getBlockState(pos.add(x, 1, 0)).isOpaqueCube()) {
					worldIn.setBlockState(pos.up(), worldIn.getBlockState(pos));
					worldIn.setBlockToAir(pos);
					return;
				}
			
		}
		for (int z = -1; z<=1; z+=2) {
			if (worldIn.getBlockState(pos.add(0, 0, z)).isOpaqueCube() && worldIn.getBlockState(pos.add(0, 1, z)).isOpaqueCube()) {
				worldIn.setBlockState(pos.up(), worldIn.getBlockState(pos));
				worldIn.setBlockToAir(pos);
				return;
			}
		
	}
	}
	

}
