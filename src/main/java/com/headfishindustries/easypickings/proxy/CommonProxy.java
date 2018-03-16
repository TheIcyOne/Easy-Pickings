package com.headfishindustries.easypickings.proxy;

import com.headfishindustries.easypickings.EasyPickings;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	
	
	public void preInit(FMLPreInitializationEvent event){
	       MinecraftForge.EVENT_BUS.register(EasyPickings.class);
	}

	public void init(FMLInitializationEvent e) {
	
		
	}
	    
	    
}
