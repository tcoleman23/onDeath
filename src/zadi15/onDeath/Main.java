package zadi15.onDeath;

/*  
 *  Copyright https://github.com/zadi15
 *  
 *  This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;


public class Main extends JavaPlugin implements Listener{
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}

	public void onDisable() {
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) throws InterruptedException {
		Player player = event.getEntity();
		int playerx = player.getLocation().getBlockX();
		int playery = player.getLocation().getBlockY();
		int playerz = player.getLocation().getBlockZ();
		String cmdtp = "/tp " + (player).getPlayerListName() + " " + String.valueOf(playerx) + " " + 
				String.valueOf(playery) + " " + String.valueOf(playerz);
		String cmd = "" + String.valueOf(playerx) + " " + 
				String.valueOf(playery) + " " + String.valueOf(playerz);
		player.sendMessage(ChatColor.BLUE + "You have died at the co-ordinates: " + ChatColor.GOLD + cmd);
		TextComponent message = new TextComponent("Click to go to death point.");
		message.setColor(ChatColor.GOLD);
		message.setBold(true);
		message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, cmdtp));
		message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
				new ComponentBuilder("Click here to be teleported back!").color(ChatColor.GRAY).italic(true).create()));
		player.spigot().sendMessage(message);
	}
}