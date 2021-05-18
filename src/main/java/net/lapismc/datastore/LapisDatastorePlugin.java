package net.lapismc.datastore;

import net.lapismc.lapiscore.LapisCorePlugin;
import net.lapismc.lapiscore.utils.LapisUpdater;
import org.bukkit.Bukkit;

public final class LapisDatastorePlugin extends LapisCorePlugin {

    @Override
    public void onEnable() {
        getDataFolder().mkdir();
        Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
            LapisUpdater updater = new LapisUpdater(this, "LapisDatastorePlugin", "Dart2112", "LapisDatastorePlugin", "master");
            if (updater.checkUpdate()) {
                updater.downloadUpdate();
            }
        });
    }
}
