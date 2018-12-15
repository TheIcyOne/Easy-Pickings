package com.headfishindustries.easypickings.entity;

import java.util.Random;

import com.headfishindustries.easypickings.EasyConfiggings;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityEggBomb extends EntityThrowable{
	
	public EntityEggBomb(World w) {
		super (w);
	}

	public EntityEggBomb(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityEggBomb(World worldIn, double x, double y, double z, ItemStack copy) {
		super(worldIn, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote)
        {
			Explosion explosion = new Explosion(this.world, this, this.posX, this.posY, this.posZ, 2.0f, false, false);
			explosion.doExplosionB(true);
			Random rand = this.world.rand;
			for (int i = 0; i <= EasyConfiggings.miscsettings.clucksPerBomb; i++) {				
				EntityChicken chicken = new EntityChicken(this.world);
				chicken.setPosition(this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ);
				chicken.setGrowingAge(0);
				chicken.setVelocity(rand.nextDouble() * 10 - 5, rand.nextDouble() * 10, rand.nextDouble() * 10 - 5);
				chicken.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 2, 10));
				chicken.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2, 100));
				this.world.spawnEntity(chicken);
				
				
			}
        }
	}
	
}
