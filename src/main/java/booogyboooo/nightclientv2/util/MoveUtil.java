package booogyboooo.nightclientv2.util;

import booogyboooo.nightclientv2.NightClientV2;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Direction;

/**
 * Move util
 */
public class MoveUtil {
	
	/**
	 * Simpler directions
	 */
	enum NightDirection {
		PostiveX, NegativeX, PostiveY, NegativeY, PostiveZ, NegativeZ
	}
	
	/**
	 * Teleport the player (10 blocks max)
	 * <br>
	 * - tp(x, y, z)\
	 * <br>
	 * <br>
	 * x
	 * <br>
	 * - The x cord
	 * <br>
	 * <br>
	 * y
	 * <br>
	 * - The y cord
	 * <br>
	 * <br>
	 * z
	 * <br>
	 * - The z cord
	 */
	public static void tp(double x, double y, double z) {
		MinecraftClient client = MinecraftClient.getInstance();
		client.player.setPos(x, y, z);
	}
	
	/**
	 * Get the players direction
	 * <br>
	 * - getEnumDirection()
	 */
	public static Direction getEnumDirection() {
		MinecraftClient client = MinecraftClient.getInstance();
		return client.player.getFacing();
	}
	
	/**
	 * Get the "NightDirection"
	 * <br>
	 * - getNightDirection()
	 */
	public static NightDirection getNightDirection() {
		NightClientV2.LOGGER.warn("Called an unimplemented function");
		return null;
	}
}