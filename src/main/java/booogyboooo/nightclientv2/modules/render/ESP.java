package booogyboooo.nightclientv2.modules.render;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.RenderUtil;
import net.minecraft.entity.EntityType;

public class ESP extends Module implements ModuleEvents {
	public ESP() {
		super(Type.Render, "ESP", "Player", Key.NONE.key());
		this.addMode("Player");
	}

	@Override
	public void onEnable() {
		RenderUtil.addEntity(EntityType.PLAYER);
	}

	@Override
	public void onDisable() {
		RenderUtil.removeEntity(EntityType.PLAYER);
	}
}