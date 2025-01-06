package oowst.nightclientv2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import booogyboooo.nightclientv2.ui.util.ModuleUtil;
import oowst.nightclientv2.modules.movement.Dash;

public class NightClientV2Mirror {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("nightclientv2|oowst");
	
	public static void preInitialize() {
		ModuleUtil.registerModule(new Dash());
	}
	
	public static void postInitialize() {

	}
}