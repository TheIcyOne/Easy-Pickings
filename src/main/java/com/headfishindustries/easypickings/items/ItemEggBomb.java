package com.headfishindustries.easypickings.items;

import com.headfishindustries.easypickings.entity.EntityEggBomb;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemEggBomb extends Item{
	public ItemEggBomb() {
		super();
		this.setMaxStackSize(8);
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);

	    if (!playerIn.capabilities.isCreativeMode) {
	    	itemstack.shrink(1);
	    }

	    worldIn.playSound((EntityPlayer)playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	    if (!worldIn.isRemote)
	    {
	         EntityEggBomb bomb = new EntityEggBomb(worldIn, playerIn);
	         bomb.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
	         worldIn.spawnEntity(bomb);
	    }

	    playerIn.addStat(StatList.getObjectUseStats(this));
	    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	    }
	
	
	

}
