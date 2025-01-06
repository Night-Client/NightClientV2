package booogyboooo.nightclientv2.ui.util;

import booogyboooo.nightclientv2.event.module.ModuleEventList;
import booogyboooo.nightclientv2.event.module.ModuleEvents;
import booogyboooo.nightclientv2.ui.data.ModuleList;
import booogyboooo.nightclientv2.module.Module;

public class ModuleUtil {
	/**
	 * Used to register a module
	 * <br>
	 * - registerModule(module)
	 * <br>
	 * <br>
	 * module
	 * <br>
	 * - module to register as a module and event module
	 * 
	 */
	public static void registerModule(Module module) {
		ModuleList.addToList(module);
		ModuleEventList.list.add((ModuleEvents) module);
	}
	
	/**
	 * Used to register a module
	 * <br>
	 * - registerModule(module, event)
	 * <br>
	 * <br>
	 * module
	 * <br>
	 * - module to register as a module
	 * <br>
	 * <br>
	 * event
	 * <br>
	 * - register module as event to
	 * 
	 */
	public static void registerModule(Module module, Boolean event) {
		ModuleList.addToList(module);
		if (event) {
			ModuleEventList.list.add((ModuleEvents) module);
		}
	}
}