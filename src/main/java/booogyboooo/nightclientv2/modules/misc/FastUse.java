package booogyboooo.nightclientv2.modules.misc;

import booogyboooo.nightclientv2.NightClientV2;
import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import net.minecraft.client.MinecraftClient;

public class FastUse extends Module implements ModuleEvents {
	private int targetDelay = 4;
	
	public FastUse() {
		super(Type.Misc, "FastUse", "0 tick(s)", Key.NONE.key());
		this.addMode("0 tick(s)");
		this.addMode("1 tick(s)");
		this.addMode("2 tick(s)");
		this.addMode("3 tick(s)");
	}
	
	@Override
	public void onEnable() {
		if (this.getMode().equals("0 tick(s)")) {
			targetDelay = 0;
		} else if (this.getMode().equals("1 tick(s)")) {
			targetDelay = 1;
		} else if (this.getMode().equals("2 tick(s)")) {
			targetDelay = 2;
		} else if (this.getMode().equals("3 tick(s)")) {
			targetDelay = 3;
		} else {
			NightClientV2.LOGGER.info("no change " + this.getMode());
		}
	}
	
	@Override
	public void preTick() {
		if (!this.isToggled()) {
			return;
		}
		if (MinecraftClient.getInstance().itemUseCooldown > targetDelay) {
			MinecraftClient.getInstance().itemUseCooldown = targetDelay;
		}
	}
	
	@Override
	public void modeChange(String mode) {
		if (mode == "0 tick(s)") {
			targetDelay = 0;
		} else if (mode.equals("1 tick(s)")) {
			targetDelay = 1;
		} else if (mode.equals("2 tick(s)")) {
			targetDelay = 2;
		} else if (mode.equals("3 tick(s)")) {
			targetDelay = 3;
		} else {
			NightClientV2.LOGGER.info("no change " + mode);
		}
	}
	
	@Override
	public void onDisable() {
		MinecraftClient.getInstance().itemUseCooldown = 4;
	}
}