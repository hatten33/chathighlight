package net.aerenserve.chathighlight;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * ChatHighlight v1.2
 * 
 * You may use this code according to these conditions:
 *
 * 1. No warranty is given or implied.
 * 2. All damage is your own responsibility.
 * 3. You provide credit publicly to the original source should you release the plugin.
 * 
 * @author hatten33
 */


public final class ChatHighlight extends JavaPlugin {
	
	Listeners l;
	
	@Override
	public void onEnable() {
		l = new Listeners(this);
		getLogger().info("Chathighlight enabled");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("ChatHighlight disabled");
	}
}
