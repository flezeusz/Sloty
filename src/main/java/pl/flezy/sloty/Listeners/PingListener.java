package pl.flezy.sloty.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import pl.flezy.sloty.Sloty;

public class PingListener implements Listener {
    private final Sloty plugin;
    public PingListener(Sloty plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPing(ServerListPingEvent event){
        event.setMaxPlayers(plugin.getConfig().getInt("slots"));
    }
}
