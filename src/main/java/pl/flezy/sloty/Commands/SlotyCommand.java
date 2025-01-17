package pl.flezy.sloty.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import pl.flezy.sloty.Sloty;

public class SlotyCommand implements CommandExecutor {
    private final Sloty plugin;
    public SlotyCommand(Sloty plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length >= 1 && args[0].equalsIgnoreCase("reload")){
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Pomyślnie zreloadowałeś config");
            return true;
        }
        if (args.length >= 2 && args[0].equalsIgnoreCase("set")){
            int slots;
            try {
                slots = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                sender.sendMessage(ChatColor.RED + "Niepoprawna liczba slotów");
                return true;
            }
            plugin.getConfig().set("slots", slots);
            plugin.saveConfig();
            sender.sendMessage(ChatColor.YELLOW + "Liczba slotów została ustawiona na " + slots);
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Niepoprawne użycie komendy");
        return true;
    }
}
