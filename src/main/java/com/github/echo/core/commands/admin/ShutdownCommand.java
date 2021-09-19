package com.github.echo.core.commands.admin;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import com.github.echo.utilities.Constants;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  ShutdownCommand class of the ECHO Community Discord Bot project
 *
 *  All methods are explained in {@link Command}
 *
 * @author ECHO
 * @since September 2021
 */
public class ShutdownCommand extends Command {
    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("SHUTDOWN (called by " + mre.getAuthor().getAsTag() + ")");

        // Determine if the message came from the Owner, EchoedAJ#1840
        String id = mre.getAuthor().getId();
        if (id.contains(Constants.OWNER_ID)) {
            // Shutdown
            mre.getChannel().sendMessage("Okay, AJ.").complete();
            Main.shutdown(Constants.STATUS_FRIENDLY);
        }
        else {
            // Be offended, it's not AJ
            mre.getChannel().sendMessage("How dare you?").queue();
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("shutdown", "sd", "rest");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Shuts down the Bot.";
    }

    @Override
    public String getName() {
        return "Shutdown Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "sd`");
    }

    @Override
    public boolean getDefaultPermission() {
        return false;
    }
}