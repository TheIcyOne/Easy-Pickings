package com.headfishindustries.easypickings;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Config(modid=EasyPickings.MODID, name="Easy Configgings")
public class EasyConfiggings{
	
	@Config.Name(value = "Imbued Fire Transformations")
	@Config.Comment(value = { "Used to modify block transforms for Imbued Fires.", "Use the format 'modid:blockIn, modid:blockOut'"})
	@Config.RequiresWorldRestart
	@Config.RequiresMcRestart
	public static FireTransforms fireTransforms = new FireTransforms();
	public static class FireTransforms{
		@Config.Name(value = "Fire Imbued Fire")
		public String[] fireTransforms = {
				"minecraft:grass,minecraft:netherrack",
				"minecraft:dirt,minecraft:netherrack",
				"minecraft:sand,minecraft:soul_sand",
				"minecraft:gravel,minecraft:soul_sand",
				"minecraft:clay,minecraft:glowstone"
				};

		public String[] waterTransforms = {
				"minecraft:netherrack,minecraft:snow",
				"minecraft:glowstone,minecraft:ice",
				"minecraft:soul_sand,minecraft:ice",
				"minecraft:sand,minecraft:ice",
				"minecraft:lava,minecraft:obsidian"
		};

		public String[] airTransforms = {
				"minecraft:grass,minecraft:sand",
				"minecraft:dirt,minecraft:sand",
				"minecraft:log,minecraft:sand",
				"minecraft:leaves,minecraft:sand",
				"minecraft:ice,minecraft:glass",
				"minecraft:water,minecraft:cake"
				};

		public String[] earthTransforms = {
				"minecraft:cobblestone,minecraft:dirt",
				"minecraft:stone,minecraft:dirt",
				"minecraft:sand,minecraft:dirt",
				"minecraft:glass,minecraft:dirt",
				"minecraft:log,minecraft:dirt",
				"minecraft:log2,minecraft:dirt",
				"minecraft:leaves,minecraft:dirt",
				"minecraft:leaves2,minecraft:dirt",
				"minecraft:planks,minecraft:dirt",
				"minecraft:snow_layer,minecraft:tallgrass",
				"minecraft:gravel,minecraft:clay",
				"minecraft:cactus,minecraft:log",
				"minecraft:nether_brick,minecraft:planks",
				"minecraft:nether_brick_fence,minecraft:fence",
				"minecraft:nether_brick_stairs,minecraft:oak_stairs",
				"minecraft:mob_spawner,minecraft:iron_block"
		};

		public String[] orderTransforms = {
				"minecraft:iron_ore,minecraft:iron_block",
				"minecraft:coal_ore,minecraft:coal_block",
				"minecraft:redstone_ore,minecraft:redstone_block",
				"minecraft:lapis_ore,minecraft:lapis_block",
				"minecraft:quartz_ore,minecraft:quartz_block",
				"minecraft:gold_ore,minecraft:gold_block",
				"minecraft:diamond_ore,minecraft:diamond_block",
				"minecraft:emerald_ore,minecraft:emerald_block",
				"minecraft:sand,minecraft:glass"
		};
		
		public String[] perditionTransforms = {
				//tbh i have literally no idea what to do with this, the old one was basically useless and replicating it would mean messing up my nice methods.
				"minecraft:stone,minecraft:cobblestone"
		};

		public String[] wrathTransforms = {
				"minecraft:iron_block,minecraft:lapis_block" //Pretend this is wrath iron k thx
		};

	}

	@Config.Name(value = "Passive Flower Settings")
	@Config.Comment(value = {"Settings for Daybloom and Nightshade."})
	public static FlowerSettings flowerSettings = new FlowerSettings();
	public static class FlowerSettings{
		
		@Config.Comment(value = {"The mana generated per burst by the daybloom.", "For reference, the hydroangea generates 1 mana per burst, i.e. every 3 ticks.", "Set to 0 to disable mana generation."})
		@Config.RangeInt(min = 0)
		public int daybloomMana = 1;
		@Config.Comment(value = "Mana generated per burst by the nightshade.")
		@Config.RangeInt(min = 0)
		public int nightshadeMana = 1;
		
		@Config.Comment(value = "Increase this to spawn more particles per burst.")
		@Config.RangeInt(min = 0)
		public int maxBurstParticles = 20;
		
		@Config.Comment(value = {"Increasing this makes dayblooms and nightshades create more frequent particle bursts.", "Set to 0 to disable."})
		@Config.RangeDouble(min = 0)
		public double burstParticleRate = 0.5;
	}

	@Config.Name(value = "Miscellaneous Settings.")
	@Config.Comment(value = { "Stuff what I can't group easy."})
	@Config.RequiresWorldRestart
	@Config.RequiresMcRestart
	public static MiscSettings miscsettings = new MiscSettings();
	public static class MiscSettings{
		@Config.Comment(value = {"Chickens spawned per bomb."})
		public int clucksPerBomb = 64;
	}
	
	@SubscribeEvent
	public static void configChanged(ConfigChangedEvent.OnConfigChangedEvent e) {
		if (e.getModID().equals(EasyPickings.MODID)) {
			ConfigManager.load(EasyPickings.MODID, Config.Type.INSTANCE);
		}
	}
}
