package booogyboooo.nightclientv2.ui.components;

public class TextBox {
	public int startX;
	public int startY;
	public int endX;
	public int endY;
	private String value;
	private boolean focused;
	private boolean focusable;
	private int maxLen;
	
	public TextBox(int sx, int sy, int ex, int ey, String defaultText, boolean focused, boolean focusable, int maxLen) {
		this.startX = sx;
		this.startY = sy;
		this.endX = ex;
		this.endY = ey;
		this.value = defaultText;
		this.focused = focused;
		this.focusable = focusable;
		this.maxLen = maxLen;
	}
	
	public void sendKey(String key) {
		if (!this.focused || this.value.length() >= this.maxLen) {
			return;
		}
		
		this.value += key;
	}
	
	public void backspace() {
		if (this.value.isEmpty() || !this.focused) {
			return;
		}
		this.value = this.value.substring(0, this.value.length() - 1);
	}
	
	public boolean withinTextBox(double mouseX, double mouseY) {
		if (this.startX < mouseX && this.endX > mouseX && this.startY < mouseY && this.endY > mouseY) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setFocused(boolean focused) {
		if (!this.focusable) {
			return;
		}
		this.focused = focused;
	}

	public String getValue() {
		return this.value;
	}
	
	public void setBounds(int sx, int sy, int ex, int ey) {
		this.startX = sx;
		this.startY = sy;
		this.endX = ex;
		this.endY = ey;
	}
	
	public boolean isFocused() {
		return this.focused;
	}
}