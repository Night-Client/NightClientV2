package booogyboooo.nightclientv2;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import oowst.nightclientv2.NightClientV2Mirror;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import booogyboooo.nightclientv2.cmd.CommandManger;
import booogyboooo.nightclientv2.cmd.components.Command;
import booogyboooo.nightclientv2.cmds.Cmd;
import booogyboooo.nightclientv2.cmds.TP;
import booogyboooo.nightclientv2.cmds.Test;
import booogyboooo.nightclientv2.event.EventManger;
import booogyboooo.nightclientv2.event.keypress.LeftClickListener;
import booogyboooo.nightclientv2.event.module.ModuleEventList;
import booogyboooo.nightclientv2.events.block.AttemptBlockPlaceListener;
import booogyboooo.nightclientv2.events.chat.ChatEventListener;
import booogyboooo.nightclientv2.events.knockback.KnockbackListener;
import booogyboooo.nightclientv2.events.tick.PostTickListener;
import booogyboooo.nightclientv2.events.tick.PreTickListener;
import booogyboooo.nightclientv2.modules.combat.AutoClicker;
import booogyboooo.nightclientv2.modules.combat.Critcals;
import booogyboooo.nightclientv2.modules.exploit.AntiDurability;
import booogyboooo.nightclientv2.modules.exploit.Lag;
import booogyboooo.nightclientv2.modules.misc.FastBreak;
import booogyboooo.nightclientv2.modules.misc.FastUse;
import booogyboooo.nightclientv2.modules.misc.NoFall;
import booogyboooo.nightclientv2.modules.movement.AntiKB;
import booogyboooo.nightclientv2.modules.movement.Flight;
import booogyboooo.nightclientv2.modules.movement.Scaffold;
import booogyboooo.nightclientv2.modules.movement.Speed;
import booogyboooo.nightclientv2.modules.render.FullBright;
import booogyboooo.nightclientv2.modules.render.PlayerESP;
import booogyboooo.nightclientv2.ui.NightUI;
import booogyboooo.nightclientv2.ui.ThemeUI;
import booogyboooo.nightclientv2.ui.data.ModuleList;
import booogyboooo.nightclientv2.ui.util.ModuleUtil;
import booogyboooo.nightclientv2.util.Key;
import booogyboooo.nightclientv2.util.LoggerUtil;
import booogyboooo.nightclientv2.module.Module;

public class NightClientV2 implements ModInitializer {
	
	public static final String MOD_ID = "nightclientv2";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID + "|main");
	public static final Logger DEBUG = LoggerFactory.getLogger(MOD_ID + "|debug");
	public static final Logger BOOOGYBOOOO = LoggerFactory.getLogger(MOD_ID + "|booogyboooo");
	private static KeyBinding openThemeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("Open Theme Picker", Key.NONE.key(), "NightClient"));
	private static KeyBinding openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("Open UI", GLFW.GLFW_KEY_RIGHT_SHIFT, "NightClient"));
	private static ThemeUI themeUI = new ThemeUI();
	private String path = System.getProperty("user.home") + "/AppData/Roaming/.minecraft/NightClient";
	private File conf = new File(path + "/config.txt");
	
	@Override
	public void onInitialize() {
		NightClientV2Mirror.preInitialize();
		
		//TODO: Better Events System
		//TODO: Add events
		
		//Get MC
		Module.mc = MinecraftClient.getInstance();
		Command.mc = MinecraftClient.getInstance();
		
		//Listeners
		EventManger.registerEvent(new KnockbackListener());
		EventManger.registerEvent(new ChatEventListener());
		EventManger.registerEvent(new PreTickListener());
		EventManger.registerEvent(new PostTickListener());
		EventManger.registerEvent(new AttemptBlockPlaceListener());
		EventManger.registerEvent(new LeftClickListener());
		
		//Commands
		CommandManger.registerCmd(new Test());
		CommandManger.registerCmd(new Cmd());
		CommandManger.registerCmd(new TP());
		
		//Movement
		AntiKB antikb = new AntiKB();
		ModuleEventList.list.add(antikb);
		ModuleList.addToList(antikb);
		
		Scaffold scaffold = new Scaffold();
		ModuleEventList.list.add(scaffold);
		ModuleList.addToList(scaffold);
		
		Flight flight = new Flight();
		ModuleEventList.list.add(flight);
		ModuleList.addToList(flight);
		
		Speed speed = new Speed();
		ModuleEventList.list.add(speed);
		ModuleList.addToList(speed);
		
		//Render
		FullBright fullBright = new FullBright();
		ModuleList.addToList(fullBright);
		
		//ModuleUtil.registerModule(new PlayerESP());
		
		
		//Misc
		FastUse fastUse = new FastUse();
		ModuleEventList.list.add(fastUse);
		ModuleList.addToList(fastUse);
		
		ModuleUtil.registerModule(new NoFall());
		ModuleUtil.registerModule(new FastBreak());
		
		//Combat
		ModuleUtil.registerModule(new AutoClicker());
		ModuleUtil.registerModule(new Critcals());
		
		//Exploits
		ModuleUtil.registerModule(new AntiDurability());
		ModuleUtil.registerModule(new Lag());
		
		//UI Keybind Listener
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openGuiKey.wasPressed()) {
                client.setScreen(new NightUI());
            } else if (openThemeKey.wasPressed()) {
            	client.setScreen(themeUI);
            }
        });
        
		//Keybind Listener
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ModuleList.getList().forEach(module -> {
            	if (module.getKeyBind().wasPressed()) {
            		module.toggle();
            	}
            });
        });
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        	saveData();
        }));
        
		NightClientV2Mirror.postInitialize();
		
		if (conf.isFile() && conf.exists()) {
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(conf));
				String line;
				try {
					while ((line = fileReader.readLine()) != null) {
						//p1 = name
						//p2 = mode
						String[] parts = line.split(":");
						ModuleList.getList().forEach(module -> {
							if(module.getName().equals(parts[0].strip())) {
								module.setMode(parts[1].replaceAll("\n", ""));
							}
						});
					}
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				conf.createNewFile();
				FileWriter writer = new FileWriter(conf);
				ModuleList.getList().forEach(module -> {
					try {
						writer.write(module.getName() + ":" + module.getMode());
						writer.write("\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void saveData() {
		LoggerUtil.MAIN.info("Saving data");
		FileWriter writer;
		try {
			writer = new FileWriter(conf);
		} catch (IOException e) {
			e.printStackTrace();
			LoggerUtil.MAIN.error("Failed to save data");
			return;
		}
		ModuleList.getList().forEach(module -> {
			try {
				writer.write(module.getName() + ":" + module.getMode());
				writer.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}