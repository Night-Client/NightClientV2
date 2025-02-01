package booogyboooo.nightclientv2.event;

public class EventType {
	public enum Type {
		render, pretick, posttick, onknockback, onchat, onattemptblockplaced, onleftclick
	}
	
	public static Type[] getTypes() {
		return Type.values();
	}
}