package booogyboooo.nightclientv2.modules.render;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class PlayerESP extends Module implements ModuleEvents {
	public PlayerESP() {
		super(Type.Render, "PlayerESP", "PlayerESP", Key.NONE.key());
		this.addMode("Vannila");
	}
	/*
	@Override
	public void onRender() {
		if (!this.isToggled()) {
			return;
		}
		mc.world.getPlayers().forEach(player -> {
			player.getBoundingBox()
		});
	}
	*/
}