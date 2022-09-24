package online.nasgar.disguise;

import online.nasgar.disguise.command.DisguiseCommand;
import online.nasgar.disguise.file.FileMatcher;
import online.nasgar.disguise.modules.DisguiseModule;
import online.nasgar.disguise.modules.submodule.LangModule;
import org.bukkit.plugin.java.JavaPlugin;

public final class DisguiseMain extends JavaPlugin {

    @Override
    public void onEnable() {

        FileMatcher matcher = new FileMatcher(this);
        DisguiseModule disguiseModule = new DisguiseModule(this, matcher);

        getServer().getPluginCommand("disguise"
        ).setExecutor
                (new DisguiseCommand
                        (new LangModule(this)));

        disguiseModule.start();
    }

    @Override
    public void onDisable() {
    }
}
