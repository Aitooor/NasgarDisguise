package online.nasgar.disguise;

import online.nasgar.disguise.profile.User;
import org.bukkit.entity.Player;

public class DisguiseAPI {
    public String getDisguiseNamePlayer(Player player){
        User user = User.getPlayer(player);

        return user.getName();
    }
    public String getDisguiseNewNamePlayer(Player player){
        User user = User.getPlayer(player);

        return user.getNewName();
    }
    public String getDisguisePrefixPlayer(Player player){
        User user = User.getPlayer(player);

        return user.getPrefix();
    }
}
