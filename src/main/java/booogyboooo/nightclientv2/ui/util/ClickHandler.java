package booogyboooo.nightclientv2.ui.util;

import booogyboooo.nightclientv2.ui.data.ButtonList;

public class ClickHandler {
	
	/**
	 * Called on mouse click
	 * <br>
	 * - handle(mouseX, mouseY, buttonPressed)
	 * <br>
	 * <br>
	 * buttonPressed
	 * <br>
	 * - 0 Left click
	 * <br>
	 * - 1 Right click
	 * <br>
	 * - 2 Middle click
	 * <br>
	 * <br>
	 * mouseX
	 * <br>
	 * - Mouses X pos
	 * <br>
	 * <br>
	 * mouseY
	 * <br>
	 * - Mouses Y pos
	 */
	public static void handle(double mouseX, double mouseY, double buttonPressed) {
		ButtonList.getList().forEach(button -> {
			if(button.withinButton(mouseX, mouseY)) {
				if (buttonPressed == 0) {
					button.click();
				}
				if (buttonPressed == 2) {
					button.nextMode();
				}
			}
		});
	}
	
}