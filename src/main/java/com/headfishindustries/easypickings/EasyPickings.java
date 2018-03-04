package com.headfishindustries.easypickings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.headfishindustries.easypickings.blocks.fire.FireMapper;
import com.headfishindustries.easypickings.blocks.fire.ImbuedFireBase;
import com.headfishindustries.easypickings.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.Item;
import net.minecraft.world.GameRules.ValueType;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = EasyPickings.MODID, version = EasyPickings.VERSION, acceptedMinecraftVersions="[1.12, 1.13]", dependencies="after:botania")
public class EasyPickings
{
    public static final String MODID = "easypickings";
    public static final String VERSION = "1.2.0";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
    public static final StuffDefs STUFF_DEFS = new StuffDefs();
    
    @SidedProxy(serverSide="com.headfishindustries.easypickings.proxy.CommonProxy", clientSide="com.headfishindustries.easypickings.proxy.ClientProxy")
    static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
       proxy.preInit(e);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e){
    	proxy.init(e);
    }
    
    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
    	
    	STUFF_DEFS.registerBlocks(event);

    }
    
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
    	STUFF_DEFS.registerItems(event);
    }
    
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	   	
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.ItemDaybloom, 0, new ModelResourceLocation(MODID + ":flower_daybloom", "inventory"));
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.ItemNightshade, 0, new ModelResourceLocation(MODID + ":flower_nightshade", "inventory"));
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.ItemUnstableGoo, 0, new ModelResourceLocation(MODID + ":unstable_goo", "inventory"));
    	
    	//ModelLoader.setCustomStateMapper(STUFF_DEFS.BlockAirFire, new FireMapper.Builder().ignore(/*BlockFire.AGE, BlockFire.EAST, BlockFire.NORTH, BlockFire.SOUTH, BlockFire.WEST*/).build());
    }
    
    @EventHandler
    public void onPlayerDeath(LivingDeathEvent e){
    	
    }
    
    @SubscribeEvent
    public static void onWorldLoad(WorldEvent.Load e){
    	World w = e.getWorld();
    	if (!w.getGameRules().hasRule("extinguishImbuedFires")){
    		w.getGameRules().addGameRule("extinguishImbuedFires", "false", ValueType.BOOLEAN_VALUE);;
    	}
    	STUFF_DEFS.BlockAirFire.updateTransforms(EasyConfiggings.fireTransforms.airTransforms);
    }

}
