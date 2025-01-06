package booogyboooo.nightclientv2.mixin;

import java.awt.Color;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import booogyboooo.nightclientv2.ui.data.ModuleList;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;

//NightClientV2 overlay
@Mixin(InGameHud.class)
public class InGameHudMixin {
	private int drawn = 0;
	private int drawn2 = 0;
	
    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(DrawContext drawContext, RenderTickCounter tickDelta, CallbackInfo ci) {
    	drawn2 = 0;
    	drawn = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
        	ModuleList.getList().forEach(module -> {
        		if (!module.isToggled()) {
        			return;
        		}
        		drawContext.fill(6, (drawn2 * 12) + 5, client.textRenderer.getWidth(module.getName() + " (" + module.getMode() + ")") + 12, (drawn2 * 12) + 12 + client.textRenderer.fontHeight, Color.BLACK.getRGB());
        		drawn2++;
        	});
        	ModuleList.getList().forEach(module -> {
        		if (!module.isToggled()) {
        			return;
        		}
        		drawContext.drawText(client.textRenderer, module.getName() + " (" + module.getMode() + ")", 10, (drawn * 12) + 10, Color.RED.getRGB(), false);
        		drawn++;
        	});
        }
    }
}