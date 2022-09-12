package online.nasgar.disguise.storage;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import online.nasgar.disguise.DisguiseMain;
import online.nasgar.disguise.file.FileMatcher;
import online.nasgar.disguise.file.YAMLFile;
import online.nasgar.disguise.storage.impl.IConnection;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public class MongoConnection implements IConnection {
    private final YAMLFile config;
    private final DisguiseMain plugin;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection profilesCollection;
    private MongoClientURI clientURI;

    public MongoConnection (DisguiseMain plugin, FileMatcher matcher){
        this.config = matcher.getFile("config");
        this.plugin = plugin;
    }

    @Override
    public void start() {
        try {
            loadDatabase();
            getLogger().info("[Nasgar-Disguise] -> Mongo Ready");
        } catch (Exception exception) {
            exception.printStackTrace();
            getLogger().severe(exception.toString());
            getServer().getPluginManager().disablePlugin(plugin);
        }
    }

    @Override
    public void stop() {
    }
    
    public void loadDatabase(){
        String uri = config.getString("mongo.uri");
        clientURI = new MongoClientURI(uri);
        mongoClient = new MongoClient(clientURI);

        mongoDatabase = mongoClient.getDatabase(
                config.getString("mongo.database"));

        profilesCollection = mongoDatabase.getCollection(
                config.getString("mongo.collection"));
    }

    public MongoCollection getProfilesCollection() {
        return profilesCollection;
    }
}
