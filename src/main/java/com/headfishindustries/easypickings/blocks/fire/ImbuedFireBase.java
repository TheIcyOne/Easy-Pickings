package com.headfishindustries.easypickings.blocks.fire;

import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import com.headfishindustries.easypickings.EasyPickings;
import com.headfishindustries.easypickings.items.ItemImbuedFire.EnumFireType;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ImbuedFireBase extends Block implements IBlockColor{
	
	protected HashMap<IBlockState, IBlockState> transforms = new HashMap<IBlockState, IBlockState>();
	/*public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool UPPER = PropertyBool.create("up");
	*/
	public abstract void setTransform(IBlockState a, IBlockState b);

	public ImbuedFireBase() {
		super(Material.FIRE);
		setRegistryName("imbuedfire_" + getFireType());
		setTickRandomly(true);
		setLightLevel(1F);
	}

	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
}
	
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	
	public abstract EnumFireType getFireType();
	
	public void updateTransforms(String[] transformsList) {
		Pattern p = Pattern.compile("[^:]+:[^:]+,[^:]+:[^:]+");
		for (String in : transformsList){
			
			Matcher m = p.matcher(in);
			if (!m.matches()){
				EasyPickings.LOGGER.error("Incorrect transformation format in Imbued Fire configuration: '" + in + "', this transform will not be enabled.");
				continue;
			}
			if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(in.split(",")[0])) == null) {
				EasyPickings.LOGGER.error("Reference to nonexistent block '" + in.split(",")[0] + "' in Imbued Fire configuration: " + in);
				continue;
			}
			IBlockState key = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(in.split(",")[0])).getDefaultState();
			if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(in.split(",")[1])) == null) {
				EasyPickings.LOGGER.error("Reference to nonexistent block '" + in.split(",")[1] + "' in Imbued Fire configuration: " + in);
				continue;
			}
			IBlockState val = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(in.split(",")[1])).getDefaultState();
			setTransform(key, val);
		}
		
	}
		
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		if (!worldIn.getGameRules().getBoolean("extinguishImbuedFires")){
			if (worldIn.getGameRules().getBoolean("doFireTick")){
				if (worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.AIR) || worldIn.getBlockState(pos.down()).getBlock() instanceof ImbuedFireBase) worldIn.setBlockToAir(pos);
				if (worldIn.rand.nextInt(5) == 0) transformBlock(worldIn, pos.down());
				if (isTransformed(worldIn.getBlockState(pos.down()).getBlock().getDefaultState()) && worldIn.rand.nextInt(1) == 0 ) worldIn.setBlockToAir(pos); 
				trySpread(worldIn, pos, 5);
				if (worldIn.rand.nextInt(6) == 0) worldIn.setBlockToAir(pos);
			}
		}else {
			worldIn.setBlockToAir(pos);
		}
    }
	
	private void trySpread(World world, BlockPos pos, Integer iterations){
		for (int i = 1; i < iterations; i++){
			trySpread(world, pos);
		}
	}
	
	private void trySpread(World world, BlockPos pos){
		BlockPos tt = pos.add(world.rand.nextInt(4) - 2, world.rand.nextInt(4) - 2, world.rand.nextInt(4) - 2);
		if (world.getBlockState(tt.down()).getBlock() != Blocks.AIR && !(world.getBlockState(tt.down()).getBlock() instanceof ImbuedFireBase)){
			world.getBlockState(tt.down()).getBlock();
			Blocks.AIR.getDefaultState().getBlock();
			
			if (world.getBlockState(tt).getBlock().equals(Blocks.AIR)){
				world.setBlockState(tt, this.getDefaultState());
				transformBlock(world, pos.down());
			}
		}
	}

	
	public boolean isCollidable()
    {
        return false;
    }
	
	
	public abstract HashMap<IBlockState, IBlockState> getTransformations();
	
	public boolean canTransform(IBlockState toTransform){
		return getTransformations().containsKey(toTransform);
	}
	
	public boolean isTransformed(IBlockState toTransform){
		return getTransformations().containsValue(toTransform);
	}
	
	private void transformBlock(World world, BlockPos pos){
		if (/*getTransformations() == null ||*/ getTransformations().get(world.getBlockState(pos).getBlock().getDefaultState()) == null) return;
		world.setBlockState(pos, getTransformations().get(world.getBlockState(pos).getBlock().getDefaultState()));
	}
	
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	public int tickRate(World w) {
		//Set to 1 for supersonicfire
		
		return 1;
	}
	
	@Override
	public int getLightOpacity(IBlockState state, IBlockAccess world, BlockPos pos) {
		return 0;
	}
	
	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
		return colourMultiplier();
	}
	
	public int colourMultiplier(){
		return getFireType().getColourMultiplier();
	}
	
}
