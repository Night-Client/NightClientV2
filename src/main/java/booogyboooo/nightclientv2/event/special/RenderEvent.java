package booogyboooo.nightclientv2.event.special;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventType;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;

public class RenderEvent extends Event {
	
	public WorldRenderContext context;
	
	public RenderEvent(WorldRenderContext context) {
		super(false, EventType.Type.render);
		this.context = context;
	}
	
	public WorldRenderContext getContext() {
		return this.context;	
	}

}