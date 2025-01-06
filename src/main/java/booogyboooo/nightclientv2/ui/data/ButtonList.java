package booogyboooo.nightclientv2.ui.data;

import java.util.ArrayList;
import java.util.List;

import booogyboooo.nightclientv2.ui.components.Button;

public class ButtonList {
	private static List<Button> list = new ArrayList<>();
	
	public static List<Button> getList() {
		return list;
	}
	
	public static void addToList(Button button) {
		list.add(button);
	}
	
	public static void removeFromList(Button button) {
		list.remove(button);
	}

	public static void clearList() {
		list.removeAll(list);
	}
}