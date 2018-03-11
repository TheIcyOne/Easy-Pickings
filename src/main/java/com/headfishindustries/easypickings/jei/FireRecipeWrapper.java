package com.headfishindustries.easypickings.jei;

import java.util.ArrayList;
import java.util.List;

import com.headfishindustries.easypickings.blocks.fire.FireTransforms;
import com.headfishindustries.easypickings.items.ItemImbuedFire;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

public class FireRecipeWrapper implements IRecipeWrapper{
	
	private final FireTransforms.Transform transform;
	
	ItemImbuedFire fire;
	
	public FireRecipeWrapper(FireTransforms.Transform recipe){
		this.transform = recipe;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getIngredients(IIngredients ingredients) {
		fire = transform.fire;
		IBlockState in = transform.input;
		Fluid f = FluidRegistry.lookupFluidForBlock(in.getBlock());

		if(f != null){
//			ingredients.setInput(FluidStack.class, new FluidStack(FluidRegistry.lookupFluidForBlock(in.getBlock()), Fluid.BUCKET_VOLUME));
			//shh this is fine
			List<ItemStack> l = new ArrayList<ItemStack>();
			l.add(new ItemStack(fire));
			l.add(FluidUtil.getFilledBucket(new FluidStack(f, 1000)));
			ingredients.setInputs(ItemStack.class, l);
		}else{
			List<ItemStack> l = new ArrayList<ItemStack>();
			l.add(new ItemStack(fire));
			l.add(new ItemStack(Item.getItemFromBlock(in.getBlock()), 1));
			ingredients.setInputs(ItemStack.class, l);
		}
		
		IBlockState out = transform.output;
		f = FluidRegistry.lookupFluidForBlock(out.getBlock());
		
		if (f != null){
			ingredients.setOutput(FluidStack.class, new FluidStack(f, 1000));
		}else{
			Block b = out.getBlock();
			Item i = Item.getItemFromBlock(b);
			if (b.equals(Blocks.CAKE))
			i = Items.CAKE;
			ItemStack s = new ItemStack(i);
			ingredients.setOutput(ItemStack.class, s);
		}
	}
	
	public ItemImbuedFire getFire(){
		return fire;
	}


}
