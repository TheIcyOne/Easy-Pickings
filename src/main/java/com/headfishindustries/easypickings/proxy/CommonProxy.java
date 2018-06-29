package com.headfishindustries.easypickings.proxy;

import com.headfishindustries.easypickings.EasyConfiggings;
import com.headfishindustries.easypickings.EasyPickings;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	
	
	public void preInit(FMLPreInitializationEvent event){
	       MinecraftForge.EVENT_BUS.register(EasyPickings.class);
	       MinecraftForge.EVENT_BUS.register(EasyConfiggings.class);
	}

	public void init(FMLInitializationEvent e) {
	
		
	}
	    
	    
}
