package com.expenox.vau;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.expenox.vau.commands.DiscordCommand;
import com.expenox.vau.commands.SpawnFirework;

public class Main extends JavaPlugin {

    private ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    @Override
    public void onEnable() {

        saveDefaultConfig();

        new SpawnFirework(this);
        new DiscordCommand(this);

        console.sendMessage(ChatColor.GREEN + "Virtual Accord Utilities loaded successfully!");
    }

    @Override
    public void onDisable() {
        console.sendMessage(ChatColor.GREEN + "Virtual Accord Utilities unloaded successfully!");
    }
}

