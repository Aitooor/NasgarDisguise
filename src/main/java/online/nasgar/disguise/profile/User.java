package online.nasgar.disguise.profile;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import online.nasgar.disguise.DisguiseMain;
import online.nasgar.disguise.file.FileMatcher;
import online.nasgar.disguise.storage.MongoConnection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class User {
    private final DisguiseMain plugin = new DisguiseMain();
    private final FileMatcher matcher = new FileMatcher(plugin);
    private final MongoConnection mongoConnection = new MongoConnection(plugin, matcher);
    private static final HashMap<UUID, User> user = new HashMap<>();
    private final UUID uuid;
    private String name;
    private String newName;
    private String prefix;

    public User(UUID uuid, String name, String prefix) {
        this.uuid = uuid;
        this.name = name;
        this.prefix = prefix;

        this.load();

        user.put(uuid, this);
    }

    public void load() {
        Document document = (Document) mongoConnection.getProfilesCollection().
                find(Filters.eq("_id", this.uuid)).
                first();

        if (document == null) return;

        name = document.getString("name");
        newName = document.getString("new_name");
        prefix = document.getString("prefix");
    }

    public void save() {
        Document document = new Document("_id", this.uuid);

        document.put("name", name);
        document.put("new_name", newName);
        document.put("prefix", prefix);

        Bson filter = Filters.eq("_id", this.uuid);
        FindIterable iterable = mongoConnection.getProfilesCollection().find(filter);

        if (iterable.first() == null) {
            mongoConnection.getProfilesCollection().insertOne(document);
        } else {
            mongoConnection.getProfilesCollection().replaceOne(filter, document);
        }
    }

    public static User getPlayer(Player player) {
        return user.get(player.getUniqueId());
    }

    public String getName() {
        return name;
    }

    public String getNewName() {
        return newName;
    }

    public String getPrefix() {
        return prefix;
    }
}
