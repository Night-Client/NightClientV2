package booogyboooo.nightclientv2.ui;

import java.awt.Color;

import booogyboooo.nightclientv2.ui.data.ModuleList;
import booogyboooo.nightclientv2.ui.data.TitleList;
import booogyboooo.nightclientv2.ui.util.ClickHandler;
import booogyboooo.nightclientv2.ui.util.Renderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class NightUIV2 extends Screen {

	private MinecraftClient mc = null;
	
	public NightUIV2() {
		super(Text.of("NightUI"));
		mc = MinecraftClient.getInstance();
	}
    
	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
		super.render(drawContext, mouseX, mouseY, delta);
		Renderer.reset();
		if (mc.options.getGuiScale().getValue() == 3) {
			TitleList.getCategorys().forEach(title -> {
				Renderer.drawTitle(title.name(), drawContext, textRenderer, 95, 20, 80, 30, 0x80000000, Color.GRAY.getRGB());
			});
			ModuleList.getList().forEach(module -> {
				Renderer.drawModule(module, drawContext, textRenderer, 95, 20, 80, 30, Color.DARK_GRAY.darker().getRGB(), Color.GRAY.getRGB(), Color.WHITE.darker().getRGB(), Color.GRAY.getRGB(), Color.GRAY.darker().getRGB(), Color.GRAY.getRGB(), 0x80000000);
			});
		} else if (mc.options.getGuiScale().getValue() == 4) {
			TitleList.getCategorys().forEach(title -> {
				Renderer.drawTitle(title.name(), drawContext, textRenderer, 80, 10, 70, 28, 0x80000000, Color.GRAY.getRGB());
			});
			ModuleList.getList().forEach(module -> {
				Renderer.drawModule(module, drawContext, textRenderer, 80, 10, 70, 28, Color.DARK_GRAY.darker().getRGB(), Color.GRAY.getRGB(), Color.WHITE.darker().getRGB(), Color.GRAY.getRGB(), Color.GRAY.darker().getRGB(), Color.GRAY.getRGB(), 0x80000000);
			});
		} else if (mc.options.getGuiScale().getValue() == 2) {
			TitleList.getCategorys().forEach(title -> {
				Renderer.drawTitle(title.name(), drawContext, textRenderer, 125, 25, 100, 38, 0x80000000, Color.GRAY.getRGB());
			});
			ModuleList.getList().forEach(module -> {
				Renderer.drawModule(module, drawContext, textRenderer, 125, 25, 100, 38, Color.DARK_GRAY.darker().getRGB(), Color.GRAY.getRGB(), Color.WHITE.darker().getRGB(), Color.GRAY.getRGB(), Color.GRAY.darker().getRGB(), Color.GRAY.getRGB(), 0x80000000);
			});
		} else {
			drawContext.drawText(textRenderer, "Unsupported GUI Scale", (this.width - textRenderer.getWidth("Unsupported GUI Scale"))/2, (this.height - textRenderer.fontHeight)/2, Color.WHITE.getRGB(), false);
		}
	}
	
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        ClickHandler.handle(mouseX, mouseY, button);
        return super.mouseClicked(mouseX, mouseY, button);
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
}