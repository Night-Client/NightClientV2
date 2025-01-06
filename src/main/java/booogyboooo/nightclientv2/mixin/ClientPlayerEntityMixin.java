package booogyboooo.nightclientv2.mixin;

import org.spongepowered.asm.mixin.Mixin;

import com.mojang.authlib.GameProfile;

import booogyboooo.nightclientv2.event.EventManger;
import booogyboooo.nightclientv2.event.special.KnockbackEvent;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {

	public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
		super(world, profile);
	}
	
	@Override
	public void setVelocityClient(double x, double y, double z) {
		KnockbackEvent event = new KnockbackEvent(x, y, z);
		EventManger.sendEvent(event);
		if (event.isCanceled) {
			return;
		}
		super.setVelocityClient(event.getX(), event.getY(), event.getZ());
	}

}