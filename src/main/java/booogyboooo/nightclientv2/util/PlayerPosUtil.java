package booogyboooo.nightclientv2.util;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/**
 * Util for interacting with the player position
 */
public class PlayerPosUtil {
	
	/**
	 * Get the block under the players BlockPos
	 * <br>
	 * - getBlockUnderPlayer(client)
	 * <br>
	 * <br>
	 * client
	 * <br>
	 * - The minecraft instance
	 */
    public static BlockPos getBlockUnderPlayer(MinecraftClient client) {
        if (client.player != null && client.world != null) {
            Vec3d playerPos = client.player.getPos();
            BlockPos blockUnderPos = new BlockPos( (int) Math.floor(playerPos.x), (int) Math.floor(playerPos.y - 1), (int) Math.floor(playerPos.z));
            ClientWorld world = client.world;
            BlockState blockStateUnder = world.getBlockState(blockUnderPos);
            if (!blockStateUnder.isAir()) {
                return blockUnderPos;
            }
        }
        return null;
    }
    
	/**
	 * Get the block under the players BlockPos
	 * <br>
	 * - getBlockUnderPlayer(client, allowAir)
	 * <br>
	 * <br>
	 * client
	 * <br>
	 * - The minecraft instance
	 * <br>
	 * <br>
	 * allowAir
	 * <br>
	 * - Can it return air
	 */
    public static BlockPos getBlockUnderPlayer(MinecraftClient client, boolean allowAir) {
        if (client.player != null && client.world != null) {
            Vec3d playerPos = client.player.getPos();
            BlockPos blockUnderPos = new BlockPos( (int) Math.floor(playerPos.x), (int) Math.floor(playerPos.y - 1), (int) Math.floor(playerPos.z));
            ClientWorld world = client.world;
            BlockState blockStateUnder = world.getBlockState(blockUnderPos);
            if (!blockStateUnder.isAir() && !allowAir) {
                return blockUnderPos;
            } else if (allowAir){
            	return blockUnderPos;
            }
        }
        return null;
    }
}