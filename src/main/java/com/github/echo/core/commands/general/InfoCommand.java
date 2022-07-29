package com.github.echo.core.commands.general;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import com.github.echo.utilities.MessageUtilities;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 *  InfoCommand class of the ECHO Community Discord Bot project
 *
 *  All methods are explained in {@link Command}
 *
 * @author ECHO
 * @since September 2021
 */
public class InfoCommand extends Command {
    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent sce) {
        Main.getLog().info("SLASH / INFO (called by " + sce.getMember().getUser().getAsTag() + ")");

        if (sce.getName().equals("info")) {
            sce.replyEmbeds(MessageUtilities.embedCoreInfo().build()).setEphemeral(true).queue();
        }
    }

    @Override
    public CommandData getSlashCommandData() {
        return Commands.slash("info", "Returns information about the Bot.");
    }

    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("INFO (called by " + mre.getAuthor().getAsTag() + ")");

        mre.getChannel().sendMessageEmbeds(MessageUtilities.embedCoreInfo().build()).queue();
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("info");
    }

    @Override
    public String getModule() {
        return Modules.GENERIC;
    }

    @Override
    public String getDescription() {
        return "Returns information about the Bot.";
    }

    @Override
    public String getName() {
        return "Information Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "info`");
    }

    @Override
    public boolean getDefaultPermission() {
        return true;
    }
}
