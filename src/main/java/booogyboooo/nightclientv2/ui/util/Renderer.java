package booogyboooo.nightclientv2.ui.util;

import java.awt.Color;
import java.util.HashMap;

import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.ui.components.Button;
import booogyboooo.nightclientv2.ui.components.TextBox;
import booogyboooo.nightclientv2.ui.data.ButtonList;
import booogyboooo.nightclientv2.ui.data.TitleList;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class Renderer {
	private static int titlesDrawn = 0;
	private static HashMap<String, Integer> modulesDrawn = new HashMap<String, Integer>();
	
	/**
	 * Used to draw a title
	 * <br>
	 * - drawTitle(title, drawContext, textRenderer)
	 * <br>
	 * <br>
	 * title
	 * <br>
	 * - title of module to render
	 * <br>
	 * <br>
	 * drawContext
	 * <br>
	 * - DrawContext object
	 * <br>
	 * <br>
	 * textRenderer
	 * <br>
	 * - TextRenderer object
	 * 
	 */
	public static void drawTitle(String title, DrawContext drawContext, TextRenderer textRenderer) {
        int buttonX = (titlesDrawn + 1) * 125;
        int buttonY = 20;
        int buttonWidth = 100;
        int buttonHeight = 40;
        drawContext.fill(buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, Color.black.getRGB());
        
        int textX = buttonX + (buttonWidth - textRenderer.getWidth(title)) / 2;
        int textY = buttonY + (buttonHeight - textRenderer.fontHeight) / 2;
        
        drawContext.drawText(textRenderer, title, textX, textY, Color.red.getRGB(), false);
        
        modulesDrawn.put(title, 0);
        titlesDrawn++;
	}
	
	/**
	 * Used to draw a title
	 * <br>
	 * - drawTitle(title, drawContext, textRenderer, spacingX, spacingY, width, height, boxColor, textColor)
	 * <br>
	 * <br>
	 * title
	 * <br>
	 * - title of module to render
	 * <br>
	 * <br>
	 * drawContext
	 * <br>
	 * - DrawContext object
	 * <br>
	 * <br>
	 * textRenderer
	 * <br>
	 * - TextRenderer object
	 * <br>
	 * <br>
	 * spacingX
	 * <br>
	 * - Space between titles (x)
	 * <br>
	 * <br>
	 * spacingY
	 * <br>
	 * - Space between titles and the top of the screen (y)
	 * <br>
	 * <br>
	 * width
	 * <br>
	 * - Width of title
	 * <br>
	 * <br>
	 * height
	 * <br>
	 * - Height of title
	 * <br>
	 * <br>
	 * boxColor
	 * <br>
	 * - Color of the box
	 * <br>
	 * <br>
	 * textColor
	 * <br>
	 * - Color of the text
	 */
	public static void drawTitle(String title, DrawContext drawContext, TextRenderer textRenderer, int spacingX, int spacingY, int width, int height, int boxColor, int textColor) {
        int buttonX = titlesDrawn * spacingX + 20;
        int buttonY = spacingY;
        int buttonWidth = width;
        int buttonHeight = height;
        drawContext.fill(buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, boxColor);
        
        int textX = buttonX + (buttonWidth - textRenderer.getWidth(title)) / 2;
        int textY = buttonY + (buttonHeight - textRenderer.fontHeight) / 2;
        
        drawContext.drawText(textRenderer, title, textX, textY, textColor, false);
        
        modulesDrawn.put(title, 0);
        titlesDrawn++;
	}
	
	/**
	 * Used to draw a module
	 * <br>
	 * - drawModule(module, drawContext, textRenderer)
	 * <br>
	 * <br>
	 * module
	 * <br>
	 * - module to draw
	 * <br>
	 * <br>
	 * drawContext
	 * <br>
	 * - DrawContext object
	 * <br>
	 * <br>
	 * textRenderer
	 * <br>
	 * - TextRenderer object
	 * 
	 */
	public static void drawModule(Module module, DrawContext drawContext, TextRenderer textRenderer) {
        String title = module.getName();
		int buttonX = (TitleList.getCategorys().indexOf(module.getTitleCategory()) + 1) * 125;
        int buttonY = ((modulesDrawn.get(module.getType().name()) + 1) * 40) + 20;
        int buttonWidth = 100;
        int buttonHeight = 40;
        drawContext.fill(buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, Color.black.getRGB());
        
        if (module.isToggled()) {
        	drawContext.fill(buttonX, buttonY, buttonX + buttonWidth, buttonY + 1, Color.blue.getRGB());
        	drawContext.fill(buttonX, buttonY + buttonHeight, buttonX + buttonWidth, buttonY + buttonHeight - 1, Color.blue.getRGB());
        	drawContext.fill(buttonX, buttonY, buttonX + 1, buttonY + buttonHeight, Color.blue.getRGB());
        	drawContext.fill(buttonX + buttonWidth, buttonY, buttonX + buttonWidth - 1, buttonY + buttonHeight, Color.blue.getRGB());
        } else {
        	drawContext.fill(buttonX, buttonY, buttonX + buttonWidth, buttonY + 1, Color.red.getRGB());
        	drawContext.fill(buttonX, buttonY + buttonHeight, buttonX + buttonWidth, buttonY + buttonHeight - 1, Color.red.getRGB());
        	drawContext.fill(buttonX, buttonY, buttonX + 1, buttonY + buttonHeight, Color.red.getRGB());
        	drawContext.fill(buttonX + buttonWidth, buttonY, buttonX + buttonWidth - 1, buttonY + buttonHeight, Color.red.getRGB());
        }
        
        int textX = buttonX + (buttonWidth - textRenderer.getWidth(title)) / 2;
        int textY = buttonY + (buttonHeight - textRenderer.fontHeight) / 2 - 7;
        
        int modeX = buttonX + (buttonWidth - textRenderer.getWidth(module.getMode())) / 2;
        int modeY = buttonY + (buttonHeight - textRenderer.fontHeight) / 2 + 7;
        
        if (module.isToggled()) {
        	drawContext.drawText(textRenderer, title, textX, textY, Color.blue.getRGB(), false);
        	drawContext.drawText(textRenderer, module.getMode(), modeX, modeY, new Color(0, 0, 155).getRGB(), false);
        } else {
        	drawContext.drawText(textRenderer, title, textX, textY, Color.red.getRGB(), false);
        	drawContext.drawText(textRenderer, module.getMode(), modeX, modeY, new Color(115, 0, 0).getRGB(), false);
        }
        
        ButtonList.addToList(new Button(buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, module));
        
        modulesDrawn.put(module.getType().name(), (modulesDrawn.get(module.getType().name()) + 1));
	}
	
	/**
	 * Used to draw a module - WIP
	 * <br>
	 * - drawModule(module, drawContext, textRenderer)
	 * <br>
	 * <br>
	 * module
	 * <br>
	 * - module to draw
	 * <br>
	 * <br>
	 * drawContext
	 * <br>
	 * - DrawContext object
	 * <br>
	 * <br>
	 * textRenderer
	 * <br>
	 * - TextRenderer object
	 * 
	 */
	public static void drawModule(Module module, DrawContext drawContext, TextRenderer textRenderer, int spacingX, int spacingY, int width, int height, int boxColor, int textColor, int modeColor, int boxColorEnabled, int textColorEnabled, int modeColorEnabled, int boxFillColor) {
        String title = module.getName();
		int buttonX = (TitleList.getCategorys().indexOf(module.getTitleCategory()) + 1) * spacingX + 20 - spacingX;
        int buttonY = ((modulesDrawn.get(module.getType().name()) + 1) * height) + spacingY;
        int buttonWidth = width;
        int buttonHeight = height;
        drawContext.fill(buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, boxFillColor);
        
        if (module.isToggled()) {
        	drawContext.fill(buttonX, buttonY, buttonX + buttonWidth, buttonY + 1, boxColorEnabled);
        	drawContext.fill(buttonX, buttonY + buttonHeight, buttonX + buttonWidth, buttonY + buttonHeight - 1, boxColorEnabled);
        	drawContext.fill(buttonX, buttonY, buttonX + 1, buttonY + buttonHeight, boxColorEnabled);
        	drawContext.fill(buttonX + buttonWidth, buttonY, buttonX + buttonWidth - 1, buttonY + buttonHeight, boxColorEnabled);
        } else {
        	drawContext.fill(buttonX, buttonY, buttonX + buttonWidth, buttonY + 1, boxColor);
        	drawContext.fill(buttonX, buttonY + buttonHeight, buttonX + buttonWidth, buttonY + buttonHeight - 1, boxColor);
        	drawContext.fill(buttonX, buttonY, buttonX + 1, buttonY + buttonHeight, boxColor);
        	drawContext.fill(buttonX + buttonWidth, buttonY, buttonX + buttonWidth - 1, buttonY + buttonHeight, boxColor);
        }
        
        int textX = buttonX + (buttonWidth - textRenderer.getWidth(title)) / 2;
        int textY = buttonY + (buttonHeight - textRenderer.fontHeight) / 2 - 7;
        
        int modeX = buttonX + (buttonWidth - textRenderer.getWidth(module.getMode())) / 2;
        int modeY = buttonY + (buttonHeight - textRenderer.fontHeight) / 2 + 7;
        
        if (module.isToggled()) {
        	drawContext.drawText(textRenderer, title, textX, textY, textColorEnabled, false);
        	drawContext.drawText(textRenderer, module.getMode(), modeX, modeY, modeColorEnabled, false);
        } else {
        	drawContext.drawText(textRenderer, title, textX, textY, textColor, false);
        	drawContext.drawText(textRenderer, module.getMode(), modeX, modeY, modeColor, false);
        }
        
        ButtonList.addToList(new Button(buttonX, buttonY, buttonX + buttonWidth, buttonY + buttonHeight, module));
        
        modulesDrawn.put(module.getType().name(), (modulesDrawn.get(module.getType().name()) + 1));
	}

	/**
	 * Used to draw a text box
	 * <br> 
	 * - drawTextBox(textBox, drawContext, textRenderer)
	 * <br>
	 * <br>
	 * textBox
	 * <br>
	 * - text box to draw
	 * <br> 
	 * <br>
	 * drawContext
	 * <br> 
	 * - DrawContext object
	 * <br>
	 * <br>
	 * textRenderer
	 * <br> 
	 * - TextRenderer object
	 */
	public static void drawTextBox(TextBox textBox, DrawContext drawContext, TextRenderer textRenderer) {
		String text = textBox.getValue();
        int buttonWidth = textBox.endX - textBox.startX;
        int buttonHeight = textBox.endY - textBox.startY;
        int textX = textBox.startX + (buttonWidth - textRenderer.getWidth(text)) / 2;
        int textY = textBox.startY + (buttonHeight - textRenderer.fontHeight) / 2;
        
		drawContext.fill(textBox.startX, textBox.startY, textBox.endX, textBox.endY, Color.red.getRGB());
		drawContext.fill(textBox.startX + 5, textBox.startY + 5, textBox.endX - 5, textBox.endY - 5, Color.black.getRGB());
		drawContext.drawText(textRenderer, text, textX, textY, Color.red.getRGB(), false);
	}
	
	/**
	 * Used to reset Renderer default varibles
	 * <br>
	 * - reset()
	 * 
	 */
	public static void reset() {
		titlesDrawn = 0;
		ButtonList.clearList();
	}
	
}