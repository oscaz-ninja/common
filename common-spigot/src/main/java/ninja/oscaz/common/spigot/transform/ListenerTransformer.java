package ninja.oscaz.common.spigot.transform;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import ninja.oscaz.common.spigot.plugin.OscazPlugin;
import ninja.oscaz.hero.transform.HeroTransformer;
import ninja.oscaz.hero.transform.inject.Inject;

public class ListenerTransformer implements HeroTransformer {

    @Inject
    private OscazPlugin plugin;

    @Override
    public <T> T transform(T value) {
        if (Listener.class.isInstance(value)) {
            Bukkit.getPluginManager().registerEvents((Listener) value, this.plugin);
        }

        return value;
    }
}
