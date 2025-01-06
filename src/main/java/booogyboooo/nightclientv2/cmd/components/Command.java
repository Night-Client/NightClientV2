package booogyboooo.nightclientv2.cmd.components;

import java.awt.Color;
import java.util.List;

import booogyboooo.nightclientv2.util.ChatUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;

public class Command {
	public static MinecraftClient mc = null;
	private String name;
	private int argAmt;
	private String errorMsg;
	private String desc;
	
	public Command(String name, int args, String errorMsg, String desc) {
		this.name = name;
		this.argAmt = args;
		this.errorMsg = errorMsg;
		this.desc = desc;
	}
	
	public void run(List<String> args) {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getArgAmt() {
		return this.argAmt;
	}
	
	public String getErrorMsg() {
		return this.errorMsg;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public void callError() {
		ChatUtil.addToChat(Text.literal(this.errorMsg).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(Color.RED.getRGB()))));
	}
}