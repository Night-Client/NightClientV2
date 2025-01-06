package booogyboooo.nightclientv2.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;

/**
 * Util for chat hud
 */
public class ChatUtil {
	/**
	 * Add to message to chat
	 * <br>
	 * - addToChat(msg)
	 * <br>
	 * <br>
	 * msg
	 * <br>
	 * - A String object as a message
	 */
	public static void addToChat(String msg) {
		MinecraftClient mc = MinecraftClient.getInstance();
		ChatHud hud = mc.inGameHud.getChatHud();
		hud.addMessage(Text.of(msg));
	}
	
	/**
	 * Add to message to chat
	 * <br>
	 * - addToChat(msg)
	 * <br>
	 * <br>
	 * msg
	 * <br>
	 * - A Text object as a message
	 */
	public static void addToChat(Text msg) {
		MinecraftClient mc = MinecraftClient.getInstance();
		ChatHud hud = mc.inGameHud.getChatHud();
		hud.addMessage(msg);
	}
}