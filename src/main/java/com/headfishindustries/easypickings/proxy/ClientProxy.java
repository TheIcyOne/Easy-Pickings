package com.headfishindustries.easypickings.proxy;

import com.headfishindustries.easypickings.EasyPickings;
import com.headfishindustries.easypickings.blocks.IWantMyOwnBlockColour;
import com.headfishindustries.easypickings.entity.EntityEggBomb;
import com.headfishindustries.easypickings.items.IWantMyOwnItemColour;
import com.headfishindustries.easypickings.items.ItemEggBomb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		RenderingRegistry.registerEntityRenderingHandler(EntityEggBomb.class, renderManager -> new RenderSnowball<>(renderManager, EasyPickings.STUFF_DEFS.itemEggBomb, Minecraft.getMinecraft().getRenderItem()));
	}
	
	@Override
    public void init(FMLInitializationEvent e){
    	BlockColors  blockColour = Minecraft.getMinecraft().getBlockColors();

    	final IBlockColor blockColourHandler = (state, blockAccess, pos, tintIndex) -> {
    		if (blockAccess != null && pos != null && state !=null && blockAccess.getBlockState(pos).getBlock() instanceof IWantMyOwnBlockColour) {
    			IWantMyOwnBlockColour block = (IWantMyOwnBlockColour) (blockAccess.getBlockState(pos).getBlock());
    			return block.colorMultiplier(state, blockAccess, pos, tintIndex);
    		}

    		return 0xFFFFFF;
    	};
    	
    	final IItemColor itemColourHandler = (stack, meta) -> {
    		if (stack != null && stack.getItem() != null && stack.getItem() instanceof IWantMyOwnItemColour){
    			IWantMyOwnItemColour item = (IWantMyOwnItemColour) stack.getItem();
    			return item.colorMultiplier(stack, 1);
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
    			EasyPickings.STUFF_DEFS.itemEarthFire,
    			EasyPickings.STUFF_DEFS.itemFireFire,
    			EasyPickings.STUFF_DEFS.itemOrderFire,
    			EasyPickings.STUFF_DEFS.itemPerditionFire,
    			EasyPickings.STUFF_DEFS.itemWaterFire,
    			EasyPickings.STUFF_DEFS.itemWrathFire,
    			EasyPickings.STUFF_DEFS.itemUnstableGoo
    			);
    }
}
