package booogyboooo.nightclientv2.event;

import booogyboooo.nightclientv2.NightClientV2;

public class Event {
	public Boolean isCancelable;
	public EventType.Type eventTypes;
	public Boolean isCanceled = false;
	
	public Event(Boolean cancelable, EventType.Type eventType) {
		isCancelable = cancelable;
		eventTypes = eventType;
	}
	
	public void cancel(Event event) {
		if (isCanceled) {
			NightClientV2.LOGGER.warn("Tried to cancel an already canceled event!");
			return;
		}
		
		if (!isCancelable) {
			NightClientV2.LOGGER.warn("Tried to cancel an uncancelable event!");
			return;
		}
		
		event.isCanceled = true;
	}
	
	public EventType.Type getEventType() {
		return eventTypes;
	}
}