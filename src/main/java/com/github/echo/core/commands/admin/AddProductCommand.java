package com.github.echo.core.commands.admin;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import com.github.echo.utilities.Constants;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  AddProductCommand class of the ECHO Community Discord Bot project
 *
 *  All methods are explained in {@link Command}
 *  Slash Command methods are unused as these are owner-only commands.
 *
 * @author ECHO
 * @since September 2021
 */
public class AddProductCommand extends Command {
    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent sce) {}

    @Override
    public CommandData getSlashCommandData() { return null; }

    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("ADD PRODUCT (called by " + mre.getAuthor().getAsTag() + ")");

        // Check if owner. If not, quit
        String userID = mre.getAuthor().getId();
        if (!userID.equals(Constants.OWNER_ID)) {
            mre.getChannel().sendMessage("This command can only be used by the owner.").queue();
            return;
        }

        // If no argument, ask for one
        if (args.length < 3) {
            mre.getChannel().sendMessage("Please define a name & permalink to add a product.").queue();
        }
        else {
            String name = args[1];
            String permalink = args[2];

            Main.getGumroadConfig().addProduct(name, permalink);
            mre.getChannel().sendMessage("Product added to archive.").queue();
        }

        // TODO Refresh command data for VerifyCommand


    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("product", "np");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Adds a verifiable product.";
    }

    @Override
    public String getName() {
        return "Add Product Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "product [product name] [product link]`");
    }

    @Override
    public boolean getDefaultPermission() {
        return false;
    }
}
