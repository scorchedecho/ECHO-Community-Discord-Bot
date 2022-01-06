package com.github.echo.utilities;

import com.github.echo.core.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

/**
 *  DefaultEmbeds class of the ECHO Community Discord Bot project
 *
 *  All methods are explained in {@link Command}
 *
 * @author ECHO
 * @since September 2021
 */
public class RoleReactEmbeds {
    public static MessageEmbed notificationRoles () {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("Notification Roles");

        embed.addField("", "React with :one: for `General Updates`", false);
        embed.addField("", "React with :two: for `Asset/Avatar Updates`", false);
        embed.addField("", "React with :three: for `Art Updates`", false);
        embed.addField("", "React with :four: for `GitHub Updates`", false);
        embed.addField("", "React with :five: for `Partner Updates`", false);

        return embed.build();
    }

    public static MessageEmbed aboutYouRoles () {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("About You");

        embed.addField("", "React with :one: for `VRChat Avatar Creator`", false);
        embed.addField("", "React with :two: for `YouTuber/Streamer`", false);
        embed.addField("", "React with :three: for `Artist`", false);
        embed.addField("", "React with :four: for `Programmer`", false);
        embed.addField("", "React with :five: for `18+ (NSFW)`", false);

        return embed.build();
    }

    public static MessageEmbed vrchatRoles () {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("VRChat Roles");

        embed.addField("", "React with <:" + Constants.EMOTE_INDEX + "> for `Index User`", false);
        embed.addField("", "React with <:" + Constants.EMOTE_OCULUS + "> for `Oculus User`", false);
        embed.addField("", "React with <:" + Constants.EMOTE_VIVE + "> for `Vive User`", false);
        embed.addField("", "React with :" + Constants.EMOTE_DESKTOP + ": for `Desktop User`", false);
        embed.addField("", "React with <:" + Constants.EMOTE_FULLBODY + "> for `Full-Body User`", false);

        return embed.build();
    }


    public static MessageEmbed pronounRoles () {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("Pronouns");

        embed.addField("", "React with " + Constants.EMOTE_GIRL + " for `she/her`", false);
        embed.addField("", "React with " + Constants.EMOTE_BOY + " for `he/him`", false);
        embed.addField("", "React with " + Constants.EMOTE_NEUTRAL + " for `they/them`", false);

        return embed.build();
    }

    /* ----- COLORS BEGIN HERE ----- */
    /**
     * Create custom Reaction Embed for red color roles
     * @return custom Reaction Embed for red color roles
     */
    public static MessageEmbed redRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_WINE + "> for <@&" + Constants.ROLEID_WINE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_BLOOD + "> for <@&" + Constants.ROLEID_BLOOD + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_ROSE + "> for <@&" + Constants.ROLEID_ROSE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_CHERRY + "> for <@&" + Constants.ROLEID_CHERRY + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_RUBY + "> for <@&" + Constants.ROLEID_RUBY + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for yellow color roles
     * @return custom Reaction Embed for yellow color roles
     */
    public static MessageEmbed yellowRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_SUMMERLOVE + "> for <@&" + Constants.ROLEID_SUMMERLOVE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_HONEY + "> for <@&" + Constants.ROLEID_HONEY + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_DAZE + "> for <@&" + Constants.ROLEID_DAZE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_BUZZ + "> for <@&" + Constants.ROLEID_BUZZ + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for blue color roles
     * @return custom Reaction Embed for blue color roles
     */
    public static MessageEmbed greenRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_LUSH + "> for <@&" + Constants.ROLEID_LUSH + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_FERNY + "> for <@&" + Constants.ROLEID_FERNY + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_CLOVER + "> for <@&" + Constants.ROLEID_CLOVER + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for blue color roles
     * @return custom Reaction Embed for blue color roles
     */
    public static MessageEmbed blueRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_SERPENT + "> for <@&" + Constants.ROLEID_SERPENT + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_STORM + "> for <@&" + Constants.ROLEID_STORM + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_PUDDLE + "> for <@&" + Constants.ROLEID_PUDDLE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_TSUNAMI + "> for <@&" + Constants.ROLEID_TSUNAMI + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_COSTAL + "> for <@&" + Constants.ROLEID_COSTAL + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for purple color roles
     * @return custom Reaction Embed for purple color roles
     */
    public static MessageEmbed purpleRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_ECHO + "> for <@&" + Constants.ROLEID_ECHO + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_FORTUNE + "> for <@&" + Constants.ROLEID_FORTUNE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_LAVENDER + "> for <@&" + Constants.ROLEID_LAVENDER + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for pink color roles
     * @return custom Reaction Embed for pink color roles
     */
    public static MessageEmbed pinkRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_DUSTYROSE + "> for <@&" + Constants.ROLEID_DUSTYROSE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_BLOSSOM + "> for <@&" + Constants.ROLEID_BLOSSOM + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_BLUSH + "> for <@&" + Constants.ROLEID_BLUSH + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_PEACH + "> for <@&" + Constants.ROLEID_PEACH + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for other color roles
     * @return custom Reaction Embed for other color roles
     */
    public static MessageEmbed otherRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_NORI + "> for <@&" + Constants.ROLEID_NORI + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_COFFEE + "> for <@&" + Constants.ROLEID_COFFEE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_WARMTH + "> for <@&" + Constants.ROLEID_WARMTH + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_COLD + "> for <@&" + Constants.ROLEID_COLD + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_CANVAS + "> for <@&" + Constants.ROLEID_CANVAS + ">", false);

        // Return embed
        return embed.build();
    }
}
