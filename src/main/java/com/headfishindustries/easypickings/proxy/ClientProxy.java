package com.headfishindustries.easypickings.proxy;

import com.headfishindustries.easypickings.EasyPickings;
import com.headfishindustries.easypickings.blocks.fire.ImbuedFireBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy{
	@Override
    public void init(FMLInitializationEvent e){
    	BlockColors  blockColour = Minecraft.getMinecraft().getBlockColors();

    	final IBlockColor colourHandler = (state, blockAccess, pos, tintIndex) -> {
    		if (blockAccess != null && pos != null) {
    			ImbuedFireBase fire = (ImbuedFireBase) (blockAccess.getBlockState(pos).getBlock());
    			return fire.colourMultiplier();
    		}

    		return 0xFFFFFF;
    	};
    	blockColour.registerBlockColorHandler(colourHandler, EasyPickings.STUFF_DEFS.BlockAirFire);
    }
}
