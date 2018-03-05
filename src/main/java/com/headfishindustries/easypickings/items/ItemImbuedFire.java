package com.headfishindustries.easypickings.items;

import java.util.List;

import com.headfishindustries.easypickings.blocks.fire.ImbuedFireBase;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.World;

public class ItemImbuedFire extends ItemBlock implements IItemColor{


	public ItemImbuedFire(ImbuedFireBase b) {
		super(b);
		this.setMaxStackSize(16);
		this.setRegistryName("imbuedfire_" + b.getFireType().toString());
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		tooltip.add(I18n.format("lore.fire."+((ImbuedFireBase)this.block).getFireType().toString().toLowerCase()));
	}
	

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
	/*	if (this.isInCreativeTab(tab)){
			for(EnumFireType type : EnumFireType.values()){
				items.add(new ItemStack(this, 1, type.getMeta()));
			}
		}*/
	}
	
	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
		
        return "item.imbuedfire_" + ((ImbuedFireBase)this.block).getFireType().toString().toLowerCase();
    }
	
	

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		return EnumFireType.fromMeta(stack.getMetadata()).getColourMultiplier();
	}
	
	
	public enum EnumFireType{
		/** Remember, future me, to keep this in ascending order, or you'll break your fromMeta function and have to do it properly. **/
		FIRE(0, "fire", 0xff0000), //Fire imbued fire. Makes about as much sense as water imbued fire :thinking:
		WATER(1, "water", 0x3366cc),
		AIR(2, "air", 0xf9ec91),
		EARTH(3, "earth", 0x009900),
		ORDER(4, "order", 0xffffff),
		LOSS(5, "perdition",0x010101), //Thaumcraft? Never heard of it.
		WRATH(6, "wrath",0xcc33ff); //tbh I just miss Factorization.
	
		private int meta;
		private String name;
		private int colour;
		
		EnumFireType(int m, String n, int c){
			this.meta = m;
			this.name = n;
			this.colour = c;
		}

		public int getMeta() {
			return meta;
		}

		public String getName() {
			return name;
		}
		
		public int getColourMultiplier(){
			return colour;
		}
		
		public static EnumFireType fromMeta(int m){
			if (m < 0 || m >= EnumFireType.values().length){
				m = 0;
			}
			return EnumFireType.values()[m];
		}
	}

	

}
