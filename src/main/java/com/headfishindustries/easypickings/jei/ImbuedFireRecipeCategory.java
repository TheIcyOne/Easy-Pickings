package com.headfishindustries.easypickings.jei;

import com.headfishindustries.easypickings.EasyPickings;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

public class ImbuedFireRecipeCategory implements IRecipeCategory<FireRecipeWrapper>{
	
	private static final int SLOT_FIRE = -1;
	private static final int SLOT_IN = 0;
	private static final int SLOT_OUT = 1;
	private final IDrawable bg = EasyJEIPluggings.jeiHelper.getGuiHelper().createDrawable(new ResourceLocation(EasyPickings.MODID, "textures/gui/jei/fire_recipe.png"), 0, 0, 90, 20);

	
	@Override
	public String getUid() {
		return EasyPickings.MODID + ":fire_recipe";
	}

	@Override
	public String getTitle() {
		return I18n.format("easypickings.recipe.fire");
	}

	@Override
	public String getModName() {
		return EasyPickings.NAME;
	}

	@Override
	public IDrawable getBackground() {
		return bg;
	}
	
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, FireRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup layoutItem = recipeLayout.getItemStacks();
		IGuiFluidStackGroup layoutFluid = recipeLayout.getFluidStacks();
		
		layoutItem.init(SLOT_FIRE, true, 8, 0);
		layoutItem.set(SLOT_FIRE, ingredients.getInputs(ItemStack.class).get(0));
		
		if(ingredients.getInputs(FluidStack.class).size() == 0){
			layoutItem.init(SLOT_IN, true, 32, 0);
			layoutItem.set(SLOT_IN, ingredients.getInputs(ItemStack.class).get(1));
		}else{
			layoutFluid.init(SLOT_IN, false, 64, 0);
			layoutFluid.set(SLOT_IN, ingredients.getInputs(FluidStack.class).get(0).get(0));
		}
		
		
		if(ingredients.getOutputs(FluidStack.class).size() == 0){
			layoutItem.init(SLOT_OUT, false, 64, 0);
			layoutItem.set(SLOT_OUT, ingredients.getOutputs(ItemStack.class).get(0));
		}else{
			layoutFluid.init(SLOT_OUT, false, 64, 0);
			layoutFluid.set(SLOT_OUT, ingredients.getOutputs(FluidStack.class).get(0).get(0));
		}
}


}
