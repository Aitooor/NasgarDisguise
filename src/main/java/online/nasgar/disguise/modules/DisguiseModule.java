package online.nasgar.disguise.modules;

import online.nasgar.disguise.DisguiseMain;
import online.nasgar.disguise.file.FileMatcher;
import online.nasgar.disguise.modules.impl.IModule;
import online.nasgar.disguise.modules.submodule.LangModule;
import online.nasgar.disguise.modules.submodule.ListenerModule;
import online.nasgar.disguise.modules.submodule.StorageModule;

public class DisguiseModule implements IModule {
    private final DisguiseMain plugin;
    private final FileMatcher matcher;

    public DisguiseModule(DisguiseMain plugin, FileMatcher matcher){
        this.plugin = plugin;
        this.matcher = matcher;
    }

    @Override
    public void start() {
        LangModule langModule = new LangModule(plugin);
        ListenerModule listenerModule = new ListenerModule(plugin);
        StorageModule storageModule = new StorageModule(plugin, matcher);
        langModule.start();
        listenerModule.start();
        storageModule.start();

    }

    @Override
    public void stop() {

    }
}
