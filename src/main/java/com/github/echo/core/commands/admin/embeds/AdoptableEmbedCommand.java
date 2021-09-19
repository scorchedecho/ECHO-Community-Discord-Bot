package com.github.echo.core.commands.admin.embeds;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

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
