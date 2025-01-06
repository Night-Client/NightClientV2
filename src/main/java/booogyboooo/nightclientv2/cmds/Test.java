package booogyboooo.nightclientv2.cmds;

import java.util.List;

import booogyboooo.nightclientv2.cmd.components.Command;

public class Test extends Command {

	public Test() {
		super("test", 0, "Format: .test", "test command");
	}
	
	@Override
	public void run(List<String> args) {
		mc.player.addVelocity(0, 10, 0);
	}

}