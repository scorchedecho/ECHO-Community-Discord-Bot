package com.github.echo.core.commands.general;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import com.github.echo.utilities.Constants;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 *  VerifyCommand class of the ECHO Community Discord Bot project
 *
 *  All methods are explained in {@link Command}
 *
 * @author ECHO
 * @since September 2021
 */
public class VerifyCommand extends Command {

    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent sce) {
        Main.getLog().info("SLASH / VERIFY (called by " + sce.getMember().getUser().getAsTag() + ")");

        if (sce.getName().equals("verify")) {
            sce.deferReply(true).queue();

            String avatar = sce.getOption("avatar").getAsString();
            String avatarCapital = avatar.substring(0, 1).toUpperCase() + avatar.substring(1);

            String license = sce.getOption("license").getAsString();
            String permalink = Main.getGumroadConfig().getPermalink(avatarCapital);

            if (permalink.isEmpty()) {
                sce.getHook().sendMessage("You did not chose an available avatar. Please try again.").queue();
                Main.getLog().error("Unable to verify license.", new Exception());
            }

            StringBuilder sb = new StringBuilder();
            try {
                URL url = new URL("https://api.gumroad.com/v2/licenses/verify");
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoOutput(true);
                http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                Main.getLog().debug("Attempting to verify: " + avatar + " with permalink " + permalink + " and license key " + license, Constants.stageCommand);
                String data = "product_permalink=" + permalink + "&license_key=" + license;

                byte[] out = data.getBytes(StandardCharsets.UTF_8);

                OutputStream stream = http.getOutputStream();
                stream.write(out);

                // Gather the JSON response
                Main.getLog().info(http.getResponseCode() + " " + http.getResponseMessage());
                if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(http.getInputStream(), "utf-8"));
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    br.close();
                    System.out.println("" + sb);

                    String response = respond(sb.toString(), sce.getMember().getUser().getAsTag());
                    if (response.contains("verified")) {
                            sce.getGuild().addRoleToMember(sce.getMember().getId(), sce.getGuild().getRolesByName(avatarCapital, true).get(0)).queue();
                            sce.getGuild().addRoleToMember(sce.getMember().getId(), sce.getGuild().getRoleById("659832639930368007")).queue();
                    }

                    sce.getHook().sendMessage(response).queue();
                }
                else {
                    sce.getHook().sendMessage("Your license key is not valid.").queue();
                }

                // Disconnect
                http.disconnect();
            }
            catch (IOException e) {
                sce.getHook().sendMessage("I ran into an unexpected issue. Please try again.").queue();
                Main.getLog().error("Unable to verify license.", e);
            }
        }
    }

    @Override
    public CommandData getSlashCommandData() {
        return Commands.slash("verify", "Verifies a purchase from E.C.H.O")
                .addOptions(addProductOptions())
                .addOption(OptionType.STRING, "license", "License Key from your purchase", true);
    }

    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("VERIFY (called by " + mre.getAuthor().getAsTag() + ")");

        // TODO handle normal commands
        mre.getChannel().sendMessage("The text-command version is not yet implemented. Please use the slash command in E.C.H.O's server. `/verify`").queue();
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("verify");
    }

    @Override
    public String getModule() {
        return Modules.GENERIC;
    }

    @Override
    public String getDescription() {
        return "Verifies a purchase from E.C.H.O";
    }

    @Override
    public String getName() {
        return "Verify Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "verify [Avatar Name] [License Key]`");
    }

    @Override
    public boolean getDefaultPermission() {
        return true;
    }

    private OptionData addProductOptions() {
        OptionData options = new OptionData(OptionType.STRING, "avatar", "Name of the avatar you purchased", true);

        for (String avatar : Main.getGumroadConfig().getProductNames()) {
            options.addChoice(avatar, avatar.toLowerCase());
        }

        return options;
    }

    private String respond(String json, String nameAsTag) {
        JSONObject obj = new JSONObject(json);

        // Was it a success?
        // The license key is no longer considered valid in refunds, disputes won, or chargebacks.
        if (obj.optString("success").equals("true")) {
            JSONObject nested = obj.getJSONObject("purchase");
            if (nested.optString("refunded").equals("true")
                || nested.optString("dispute_won").equals("true")
                || nested.optString("chargebacked").equals("true")) {
                // License key is not valid anymore.
                return "Due to a refund, dispute, or chargeback, your license key is no longer valid.";
            }
            else if (nested.optString("Discord#Tag").equals(nameAsTag)) {
                Main.getLog().debug(nameAsTag, Constants.stageCommand);
                return "Your license key has been verified! I have given you the respective role.";
            }
            else {
                Main.getLog().debug(nameAsTag + " does not match " + nested.optString("Discord#Tag"), Constants.stageCommand);
                return "Your Discord#Tag does not match the license key.";
            }
        }
        else {
            return "Your license key is not valid for the given avatar.";
        }
    }
}
