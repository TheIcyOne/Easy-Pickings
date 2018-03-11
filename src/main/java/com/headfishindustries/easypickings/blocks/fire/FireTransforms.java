package com.headfishindustries.easypickings.blocks.fire;

import java.util.ArrayList;
import java.util.List;

import com.headfishindustries.easypickings.items.ItemImbuedFire;

import net.minecraft.block.state.IBlockState;

public class FireTransforms {
	
	 static List<Transform> transforms = new ArrayList<Transform>();
	
	
	public static void addTransform(ItemImbuedFire fireType, IBlockState in, IBlockState out){
		transforms.add(new Transform(fireType, in, out));
	}
	
	public static List<Transform> getTransforms(){
		return transforms;
	}
	
	public static List<Transform> getTransforms(ItemImbuedFire fireType){
		List<Transform> l = new ArrayList<Transform>();
		for (Transform t : transforms){
			if (t.fire == fireType){
				l.add(t);
			}
		}
		return l;
	}
	
	public static class Transform{
		public ItemImbuedFire fire;
		public IBlockState input;
		public IBlockState output;
		
		public Transform(ItemImbuedFire f, IBlockState in, IBlockState out){
			this.fire = f;
			this.input = in;
			this.output = out;
		}
	}
}
