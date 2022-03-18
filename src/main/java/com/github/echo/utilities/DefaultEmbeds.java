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

    public static MessageEmbed marketRules() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.addField("❧ | Credit every single asset on your avatar, even if you made it.",
                        "➾ Include their Discord tag in your post. If you can't find it, or they don't have one, state their name.\n" +
                        "➾ Don't post links in your Discord message, but you must include them on the product listing.\n" +
                        "➾ You may post a text (.txt) file with both their names (and links if you choose) to save space. This is in addition to the product listing.\n"+
                        "➾ List out every asset with the creators name. Do not list names without saying which asset they made.\n",
                false);

        embed.addField("❧ | Do not sell assets you do not have the commercial right to sell.",
                "This is illegal and it is not allowed or welcome in our market. These assets include, but are not limited to:\n" +
                        "➾ Game rips and assets (Second Life, Shining Nikki, etc.)\n" +
                        "➾ TDA & IMVU\n" +
                        "➾ Assets purchased with personal license only",
                false);

        embed.addField("❧ | Do not sell assets that mimic brands or have brand logos.",
                "This is illegal and it is not allowed or welcome in our market.",
                false);

        embed.addField("❧ | Do not advertise uploads or sales through direct messages.",
                "This is an easy way to scam and hard to moderate.",
                false);

        embed.addField("❧ | Follow our post etiquette.",
                        "➾ Use readable text.\n" +
                        "➾ No advertising preorders, discounts, or sale posts.\n" +
                        "➾ Do not repost.\n" +
                        "➾ Do not post other people's avatars, only your own.\n" +
                        "➾ Link directly to the product page. Do not link to the store page or your Discord server.\n" +
                        "➾ Do not post \"join my server for a discount/for free\" assets. This is a form of advertising not allowed.\n" +
                        "➾ Do not include NSFW previews on your sale post or on your product listing. Avoid stating if it is NSFW at all, as it is against VRChat's T.O.S. to sell.\n",
                false);

        embed.addBlankField(false);

        embed.addField("If you agree to these rules, react below to gain your Verified Seller role.",
                "If you fail to follow these rules:\n➾ `1st offense` will result in a warning\n" +
                        "➾ `2nd offense` will result in a 24hr mute\n" +
                        "➾ `3rd offense` will result in a kick\n" +
                        "➾ `4th offense` will result in a ban\n",
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

        embed.addField("Discord Administrator Application", "https://scorched-echo.com/go/chat-mod", true);
        embed.addField("Website Administrator Application", "Not Yet Open", true);
        embed.addBlankField(true);
        embed.addField("Stream & Chat Moderator", "https://scorched-echo.com/go/discord-admin", true);
        embed.addField("Website Moderator", "Not Yet Open", true);
        embed.addBlankField(true);

        return embed.build();
    }

    public static MessageEmbed credits() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("Credits");

        // fiverr, emotes, stream layout
        embed.addField("seb0231 on Fiverr", "Discord Assets\nhttps://www.fiverr.com/seb0231", true);
        embed.addField("Hugh Leandro on Twitter", "Stream Layout\nhttps://twitter.com/imHugoLeandro", true);
        embed.addField("Many Artists", "View all here\nhttps://scorched-echo.com/about/echo-bat", true);

        embed.addField("Beautifulkitties12 on DeviantArt", "Emotes\nhttps://www.deviantart.com/beautifulkitties12", true);
        embed.addField("Yoru#1112 on Discord", "Emotes\nhttps://discord.gg/mDscNrAytV", true);
        embed.addField("jasper#2262 on Discord", "Emotes", true);

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
