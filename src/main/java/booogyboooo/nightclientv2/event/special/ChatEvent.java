package booogyboooo.nightclientv2.event.special;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventType;

public class ChatEvent extends Event {

	private String message;
	
	public ChatEvent(String message) {
		super(true, EventType.Type.onchat);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}