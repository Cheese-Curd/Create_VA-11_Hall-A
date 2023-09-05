package io.github.cheesecurd.vallhalla;

import com.simibubi.create.Create;
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;

import io.github.cheesecurd.vallhalla.items.ModItems;
import static io.github.cheesecurd.vallhalla.items.ModItems.registerItems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VallHalla implements ModInitializer {
	public static final String ID = "vallhalla";
	public static final String NAME = "VA-11 Hall-A";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	public static final ResourceLocation DRINK_SOUND_ID = new ResourceLocation("vallhalla:drink_swollow");
	public static final ResourceLocation MONEY_SOUND_ID = new ResourceLocation("vallhalla:money");
	public static SoundEvent DRINK_SOUND_EVENT = new SoundEvent(DRINK_SOUND_ID);
	public static SoundEvent MONEY_SOUND_EVENT = new SoundEvent(MONEY_SOUND_ID);

	public static final CreativeModeTab VALLHALLA_TAB = FabricItemGroupBuilder.create(new ResourceLocation("vallhalla", "vallhalla_tab"))
			.icon(() -> new ItemStack(ModItems.shaker_icon))
			.build();

	public static void logVMessage(String Char, String message)
	{
		int totalLength = 0;
		totalLength += Char != "" ? Char.length() + 2 : 0; // I refuse to use !equals(), fuck you
		totalLength += 2 + message.length();

		LOGGER.info("+" + "=".repeat(totalLength) + "+");
		if (Char != "")
			LOGGER.info("| " + Char +": " + message + " |");
		else
			LOGGER.info("| " + message + " |");
		LOGGER.info("+" + "=".repeat(totalLength) + "+");
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);

		LOGGER.info("+=============Mod Loaded===============+");
		LOGGER.info("| Time to mix drinks and change lives. |");
		LOGGER.info("+======================================+");

		// Registering
		registerItems();
		Registry.register(Registry.SOUND_EVENT, DRINK_SOUND_ID, DRINK_SOUND_EVENT);
		Registry.register(Registry.SOUND_EVENT, MONEY_SOUND_ID, MONEY_SOUND_EVENT);
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
