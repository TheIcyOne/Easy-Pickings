package com.headfishindustries.easypickings.blocks.tank;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import vazkii.botania.api.mana.IManaPool;

public class TileManaTank extends TileEntity implements IManaPool{
	
	int mana;
	final int MAX_MANA_BASE = 1000000;
	final double EXP = -0.2;
	
	int connectedBlocks;
	int maxMana;
	
	EnumDyeColor colour = EnumDyeColor.WHITE;

	public TileManaTank() {
		
	}

	@Override
	public boolean canRecieveManaFromBursts() {
		return mana < maxMana;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return mana >= maxMana;
	}

	@Override
	public void recieveMana(int arg0) {

		mana+= arg0;
		
	}

	@Override
	public int getCurrentMana() {
		return mana;
	}

	@Override
	public EnumDyeColor getColor() {
		return colour;
	}

	@Override
	public boolean isOutputtingPower() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColor(EnumDyeColor arg0) {
		this.colour = arg0;		
	}

}
