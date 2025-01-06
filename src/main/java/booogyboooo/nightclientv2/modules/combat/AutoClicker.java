package booogyboooo.nightclientv2.modules.combat;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.MouseUtil;
import net.minecraft.util.hit.HitResult;

public class AutoClicker extends Module implements ModuleEvents {
	
	public AutoClicker() {
		super(ModuleType.Type.Combat, "AutoClicker", "1.8", Key.NONE.key());
		this.addMode("1.8");
		this.addMode("1.9+");
		this.addMode("Constant");
	}
	
	@Override
	public void preTick() {
		if (!this.isToggled()) {
			return;
		}
		if (this.getMode().equals("Constant")) {
			if (mc.world != null) {
				MouseUtil.leftClick();
			}
		}
		if (this.getMode().equals("1.8")) { 
			if (mc.crosshairTarget.getType() == HitResult.Type.ENTITY) {
				MouseUtil.leftClick();
			}
		}
		if (this.getMode() == "1.9+") {
			if (mc.crosshairTarget.getType() == HitResult.Type.ENTITY && mc.player.getAttackCooldownProgress(0.0F) >= 1.0f) {
				MouseUtil.leftClick();
			}
		}
	}
}