package booogyboooo.nightclientv2.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

/**
 * Move packet util
 */
public class MovePacketUtil {
	
	/**
	 * Send a move packet
	 * <br>
	 * - move(x, y, z, onGround)
	 * <br>
	 * <br>
	 * x
	 * <br>
	 * - X cord
	 * <br>
	 * <br>
	 * y
	 * <br>
	 * - Y cord
	 * <br>
	 * <br>
	 * z
	 * <br>
	 * - b cord
	 * <br>
	 * <br>
	 * onGround
	 * <br>
	 * - is the player be on the ground
	 */
	public static void move(double x, double y, double z, boolean onGround) {
		MinecraftClient client = MinecraftClient.getInstance();
	    if (client.player != null && client.getNetworkHandler() != null) {
	        PlayerMoveC2SPacket.Full packet = new PlayerMoveC2SPacket.Full(x, y, z, client.player.getYaw(), client.player.getPitch(), onGround);
	        client.getNetworkHandler().sendPacket(packet);
	    }
	}
	
	/**
	 * Send a look packet
	 * <br>
	 * - look(yaw, pitch)
	 * <br>
	 * <br>
	 * yaw
	 * <br>
	 * - the yaw to spoof
	 * <br>
	 * <br>
	 * pitch
	 * <br>
	 * - the pitch to spoof
	 */
	public static void look(float yaw, float pitch) {
		MinecraftClient client = MinecraftClient.getInstance();
	    if (client.player != null && client.getNetworkHandler() != null) {
	        PlayerMoveC2SPacket.Full packet = new PlayerMoveC2SPacket.Full(client.player.getX(), client.player.getY(), client.player.getZ(), yaw, pitch, client.player.isOnGround());
	        client.getNetworkHandler().sendPacket(packet);
	    }
	}
	
	/**
	 * Send a on ground packet
	 * <br>
	 * - onGround(onGround)
	 * <br>
	 * <br>
	 * onGround
	 * <br>
	 * - is the player be on the ground
	 */
	public static void onGround(boolean onGround) {
		MinecraftClient client = MinecraftClient.getInstance();
	    if (client.player != null && client.getNetworkHandler() != null) {
	        client.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(onGround));
	    }
	}
}
