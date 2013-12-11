package net.aerenserve.chathighlight;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChatHighlight extends JavaPlugin
{
	Listeners l;
	@Override
	public void onEnable()
	{
		l = new Listeners(this);
		getLogger().info("Chathighlight enabled");
	}
	@Override
	public void onDisable()
	{
		getLogger().info("ChatHighlight disabled");
	}
}
