package booogyboooo.nightclientv2.modules.misc;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.BlockPlacePacketUtil;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.MovePacketUtil;
import booogyboooo.nightclientv2.util.PlayerPosUtil;

public class NoFall extends Module implements ModuleEvents {

	public NoFall() {
		super(Type.Misc, "NoFall", "Vannila", Key.NONE.key());
		this.addMode("Vannila");
		this.addMode("AirPlace");
	}
	
	@Override
	public void preTick() {
		if (!this.isToggled()) {
			return;
		}
		if (this.getMode().equals("Vannila")) {
			MovePacketUtil.onGround(true);
		}
		if (this.getMode() == "AirPlace") {
			if (mc.player.fallDistance > 2.5) {
				BlockPlacePacketUtil.placeBlockVannila(PlayerPosUtil.getBlockUnderPlayer(mc, true));
			}
		}
	}

}
