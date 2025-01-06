package booogyboooo.nightclientv2.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

/**
 * Util for raytracing
 */
public class RayTraceUtil {
	
	/**
	 * Get the entity under your crosshair
	 * <br>
	 * - getEntityUnderCrosshair(maxDistance)
	 * <br>
	 * <br>
	 * maxDistance
	 * <br>
	 * - The max distance for the ray trace
	 */
    public static Entity getEntityUnderCrosshair(double maxDistance) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.world == null || client.cameraEntity == null) {
            return null;
        }

        HitResult hitResult = client.crosshairTarget;

        if (hitResult instanceof EntityHitResult entityHitResult) {
            return entityHitResult.getEntity();
        }

        return null;
    }
}