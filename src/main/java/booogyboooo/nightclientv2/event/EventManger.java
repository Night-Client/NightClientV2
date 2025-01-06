package booogyboooo.nightclientv2.event;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class EventManger {
	public static HashMap<EventType.Type, Collection<EventListner>> listeners = new HashMap<EventType.Type, Collection<EventListner>>();

	public static void sendEvent(Event event) {
		if (listeners.get(event.getEventType()) == null) {
			return;
		}
		listeners.get(event.getEventType()).forEach(listener -> {
			listener.run(event);
		});;
	}
	
	public static void registerEvent(EventListner listener) {
		Collection<EventListner> currentListeners;
		if (listeners.get(listener.getType()) == null) {
			currentListeners = new HashSet<EventListner>();
		} else {
			currentListeners = listeners.get(listener.getType());
		}
		currentListeners.add(listener);
		listeners.put(listener.getType(), currentListeners);
	}
}