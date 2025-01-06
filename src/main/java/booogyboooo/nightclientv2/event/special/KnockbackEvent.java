package booogyboooo.nightclientv2.event.special;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventType;

public class KnockbackEvent extends Event {
	
	public double x;
	public double y;
	public double z;
	
	public KnockbackEvent(double x, double y, double z) {
		super(true, EventType.Type.onknockback);
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}
	
	public void modify(double x, double y, double z, KnockbackEvent event) {
		event.x = x;
		event.y = y;
		event.z = z;
	}

}