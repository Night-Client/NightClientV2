package booogyboooo.nightclientv2.util;

import org.slf4j.Logger;

import booogyboooo.nightclientv2.NightClientV2;
import oowst.nightclientv2.NightClientV2Mirror;

/**
 * Collection of all loggers
 */
public enum LoggerUtil {
	DEBUG(NightClientV2.DEBUG), MAIN(NightClientV2.LOGGER), OOWST(NightClientV2Mirror.LOGGER), BOOOGYBOOOO(NightClientV2.BOOOGYBOOOO);
	
	LoggerUtil(Logger logger) {
		this.logger = logger;
	}
	
	private Logger logger;
	
	/**
	 * Log a message
	 * <br>
	 * - info(msg)
	 * <br>
	 * <br>
	 * msg
	 * <br>
	 * - The message to log
	 */
	public void info(String msg) {
		this.logger.info(msg);
	}
	
	/**
	 * Log a warning
	 * <br>
	 * - info(warn)
	 * <br>
	 * <br>
	 * warn
	 * <br>
	 * - The warning to log
	 */
	public void warn(String warn) {
		this.logger.warn(warn);
	}
	
	/**
	 * Log a error
	 * <br>
	 * - info(error)
	 * <br>
	 * <br>
	 * error
	 * <br>
	 * - The error to log
	 */
	public void error(String error) {
		this.logger.error(error);
	}
}