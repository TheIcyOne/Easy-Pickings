package com.headfishindustries.easypickings.proxy;

import com.headfishindustries.easypickings.EasyConfiggings;
import com.headfishindustries.easypickings.EasyPickings;
import com.headfishindustries.easypickings.entity.EntityEggBomb;
import com.headfishindustries.easypickings.items.ItemEggBomb;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {
	
	
	
	public void preInit(FMLPreInitializationEvent event){
	       MinecraftForge.EVENT_BUS.register(EasyPickings.class);
	       MinecraftForge.EVENT_BUS.register(EasyConfiggings.class);
	       
	       EasyPickings.STUFF_DEFS.entityInit();
	}

	public void init(FMLInitializationEvent e) {
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(EasyPickings.STUFF_DEFS.itemEggBomb, new IBehaviorDispenseItem()
        {
            /**
             * Dispenses the specified ItemStack from a dispenser.
             */
            public ItemStack dispense(IBlockSource source, final ItemStack stack)
            {
                return (new BehaviorProjectileDispense()
                {
                    /**
                     * Return the projectile entity spawned by this dispense behavior.
                     */
                    protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn)
                    {
                        return new EntityEggBomb(worldIn, position.getX(), position.getY(), position.getZ(), stack.copy());
                    }
                    protected float getProjectileInaccuracy()
                    {
                        return super.getProjectileInaccuracy() * 0.5F;
                    }
                    protected float getProjectileVelocity()
                    {
                        return super.getProjectileVelocity() * 1.25F;
                    }
                }).dispense(source, stack);
            }
        });
		
	}
	    
	    
}
