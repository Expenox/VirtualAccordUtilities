package com.expenox.vau.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import com.expenox.vau.Main;

public final class SpawnFirework implements Listener {

    @SuppressWarnings("unused")
    private Main plugin;

    public SpawnFirework(Main plugin) {

        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onNewPlayer(PlayerJoinEvent event) {

        Random rand = new Random();

        Player p = event.getPlayer();

        /*if (!p.hasPlayedBefore()) {*/

            Firework fw = (Firework) Bukkit.getServer().getWorld("World").spawnEntity(p.getLocation(), EntityType.FIREWORK);
            FireworkMeta fwm = fw.getFireworkMeta();
            FireworkEffect.Builder builder = FireworkEffect.builder();

            Color[] colors = { Color.AQUA, Color.BLUE, Color.FUCHSIA, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY,
                    Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.TEAL, Color.WHITE, Color.YELLOW };
            builder.withColor(colors[rand.nextInt(colors.length)]);
            for (int i = 0; i < 2; i++) {
                if (rand.nextBoolean()) {
                    builder.withColor(colors[rand.nextInt(colors.length)]);
                }
            }

            FireworkEffect.Type[] effects = { FireworkEffect.Type.BALL, FireworkEffect.Type.BALL_LARGE,
                    FireworkEffect.Type.BURST, FireworkEffect.Type.CREEPER, FireworkEffect.Type.STAR };
            builder.with(effects[rand.nextInt(effects.length)]);
            if (rand.nextBoolean()) {
                builder.withFlicker();
            }

            FireworkEffect effect = builder.build();

            fwm.addEffect(effect);
            fwm.setPower(1);
            fw.setFireworkMeta(fwm);

            /*
             * Bukkit.broadcastMessage(
             * Utils.chat(plugin.getConfig().getString("firstJoin_message").replace(
             * "<player>", p.getName())));
             */
        /*} else {*/
            /*
             * Bukkit.broadcastMessage(
             * Utils.chat(plugin.getConfig().getString("join_message").replace("<player>",
             * p.getName())));
             */
       /* }*/
    }
}
