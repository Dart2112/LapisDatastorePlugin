package net.lapimc.lapisdatastore;

import net.lapismc.lapiscore.LapisCorePlugin;
import net.lapismc.lapiscore.utils.LapisUpdater;
import org.bukkit.Bukkit;

public final class LapisDatastorePlugin extends LapisCorePlugin {

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
            String name = getDescription().getName();
            LapisUpdater updater = new LapisUpdater(this, name, "Dart2112", name, "master");
            if (updater.checkUpdate()) {
                updater.downloadUpdate();
            }
        });
    }
}
