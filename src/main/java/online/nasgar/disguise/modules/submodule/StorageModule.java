package online.nasgar.disguise.modules.submodule;

import online.nasgar.disguise.DisguiseMain;
import online.nasgar.disguise.file.FileMatcher;
import online.nasgar.disguise.modules.impl.IModule;
import online.nasgar.disguise.storage.MongoConnection;

public class StorageModule implements IModule {
    private final DisguiseMain plugin;
    private final FileMatcher matcher;

    public StorageModule(DisguiseMain plugin, FileMatcher matcher){
        this.plugin = plugin;
        this.matcher = matcher;
    }
    @Override
    public void start() {
        MongoConnection mongoConnection = new MongoConnection(plugin, matcher);
        mongoConnection.start();
    }

    @Override
    public void stop() {

    }
}
