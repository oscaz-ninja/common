package ninja.oscaz.common.spigot.plugin;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import ninja.oscaz.common.spigot.aop.MustBeOp;
import ninja.oscaz.common.spigot.aop.MustBeOpInterceptor;
import ninja.oscaz.common.spigot.transform.ListenerTransformer;
import ninja.oscaz.hero.Hero;
import ninja.oscaz.hero.config.HeroConfiguration;

public abstract class OscazPlugin extends JavaPlugin {

    protected OscazPlugin() {
        HeroConfiguration config = HeroConfiguration.make().withDefaults()
                .withBindings(this::defaultBindings)
                .withTransformers(this::defaultTransformers);

        Hero hero = Hero.create(config);
        hero.transform(this);
    }

    private void defaultBindings(Hero hero) {
        hero.bind(Plugin.class).toValue(this);
        hero.bind(JavaPlugin.class).toValue(this);
        hero.bind(OscazPlugin.class).toValue(this);
        hero.bind(this.getClass()).toValue(this);

        hero.bind(MustBeOp.class).to(MustBeOpInterceptor.class);

        this.bind(hero);
    }

    private void defaultTransformers(Hero hero) {
        hero.addTransformer(ListenerTransformer.class);

        this.transform(hero);
    }

    @Override
    public final void onEnable() {
        this.enable();
    }

    @Override
    public final void onDisable() {
        this.disable();
    }

    protected void enable() {

    }

    protected void disable() {

    }

    protected void bind(Hero hero) {

    }

    protected void transform(Hero hero) {

    }

}
