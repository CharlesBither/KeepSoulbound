package tech.secretgarden;

import dev.drawethree.deathchestpro.DeathChestPro;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("plugin has enabled");
        Bukkit.getPluginManager().registerEvents(new NewItems(), this);

        if (getSfAPI() == null) {
            System.out.println("sf4 not found");
        } else {
            System.out.println("sf4 was found");
        }

        if (getDcAPI() == null) {
            System.out.println("dc not found");
        } else {
            System.out.println("dc was found");
        }

    }
    //slimefun API
    public Slimefun getSfAPI() {
        Plugin sfPlugin = Bukkit.getServer().getPluginManager().getPlugin("Slimefun");
        if (sfPlugin instanceof Slimefun) {
            return (Slimefun) sfPlugin;
        } else {
            return null;
        }
    }
    //slimefun API
    public DeathChestPro getDcAPI() {
        Plugin dcPlugin = Bukkit.getServer().getPluginManager().getPlugin("DeathChestPro");
        if (dcPlugin instanceof DeathChestPro) {
            return (DeathChestPro) dcPlugin;
        } else {
            return null;
        }
    }
}
