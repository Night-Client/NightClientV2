package booogyboooo.nightclientv2.cmds;

import java.util.List;

import booogyboooo.nightclientv2.cmd.components.Command;

public class TP extends Command {

	public TP() {
		super("tp", 3, "Format: .tp <x> <y> <z>", "teleport somewhere");
	}
	
	@Override
	public void run(List<String> args) {
		mc.player.setPos(Double.valueOf(args.get(1)), Double.valueOf(args.get(2)), Double.valueOf(args.get(3)));
	}

}