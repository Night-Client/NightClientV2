package booogyboooo.nightclientv2.event;

public class EventListner {
	public EventType.Type type;
	
	public EventListner (EventType.Type type) {
		this.type = type;
	}
	
	public EventType.Type getType() {
		return type;
	}
	
	public void run(Event event) {
		
	}
}