package com.headfishindustries.easypickings;

import com.headfishindustries.easypickings.blocks.BlockDefs;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = EasyPickings.MODID, version = EasyPickings.VERSION, acceptedMinecraftVersions="[1.12, 1.13]")
public class EasyPickings
{
    public static final String MODID = "easypickings";
    public static final String VERSION = "1.0.1";
    
    private static final BlockDefs BLOCK_DEFS = new BlockDefs();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
       MinecraftForge.EVENT_BUS.register(this.getClass());
        
    }
    
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
    	BLOCK_DEFS.registerBlocks(event);
    }
    
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
    	BLOCK_DEFS.registerItems(event);
    }
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	ModelLoader.setCustomModelResourceLocation(BLOCK_DEFS.ItemDaybloom, 0, new ModelResourceLocation(MODID + ":flower_daybloom", "inventory"));
    	ModelLoader.setCustomModelResourceLocation(BLOCK_DEFS.ItemNightshade, 0, new ModelResourceLocation(MODID + ":flower_nightshade", "inventory"));
    }

}
