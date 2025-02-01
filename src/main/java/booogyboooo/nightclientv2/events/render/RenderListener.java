package booogyboooo.nightclientv2.events.render;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventListner;
import booogyboooo.nightclientv2.event.EventType;
import booogyboooo.nightclientv2.event.module.ModuleEventList;
import booogyboooo.nightclientv2.event.special.RenderEvent;

public class RenderListener extends EventListner {
	public RenderListener() {
		super(EventType.Type.render);
	}
	
	@Override
	public void run(Event event) {
		RenderEvent revent = (RenderEvent) event;
		ModuleEventList.list.forEach(module -> {
			module.onRender(revent);
		});
	}
}
