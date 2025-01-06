package booogyboooo.nightclientv2.cmds;

import java.util.List;

import booogyboooo.nightclientv2.cmd.CommandManger;
import booogyboooo.nightclientv2.cmd.components.Command;
import booogyboooo.nightclientv2.util.ChatUtil;

public class Cmd extends Command {
	
	public Cmd() {
		super("cmd", 0, "Format: .cmd", "shows available commands");
	}
	
	@Override
	public void run(List<String> args) {
		CommandManger.getCommands().forEach(command -> {
			ChatUtil.addToChat("." + command.getName() + " - " + command.getDesc());
		});
	}
	
}
