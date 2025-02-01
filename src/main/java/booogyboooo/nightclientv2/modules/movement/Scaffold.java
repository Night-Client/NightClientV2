package booogyboooo.nightclientv2.modules.movement;

import booogyboooo.nightclientv2.NightClientV2;
import booogyboooo.nightclientv2.event.Event;
import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType.Type;
import booogyboooo.nightclientv2.ui.data.ModuleList;
import booogyboooo.nightclientv2.util.BlockPlacePacketUtil;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.LoggerUtil;
import booogyboooo.nightclientv2.util.PlayerPosUtil;
import booogyboooo.nightclientv2.util.RayTraceUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockStateRaycastContext;
import net.minecraft.world.RaycastContext;

public class Scaffold extends Module implements ModuleEvents{

	MinecraftClient client = MinecraftClient.getInstance();
	ClientPlayerEntity player;
	
	private boolean wasShifting = false;
	private int godBridgeBlocks = 0;
	
	public Scaffold() {
		super(Type.Movement, "Scaffold", "Shift", Key.NONE.key());
		this.addMode("Shift");
		this.addMode("Godbridge");
		this.addMode("Packet");
	}
	
	@Override
	public void onEnable() {
		this.wasShifting = client.options.sneakKey.isPressed();
		this.player = client.player;
	}
	
	@Override
	public void onDisable() {
		client.options.sneakKey.setPressed(this.wasShifting);
		if (this.getMode().equals("Godbridge")) {
			this.client.options.useKey.setPressed(false);
			this.client.options.backKey.setPressed(false);
			this.client.options.rightKey.setPressed(false);
		}
	}

	@Override
	public void postTick() {
		if (!this.isToggled() || this.client.player == null || this.client.world == null) {
			return;
		}
		if (this.getMode().equals("Shift")) {
			Vec3d pos = player.getPos();
			BlockPos blockPos = player.getBlockPos();
			double xOffset = pos.x - blockPos.getX();
			double zOffset = pos.z - blockPos.getZ();
			BlockState blockBelow = client.world.getBlockState(blockPos.down());
			boolean isAirBelow = blockBelow.isAir();
			if (isAirBelow || (xOffset < 0.05 || xOffset > 1 - 0.05) || (zOffset < 0.05 || zOffset > 1 - 0.05)) {
				client.options.sneakKey.setPressed(true);
			} else {
				client.options.sneakKey.setPressed(false);
			}
		} else if (this.getMode().equals("Packet")) {
			BlockPlacePacketUtil.placeBlockVannila(PlayerPosUtil.getBlockUnderPlayer(client, true));
		} else if (this.getMode().equals("Godbridge")) {
			this.client.player.setPitch(75f);
			this.client.options.useKey.setPressed(true);
			this.client.options.backKey.setPressed(true);
			this.client.options.rightKey.setPressed(true);
			MinecraftClient.getInstance().itemUseCooldown = 0;
			if (this.player.getYaw() <= 180 && this.player.getYaw() >= 90) {
				this.player.setYaw(135);
			} else if (this.player.getYaw() <= 90 && this.player.getYaw() >= 0) {
				this.player.setYaw(45);
			} else if (this.player.getYaw() <= 0 && this.player.getYaw() >= -90) {
				this.player.setYaw(-45);
			} else {
				this.player.setYaw(-135);
			}
			if (godBridgeBlocks >= 20) {
				if (this.player.isOnGround()) {
					player.jump();
					godBridgeBlocks = 0;
				}
			}
			//-180 : 180
			//135 = 90< : >180
			//45 = 0< : >90
			//-45 = -90< : >0
			//-135 = -180< : >-90
		}
	}

	@Override
	public void onAttemptBlockPlace(Event event) {
		if (this.isToggled()) {
			if (this.getMode().equals("Godbridge")) {
				godBridgeBlocks++;
			}
		}
	}
}