package booogyboooo.nightclientv2.events.tick;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventListner;
import booogyboooo.nightclientv2.event.EventType;
import booogyboooo.nightclientv2.event.module.ModuleEventList;

public class PreTickListener extends EventListner {
	public PreTickListener () {
		super(EventType.Type.pretick);
	}
	
	@Override
	public void run(Event event) {
		ModuleEventList.list.forEach(module -> {
			module.preTick();
		});
	}
}