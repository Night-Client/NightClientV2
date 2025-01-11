package booogyboooo.nightclientv2.modules.movement;

import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.module.Module;
import booogyboooo.nightclientv2.module.ModuleType;
import booogyboooo.nightclientv2.util.DelayUtil;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.RayTraceUtil;
import net.minecraft.block.Blocks;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;


@SuppressWarnings("deprecation")
public class RightClickTP extends Module implements ModuleEvents {
	
	private boolean buttonDown = false;

	public RightClickTP() {
		super(ModuleType.Type.Movement, "RightClickTP", "Vannila", Key.NONE.key());
		this.addMode("Vannila");
		this.addMode("Vannila (NoLim)");
	}

	@Override
	public void preTick() {
		if (!this.isToggled()) {
			return;
		}
		if (this.getMode() == "Vannila") {
			if (mc.mouse.wasRightButtonClicked() && !buttonDown) {
				buttonDown = true;
				DelayUtil.timeout(() -> {buttonDown = false;}, 350);
				BlockHitResult block = RayTraceUtil.getBlock(3);
				if (mc.world.getBlockState(block.getBlockPos()).getBlock() == null || mc.world.getBlockState(block.getBlockPos()).getBlock() == Blocks.AIR || !mc.world.getBlockState(block.getBlockPos()).isSolid()) {
					mc.inGameHud.getChatHud().addMessage(Text.of("Target block is out of range."));
					return;
				} else {
					mc.player.setPos(block.getBlockPos().up().getX(), block.getBlockPos().up().getY(), block.getBlockPos().up().getZ());
				}
			}
		} else if (this.getMode() == "Vannila (NoLim)") {
			if (mc.mouse.wasRightButtonClicked()) {
				buttonDown = true;
				DelayUtil.timeout(() -> {buttonDown = false;}, 350);
				BlockHitResult block = RayTraceUtil.getBlock(3);
				if (block == null) {
					return;
				}
				mc.player.setPos(block.getBlockPos().up().getX(), block.getBlockPos().up().getY(), block.getBlockPos().up().getZ());
			}
		}
	}
}