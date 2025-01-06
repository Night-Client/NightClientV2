package booogyboooo.nightclientv2.module;

import java.util.ArrayList;
import java.util.List;

import booogyboooo.nightclientv2.ui.data.TitleList;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

public class Module {
	
	public static MinecraftClient mc = null;
	private boolean isToggled = false;
	private ModuleType.Type type;
	private String name;
	private List<String> modes = new ArrayList<>();
	private String currMode;
	private KeyBinding keyBinding;
	
	public Module(ModuleType.Type type, String name, String firstMode, int defaultBind) {
		this.type = type;
		this.name = name;
		this.currMode = firstMode;
		this.keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("Toggle " + name, defaultBind, "NightClient Modules"));
	}
	
	public KeyBinding getKeyBind() {
		return this.keyBinding;
	}
	
	public void toggle() {
		if (!isToggled) {
			this.isToggled = true;
			onEnable();
		} else {
			this.isToggled = false;
			onDisable();
		}
	}
	
	public void toggle(Boolean enable) {
		if (enable) {
			this.isToggled = true;
			onEnable();
		} else {
			this.isToggled = false;
			onDisable();
		}
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public void modeChange(String mode) {
		
	}
	
	public boolean isToggled() {
		return this.isToggled;
	}
	
	public void setMode(String mode) {
		this.currMode = mode;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ModuleType.Type getType() {
		return this.type;
	}
	
	public TitleList.Categorys getTitleCategory() {
		switch (this.type) {
			case Combat:
				return TitleList.Categorys.Combat;
			case Misc:
				return TitleList.Categorys.Misc;
			case Movement:
				return TitleList.Categorys.Movement;
			case Render:
				return TitleList.Categorys.Render;
			case Exploits:
				return TitleList.Categorys.Exploits;
			default:
				return null;
		}
	}
	
	public void addMode(String name) {
		modes.add(name);
	}
	
	public void removeMode(String name) {
		modes.remove(name);
	}
	
	public String getMode() {
		return currMode;
	}
	
	public void nextMode() {
		if (modes.getLast().equals(currMode)) {
			currMode = modes.getFirst();
			modeChange(currMode);
			return;
		}
		currMode = modes.get(modes.indexOf(currMode) + 1);
		modeChange(currMode);
	}
}