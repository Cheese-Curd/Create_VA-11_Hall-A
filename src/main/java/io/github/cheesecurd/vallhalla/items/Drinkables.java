package io.github.cheesecurd.vallhalla.items;

import io.github.cheesecurd.vallhalla.VallHalla;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class Drinkables extends Item
{
	private ItemStack returnItem;

	public Drinkables(Properties properties)
	{
		super(properties);
		this.returnItem = new ItemStack(Items.GLASS_BOTTLE);
	}

	public static FoodProperties createAlcohol(Integer adelhyde, Integer bronson, Integer delta, Integer flan, Integer karmo, Integer effectAmplifier, Integer effectProb, MobEffectInstance[] extraEffects)
	{
		FoodProperties.Builder foodProps = new FoodProperties.Builder()
			.nutrition(0)
			.saturationMod(0)
			.alwaysEat();
		if (adelhyde != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.DIG_SPEED, adelhyde * 20, effectAmplifier), effectProb);
		if (bronson != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, bronson * 20, effectAmplifier), effectProb);
		if (delta != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.WEAKNESS, delta * 20, effectAmplifier), effectProb);
		if (flan != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, flan * 20, effectAmplifier), effectProb);
		if (karmo != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.CONFUSION, karmo * 20, effectAmplifier), effectProb);
		for (MobEffectInstance effectInstance : extraEffects)
		{
			foodProps.effect(effectInstance, effectProb);
		}
		return foodProps.build();
	}

	public void setReturnItem(ItemStack returnItem)
	{
		this.returnItem = returnItem;
	}

	public ItemStack getReturnItem()
	{
		return returnItem;
	}

	// mfw I stole this code from a honey bottle :3
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		super.finishUsingItem(stack, level, livingEntity);
		if (livingEntity instanceof ServerPlayer serverPlayer) {
			CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
			serverPlayer.awardStat(Stats.ITEM_USED.get(this));
		}

		if (!level.isClientSide) // mfw I hard code this because I don't know how to do this otherwise
		{
			if (stack.getItem().equals(ModItems.sugar_rush))
			{
				livingEntity.removeEffect(MobEffects.CONFUSION);
			}
			else if (stack.getItem().equals(ModItems.crevice_spike)) {
				livingEntity.removeEffect(MobEffects.CONFUSION);
				livingEntity.removeEffect(MobEffects.POISON);
			}
		}


		VallHalla.logVMessage("Eliana", "You just drank out of a " + getReturnItem() + ".");

		// wow, thanks MilkBucketItem.class
		return stack.isEmpty() ? returnItem : stack;
	}

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
