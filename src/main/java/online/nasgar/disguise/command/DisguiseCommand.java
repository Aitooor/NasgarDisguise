package online.nasgar.disguise.command;

import online.nasgar.disguise.modules.submodule.LangModule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DisguiseCommand implements CommandExecutor {
    private final LangModule langModule;

    public DisguiseCommand(LangModule langModule) {
        this.langModule = langModule;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("disguise.menu")){
            langModule.getMessageHandler().sendReplacing(sender,
                    "no-permissions");
            return true;
        }

        Player player = (Player) sender;

        //open disguise main menu

        return false;
    }
}
