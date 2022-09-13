package online.nasgar.disguise.placerholder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import online.nasgar.disguise.profile.User;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlacerHolderHook extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "disguise";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Sakio";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        User user = User.getPlayer(player);

        // %disguise_new_name
        if (params.equalsIgnoreCase("new_name")) {
            if (user.getNewName() != null) {
                return user.getNewName();
            }
            return player.getName();
        }

        // %disguise_prefix%
        if (params.equalsIgnoreCase("prefix")) {
            return user.getPrefix();
        }

        return "Placeholder not found";
    }
}
