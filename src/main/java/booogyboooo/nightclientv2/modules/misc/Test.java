package booogyboooo.nightclientv2.modules.misc;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.MoveUtil;

public class Test extends Module implements ModuleEvents {
	
	public Test() {
		super(Type.Misc, "Test", "1", Key.NONE.key());
		this.addMode("1");
		this.addMode("2");
	}
	
	@Override
	public void preTick() {
		if (!this.isToggled()) {
			return;
		}
		mc.player.setVelocity(0, 0, 0);
	}
	
	@Override
	public void postTick() {
		if (!this.isToggled()) {
			return;
		}
		mc.player.setVelocity(0, 0, 0);
		MoveUtil.tp(mc.player.getX(), mc.player.getY(), mc.player.getZ() + 8);
	}
}