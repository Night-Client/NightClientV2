package booogyboooo.nightclientv2.modules.misc;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.util.Key;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

@SuppressWarnings("resource")
public class FastBreak extends Module implements ModuleEvents {

	public FastBreak() {
		super(Type.Misc, "FastBreak", "Haste I", Key.NONE.key());
		this.addMode("Haste I");
		this.addMode("Haste II");
		this.addMode("Haste III");
	}
	
	@Override
	public void onEnable() {
		if (MinecraftClient.getInstance().player == null) {
			this.toggle(false);
			return;
		}
		if (this.getMode().equals("Haste I")) {
			MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2147483647, 0));
		}
	}
	
	@Override
	public void onDisable() {
		if (MinecraftClient.getInstance().player == null) {
			return;
		}
		if (this.getMode().equals("Haste I") || this.getMode().equals("Haste II") || this.getMode().equals("Haste III")) {
			MinecraftClient.getInstance().player.removeStatusEffect(StatusEffects.HASTE);
		} else if (this.getMode().equals("Haste II")) {
			MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2147483647, 1));
		} else if (this.getMode().equals("Haste III")) {
			MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2147483647, 2));
		}
	}
	
	@Override
	public void preTick() {
		if (MinecraftClient.getInstance().player == null || this.isToggled() == false) {
			return;
		}
		if (this.getMode().equals("Haste I")) {
			MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2147483647, 0));
		} else if (this.getMode().equals("Haste II")) {
			MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2147483647, 1));
		} else if (this.getMode().equals("Haste III")) {
			MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2147483647, 2));
		}
	}
	
}