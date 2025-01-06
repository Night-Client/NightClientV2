package booogyboooo.nightclientv2.ui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import booogyboooo.nightclientv2.ui.components.TextBox;
import booogyboooo.nightclientv2.ui.util.Renderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ThemeUI extends Screen {
	
	private List<TextBox> boxes = new ArrayList<TextBox>();
	private List<String> validChars = new ArrayList<String>(26);
	
    public ThemeUI() {
        super(Text.of("ThemeUI"));
        validChars.add("a");
        validChars.add("b");
        validChars.add("c");
        validChars.add("d");
        validChars.add("e");
        validChars.add("f");
        validChars.add("g");
        validChars.add("h");
        validChars.add("i");
        validChars.add("j");
        validChars.add("k");
        validChars.add("l");
        validChars.add("m");
        validChars.add("n");
        validChars.add("o");
        validChars.add("p");
        validChars.add("q");
        validChars.add("r");
        validChars.add("s");
        validChars.add("t");
        validChars.add("u");
        validChars.add("v");
        validChars.add("w");
        validChars.add("x");
        validChars.add("y");
        validChars.add("z");
        boxes.add(new TextBox(10, 10, 110, 60, "", false, true, 8));
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
    
    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        super.render(drawContext, mouseX, mouseY, delta);
        boxes.forEach(box -> {
            Renderer.drawTextBox(box, drawContext, textRenderer);
        });
    }
    
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
    	String key = KeyEvent.getKeyText(keyCode);
    	boxes.forEach(box -> {
    		if (box.isFocused() && key == "Japanese Katakana") {
    			box.backspace();
    		}
    	});
    	if (!validChars.contains(key.toLowerCase())) {
    		return super.keyPressed(keyCode, scanCode, modifiers);
    	}
    	boxes.forEach(box -> {
    		if (box.isFocused()) {
    			box.sendKey(key);
    		}
    	});
    	return super.keyPressed(keyCode, scanCode, modifiers);
    }
    
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
    	if (button == 0) {
    		boxes.forEach(box -> {
    			if (box.withinTextBox(mouseX, mouseY)) {
    				box.setFocused(true);
    			} else {
    				box.setFocused(false);
    			}
    		});
    	}
    	
    	return super.mouseClicked(mouseX, mouseY, button);
    }
    
}
