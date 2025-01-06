package booogyboooo.nightclientv2.modules.render;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

@SuppressWarnings("resource")
public class FullBright extends Module implements ModuleEvents {

	public FullBright() {
		super(Type.Render, "FullBright", "NightVision", Key.NONE.key());
		this.addMode("NightVision");
	}
	
	@Override
	public void onEnable() {
		if (MinecraftClient.getInstance().player == null) {
			this.toggle(false);
			return;
		}
		if (this.getMode().equals("NightVision")) {
			MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2147483647, 255));
		}
	}
	
	@Override
	public void onDisable() {
		if (MinecraftClient.getInstance().player == null) {
			return;
		}
		if (this.getMode().equals("NightVision")) {
			MinecraftClient.getInstance().player.removeStatusEffect(StatusEffects.NIGHT_VISION);
		}
	}

	@Override
	public void preTick() {
		if (MinecraftClient.getInstance().player == null) {
			return;
		}
		if (this.getMode().equals("NightVision")) {
			MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2147483647, 255));
		}
	}
	
}