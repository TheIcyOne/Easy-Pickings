package com.headfishindustries.easypickings.blocks;

import java.util.Random;

import com.headfishindustries.easypickings.EasyPickings;
import com.headfishindustries.easypickings.utils.MathsyStuff;

import net.minecraft.block.BlockBush;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapelessOreRecipe;



public class FlowerDaybloom extends BlockBush{	
	protected int dedchance = 216000;

	public FlowerDaybloom() {
		super(Material.LEAVES);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.setUnlocalizedName("shit_flowr");
		this.setHardness(1.0F);
		this.dedchance = 216000;
	}
	
	@Override
	 public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
//		if (rand.nextInt(20) == 1 )
		if (Loader.isModLoaded("botania"))
			this.doManaGen(worldIn, pos, state, rand);
			
	    }
	/** If you're going to set dedchance to 1337 or less, this needs to be overridden. I could use 0 as my equivalent, but memes are just too important. **/
	protected void doManaGen(World worldIn, BlockPos pos, IBlockState state, Random rand){
		if (rand.nextInt(this.getDedchance()) == 1337){
			worldIn.setBlockState(pos, Blocks.DEADBUSH.getDefaultState());
		}
		
		/** This is a dumb implementation. Use Botania's SubTileEntity if you actually want to do this properly.**/
		if (rand.nextInt(20) == 1 && Loader.isModLoaded("botania")){

			BlockPos target = MathsyStuff.offsetRandomly(pos, 5, rand);
			if (worldIn.getTileEntity(target) instanceof vazkii.botania.api.mana.IManaReceiver){
				((vazkii.botania.api.mana.IManaReceiver)worldIn.getTileEntity(target)).recieveMana(1);
			}
		}
	}
	
	
	private int getDedchance(){
		return this.dedchance;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState s, World worldIn, BlockPos pos, Random rand) {
		Vec3d dir = new Vec3d(rand.nextDouble(), rand.nextDouble(), rand.nextDouble()).normalize();
		int n = rand.nextInt(48);
		if (n < 4 || n >20) return;
		for (int i = 0; i<n; i++) {
			Vec3d cur_dir = dir.rotateYaw((float) (2f * i * Math.PI / n));
			worldIn.spawnParticle(EnumParticleTypes.CRIT_MAGIC, pos.getX() + cur_dir.x * 0.75 + 0.5, pos.getY() + cur_dir.y * 0.5, pos.getZ() + cur_dir.z * 0.25 + 0.5, cur_dir.x * 0.5, cur_dir.y, cur_dir.z);

		}
}

	
}
	


