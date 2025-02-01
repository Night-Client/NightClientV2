package booogyboooo.nightclientv2.modules.movement;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.event.special.KnockbackEvent;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType;
import booogyboooo.nightclientv2.util.Key;

public class AntiKB extends Module implements ModuleEvents {

	public AntiKB() {
		super(ModuleType.Type.Movement, "KBModifier", "0x", Key.NONE.key());
		this.addMode("0x");
		this.addMode("0.5x");
		this.addMode("1.5x");
		this.addMode("2x");
		this.addMode("3x");
	}
	
	@Override
	public void onKnockback(KnockbackEvent event) {
		if (this.isToggled()) {
			if (this.getMode().equals("0x")) {
				event.cancel(event);
			} else if (this.getMode().equals("0.5x")){
				event.modify(event.getX() * 0.5, event.getY(), event.getZ() * 0.5, event);
			} else if (this.getMode().equals("1.5x")){
				event.modify(event.getX() * 1.5, event.getY(), event.getZ() * 1.5, event);
			} else if (this.getMode().equals("2x")){
				event.modify(event.getX() * 2, event.getY(), event.getZ() * 2, event);
			} else if (this.getMode().equals("3x")){
				event.modify(event.getX() * 3, event.getY(), event.getZ() * 3, event);
			}
		}
	}
}
