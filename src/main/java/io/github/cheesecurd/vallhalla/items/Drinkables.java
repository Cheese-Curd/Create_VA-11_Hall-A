package io.github.cheesecurd.vallhalla.items;

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

	public static FoodProperties createAlcohol(Integer effectTime, Integer effectAmplifier, Integer effectProb /*, MobEffectInstance[] extraEffects */)
	{
		FoodProperties.Builder foodProps = new FoodProperties.Builder()
				.nutrition(0)
				.saturationMod(0)
				.alwaysEat()
				.effect(new MobEffectInstance(MobEffects.CONFUSION, effectTime, effectAmplifier), effectProb);
//		for (MobEffectInstance effectInstance : extraEffects)
//		{
//			foodProps.effect(effectInstance, effectProb);
//		}
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
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity)
	{
		super.finishUsingItem(stack, level, livingEntity);
		if (livingEntity instanceof ServerPlayer serverPlayer) {
			CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
			serverPlayer.awardStat(Stats.ITEM_USED.get(this));
		}

		if (stack.isEmpty()) {
			return returnItem;
		} else {
			if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
				ItemStack itemStack = returnItem;
				Player player = (Player)livingEntity;
				if (!player.getInventory().add(itemStack)) {
					player.drop(itemStack, false);
				}
			}

			return stack;
		}
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
