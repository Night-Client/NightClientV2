package booogyboooo.nightclientv2.event.module;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.special.ChatEvent;
import booogyboooo.nightclientv2.event.special.KnockbackEvent;
import booogyboooo.nightclientv2.event.special.RenderEvent;

public interface ModuleEvents {
	public default void onKnockback(KnockbackEvent event) {
		
	}
	
	public default void preTick() {
		
	}
	
	public default void postTick() {
		
	}
	
	public default void onChat(ChatEvent event) {
		
	}
	
	public default void onAttemptBlockPlace(Event event) {
		
	}
	
	public default void onLeftClick(Event event) {
		
	}
	
	public default void onRender(RenderEvent event) {
		
	}
}