package com.headfishindustries.easypickings.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public interface IWantMyOwnBlockColour {
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex);
}
