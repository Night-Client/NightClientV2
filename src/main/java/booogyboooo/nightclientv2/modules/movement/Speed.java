package booogyboooo.nightclientv2.modules.movement;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

public class Speed extends Module implements ModuleEvents {

	MinecraftClient client = MinecraftClient.getInstance();
	ClientPlayerEntity player;
	
	public Speed() {
		super(Type.Movement, "Speed", "Legit", Key.NONE.key());
		this.addMode("Legit");
		this.addMode("Vannila");
		this.addMode("Vannila 2");
	}
	
	@Override
	public void onEnable() {
		this.player = client.player;
	}
	
	@Override
	public void postTick() {
		if (this.isToggled()) {
			if (this.getMode().equals("Vannila")) {
				if (this.player.getVelocity().getX() > 2 || this.player.getVelocity().getX() < -2 || this.player.getVelocity().getZ() > 2 || this.player.getVelocity().getZ() < -2) {
					return;
				}
				this.player.setVelocity(this.player.getVelocity().getX() * 1.2, this.player.getVelocity().getY(), this.player.getVelocity().getZ() * 1.2);
			} else if (this.getMode().equals("Legit")) {
				if (this.player.isOnGround()) {
					this.player.jump();
				}
				this.player.setSprinting(true);
			} else if (this.getMode().equals("Vannila 2")) {
				this.player.setSprinting(true);
				if (this.player.isOnGround()) {
					this.player.jump();
					return;
				}
				double xVelo = this.player.getVelocity().getX() / 5;
				double zVelo = this.player.getVelocity().getZ() / 5;
				this.player.setVelocity(this.player.getVelocity().add(xVelo, -0.2, zVelo));
			}
		}
	}
	
}
