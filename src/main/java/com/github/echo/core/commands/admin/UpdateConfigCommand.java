package com.github.echo.core.commands.admin;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import com.github.echo.utilities.Constants;
import com.github.echo.utilities.Logger;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  UpdateConfigCommand class of the ECHO Community Discord Bot project
 *
 *  All methods are explained in {@link Command}
 *
 * @author ECHO
 * @since September 2021
 */
public class UpdateConfigCommand extends Command {
    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent sce) {}

    @Override
    public CommandData getSlashCommandData() { return null; }

    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("UPDATE CONFIG (called by " + mre.getAuthor().getAsTag() + ")");

        // Check if owner. If not, quit
        String userID = mre.getAuthor().getId();
        if (!userID.equals(Constants.OWNER_ID)) {
            mre.getChannel().sendMessage("This command can only be used by the owner.").queue();
            return;
        }

        // If no argument, ask for one
        if (args.length < 2) {
            mre.getChannel().sendMessage("Please define a value to view or update.").queue();
        }
        else if (args.length < 3) {
            // Supported: Prefix and Debug and Log
            switch (args[1].toLowerCase()) {
                case "prefix":
                    mre.getChannel().sendMessage("Prefix is currently: " + Main.getConfig().getPrefix()).queue();
                    break;
                case "debug":
                    mre.getChannel().sendMessage("Debug is currently: " + Main.getConfig().getDebug()).queue();
                    break;
                case "log":
                    mre.getChannel().sendMessage("Logging is currently: " + Logger.isLogging()).queue();
                    break;
            }
        }
        else {
            switch (args[1].toLowerCase()) {
                case "prefix":
                    Main.getConfig().setPrefix(args[2]);
                    mre.getChannel().sendMessage("Prefix updated to: **" + args[2] + "**").queue();
                    break;
                case "debug":
                    if (args[2].equalsIgnoreCase("true")) {
                        Main.getConfig().setDebug(true);
                        mre.getChannel().sendMessage("Debug updated to: **" + args[2] + "**").queue();
                    } else if (args[2].equalsIgnoreCase("false")) {
                        Main.getConfig().setDebug(false);
                        mre.getChannel().sendMessage("Debug updated to: **" + args[2] + "**").queue();
                    } else {
                        mre.getChannel().sendMessage("Please only use **true** or **false**.").queue();
                    }
                    break;
                case "log":
                    if (args[2].equalsIgnoreCase("true")) {
                        Main.getLog().setLogging(true);
                        mre.getChannel().sendMessage("Logging updated to: **" + args[2] + "**").queue();
                    } else if (args[2].equalsIgnoreCase("false")) {
                        Main.getLog().setLogging(false);
                        mre.getChannel().sendMessage("Logging updated to: **" + args[2] + "**").queue();
                    } else {
                        mre.getChannel().sendMessage("Please only use **true** or **false**.").queue();
                    }
                    break;
            }
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("uc", "updateconfig", "update");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Sets a new prefix for the Bot.";
    }

    @Override
    public String getName() {
        return "Prefix Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "update [key] [newValue]`");
    }

    @Override
    public boolean getDefaultPermission() {
        return false;
    }
}
