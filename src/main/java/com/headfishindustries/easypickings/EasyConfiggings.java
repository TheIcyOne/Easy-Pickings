package com.headfishindustries.easypickings;

import net.minecraftforge.common.config.Config;


@Config(modid=EasyPickings.MODID, name="Easy Configgings")
public class EasyConfiggings{
	
	@Config.Name(value = "Imbued Fire Transformations")
	@Config.Comment(value = { "Used to modify block transforms for Imbued Fires.", "Use the format 'modid:blockIn, modid:blockOut'"})
	@Config.RequiresWorldRestart
	public static FireTransforms fireTransforms = new FireTransforms();
	
	public static class FireTransforms{
		@Config.Name(value = "Fire Imbued Fire")
		public String[] fireTransforms = {
				"minecraft:grass_block,minecraft:netherrack",
				"minecraft:dirt,minecraft:netherrack",
				"minecraft:sand,minecraft:soul_sand",
				"minecraft:gravel,minecraft:soul_sand",
				"minecraft:clay,minecraft:glowstone",
				"minecraft:tallgrass, minecraft:air"
				};

		public String[] waterTransforms = {
				"minecraft:netherrack,minecraft:snow",
				"minecraft:glowstone,minecraft:ice",
				"minecraft:soul_sand,minecraft:ice",
				"minecraft:sand,minecraft:ice",
				"minecraft:lava,minecraft:obsidian"
		};

		public String[] airTransforms = {
				"minecraft:grass_block,minecraft:sand",
				"minecraft:dirt,minecraft:sand",
				"minecraft:log,minecraft:sand",
				"minecraft:leaves,minecraft:sand",
				"minecraft:ice,minecraft:glass",
				"minecraft:water,minecraft:cake",
				"minecraft:tallgrass, minecraft:air"
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
				"minecraft:nether_brick_fence,minecraft:oak_fence",
				"minecraft:oak_fence,minecraft:oak_stairs",
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
				"minecraft:sand, minecraft:glass"
		};
		
		public String[] perditionTransforms = {
				//tbh i have literally no idea what to do with this, the old one was basically useless and replicating it would mean messing up my nice methods.
				"minecraft:stone,minecraft:cobblestone"
		};

		public String[] wrathTransforms = {
			"minecraft:iron_block, minecraft:lapis_block" //Pretend this is wrath iron k thx
		};

	}

}
