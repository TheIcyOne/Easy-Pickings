package com.headfishindustries.easypickings.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.World;

public class ItemImbuedFire extends ItemBlock{


	public ItemImbuedFire(Block b) {
		super(b);
		this.setMaxStackSize(16);
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		tooltip.add(I18n.format("lore.fire."+EnumFireType.fromMeta(stack.getMetadata()).getName()));
	}
	

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
		if (this.isInCreativeTab(tab)){
			for(EnumFireType type : EnumFireType.values()){
				items.add(new ItemStack(this, 1, type.getMeta()));
			}
		}
	}
	
	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return "item.imbuedfire_" + EnumFireType.fromMeta(stack.getMetadata()).toString();
    }
	
	public enum EnumFireType{
		/** Remember, future me, to keep this in ascending order, or you'll break your fromMeta function and have to do it properly. **/
		FIRE(0, "fire"), //Fire imbued fire. Makes about as much sense as water imbued fire :thinking:
		WATER(1, "water"),
		AIR(2, "air"),
		EARTH(3, "earth"),
		ORDER(4, "order"),
		LOSS(5, "perdition"), //Thaumcraft? Never heard of it.
		WRATH(6, "wrath"); //tbh I just miss Factorization.
	
		
		private int meta;
		private String name;
		
		EnumFireType(int m, String n){
			this.meta = m;
			this.name = n;
		}

		public int getMeta() {
			return meta;
		}

		public String getName() {
			return name;
		}
		
		public static EnumFireType fromMeta(int m){
			if (m < 0 || m >= EnumFireType.values().length){
				m = 0;
			}
			return EnumFireType.values()[m];
		}
	}
	
	

}
