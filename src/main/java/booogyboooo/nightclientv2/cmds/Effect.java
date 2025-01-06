package booogyboooo.nightclientv2.cmds;

import java.util.List;
import java.util.Optional;

import booogyboooo.nightclientv2.cmd.components.Command;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntry.Reference;
import net.minecraft.util.Identifier;

public class Effect extends Command {
	
	public Effect() {
		super("effect", 0, "Format: .effect <on|off> <numeric id>", "toggle on or off an effect");
	}
	
	@Override
	public void run(List<String> args) {
		//new StatusEffectInstance((RegistryEntry<StatusEffect>) Registries.STATUS_EFFECT.get()));
		//mc.player.addStatusEffect(new StatusEffectInstance(Registries.STATUS_EFFECT.getOrThrow(Integer.valueOf(args.get(1))), 2000000000, 1);
	}
	
}