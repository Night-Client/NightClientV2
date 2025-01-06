package booogyboooo.nightclientv2.ui.data;

import java.util.ArrayList;
import java.util.List;

import booogyboooo.nightclientv2.module.Module;

public class ModuleList {
	private static List<Module> list = new ArrayList<>();
	
	public static List<Module> getList() {
		return list;
	}
	
	public static void addToList(Module module) {
		list.add(module);
	}
	
	public static void removeFromList(Module module) {
		list.remove(module);
	}
}