package booogyboooo.nightclientv2.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.EventManger;
import booogyboooo.nightclientv2.event.EventType;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Inject(method = "interactBlock", at = @At("HEAD"), cancellable = true)
    private void onBlockPlace(ClientPlayerEntity player, Hand hand, BlockHitResult res, CallbackInfoReturnable<ActionResult> cir) {
    	Event event = new Event(true, EventType.Type.onattemptblockplaced);
    	EventManger.sendEvent(event);
    	if (event.isCanceled) {
    		cir.setReturnValue(ActionResult.FAIL);
    	}
    }
}