package online.nasgar.disguise.nms;

import org.bukkit.entity.Player;

import java.lang.reflect.Method;
import java.util.Locale;

public class LocaleCraftBukkit implements ILocale {

    private Method playerLocaleMethod;

    @Override
    public String getLocale(Player p) throws Exception {
        if (playerLocaleMethod == null)
            playerLocaleMethod = p.getClass().getDeclaredMethod("getLocale");

        return ((Locale) playerLocaleMethod.invoke(p)).getLanguage();
    }
}
