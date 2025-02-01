package booogyboooo.nightclientv2.ui;

import booogyboooo.nightclientv2.ui.data.ModuleList;
import booogyboooo.nightclientv2.ui.data.TitleList;
import booogyboooo.nightclientv2.ui.util.ClickHandler;
import booogyboooo.nightclientv2.ui.util.Renderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class NightUI extends Screen {
	
    public NightUI() {
        super(Text.of("NightUI"));
    }
    
    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        super.render(drawContext, mouseX, mouseY, delta);
		Renderer.reset();
    	TitleList.getCategorys().forEach(category -> {
    		Renderer.drawTitle(category.name(), drawContext, textRenderer);
    	});
    	
    	ModuleList.getList().forEach(module -> {
    		Renderer.drawModule(module, drawContext, textRenderer);
    	});
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
    
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        ClickHandler.handle(mouseX, mouseY, button);
        return super.mouseClicked(mouseX, mouseY, button);
    }

}