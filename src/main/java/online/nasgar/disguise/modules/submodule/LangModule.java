package online.nasgar.disguise.modules.submodule;

import me.yushust.message.MessageHandler;
import me.yushust.message.MessageProvider;
import me.yushust.message.bukkit.BukkitMessageAdapt;
import me.yushust.message.source.MessageSourceDecorator;
import online.nasgar.disguise.DisguiseMain;
import online.nasgar.disguise.modules.impl.IModule;
import online.nasgar.disguise.nms.ILocale;
import online.nasgar.disguise.nms.LocaleCraftBukkit;
import online.nasgar.disguise.nms.LocaleSpigot;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class LangModule implements IModule {
    private MessageHandler messageHandler;
    private final DisguiseMain plugin;
    private ILocale locale;

    public LangModule(DisguiseMain plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        messages();

    }

    @Override
    public void stop() {

    }

    private void messages() {
        setupLocale();
        File folder = new File(plugin.getDataFolder(), "lang");
        if (!folder.exists()) folder.mkdirs();
        MessageProvider messageProvider = MessageProvider
                .create(
                        MessageSourceDecorator
                                .decorate(BukkitMessageAdapt.newYamlSource(plugin,
                                        "lang/lang_%lang%.yml"))
                                .addFallbackLanguage("en")
                                .addFallbackLanguage("es")
                                .get(),
                        config -> {
                            config.specify(Player.class)
                                    .setLinguist(player -> {
                                        try {
                                            return locale.getLocale(player).split("_")[0];
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                    })
                                    .setMessageSender((sender, mode, message) -> sender.sendMessage(message));
                            config.specify(CommandSender.class)
                                    .setLinguist(commandSender -> "en")
                                    .setMessageSender((sender, mode, message) -> sender.sendMessage(message));
                            config.addInterceptor(s -> ChatColor.translateAlternateColorCodes('&', s));
                        }
                );

        messageHandler = MessageHandler.of(messageProvider);
    }

    private void setupLocale() {
        double version = 0;
        try {
            version = Double.parseDouble(Bukkit.getBukkitVersion().split("-")[0].replaceFirst("1\\.", ""));
        } catch (Exception ignored) {}

        if (version > 8.8) // > 1.8.8
            locale = new LocaleSpigot();
        else
            locale = new LocaleCraftBukkit();
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }
}
