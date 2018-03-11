package com.headfishindustries.easypickings.jei;

import javax.annotation.Nonnull;

import com.headfishindustries.easypickings.EasyPickings;
import com.headfishindustries.easypickings.blocks.fire.FireTransforms;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class EasyJEIPluggings implements IModPlugin{
	public static IJeiHelpers jeiHelper;
	
	@Override
	public void register(@Nonnull IModRegistry reg){
		if (jeiHelper == null) jeiHelper = reg.getJeiHelpers();
		
		reg.addRecipes(FireTransforms.getTransforms(), EasyPickings.MODID + ":fire_recipe");
		reg.handleRecipes(FireTransforms.Transform.class, FireRecipeWrapper::new, EasyPickings.MODID + ":fire_recipe");
		//tbh not sure whether I want this or not. I'm going with not for now.
		/*reg.addRecipeCatalyst(new ItemStack(EasyPickings.STUFF_DEFS.itemAirFire), EasyPickings.MODID + ":fire_recipe");
		reg.addRecipeCatalyst(new ItemStack(EasyPickings.STUFF_DEFS.itemEarthFire), EasyPickings.MODID + ":fire_recipe");
		reg.addRecipeCatalyst(new ItemStack(EasyPickings.STUFF_DEFS.itemWaterFire), EasyPickings.MODID + ":fire_recipe");
		reg.addRecipeCatalyst(new ItemStack(EasyPickings.STUFF_DEFS.itemFireFire), EasyPickings.MODID + ":fire_recipe");
		reg.addRecipeCatalyst(new ItemStack(EasyPickings.STUFF_DEFS.itemOrderFire), EasyPickings.MODID + ":fire_recipe");
		reg.addRecipeCatalyst(new ItemStack(EasyPickings.STUFF_DEFS.itemPerditionFire), EasyPickings.MODID + ":fire_recipe");
		reg.addRecipeCatalyst(new ItemStack(EasyPickings.STUFF_DEFS.itemWrathFire), EasyPickings.MODID + ":fire_recipe");*/
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration reg){
		if (jeiHelper == null) jeiHelper = reg.getJeiHelpers();
		
		reg.addRecipeCategories(new ImbuedFireRecipeCategory());		
	}
	

}
