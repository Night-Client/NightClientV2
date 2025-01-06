package booogyboooo.nightclientv2.events.block;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventListner;
import booogyboooo.nightclientv2.event.EventType.Type;
import booogyboooo.nightclientv2.event.module.ModuleEventList;

public class AttemptBlockPlaceListener extends EventListner {

	public AttemptBlockPlaceListener() {
		super(Type.onattemptblockplaced);
	}
	
	@Override
	public void run(Event event) {
		ModuleEventList.list.forEach(module -> {
			module.onAttemptBlockPlace(event);
		});
	}

}
