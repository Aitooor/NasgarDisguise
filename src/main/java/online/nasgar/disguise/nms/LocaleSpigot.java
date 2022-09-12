package online.nasgar.disguise.nms;

import org.bukkit.entity.Player;

public class LocaleSpigot implements ILocale {

    @Override
    public String getLocale(Player p) throws Exception {
        return p.getLocale();
    }
}
