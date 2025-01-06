package booogyboooo.nightclientv2.ui.data;

import java.util.ArrayList;
import java.util.List;

public class TitleList {
	public enum Categorys {
		Movement, Render, Misc, Combat, Exploits
	}
	
	public static List<Categorys> getCategorys() {
		List<Categorys> categorys = new ArrayList<>();
		int i = 0;
		while (i < Categorys.values().length) {
			categorys.add(Categorys.values()[i]);
			i++;
		}
		return categorys;
	}
}