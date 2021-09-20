package com.github.echo.core.commands.admin;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.utilities.Constants;
import com.github.echo.utilities.MessageUtilities;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiveCommand extends Command {

    private static final String link = "https://twitch.tv/scorched-echo";
    private static final String banner = "https://media.discordapp.net/attachments/888533896952676353/888534241137287259/Banner_with_Bat.png?width=2052&height=843";

    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("LIVE (called by " + mre.getAuthor().getAsTag() + ")");

        // handle args
        StringBuilder combinedArgs = new StringBuilder();
        args[0] = "";

        for (String x : args) {
            combinedArgs.append(x).append(" ");
        }
        String title = combinedArgs.toString().replaceFirst(" ", "");

        Main.getLog().debug("Going Live with: " + title, Constants.stageCommand);

        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("scorchedE.C.H.O is going live!", link);
        embed.setImage(banner);

        embed.addField(title, "Click the title to join!", false);

        mre.getChannel().sendMessage("@everyone").queue();
        mre.getChannel().sendMessageEmbeds(embed.build()).queue();

        // delete msg
        mre.getMessage().delete().queue();

    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("live", "twitch");
    }

    @Override
    public String getModule() {
        return null;
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
