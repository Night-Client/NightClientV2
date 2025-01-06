package booogyboooo.nightclientv2.cmd;

import booogyboooo.nightclientv2.event.special.ChatEvent;
import booogyboooo.nightclientv2.util.ClassUtil;
import booogyboooo.nightclientv2.cmd.components.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandManger {
	private static List<Command> commands = new ArrayList<Command>();
	
	public static void proccessEvent(ChatEvent event) {
		if (commands.get(0) == null || commands.size() < 1) {
			return;
		}
		String msg = event.getMessage();
		if (msg.startsWith(".")) {
			event.cancel(event);
			List<String> parts = ClassUtil.arrToList(msg.split(" "));
			commands.forEach(command -> {
				if (parts.get(0).equals("." + command.getName())) {
					List<String> args = ClassUtil.arrToList(msg.split(" "));
					if ((command.getArgAmt() + 1) != args.size()) {
						command.callError();
						return;
					}
					command.run(args);
				}
			});
		}
	}
	
	public static void registerCmd(Command cmd) {
		commands.add(cmd);
	}
	
	public static List<Command> getCommands() {
		return commands;
	}
}