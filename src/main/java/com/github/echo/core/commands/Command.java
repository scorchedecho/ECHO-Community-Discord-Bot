/*
 *  Copyright 2021 scorchedECHO
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.echo.core.commands;

import com.github.echo.core.Main;
import com.github.echo.utilities.Constants;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 *  Command class of the ECHO Community Discord Bot project
 *
 *  All methods are explained here
 *
 * @author ECHO
 * @since September 2020
 */
public abstract class Command extends ListenerAdapter {

    /**
     * Calls a slash command
     * @param sce Event triggered
     */
    public abstract void onSlashCommand(@NotNull SlashCommandInteractionEvent sce);

    /**
     * Slash Command data
     * @return data of the Slash Command
     */
    public abstract CommandData getSlashCommandData();


    /**
     * Calls a command
     * @param mre Event triggered
     * @param args Arguments from event trigger
     */
    protected abstract void onCommand(MessageReceivedEvent mre, String[] args);

    /**
     * Returns a list of aliases that the command can be called by.
     * The first one is it's "mainly" used alias.
     * @return list of possible aliases.
     */
    public abstract List<String> getAliases();

    /**
     * Gets the Module the Command is a part of.
     * @return the Module
     */
    public abstract String getModule();

    /**
     * Gets the description of the Command.
     * @return description of the Command.
     */
    public abstract String getDescription();

    /**
     * Gets the name of the Command
     * @return name of the Command
     */
    public abstract String getName();

    /**
     * Gets example usage for the Command
     * @return example usage for the Command
     */
    public abstract List<String> getUsage();

    /**
     * Determines default permissions
     * @return true if default, false if not
     */
    // TODO reimplement getDefaultPermission();
    @SuppressWarnings("SameReturnValue")
    public abstract boolean getDefaultPermission();

    /**
     * Called when Message is received visible to the Bot.
     * Determines if there was a command called, and if so,
     * executes the command.
     * @param mre Event triggered.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent mre) {
        if (mre.getAuthor().isBot() && !respondToBots()) {
            return;
        }
        if(commandArgs(mre.getMessage())[0].contains(Main.getConfig().getPrefix()) && containsCommand(mre.getMessage())) {
            Main.getLog().info("Calling a command...");

            String id = mre.getAuthor().getId();
            if (!id.contains(Constants.OWNER_ID) && !getDefaultPermission()) return;
            onCommand(mre, commandArgs(mre.getMessage()));
        }

    }

    /**
     * Called when Slash Command is received visible to the Bot.
     * Determines if there was a command called, and if so,
     * executes the command.
     * @param sce Event triggered.
     */
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent sce) {
        if (sce.getName().equals(getSlashCommandData().getName())) {
            Main.getLog().info("Calling a slash command...");

            onSlashCommand(sce);
        }
    }

    /**
     * Determines if the message contained a command.
     * @param message message to scan
     * @return true if message contained command, false if not.
     */
    private boolean containsCommand(Message message) {
        return getAliases().contains(commandArgs(message)[0].replace(Main.getConfig().getPrefix(), ""));
    }

    /**
     * Breaks up the message into String[].
     * @param message message to split
     * @return String[] of the split message.
     */
    private String[] commandArgs(Message message) {
        return commandArgs(message.getContentDisplay());
    }

    /**
     * Breaks up the message into String[].
     * @param string message to split
     * @return String[] of the split message.
     */
    private String[] commandArgs(String string) {
        return string.split(" ");
    }

    /**
     * Determines if the Bot will respond to other Bots.
     * @return true if the Bot will respond to other Bots,
     * false if not.
     */
    @SuppressWarnings("SameReturnValue")
    private boolean respondToBots() {
        return false;
    }
}
