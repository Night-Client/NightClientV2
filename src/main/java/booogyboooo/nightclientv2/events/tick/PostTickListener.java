package booogyboooo.nightclientv2.events.tick;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventListner;
import booogyboooo.nightclientv2.event.EventType;
import booogyboooo.nightclientv2.event.module.ModuleEventList;

public class PostTickListener extends EventListner {
	public PostTickListener () {
		super(EventType.Type.posttick);
	}
	
	@Override
	public void run(Event event) {
		ModuleEventList.list.forEach(module -> {
			module.postTick();
		});
	}
}