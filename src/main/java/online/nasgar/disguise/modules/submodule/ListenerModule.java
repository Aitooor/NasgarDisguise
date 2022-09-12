package online.nasgar.disguise.modules.submodule;

import online.nasgar.disguise.DisguiseMain;
import online.nasgar.disguise.listener.ConnectionListener;
import online.nasgar.disguise.modules.impl.IModule;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.Arrays;

public class ListenerModule implements IModule {
    private final DisguiseMain plugin;

    public ListenerModule(DisguiseMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        loadListener();
    }

    @Override
    public void stop() {
    }

    public void loadListener(){
        listener(
                new ConnectionListener(plugin)
        );
    }
    public void listener(Listener... listeners) {
        Arrays.stream(listeners).forEach(listener ->
                Bukkit.getServer().
                        getPluginManager().
                        registerEvents(listener, plugin));
    }
}
