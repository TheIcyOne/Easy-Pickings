package com.headfishindustries.easypickings.blocks;

import com.headfishindustries.easypickings.EasyPickings;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockShoveable extends Block{
	
	boolean isPullable;

	public BlockShoveable(boolean pullable) {
		super(Material.PISTON, MapColor.BLACK_STAINED_HARDENED_CLAY);
		this.setHardness(18000004); //Pistons have a check for hardness == -1, so we can't use that. Thanks Notch.
		this.setResistance(18000004); //come at me barrier
		this.setRegistryName(new ResourceLocation(EasyPickings.MODID, "shovey_block_" + (pullable ? "normal": "push_only")));
		this.setUnlocalizedName("shovey_block_" + (pullable ? "normal": "push_only"));
		this.isPullable = pullable;
	}

	@Override
	public EnumPushReaction getMobilityFlag(IBlockState s) {
		EnumPushReaction p = (this.isPullable ?  EnumPushReaction.NORMAL : EnumPushReaction.PUSH_ONLY);
		return p;
	}
	
	@Override
	public NonNullList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState s, int fortune){
		return NonNullList.create();
	}


}
