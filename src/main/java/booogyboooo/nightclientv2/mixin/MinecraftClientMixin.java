package booogyboooo.nightclientv2.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventManger;
import booogyboooo.nightclientv2.event.EventType;
import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	
    private boolean wasAttackKeyPressed = false;
	
    @Inject(method = "tick", at = @At("HEAD"))
    private void onPreTick(CallbackInfo info) {
    	EventManger.sendEvent(new Event(false, EventType.Type.pretick));
    }
    
    @Inject(method = "tick", at = @At("TAIL"))
    private void onPostTick(CallbackInfo info) {
    	EventManger.sendEvent(new Event(false, EventType.Type.posttick));
    }

    @Inject(method = "handleInputEvents", at = @At("HEAD"))
    private void onHandleInputEvents(CallbackInfo info) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.options.attackKey.isPressed() && !wasAttackKeyPressed) {
            wasAttackKeyPressed = true;
            Event event = new Event(true, EventType.Type.onleftclick);
            EventManger.sendEvent(event);
            if (event.isCanceled) {
            	client.options.attackKey.setPressed(false);
            	wasAttackKeyPressed = false;
            }
        } else if (!client.options.attackKey.isPressed()) {
            wasAttackKeyPressed = false;
        }
    }
}