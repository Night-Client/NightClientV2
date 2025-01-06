package oowst.nightclientv2.modules.movement;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType;
import booogyboooo.nightclientv2.util.Key;
import net.minecraft.client.MinecraftClient;

public class Dash extends Module implements ModuleEvents {

	public Dash() {
		super(ModuleType.Type.Movement, "Dash", "Vannila", Key.NONE.key());
		this.addMode("Vannila");
	}
	
	@Override
	public void onEnable() {
		MinecraftClient mc = MinecraftClient.getInstance();
		double mx = mc.player.getVelocity().x;
		double mz = mc.player.getVelocity().z;
		mc.player.setVelocity(mx * 5, mc.player.getVelocity().y, mz * 5);
		this.toggle();
	}

}
