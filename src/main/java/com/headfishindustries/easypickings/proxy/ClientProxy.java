package com.headfishindustries.easypickings.proxy;

import com.headfishindustries.easypickings.EasyPickings;
import com.headfishindustries.easypickings.blocks.fire.ImbuedFireBase;
import com.headfishindustries.easypickings.items.ItemImbuedFire;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy{
	@Override
    public void init(FMLInitializationEvent e){
    	BlockColors  blockColour = Minecraft.getMinecraft().getBlockColors();

    	final IBlockColor blockColourHandler = (state, blockAccess, pos, tintIndex) -> {
    		if (blockAccess != null && pos != null) {
    			ImbuedFireBase fire = (ImbuedFireBase) (blockAccess.getBlockState(pos).getBlock());
    			return fire.colourMultiplier();
    		}

    		return 0xFFFFFF;
    	};
    	
    	final IItemColor itemColourHandler = (stack, meta) -> {
    		if (stack != null){
    			ItemImbuedFire fire = (ItemImbuedFire) stack.getItem();
    			return fire.colorMultiplier(stack, 1);
    		}
    		return 0xFFFFFF;
    	};
    	
    	blockColour.registerBlockColorHandler(blockColourHandler, 
    			EasyPickings.STUFF_DEFS.blockAirFire, 
    			EasyPickings.STUFF_DEFS.blockEarthFire, 
    			EasyPickings.STUFF_DEFS.blockFireFire, 
    			EasyPickings.STUFF_DEFS.blockWaterFire,
    			EasyPickings.STUFF_DEFS.blockOrderFire,
    			EasyPickings.STUFF_DEFS.blockPerditionFire,
    			EasyPickings.STUFF_DEFS.blockWrathFire);
    	
    	Minecraft.getMinecraft().getItemColors().registerItemColorHandler(itemColourHandler,
    			EasyPickings.STUFF_DEFS.itemAirFire,
    			EasyPickings.STUFF_DEFS.itemEarthFire);
    }
}
