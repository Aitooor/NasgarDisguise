package online.nasgar.disguise.listener;

import online.nasgar.disguise.DisguiseMain;
import online.nasgar.disguise.profile.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    private final DisguiseMain plugin;
    private User user;

    public ConnectionListener(DisguiseMain plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinListener(PlayerJoinEvent event){
        Player player = event.getPlayer();

        user = new User(player.getUniqueId(),
                player.getName(),
                "");
    }


    @EventHandler
    public void onQuitPlayer(PlayerQuitEvent event){
        Player player = event.getPlayer();

        user = new User(player.getUniqueId(),
                player.getName(),
                "");

        System.out.println("El player se echa de puta madre socio ");
        user.getPlayer(player).save();
    }
}
