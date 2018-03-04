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
				"minecraft:clay,minecraft:glowstone"
				};

		public String[] waterTransforms = {};

		public String[] airTransforms = {
				"minecraft:grass_block,minecraft:sand",
				"minecraft:dirt,minecraft:sand",
				"minecraft:log,minecraft:sand",
				"minecraft:leaves,minecraft:sand",
				"minecraft:ice,minecraft:glass",
				"minecraft:water,minecraft:cake"
				};

		public String[] earthTransforms = {};

		public String[] orderTransforms = {};
		
		public String[] perditionTransforms = {};

		public String[] wrathTransforms = {};

	}

}
