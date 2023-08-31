package io.github.cheesecurd.vallhalla.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class Drinkables extends Item
{
	public Drinkables(Properties properties)
	{
		super(properties);
	}

	public static final FoodProperties generic_alcohol = new FoodProperties.Builder().nutrition(0).saturationMod(0).build();

	@Override
	public int getUseDuration(ItemStack stack)
	{
			return 40;
	}
	@Override
	public UseAnim getUseAnimation(ItemStack stack)
	{
		return UseAnim.DRINK;
	}
	@Override
	public SoundEvent getDrinkingSound()
	{

		return SoundEvents.GENERIC_DRINK;
	}
	@Override
	public SoundEvent getEatingSound()
	{
		return SoundEvents.GENERIC_DRINK;
	}
}
