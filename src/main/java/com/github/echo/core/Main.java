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
package com.github.echo.core;

import com.github.echo.core.commands.*;
import com.github.echo.core.commands.admin.*;
import com.github.echo.core.commands.admin.embeds.AddDefaultEmbedCommand;
import com.github.echo.core.commands.admin.embeds.AdoptableEmbedCommand;
import com.github.echo.core.commands.general.InfoCommand;
import com.github.echo.core.commands.general.VerifyCommand;
import com.github.echo.utilities.*;
import com.github.echo.core.listeners.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;

import javax.security.auth.login.LoginException;
import java.util.concurrent.TimeUnit;

/**
 * Main class of the ECHO Community Discord Bot project
 * The very Core of the framework. Contains all commands for
 * instantiating the Bot.
 *
 * @author ECHO
 * @since September 2021
 */
public class Main {
    // jda specific
    private static JDA api;
    private static JDABuilder builder;

    // core specific
    private static final Logger log = new Logger();
    private static BotConfiguration config;
    private static GumroadConfiguration gumroadConfig;
    private static final HelpCommand help = new HelpCommand();
    private static long time = 0;

    // LavaPlayer specific
    //private static AudioPlayerManager audioManager;
    //private static MusicUtilities utils;
    //private static Map<Long, GuildMusicManager> musicManagers;

    public static void main(String[] args) {
        getLog().welcome();

        enableInternalConfig();

        debugOnlyInitialization();
        preInitialization();
        initialization();
        postInitialization();
    }

    private static void debugOnlyInitialization() {
        if (config.getDebug()) {
            getLog().debug("Welcome to EchoedCore! \n \n", Constants.stagePreInit);
            getLog().debug("Prefix: " + config.getPrefix(), Constants.stagePreInit);
            getLog().debug("Game Status: " + "config.getGameStatus()", Constants.stagePreInit);
            getLog().debug("Debug Status: " + "true", Constants.stagePreInit);
            getLog().debug("Token: " + config.getToken(), Constants.stagePreInit);
        }
    }

    private static void preInitialization() {
        getLog().debug("Beginning Pre-Initialization.", Constants.stagePreInit);

        time = System.currentTimeMillis();

        builder = JDABuilder.createDefault(config.getToken())
                .setAutoReconnect(true);
        //.setActivity(Activity.watching("time pass by"));
    }

    private static void initialization() {
        getLog().debug("Beginning initialization.", Constants.stageInit);
        // Define the JDA Instance.
        try {
            getLog().debug("Defining JDA instance.", Constants.stageInit);

            if (getConfig().getShards() > 0) {
                // Adding event listeners.
                registerEventListeners();
                // Sharding.
                for (int i = 0; i < getConfig().getShards(); i++)
                {
                    api = builder.useSharding(i, config.getShards())
                            .build();
                    api.awaitReady();
                }
            }
            else {
                api = builder.build();
                registerEventListeners();
                api.awaitReady();
            }
        }
        catch (LoginException le){
            getLog().error("Unable to define the JDA instance.", le);
            shutdown(Constants.STATUS_NO_JDA);
        }
        catch (InterruptedException ie) {
            getLog().error("Interrupted upon waiting JDA Instance.", ie);
            shutdown(Constants.STATUS_NO_JDA);
        }
        catch (ErrorResponseException ere) {
            getLog().error("Unable to connect.", ere);
            shutdown(Constants.STATUS_UNABLE_TO_CONNECT);
        }

        // register commands

        // admin
        registerCommand(new ShutdownCommand());
        registerCommand(new UpdateConfigCommand());
        registerCommand(new LiveCommand());
        registerCommand(new UpdateMessageCommand());
        registerCommand(new AddProductCommand());

        // admin embeds
        registerCommand(new AddDefaultEmbedCommand());
        registerCommand(new AdoptableEmbedCommand());

        // generic
        registerSlashCommand(new InfoCommand());
        registerSlashCommand(new VerifyCommand());
    }

    private static void postInitialization() {
        getLog().debug("Beginning post-initialization.", Constants.stagePostInit);

        // Set the Bot's ID.
        try {
            getLog().debug("Bot ID: " + getId(), Constants.stagePostInit);
        }
        catch (Exception e) {
            getLog().error("Error retrieving Bot ID. This is not a vital step, but may cause issues later.", e);
        }

        // Set auto-reconnect to true & set game status.
        api.setAutoReconnect(true);
        api.getPresence().setActivity(Activity.watching("time pass by"));
    }

    // internal functions

    /**
     * Enables the use of the {@link BotConfiguration} internally
     *
     */
    public static void enableInternalConfig() {
        config = new BotConfiguration();
        gumroadConfig = new GumroadConfiguration();
    }

    /**
     * Registers a single command
     *
     * @param command Command to register
     */
    @SuppressWarnings("UnusedReturnValue")
    private static void registerCommand(Command command) {
        api.addEventListener(getHelp().registerCommand(command));
    }

    /**
     * Registers a single slash command
     * This will also register the command as a normal command.
     *
     * @param command Command to register
     */
    private static void registerSlashCommand(Command command) {
        Guild guild = api.getGuildById(Constants.GUILD_ID);

        guild.updateCommands().addCommands(command.getSlashCommandData()).queue();
        registerCommand(command);
    }

    /**
     * Adds default event listeners.
     */
    private static void registerEventListeners() {
        registerEventListener(new TagListener());
    }

    /**
     * Registers an event listener
     *
     * @param listener Event listener to register
     */
    @SuppressWarnings("UnusedReturnValue")
    private static void registerEventListener(Object... listener) {
        try {
            api.addEventListener(listener);
        }
        catch (Exception e) {
            log.error("Unable to register Event Listeners.", e);
            shutdown(Constants.STATUS_NO_EVENT);
        }
    }


    // getter and setter

    /**
     * Retrieve the {@link BotConfiguration} instance
     *
     * @return The {@link BotConfiguration} instance used
     * by the bot
     */
    public static BotConfiguration getConfig() {
        return config;
    }

    /**
     * Retrieve the {@link GumroadConfiguration} instance
     *
     * @return The {@link GumroadConfiguration} instance used
     * by the bot
     */
    public static GumroadConfiguration getGumroadConfig() {
        return gumroadConfig;
    }

    /**
     * Retrieve the {@link Logger} instance
     *
     * @return The {@link Logger} instance used
     * by the bot
     */
    public static Logger getLog () {
        return log;
    }

    /**
     * Retrieve the {@link HelpCommand} instance
     *
     * @return The {@link HelpCommand} instance used
     * by the bot
     */
    public static HelpCommand getHelp() {
        return help;
    }

    /**
     * Retrieve the Bot's ID
     *
     * @return The Bot's ID
     */
    public static String getId() {
        return getApi().getSelfUser().getId();
    }

    /**
     * Retrieve the {@link JDA} instance
     *
     * @return The {@link JDA} instance used
     * by the bot
     */
    public static JDA getApi() {
        return api;
    }

    // etc

    /**
     * Shutdown the Bot Instance and exit the program
     *
     * @param status Status of the shutdown
     */
    public static void shutdown(int status) {
        System.exit(status);

        long endTime = System.currentTimeMillis();
        long timeActive = endTime - time;

        getLog().info("Active for " + ((timeActive / 1000) / 60) + " minutes. (" + (timeActive / 1000) + " seconds)");
        getLog().info("Beginning shutdown.");

        // Remove event listeners. The Bot can shut down before these are defined.
        try {
            api.removeEventListener(api.getRegisteredListeners());
        }
        catch (NullPointerException npe) {
            getLog().debug("No Event Listeners to remove.", Constants.stageShutdown);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException ie) {
            getLog().debug("Ignored InterruptedException on shut down.", Constants.stageShutdown);
        }

        if (status != Constants.STATUS_NO_JDA && status != Constants.STATUS_CONFIG_UNUSABLE && status != Constants.STATUS_UNABLE_TO_CONNECT) {
            api.shutdownNow();
        }
        System.exit(status);
    }

}
