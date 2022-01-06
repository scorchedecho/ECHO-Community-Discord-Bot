package com.github.echo.core.commands.admin.embeds;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import com.github.echo.utilities.Constants;
import com.github.echo.utilities.DefaultEmbeds;
import com.github.echo.utilities.RoleReactEmbeds;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  AddDefaultEmbedCommand class of the ECHO Community Discord Bot project
 *
 *  All methods are explained in {@link Command}
 *
 * @author ECHO
 * @since September 2021
 */
public class AddDefaultEmbedCommand extends Command {
    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("DEFAULT EMBED (called by " + mre.getAuthor().getAsTag() + ")");

        String embedOption = args[1].toLowerCase();

        // Embed Menu
        if (!mre.getChannel().getId().equals("")) {
            if (embedOption.contains("wip")) {
                mre.getChannel().sendMessage("You don't have any WIP embeds.").queue();
            }
            else if (embedOption.contains("info")) {
                // links and socials
                mre.getChannel().sendFile(Constants.LINKS).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.links()).queue();

                // donations
                mre.getChannel().sendFile(Constants.DONATIONS).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.donations()).queue();
            }
            else if (embedOption.contains("server")) {
                // info
                mre.getChannel().sendFile(Constants.INFO).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.credits()).queue();

                // applications
                mre.getChannel().sendFile(Constants.APPLICATIONS).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.applications()).queue();
            }
            else if (embedOption.contains("rules")) {
                // send the embed
                mre.getChannel().sendFile(Constants.RULES).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.rules()).queue();
            }
            else if (embedOption.contains("partners")) {
                mre.getChannel().sendFile(Constants.PARTNERS).queue();
            }
            else if (embedOption.contains("giveaways")) {
                mre.getChannel().sendFile(Constants.GIVEAWAY).queue();
            }
            else if (embedOption.contains("adopts")) {
                mre.getChannel().sendFile(Constants.ADOPTS).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.art()).queue();
            }
            else if (embedOption.contains("nitro")) {

            }
            else if (embedOption.contains("events")) {
                mre.getChannel().sendFile(Constants.EVENTS).queue();
            }
            else if (embedOption.contains("roles")) {
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.redRoles()).queue();
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.yellowRoles()).queue();
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.greenRoles()).queue();
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.blueRoles()).queue();
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.purpleRoles()).queue();
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.pinkRoles()).queue();
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.otherRoles()).queue();

                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.aboutYouRoles()).queue();
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.pronounRoles()).queue();
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.vrchatRoles()).queue();
                mre.getChannel().sendMessageEmbeds(RoleReactEmbeds.notificationRoles()).queue();
            }
            else {
                mre.getChannel().sendMessage("Try again, ECHO.").queue();
            }

            // delete message
            mre.getMessage().delete().queue();
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("defm", "dm", "default");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Sends a pre-defined embed.";
    }

    @Override
    public String getName() {
        return "Add Default Embed Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList(Main.getConfig().getPrefix() + getAliases().get(0) + " [EmbedOption]");
    }

    @Override
    public boolean getDefaultPermission() {
        return false;
    }
}
