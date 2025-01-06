package booogyboooo.nightclientv2.modules.misc;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.MovePacketUtil;

public class NoFall extends Module implements ModuleEvents {

	public NoFall() {
		super(Type.Misc, "NoFall", "Vannila", Key.NONE.key());
		this.addMode("Vannila");
	}
	
	@Override
	public void preTick() {
		if (!this.isToggled()) {
			return;
		}
		MovePacketUtil.onGround(true);
	}

}