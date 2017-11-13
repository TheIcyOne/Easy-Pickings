package com.headfishindustries.easypickings;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = EasyPickings.MODID, version = EasyPickings.VERSION)
public class EasyPickings
{
    public static final String MODID = "easypickings";
    public static final String VERSION = "1.0.0";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
       // ForgeRegistries.BLOCKS.register(FlowerDaybloom.INSTANCE);
    
       MinecraftForge.EVENT_BUS.register(this.getClass());
        
    }
    
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
    	System.out.println("thingy");
    	event.getRegistry().register(FlowerDaybloom.INSTANCE);
    }
    
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
    	event.getRegistry().register(FlowerDaybloom.TWINSTANCE);
    }
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	ModelLoader.setCustomModelResourceLocation(FlowerDaybloom.TWINSTANCE, 0, new ModelResourceLocation(MODID + ":flower_daybloom", "inventory"));
    }
    
    
    
}
