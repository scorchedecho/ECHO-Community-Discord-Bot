package com.github.echo.core.commands.general;

import com.github.echo.core.Main;
import com.github.echo.core.commands.Command;
import com.github.echo.core.commands.Modules;
import com.github.echo.utilities.Constants;
import com.github.echo.utilities.MessageUtilities;
import com.github.echo.utilities.exceptions.UnhandledMathException;
import com.github.echo.utilities.math.Logarithmic;
import com.github.echo.utilities.math.Trigonometry;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Collections;
import java.util.List;

/**
 *  InfoCommand class of the ECHO Community Discord Bot project
 *
 *  All methods are explained in {@link Command}
 *
 * @author ECHO
 * @since September 2021
 */
public class MathCommand extends Command {
    @Override
    public void onSlashCommand(@NotNull SlashCommandInteractionEvent sce) {
        Main.getLog().info("SLASH / MATH (called by " + sce.getMember().getUser().getAsTag() + ")");

        if (sce.getName().equals("math")) {
            sce.replyEmbeds(MessageUtilities.embedCoreInfo().build()).setEphemeral(true).queue();
        }
    }

    @Override
    public CommandData getSlashCommandData() {
        return Commands.slash("math", "Evaluates a mathematical expression.");
    }

    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("MATH (called by " + mre.getAuthor().getAsTag() + ")");

        if (args[1].contains("supported") || args[1].contains("functions"))

        mre.getChannel().sendMessageEmbeds(MessageUtilities.embedCoreInfo().build()).queue();
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("math");
    }

    @Override
    public String getModule() {
        return Modules.GENERIC;
    }

    @Override
    public String getDescription() {
        return "Returns information about the Bot.";
    }

    @Override
    public String getName() {
        return "Information Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "info`");
    }

    @Override
    public boolean getDefaultPermission() {
        return true;
    }

    private static MessageEmbed functions() {
        // Make the functions embed
        Main.getLog().debug("User asked for supported functions.", Constants.stageCommand);

        EmbedBuilder embed = new EmbedBuilder().setTitle("Functions Supported").setColor(new Color(111, 83, 112));
        MessageUtilities.addEmbedDefaults(embed);

        embed.addField("Addition", "Example: 2 + 2", false);
        embed.addField("Subtraction", "Example: 2 - 2", false);
        embed.addField("Multiplication", "Example: 2 * 2", false);
        embed.addField("Division", "Example: 2 / 2", false);

        embed.addField("Sine", "Example: sin(90), sinh(90), asin(90), or asinh(90)", false);
        embed.addField("Tangent", "Example: tan(90), tanh(90), atan(90), or atanh(90)", false);
        embed.addField("Cosine", "Example: cos(90), cosh(90), acos(90), or acosh(90)", false);

        embed.addField("Cosecant", "Example: csc(90), csch(90), acsc(90), or acsch(90)", false);
        embed.addField("Cotangent", "Example: cot(90), coth(90), acot(90), or acoth(90)", false);
        embed.addField("Secant", "Example: sec(90), sech(90), asec(90), or asech(90)", false);

        embed.addField("Logarithmic", "Example: ln(10) or log(10)", false);

        embed.addField("Roots", "Example: cbrt(8) or sqrt(4)", false);

        embed.addField("Absolute Value", "Example: abs(-90)", false);

        return embed.build();
    }

    private static String factorial(String number) {
        try {
            double x = Double.parseDouble(number);
            double result = x;

            while (x > 1) {
                x = x - 1;
                result = result * x;
            }

            Main.getLog().debug("Result is " + result, Constants.stageCommand);

            return ("" + result).replace("E", " * 10^");

        }
        catch (NumberFormatException nfe) {
            Main.getLog().error("Incorrect input on factorial.", nfe);
            return "Please input a number.";
        }
    }

    /**
     * A super overkill Math function
     *
     * This code is altered from a StackOverflow answer
     * and is used from public domain.
     * You can find the original code here:
     * https://stackoverflow.com/a/26227947
     *
     * It has been adapted to work for a Discord bot and
     * expanded to include more mathematical functions.
     * It is a fully functional, dynamic-length math evaluation
     * method.
     *
     * @param str mathematical expression to parse.
     * @param c Channel that the expression is from.
     * @return the answer to the expression.
     */
    public static double eval(String str, MessageChannel c) {
        Main.getLog().debug("Parsing: " + str, Constants.stageCommand);
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) {
                    Main.getLog().error("Unexpected: " + (char)ch, new RuntimeException("Unexpected: " + (char)ch));
                    c.sendMessage("Unexpected: " + (char)ch).queue();
                    return 0;
                }
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) {
                        x += parseTerm(); // addition
                    }
                    else if (eat('-')) {
                        x -= parseTerm(); // subtraction
                    }
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) {
                        x *= parseFactor(); // multiplication
                    }
                    else if (eat('/')) {
                        x /= parseFactor(); // division
                    }
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) {
                        Main.getLog().error("Missing closing parenthesis", new UnhandledMathException("Missing closing parenthesis"));
                        c.sendMessage("Missing closing parenthesis").queue();
                        return 0;
                    }
                }
                else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                }
                else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();

                    x = parseFunction(x, func, c);
                    if (x == -99999) return 0;
                }
                else {
                    Main.getLog().error("Unexpected: " + (char)ch, new UnhandledMathException("Unexpected: " + (char)ch));
                    c.sendMessage("Unexpected: " + (char)ch).queue();
                    return 0;
                }

                if (eat('^')) {
                    x = Math.pow(x, parseFactor()); // exponentiation
                }

                return x;
            }
        }.parse();
    }

    /**
     * Checks for a supported function. If there is none, send a message and quit.
     * @param x parameter for function
     * @param func function to check for
     * @param c channel to send message to
     * @return result of function
     */
    private static double parseFunction(double x, String func, MessageChannel c) {
        switch (func) {
            // Roots
            case "sqrt":
                x = Math.sqrt(x);
                break;
            case "cbrt":
                x = Math.cbrt(x);
                break;

            // Basic Trig
            case "sin":
                x = Trigonometry.sin(x);
                break;
            case "cos":
                x = Trigonometry.cos(x);
                break;
            case "tan":
                x = Trigonometry.tan(x);
                break;

            case "csc":
                x = Trigonometry.csc(x);
                break;
            case "sec":
                x = Trigonometry.sec(x);
                break;
            case "cot":
                x = Trigonometry.cot(x);
                break;

            // Hyperbolic Trig
            case "sinh":
                x = Trigonometry.sinh(x);
                break;
            case "cosh":
                x = Trigonometry.cosh(x);
                break;
            case "tanh":
                x = Trigonometry.tanh(x);
                break;

            case "csch":
                x = Trigonometry.csch(x);
                break;
            case "sech":
                x = Trigonometry.sech(x);
                break;
            case "coth":
                x = Trigonometry.coth(x);
                break;

            // Inverse Trig
            case "asin":
                x = Trigonometry.asin(x);
                break;
            case "acos":
                x = Trigonometry.acos(x);
                break;
            case "atan":
                x = Trigonometry.atan(x);
                break;

            case "acsc":
                x = Trigonometry.acsc(x);
                break;
            case "asec":
                x = Trigonometry.asec(x);
                break;
            case "acot":
                x = Trigonometry.acot(x);
                break;

            // Inverse & Hyperbolic Trig
            case "asinh":
                x = Trigonometry.asinh(x);
                break;
            case "acosh":
                x = Trigonometry.acosh(x);
                break;
            case "atanh":
                x = Trigonometry.atanh(x);
                break;

            case "acsch":
                x = Trigonometry.acsch(x);
                break;
            case "asech":
                x = Trigonometry.asech(x);
                break;
            case "acoth":
                x = Trigonometry.acoth(x);
                break;

            // Logarithmic
            case "ln":
                x = Logarithmic.ln(x);
                break;
            case "log":
                x = Logarithmic.log(x);
                break;

            // Other
            case "abs":
                x = Math.abs(x);
                break;

            default:
                Main.getLog().error("Unknown function: " + func, new UnhandledMathException("Unknown function: " + func));
                c.sendMessage("Unknown function: " + func).queue();
                return -99999;
        }

        return x;
    }
}
