package online.nasgar.disguise;

import online.nasgar.disguise.file.FileMatcher;
import online.nasgar.disguise.modules.DisguiseModule;
import org.bukkit.plugin.java.JavaPlugin;

public final class DisguiseMain extends JavaPlugin {

    @Override
    public void onEnable() {
        FileMatcher matcher = new FileMatcher(this);
        DisguiseModule disguiseModule = new DisguiseModule(this, matcher);

        disguiseModule.start();
    }

    @Override
    public void onDisable() {
    }
}
