package com.github.echo.core.commands.admin.embeds;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import com.github.echo.utilities.MessageUtilities;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 *  AdoptableEmbedCommand class of the ECHO Community Discord Bot project
 *
 *  All methods are explained in {@link Command}
 *
 * @author ECHO
 * @since September 2021
 */
public class AdoptableEmbedCommand extends Command {
    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("ADOPT EMBED (called by " + mre.getAuthor().getAsTag() + ")");
        // set defaults
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        // get stuffs
        String number = args[1];
        String url = args[2];
        String image = args[3];
        String typeOfAdopt = args[4];
        String price = args[5];
        String sbPrice = args[6];

        if (typeOfAdopt.contains("1")) {
            typeOfAdopt = "Set Price";
        }
        else if (typeOfAdopt.contains("2")) {
            typeOfAdopt = "Auction";
        }
        else if (typeOfAdopt.contains("3")) {
            typeOfAdopt = "Offer to Adopt";
        }

        embed.setTitle("Adoptable " + number + ": " + typeOfAdopt + " | " + sbPrice, url);
        embed.addField("This Adoptable is OPEN", "Owner: N/A", false);
        embed.addField("Prices", price, false);
        embed.addBlankField(false);
        embed.addField("How to claim/bid", "Comment on the DeviantArt post (click the title) or post in the associated thread below!\nIf the thread is closed, you can request it be reopened.", false);

        embed.setImage(image);

        mre.getChannel().sendMessageEmbeds(embed.build()).queue();
        mre.getMessage().delete().queue();
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("newadopt", "nadopt", "adoptem");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Creates a new Adoptable Embed.";
    }

    @Override
    public String getName() {
        return "Adoptable Announcement Embed";
    }

    @Override
    public List<String> getUsage() {
        return null;
    }

    @Override
    public boolean getDefaultPermission() {
        return false;
    }
}
