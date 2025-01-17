package pl.flezy.sloty;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.flezy.sloty.Commands.SlotyCommand;
import pl.flezy.sloty.Listeners.LoginListener;
import pl.flezy.sloty.Listeners.PingListener;
import pl.flezy.sloty.TabCompleter.SlotyTabCompleter;

import java.util.Objects;

public class Sloty extends JavaPlugin {

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new LoginListener(this),this);
        getServer().getPluginManager().registerEvents(new PingListener(this),this);

        Objects.requireNonNull(getCommand("sloty")).setExecutor(new SlotyCommand(this));

        Objects.requireNonNull(getCommand("sloty")).setTabCompleter(new SlotyTabCompleter());

        getServer().getConsoleSender().sendMessage(
                ChatColor.YELLOW+"["+"Sloty"+"] "+ChatColor.RESET
                        +"Plugin wykonany przez Flezy! "
                        +ChatColor.BLUE+"https://flezy.pl");

        saveDefaultConfig();
        reloadConfig();
    }
}
