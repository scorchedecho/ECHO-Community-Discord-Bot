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

    private static final Color embedColor = new Color(111, 83, 112);

    // ---------- Links
    // Applications
    private static final String adminApps = "https://scorched-echo.com/go/discord-admin";
    private static final String modApps = "https://scorched-echo.com/go/chat-mod";
    // Social Media
    private static final String github = "https://www.github.com/scorchedecho";
    private static final String twitter = "https://www.twitter.com/scorchedecho";
    private static final String facebook = "https://www.facebook.com/scorchedecho";
    private static final String instagram = "https://www.instagram.com/scorchedecho";
    private static final String deviantart = "https://www.deviantart.com/scorchedecho";
    private static final String kofi = "https://www.ko-fi.com/scorchedecho";
    private static final String pinterest = " https://www.pinterest.com/scorchedecho";
    private static final String twitch = "https://www.twitch.tv/scorched_echo";
    private static final String reddit = "https://www.reddit.com/user/scorched_echo";
    private static final String tiktok = "https://www.tiktok.com/@scorchedecho";
    private static final String youtube = "https://www.youtube.com/channel/UCrgsX1i9c1XKOxXywZ6h7og";
    private static final String toyhouse = "https://toyhou.se/scorchedecho";
    private static final String gumroad = "https://store.scorched-echo.com";
    private static final String discord = "https://discord.gg/HH9EmGD";

    // Other
    private static final String credits = "https://www.scorched-echo.com/home/about/credits/";

    public static MessageEmbed rules() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(embedColor);

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
                        "➾ List out every asset with the creators name. Do not list names without saying which asset they made.\n" +
                        "➾ Credit yourself for any assets you made. Any and all assets used must be credited to yourself or others.\n",
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

        embed.addField("<:" + Constants.EMOTE_GUMROAD + "> Gumroad","[Click Here](" + gumroad + " 'scorchedE.C.H.O on Gumroad')", true);
        embed.addBlankField(true);
        embed.addBlankField(true);

        embed.addField("<:" + Constants.EMOTE_TWITTER + "> Twitter","[Click Here](" + twitter + " 'scorchedE.C.H.O on Twitter')", true);
        embed.addField("<:" + Constants.EMOTE_TWITCH + "> Twitch","[Click Here](" + twitch + " 'scorchedE.C.H.O on Twitch')", true);
        embed.addField("<:" + Constants.EMOTE_YOUTUBE + "> YouTube","[Click Here](" + youtube + " 'scorchedE.C.H.O on YouTube')", true);

        embed.addField("<:" + Constants.EMOTE_FACEBOOK + "> Facebook","[Click Here](" + facebook + " 'scorchedE.C.H.O on Facebook')", true);
        embed.addField("<:" + Constants.EMOTE_INSTAGRAM + "> Instagram","[Click Here](" + instagram + " 'scorchedE.C.H.O on Instagram')", true);
        embed.addField("<:" + Constants.EMOTE_REDDIT + "> Reddit","[Click Here](" + reddit + " 'scorchedE.C.H.O on Reddit')", true);

        embed.addField("<:" + Constants.EMOTE_GITHUB + "> GitHub","[Click Here](" + github + " 'scorchedE.C.H.O on GitHub')", true);
        embed.addField("<:" + Constants.EMOTE_DEVIANTART + "> DeviantArt","[Click Here](" + deviantart + " 'scorchedE.C.H.O on DeviantArt')", true);
        embed.addField("<:" + Constants.EMOTE_TIKTOK + "> TikTok","[Click Here](" + tiktok + " 'scorchedE.C.H.O on TikTok')", true);

        embed.addField("<:" + Constants.EMOTE_TOYHOUSE + "> Toyhou.se","[Click Here](" + toyhouse + " 'scorchedE.C.H.O on Toyhou.se')", true);
        embed.addField("<:" + Constants.EMOTE_PINTEREST + "> Pinterest","[Click Here](" + pinterest + " 'scorchedE.C.H.O on Pinterest')", true);

        embed.addField("<:" + Constants.EMOTE_DISCORD + "> Discord Server","[Click Here](" + discord + " 'scorchedE.C.H.O on Discord')", true);

        return embed.build();
    }

    public static MessageEmbed applications() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("Status: Open");

        embed.addField("Discord Administrator Application", "[Click Here](" + adminApps + " 'Administrator Applications')", true);
        embed.addField("Stream & Chat Moderator", "[Click Here](" + modApps + " 'Moderator Applications')", true);

        return embed.build();
    }

    public static MessageEmbed credits() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.setTitle("Credits");

        // fiverr, emotes, stream layout
        embed.addField("<:" + Constants.EMOTE_BATSTARE + "> Credits","[Click Here](" + credits + " 'View on scorched-echo.com')", true);
        embed.addField("", "A lot of artists contributed to my identity as you know it. Please check them out here.", false);

        return embed.build();
    }

    public static MessageEmbed donations() {
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(111, 83, 112));

        embed.addField("<:" + Constants.EMOTE_KOFI + "> Ko-Fi","[Click Here](" + kofi + " 'scorchedE.C.H.O on Ko-Fi')", true);
        embed.addField("Donations are, and always will be, completely optional.",
                "Please only donate if you enjoy what I do here and have the funds\n to do so.", false);
        embed.addBlankField(false);
        embed.addField("Ko-Fi Rewards", "Currently, there are no Ko-Fi rewards. However, it is planned that\n Monthly Subscribers will receive rewards. In addition, one-time\n and monthly subscribers will gain access to pre-claim on my\n adoptables.", true);
        embed.addField("Nitro Rewards", "Currently, there are no Nitro Boosting rewards. However, it is planned\n that Nitro Boosters will receive rewards. In addition, Nitro Boosters\n will gain access to pre-claim on my adoptables.", false);

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
