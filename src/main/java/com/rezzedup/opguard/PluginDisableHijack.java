package com.rezzedup.opguard;

import com.rezzedup.opguard.api.OpGuardAPI;
import com.rylinaux.plugman.PlugMan;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.scheduler.BukkitRunnable;

final class PluginDisableHijack implements Listener
{    
    private final OpGuardAPI api;
    
    public PluginDisableHijack(OpGuardAPI api)
    {
        this.api = api;
        api.registerEvents(this);
    }
    
    @EventHandler
    public void on(PluginEnableEvent event)
    {
        boolean isPlugMan = event.getPlugin().getName().equalsIgnoreCase("PlugMan");
        
        if (isPlugMan && api.getConfig().canExemptSelfFromPlugMan())
        {
            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    PlugMan.getInstance().getIgnoredPlugins().add(api.getPlugin().getName());
                    Messenger.send("&f[OpGuard] &9Exempted OpGuard from PlugMan.");
                }
            }
            .runTaskLater(api.getPlugin(), 20L);
        }
    }
    
    @EventHandler
    public void on(PluginDisableEvent event)
    {
        if (event.getPlugin() == api.getPlugin() && api.getConfig().canShutDownOnDisable())
        {
            Messenger.send("&c[&fOpGuard was disabled&c] Shutting server down.");
            Bukkit.shutdown();
        }
    }
}
