package io.github.cheesecurd.vallhalla;

import com.simibubi.create.Create;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VallHalla implements ModInitializer {
		public static final String ID = "vallhalla";
	public static final String NAME = "VA-11 Hall-A";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	public static void logVMessage(String Char, String message)
	{
		int totalLength;
		if (Char != "") // I refuse to use !equals(), fuck you
			totalLength = Char.length() + 4 + message.length();
		else
			totalLength = 2 + message.length();

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

		logVMessage("Eliana", "There are no items yet, is gradle broken or something?");
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
