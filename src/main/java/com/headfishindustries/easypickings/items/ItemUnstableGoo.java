package com.headfishindustries.easypickings.items;

import java.util.List;

import com.headfishindustries.easypickings.EasyPickings;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemUnstableGoo extends Item{
	
	private static final String STACK_KEY = EasyPickings.MODID + "";

	public ItemUnstableGoo() {
		this.setMaxStackSize(1);
		this.setUnlocalizedName("boom_stick");
	}
	
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity holder, int itemSlot, boolean isSelected)
    {    
    	if (!(holder instanceof EntityPlayer)) return;
    	EntityPlayer p = (EntityPlayer) holder;
    	NBTTagCompound nbt = stack.getTagCompound();
    	if (nbt == null){
    		nbt = new NBTTagCompound();
    		nbt.setInteger(STACK_KEY, 1000);
    	}
    	Integer timeLeft = nbt.getInteger(STACK_KEY);
    	if (timeLeft != -1){
    		timeLeft = (timeLeft - 5);

    		nbt.setInteger(STACK_KEY, timeLeft);
    		stack.setTagCompound(nbt);
    		

    		if (timeLeft == 0){
    			stack.setCount(0);;
    			worldIn.createExplosion(p, p.posX, p.posY, p.posZ, 5f, true);
    			p.attackEntityFrom(new DamageSource("craftinboom").setExplosion(), p.getHealth() + 10000000f);
    		}
    	}
    }
    
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn){
    	tooltip.add("WARNING: HIGHLY EXPLOSIVE");
    	Integer timeLeft = stack.getTagCompound().getInteger(STACK_KEY);
    	tooltip.add("Will explode in " + Math.round(Math.floor(timeLeft/100)) +  "." + Math.abs(timeLeft) % 100 + " seconds.");
    }
    
    


   

}
