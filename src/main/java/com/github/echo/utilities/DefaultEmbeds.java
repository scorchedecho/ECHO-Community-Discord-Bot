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
public class DefaultEmbeds {

    public static MessageEmbed rules() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.addField("❧ | No harmful material.",
                "Any harmful material (including, but not limited to: viruses, scams, disturbing imagery) should not be posted in the server.\n" +
                        "➾ `1st offense` will result in a 24hr mute\n" +
                        "➾ `2nd offense` will result in a kick\n" +
                        "➾ `3rd offense` will result in a ban",
                false);

        embed.addField("❧ | Hate speech will **not** be tolerated.",
                "Any attacks towards any group of people, server member, etc. (even in meme form) is absolutely not allowed. " +
                        "Be respectful of other members. Inappropriate language (slurs, etc.) is not okay.\n" +
                        "➾ `1st offense` will result in a kick\n" +
                        "➾ `2nd offense` will result in a ban\n",
                false);

        embed.addField("❧ | No self-promotion or advertising.",
                "This includes, but is not limited to: Discord servers, self-hosted game servers, personal YouTube/Twitch content, etc.\n" +
                        "➾ `1st offense` will result in a 24hr mute\n" +
                        "➾ `2nd offense` will result in a kick\n" +
                        "➾ `3rd offense` will result in a ban",
                false);

        embed.addField("❧ | No spamming and no personal drama or disputes.",
                "Please take disputes to private messages. If it relates to the server, tag someone in the Moderation team to resolve the issue." +
                        "Please do not attempt to moderate the issue yourself.\nSpamming will not be tolerated. Just don't do it.\n" +
                        "➾ `1st offense` will result in a 24hr mute\n" +
                        "➾ `2nd offense` will result in a kick\n" +
                        "➾ `3rd offense` will result in a ban",
                false);

        embed.addField("❧ | Use common sense.",
                "This list does not constitute a full list of rules. At all times, use common sense and good judgement for any action you're about to take." +
                        " The Moderation team will always have the final decision in any situation.\n" +
                        "The Moderation team is around to take care of making sure these rules are enforced. If someone is breaking the rules, " +
                        "please ping someone in the team and do not attempt to moderate the conversation yourself.",
                false);

        return embed.build();
    }

    public static MessageEmbed links() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("Visit my website here!", "https://scorched-echo.com/");

        embed.addField("Twitch", "https://www.twitch.tv/scorched_echo", true);
        embed.addField("Twitter", "https://www.twitter.com/scorched_echo", true);
        embed.addField("YouTube", "https://www.youtube.com/c/AJStri", true);
        embed.addField("GitHub", "https://github.com/scorchedECHO", true);
        embed.addField("DeviantArt", "https://www.deviantart.com/scorched-echo", true);
        embed.addField("Toyhouse", "https://toyhou.se/scorched-echo", true);
        embed.addField("Discord Server Invite Link", "https://discord.gg/HH9EmGD", true);

        return embed.build();
    }

    public static MessageEmbed applications() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("Status: Partially Open");

        embed.addField("Discord Administrator Application", "https://forms.gle/pDkHwxKZprkLPAMq7", true);
        embed.addField("Website Administrator Application", "Not Yet Open", true);
        embed.addBlankField(true);
        embed.addField("Stream & Chat Moderator", "https://forms.gle/yS8Zn4PJ31jXX93UA", true);
        embed.addField("Website Moderator", "Not Yet Open", true);
        embed.addBlankField(true);

        return embed.build();
    }

    public static MessageEmbed donations() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.addField("Ko-Fi", "https://ko-fi.com/scorched-echo", true);
        embed.addBlankField(true);
        embed.addField("PayPal", "https://paypal.me/ajstri", true);
        embed.addField("Donations are, and always will be, completely optional.",
                "Please only donate if you enjoy what I do here and have the funds to do so.", false);
        embed.addField("Ko-Fi Rewards", "Currently, there are no Ko-Fi rewards. However, it is planned that Monthly Subscribers will receive rewards. In addition, one-time and monthly subscribers will gain access to pre-claim on my adoptables.", true);
        embed.addField("Nitro Rewards", "Currently, there are no Nitro Boosting rewards. However, it is planed that Nitro Boosters will receive rewards. In addition, Nitro Boosters will gain access to pre-claim on my adoptables.", false);

        return embed.build();
    }

    public static MessageEmbed art() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("All art in this channel is created by scorchedE.C.H.O", "https://www.deviantart.com/scorched-echo");
        embed.addField("Please do not use my artwork without permission.", "Do not use, copy, trace, or steal any artworks in this channel.", false);

        return embed.build();
    }

}
