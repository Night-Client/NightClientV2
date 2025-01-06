package booogyboooo.nightclientv2.events.knockback;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventListner;
import booogyboooo.nightclientv2.event.EventType.Type;
import booogyboooo.nightclientv2.event.module.ModuleEventList;
import booogyboooo.nightclientv2.event.special.KnockbackEvent;

public class KnockbackListener extends EventListner {

	public KnockbackListener() {
		super(Type.onknockback);
	}
	
	@Override
	public void run(Event event) {
		KnockbackEvent kbevent = (KnockbackEvent) event;
		ModuleEventList.list.forEach(module -> {
			module.onKnockback(kbevent);
		});
	}

}
