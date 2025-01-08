package io.github.cheesecurd.vallhalla.items;

import io.github.cheesecurd.vallhalla.VallHalla;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.gameevent.GameEvent;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Drinkables extends Item
{
	private Item returnItem;
	private String descTag;

	public Drinkables(Properties properties, String descTag)
	{
		super(properties);
		this.descTag = descTag;
		this.returnItem = Items.GLASS_BOTTLE;
	}

	public static FoodProperties createAlcohol(Integer adelhyde, Integer bronson, Integer delta, Integer flan, Integer karmo, Integer effectAmplifier, Integer effectProb, MobEffectInstance[] extraEffects)
	{
		FoodProperties.Builder foodProps = new FoodProperties.Builder()
			.nutrition(0)
			.saturationMod(0)
			.alwaysEat();
		if (adelhyde != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.DIG_SPEED, adelhyde * 160, effectAmplifier), effectProb);
		if (bronson != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, bronson * 160, effectAmplifier), effectProb);
		if (delta != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.WEAKNESS, delta * 160, effectAmplifier), effectProb);
		if (flan != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, flan * 160, effectAmplifier), effectProb);
		if (karmo != 0)
			foodProps.effect(new MobEffectInstance(MobEffects.CONFUSION, karmo * 160, effectAmplifier), effectProb);
		for (MobEffectInstance effectInstance : extraEffects)
		{
			foodProps.effect(effectInstance, effectProb);
		}
		return foodProps.build();
	}

	public void setReturnItem(Item returnItem)
	{
		this.returnItem = returnItem;
	}

	public Item getReturnItem()
	{
		return returnItem;
	}

	// mfw I stole this code from a honey bottle :3
	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		super.finishUsingItem(stack, level, livingEntity);

		if (livingEntity instanceof ServerPlayer serverPlayer) {
			CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
			serverPlayer.awardStat(Stats.ITEM_USED.get(this));
		}

		if (!level.isClientSide) // mfw I hard code this because I don't know how to do this otherwise
		{
			if (this.equals(ModItems.sugar_rush))
			{
				livingEntity.removeEffect(MobEffects.CONFUSION);
			}
			else if (stack.getItem().equals(ModItems.crevice_spike)) {
				livingEntity.removeEffect(MobEffects.CONFUSION);
				livingEntity.removeEffect(MobEffects.POISON);
			}
		}

		// wow, thanks MilkBucketItem.class
		return stack.isEmpty() ? new ItemStack(returnItem) : stack;
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
	public SoundEvent getEatingSound()
	{
		return VallHalla.DRINK_SOUND_EVENT;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {

		tooltipComponents.add(Component.translatable("itemTooltip.vallhalla.drink.description." + descTag).withStyle(ChatFormatting.B LUE));
		super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
	}
}
