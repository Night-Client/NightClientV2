package booogyboooo.nightclientv2.event.keypress;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventListner;
import booogyboooo.nightclientv2.event.EventType.Type;
import booogyboooo.nightclientv2.event.module.ModuleEventList;

public class LeftClickListener extends EventListner {
	public LeftClickListener() {
		super(Type.onleftclick);
	}
	
	@Override
	public void run(Event event) {
		ModuleEventList.list.forEach(module -> {
			module.onLeftClick(event);
		});
	}
}
