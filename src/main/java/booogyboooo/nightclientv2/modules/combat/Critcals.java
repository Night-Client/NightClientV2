package booogyboooo.nightclientv2.modules.combat;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.MovePacketUtil;
import net.minecraft.util.hit.EntityHitResult;

public class Critcals extends Module implements ModuleEvents {

	public Critcals() {
		super(Type.Combat, "Critcals", "Packet", Key.NONE.key());
		this.addMode("Packet");
	}
	
	public void onLeftClick(Event event) {
		if (!(this.isToggled())) {
			return;
		}
		
		if(!(mc.crosshairTarget instanceof EntityHitResult)) {
			return;
		}
		
		if (this.getMode().equals("Packet")) {
			MovePacketUtil.move(mc.player.getX(), mc.player.getY() + 0.0625, mc.player.getZ(), true);
			MovePacketUtil.move(mc.player.getX(), mc.player.getY() + 0, mc.player.getZ(), false);
			MovePacketUtil.move(mc.player.getX(), mc.player.getY() + 1.1e-5, mc.player.getZ(), false);
			MovePacketUtil.move(mc.player.getX(), mc.player.getY() + 0, mc.player.getZ(), false);
		}
	}
	
}
