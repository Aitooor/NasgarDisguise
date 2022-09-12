package online.nasgar.disguise.file;

import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class FileMatcher {

    private final Plugin plugin;

    public FileMatcher(Plugin plugin) {
        this.plugin = plugin;

        setup();
    }

    private final Map<String, YAMLFile> files = new HashMap<>();

    public void setup() {
        files.put("config", new YAMLFile(plugin, "config"));
        files.put("nick", new YAMLFile(plugin, "nick"));
        files.put("skin", new YAMLFile(plugin, "skin"));
        files.put("prefix", new YAMLFile(plugin, "prefix"));
    }

    public YAMLFile getFile(String key) {
        return files.get(key);
    }
}
