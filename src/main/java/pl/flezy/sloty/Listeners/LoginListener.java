package pl.flezy.sloty.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import pl.flezy.sloty.Sloty;

public class LoginListener implements Listener {
    private final Sloty plugin;
    public LoginListener(Sloty plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onLogin(PlayerLoginEvent event){
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();
        if (Bukkit.getOnlinePlayers().size() < config.getInt("slots") || player.hasPermission("flezy.sloty.bypass")){
            event.allow();
        }
        else {
            event.disallow(PlayerLoginEvent.Result.KICK_FULL,
                    ChatColor.translateAlternateColorCodes('&',config.getString("kickMessage","")));
        }
    }
}
