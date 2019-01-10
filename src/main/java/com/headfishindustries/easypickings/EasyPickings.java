package com.headfishindustries.easypickings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.headfishindustries.easypickings.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.world.GameRules.ValueType;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = EasyPickings.MODID, version = EasyPickings.VERSION, name = EasyPickings.NAME, acceptedMinecraftVersions="[1.12, 1.13]", dependencies="after:botania")
public class EasyPickings
{
    public static final String MODID = "easypickings";
    public static final String VERSION = "%gradle.version%";
    public static final String NAME = "Easy Pickings";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
    public static final StuffDefs STUFF_DEFS = new StuffDefs();
    
    public static final EasyPickings INSTANCE = new EasyPickings();
    
    @SidedProxy(serverSide="com.headfishindustries.easypickings.proxy.CommonProxy", clientSide="com.headfishindustries.easypickings.proxy.ClientProxy")
    static CommonProxy proxy;
    
    static{
		FluidRegistry.enableUniversalBucket();
    }
    
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
    	
    	STUFF_DEFS.blockAirFire.updateTransforms(EasyConfiggings.fireTransforms.airTransforms);
    	STUFF_DEFS.blockEarthFire.updateTransforms(EasyConfiggings.fireTransforms.earthTransforms);
    	STUFF_DEFS.blockFireFire.updateTransforms(EasyConfiggings.fireTransforms.fireTransforms);
    	STUFF_DEFS.blockWaterFire.updateTransforms(EasyConfiggings.fireTransforms.waterTransforms);
    	STUFF_DEFS.blockOrderFire.updateTransforms(EasyConfiggings.fireTransforms.orderTransforms);
    	STUFF_DEFS.blockPerditionFire.updateTransforms(EasyConfiggings.fireTransforms.perditionTransforms);
    	STUFF_DEFS.blockWrathFire.updateTransforms(EasyConfiggings.fireTransforms.wrathTransforms);

    }
    
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
    	STUFF_DEFS.registerItems(event);
    }
    
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	   	
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemDaybloom, 0, new ModelResourceLocation(MODID + ":flower_daybloom", "inventory"));
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemNightshade, 0, new ModelResourceLocation(MODID + ":flower_nightshade", "inventory"));
    	
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemUnstableGoo, 0, new ModelResourceLocation(MODID + ":unstable_goo", "inventory"));
    	
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemClimbingRock, 0, new ModelResourceLocation(MODID + ":climbing_rock", "inventory"));
    	
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemPushOnly, 0, new ModelResourceLocation(MODID + ":push_only", "inventory"));
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemPushPull, 0, new ModelResourceLocation(MODID + ":push_pull", "inventory"));
    	
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemEggBomb, 0, new ModelResourceLocation(MODID + ":egg_bomb", "inventory"));
    	
    	ModelResourceLocation fire = new ModelResourceLocation(MODID + ":imbued_fire", "inventory");
    	
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemAirFire, 0, fire);
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemEarthFire, 0, fire);
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemFireFire, 0, fire);
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemWaterFire, 0, fire);
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemOrderFire, 0, fire);
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemPerditionFire, 0, fire);
    	ModelLoader.setCustomModelResourceLocation(STUFF_DEFS.itemWrathFire, 0, fire);
    	
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
    	STUFF_DEFS.blockAirFire.updateTransforms(EasyConfiggings.fireTransforms.airTransforms);
    	STUFF_DEFS.blockEarthFire.updateTransforms(EasyConfiggings.fireTransforms.earthTransforms);
    	STUFF_DEFS.blockFireFire.updateTransforms(EasyConfiggings.fireTransforms.fireTransforms);
    	STUFF_DEFS.blockWaterFire.updateTransforms(EasyConfiggings.fireTransforms.waterTransforms);
    	STUFF_DEFS.blockOrderFire.updateTransforms(EasyConfiggings.fireTransforms.orderTransforms);
    	STUFF_DEFS.blockPerditionFire.updateTransforms(EasyConfiggings.fireTransforms.perditionTransforms);
    	STUFF_DEFS.blockWrathFire.updateTransforms(EasyConfiggings.fireTransforms.wrathTransforms);
    }

}
