package booogyboooo.nightclientv2.modules.movement;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.MovePacketUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

public class Flight extends Module implements ModuleEvents {

	private boolean canFlyFirst = false;
	private boolean wasFlyFirst = false;
	MinecraftClient client = MinecraftClient.getInstance();
	ClientPlayerEntity player;
	
	private int yLevel;
	private int jumps;
	
	public Flight() {
		super(Type.Movement, "Flight", "Vannila", Key.NONE.key());
		this.addMode("Vannila");
		this.addMode("Fireball");
		this.addMode("AirHop");
	}
	
	@Override
	public void onEnable() {
		this.player = client.player;
		this.canFlyFirst = this.player.getAbilities().allowFlying;
		this.wasFlyFirst = this.player.getAbilities().flying;
		if (this.getMode().equals("Vannila")) {
			this.player.getAbilities().allowFlying = true;
		}
		yLevel = this.player.getBlockY();
		this.jumps = 0;
	}
	
	@Override
	public void postTick() {
		if (!this.isToggled()) {
			return;
		}
		if (this.getMode().equals("Fireball")) {
			if(this.player.getVelocity().getY() < -0.55) {
				MovePacketUtil.onGround(true);
				this.player.jump();
				this.jumps++;
				if (this.jumps > 2) {
					this.toggle();
				}
				this.player.setVelocity(this.player.getVelocity().getX() * 0.7, this.player.getVelocity().getY(), this.player.getVelocity().getZ() * 0.7);
			}
		} else if (this.getMode().equals("AirHop")) {
			if(this.player.getY() < yLevel + 0.15) {
				MovePacketUtil.onGround(true);
				this.player.jump();
			}
		}
	}
	
	@Override
	public void onDisable() {
		this.player.getAbilities().allowFlying = this.canFlyFirst;
		this.player.getAbilities().flying = this.wasFlyFirst;
	}

}