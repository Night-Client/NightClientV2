package booogyboooo.nightclientv2.util;

/**
 * Util for keycodes
 */
public enum Key {
	NONE(-1);

	Key(int i) {
		this.i = i;
	}
	
	private int i;	
	
	/**
	 * Get keycode
	 * <br>
	 * - key()
	 */
	public int key() {
		return i;
	}
}