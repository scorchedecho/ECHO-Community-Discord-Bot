package com.github.echo.core.commands.admin;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import com.github.echo.utilities.Constants;
import com.github.echo.utilities.DefaultEmbeds;
import com.github.echo.utilities.MessageUtilities;
import com.github.echo.utilities.RoleReactEmbeds;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UpdateMessageCommand extends Command {
    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent sce) {}

    @Override
    public CommandData getSlashCommandData() { return null; }

    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("UPDATE MESSAGE (called by " + mre.getAuthor().getAsTag() + ")");

        String userID = mre.getAuthor().getId();
        if (!userID.equals(Constants.OWNER_ID)) {
            mre.getChannel().sendMessage("This command can only be used by the owner.").queue();
            return;
        }

        if (args.length < 2) {
            mre.getChannel().sendMessage("Please define a message ID.").queue();
        }

        /*List<TextChannel> channels = mre.getGuild().getTextChannels();

        for (TextChannel channel : channels) {
            channel.
        }*/

        mre.getGuild().getTextChannelById("928725880740675634").retrieveMessageById("928726052853940224").queue((message -> {
            message.editMessageEmbeds(RoleReactEmbeds.notificationRoles()).queue();
        }));

        // delete msg
        mre.getMessage().delete().queue();

    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("umsg", "updatemsg");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Tell the server you are going live!";
    }

    @Override
    public String getName() {
        return "Live Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "live`");
    }

    @Override
    public boolean getDefaultPermission() {
        return false;
    }
}
