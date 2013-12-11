package net.aerenserve.chathighlight;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Listeners implements Listener {
	ChatHighlight chathighlight;
	public Listeners(JavaPlugin plugin) {
		chathighlight = (ChatHighlight) plugin;
		chathighlight.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onChatEvent(AsyncPlayerChatEvent event) {
		String message = event.getMessage();
		Player[] list = Bukkit.getServer().getOnlinePlayers();
		for(final Player p : list) {
			if(message.contains(p.getName())) {
				event.getRecipients().remove(p);
				int nLength = p.getName().length();
				int x = message.indexOf(p.getName());
				
				String a = message.substring(0, x);
				String b = message.substring(x, x+nLength);
				String c = message.substring(x+nLength);				
				String string2 = String.format(ChatColor.WHITE + "<" + event.getPlayer().getDisplayName() + ChatColor.WHITE + "> " + ChatColor.WHITE + a + ChatColor.GREEN + b + ChatColor.WHITE + c);
						
				p.sendMessage(string2);

				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 2, (float) 0.5);     
				
        		Bukkit.getScheduler().scheduleSyncDelayedTask(chathighlight, new Runnable() {
        			public void run()
        			{
        				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 2, (float) .6);
        			}
        		}, 5);
			}
		}
	}
}