package com.headfishindustries.easypickings.items.armour.obsidian;

import javax.annotation.Nonnull;

import com.headfishindustries.easypickings.EasyPickings;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemObsidianArmour extends ItemArmor implements ISpecialArmor{
	
	public static final ArmorMaterial obsidianArmourMaterial = EnumHelper.addArmorMaterial("OBSIDIAN", "obsidian", 10, new int[] {10, 10, 10, 10}, 5, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 4);


	public ItemObsidianArmour(EntityEquipmentSlot slot, String name) {
		this(slot, name, obsidianArmourMaterial);
	}
	
	public ItemObsidianArmour(EntityEquipmentSlot slot, String name, ArmorMaterial type){
		super(type, 0, slot);
		setCreativeTab(CreativeTabs.COMBAT);
		setRegistryName(new ResourceLocation(EasyPickings.MODID, name));
		setUnlocalizedName(name);
	}
	
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, @Nonnull ItemStack armor, DamageSource source, double damage, int slot) {
		return new ArmorProperties(0, damageReduceAmount / 25D, armor.getMaxDamage() + 1 - armor.getItemDamage());

	}
	
	@Override
	public int getArmorDisplay(EntityPlayer player, @Nonnull ItemStack armor, int slot) {
		return damageReduceAmount;
}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		stack.damageItem(damage / 10 + 1 , entity);
		if (stack.getItemDamage() >= stack.getMaxDamage()){
			stack = ItemStack.EMPTY;
		}
	}
	
	@Override
	public void onArmorTick(World w, EntityPlayer p, ItemStack s){
		p.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 7, 3));
		p.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 7, 2));
	}
		
}
