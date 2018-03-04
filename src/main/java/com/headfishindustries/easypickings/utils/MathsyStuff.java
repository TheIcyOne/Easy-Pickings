package com.headfishindustries.easypickings.utils;

import java.util.Random;

import net.minecraft.util.math.BlockPos;

public class MathsyStuff {

	public static BlockPos getRandomOffset(int x, int y, int z, Random rand){
		BlockPos pos = new BlockPos(rand.nextInt(x * 2) - x, rand.nextInt(y * 2) - y, rand.nextInt(z * 2) - z);
		return pos;
	}
	
	public static BlockPos offsetRandomly(BlockPos pos, int x, int y, int z, Random rand){
		return pos.add(getRandomOffset(x, y, z, rand));
	}
	
	public static BlockPos offsetRandomly(BlockPos pos, int bound, Random rand){
		return pos.add(getRandomOffset(bound,bound,bound, rand));
	}

}
