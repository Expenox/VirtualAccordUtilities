package com.expenox.vau.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.expenox.vau.Main;

public class DiscordCommand implements CommandExecutor {

    @SuppressWarnings("unused")
    private Main plugin;

    public DiscordCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("discord").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player p = (Player) sender;

        if (p.hasPermission("vau.discord.use")) {
            p.sendMessage("Here's the link: " + ChatColor.BLUE + ChatColor.BOLD + "https://discord.gg/Ep3zdgc");
            return true;
        } else {
            p.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
        }
        return false;
    }
}