package booogyboooo.nightclientv2.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import booogyboooo.nightclientv2.event.EventManger;
import booogyboooo.nightclientv2.event.special.ChatEvent;
import net.minecraft.client.gui.screen.ChatScreen;

import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
	@Inject(at = @At("HEAD"), method = "sendMessage(Ljava/lang/String;Z)V", cancellable = true)
	public void onSendMessage(String message, boolean addToHistory, CallbackInfo ci) {
		ChatEvent chatEvent = new ChatEvent(message);
		EventManger.sendEvent(chatEvent);
		if (chatEvent.isCanceled) {
			ci.cancel();
			return;
		}
	}
}