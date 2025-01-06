package booogyboooo.nightclientv2.events.chat;

import booogyboooo.nightclientv2.cmd.CommandManger;
import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventListner;
import booogyboooo.nightclientv2.event.EventType.Type;
import booogyboooo.nightclientv2.event.module.ModuleEventList;
import booogyboooo.nightclientv2.event.special.ChatEvent;

public class ChatEventListener extends EventListner {
	public ChatEventListener() {
		super(Type.onchat);
	}
	
	@Override
	public void run(Event event) {
		ChatEvent cevent = (ChatEvent) event;
		CommandManger.proccessEvent(cevent);
		ModuleEventList.list.forEach(module -> {
			module.onChat(cevent);
		});
	}
}
