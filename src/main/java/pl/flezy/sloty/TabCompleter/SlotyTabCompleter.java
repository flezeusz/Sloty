package pl.flezy.sloty.TabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SlotyTabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> arguments = new ArrayList<>();

        if (args.length == 1){
            arguments.add("set");
            arguments.add("reload");
        }

        if (!arguments.isEmpty()) {
            arguments.removeIf(arg -> !arg.toLowerCase().startsWith(args[args.length - 1].toLowerCase()));
        }
        return arguments;
    }
}
