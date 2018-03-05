package com.headfishindustries.easypickings.blocks.fire;

import java.util.HashMap;

import com.headfishindustries.easypickings.items.ItemImbuedFire.EnumFireType;

import net.minecraft.block.state.IBlockState;

public class BlockEarthImbuedFire  extends ImbuedFireBase{

	@Override
	public HashMap<IBlockState, IBlockState> getTransformations() {
		return this.transforms;
	}

	@Override
	public EnumFireType getFireType() {
		return EnumFireType.EARTH;
	}

	@Override
	public void setTransform(IBlockState a, IBlockState b) {
		transforms.put(a, b);		
	}
}
