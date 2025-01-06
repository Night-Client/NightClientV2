package booogyboooo.nightclientv2.modules.misc;

import booogyboooo.nightclientv2.NightClientV2;
import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;

public class Test extends Module implements ModuleEvents {

	public Test() {
		super(Type.Misc, "Test", "1", Key.NONE.key());
		this.addMode("1");
		this.addMode("2");
	}
	
	@Override
	public void modeChange(String mode) {
		NightClientV2.LOGGER.info(mode);
	}
}