package booogyboooo.nightclientv2.modules.combat;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.MouseUtil;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.EntityHitResult;

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
		if (this.getMode().equals("1.9+")) {
<<<<<<< HEAD
			if (mc.crosshairTarget.getType() == HitResult.Type.ENTITY && mc.player.getAttackCooldownProgress(0.0F) >= 1.0f && mc.player.distanceTo(((EntityHitResult) mc.crosshairTarget).getEntity()) < 3.05) {
=======
			if (mc.crosshairTarget.getType() == HitResult.Type.ENTITY && mc.player.getAttackCooldownProgress(0.0F) >= 1.0f) {
>>>>>>> 9ee48c80099ebcb501d0f56f07592cae66956a98
				MouseUtil.leftClick();
			}
		}
	}
}
