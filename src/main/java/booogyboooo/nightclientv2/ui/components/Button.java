package booogyboooo.nightclientv2.ui.components;

import booogyboooo.nightclientv2.module.Module;

public class Button {
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private Module module;
	
	public Button(int sx, int sy, int ex, int ey, Module module) {
		this.startX = sx;
		this.startY = sy;
		this.endX = ex;
		this.endY = ey;
		this.module = module;
	}
	
	public boolean withinButton(double mouseX, double mouseY) {
		if (this.startX < mouseX && this.endX > mouseX && this.startY < mouseY && this.endY > mouseY) {
			return true;
		} else {
			return false;
		}
	}
	
	public void click() {
		this.module.toggle();
	}
	
	public void click(Boolean enabled) {
		this.module.toggle(enabled);
	}
	
	public void nextMode() {
		this.module.nextMode();
	}
	
	public int[] getBounds() {
		int[] bound = {this.startX, this.startY, this.endX, this.endY};
		return bound;
	}
}