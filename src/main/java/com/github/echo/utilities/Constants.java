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
package com.github.echo.utilities;

import java.io.File;

/**
 * Constants used by the ECHO Community Discord Bot project
 */
@SuppressWarnings("unused")
public class Constants {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final int STATUS_FRIENDLY = 0;
    public static final int STATUS_NO_EVENT = -1;
    public static final int STATUS_NO_JDA = -2;
    public static final int STATUS_NO_CONFIG = -3;
    public static final int STATUS_CONFIG_UNUSABLE = -4;
    public static final int STATUS_UNABLE_TO_CONNECT = -5;

    public static final String DEBUG_KEY = "debug_mode";
    public static final String TOKEN_KEY = "token";
    public static final String PREFIX_KEY = "prefix";
    public static final String GAME_STATUS_KEY = "game_status";
    public static final String SHARDS_KEY = "shards";
    public static final String MATHMODE_KEY = "mathmode";

    public static final String DEBUG_VALUE = "true";
    public static final String TOKEN_VALUE = "Place your bot token here";
    public static final String PREFIX_VALUE = "/";
    public static final String GAME_STATUS_VALUE = "with my friends";
    public static final String SHARDS_VALUE = "0";
    public static final String MATHMODE_VALUE = "degrees";

    public static final String VERSION = "0";
    public static final String BUILD_NUMBER = "0.2S";
    public static final String JVM = System.getProperty("java.version");

    public static final String stagePreInit = "PRE-INITIALIZATION";
    public static final String stageInit = "INITIALIZATION";
    public static final String stagePostInit = "POST-INITIALIZATION";
    public static final String stageShutdown = "SHUTDOWN";
    public static final String stageCommand = "COMMAND CALL";

    public static final int WRITE_TO_FILE_SUCCESS = 1;
    public static final int WRITE_TO_FILE_FAIL = -1;

    public static final int VOICE_CONNECT_SUCCESS = 1;
    public static final int VOICE_CONNECT_NOT_IN_CHANNEL = -1;
    public static final int VOICE_CONNECT_NO_PERMS = -2;
    public static final int VOICE_CONNECT_FAIL_OTHER = -3;

    public static final String OWNER_ID = "202422697173581824";
    public static final String GUILD_ID = "562612266856349696";

    public static final File WELCOME = new File("discord_assets/Welcome.png");
    public static final File RULES = new File("discord_assets/Rules.png");
    public static final File INFO = new File("discord_assets/Info.png");
    public static final File NITRO = new File("discord_assets/Nitro.png");
    public static final File ADOPTS = new File("discord_assets/Open.png");
    public static final File APPLICATIONS = new File("discord_assets/Apps.png");
    public static final File DONATIONS = new File("discord_assets/Donations.png");
    public static final File PARTNERS = new File("discord_assets/Partners.png");
    public static final File ROLES = new File("discord_assets/Roles.png");
    public static final File GIVEAWAY = new File("discord_assets/Giveaways.png");
    public static final File EVENTS = new File("discord_assets/Events.png");
    public static final File LINKS = new File("discord_assets/Links.png");

    /**
     * Pronouns
     */

    // Emotes
    public static final String EMOTE_GIRL = "\uD83D\uDC69";
    public static final String EMOTE_BOY = "\uD83D\uDC68";
    public static final String EMOTE_NEUTRAL = "\uD83E\uDDD1";

    /**
     * Colors
     */

    public static final String EMOTE_WINE = "wine_661227:924436057422954549";
    public static final String EMOTE_BLOOD = "blood_88122c:924436057313923143";
    public static final String EMOTE_ROSE = "rose_aa1234:924436057460703263";
    public static final String EMOTE_CHERRY = "cherry_cc1234:924436057259409428";
    public static final String EMOTE_RUBY = "ruby_ee1234:924436057582342184";

    public static final String EMOTE_SUMMERLOVE = "summerlove_f77b10:924436057230020650";
    public static final String EMOTE_HONEY = "honey_ffc30b:924436057364262933";
    public static final String EMOTE_DAZE = "daze_fff476:924436057313906760";
    public static final String EMOTE_BUZZ = "buzz_fffac2:924436056911269959";

    public static final String EMOTE_LUSH = "lush_05542d:924436057502675014";
    public static final String EMOTE_FERNY = "ferny_207452:924436056101748826";
    public static final String EMOTE_CLOVER = "clover_339966:924436055598460939";

    public static final String EMOTE_SERPENT = "serpent_5fceae:924436056869326878";
    public static final String EMOTE_STORM = "storm_545588:924436056923865098";
    public static final String EMOTE_PUDDLE = "puddle_687c9e:924436056647016478";
    public static final String EMOTE_TSUNAMI = "tsunami_7dadba:924436056613482558";
    public static final String EMOTE_COSTAL = "costal_a4dddd:924436055145463818";

    public static final String EMOTE_ECHO = "echo_7d36ba:924436056097583144";
    public static final String EMOTE_FORTUNE = "fortune_9f87d5:924436056303108104";
    public static final String EMOTE_LAVENDER = "lavender_e4c7ff:924436056290504764";

    public static final String EMOTE_DUSTYROSE = "dustyrose_a22849:924436056030457866";
    public static final String EMOTE_BLOSSOM = "blossom_f92475:924436055686529054";
    public static final String EMOTE_BLUSH = "blush_f780a7:924436055132889150";
    public static final String EMOTE_PEACH = "peach_f9aec9:924436056437313597";

    public static final String EMOTE_NORI = "nori_020202:924436057615892540";
    public static final String EMOTE_COFFEE = "coffee_a27063:924436055933984820";
    public static final String EMOTE_WARMTH = "warmth_8f7f7f:924436057049681920";
    public static final String EMOTE_COLD = "cold_848394:924436055938191400";
    public static final String EMOTE_CANVAS = "canvas_fefefe:924436055741067284";

    // Roles
    public static final String ROLEID_WINE = "928714112450560070";
    public static final String ROLEID_BLOOD = "928714573018693632";
    public static final String ROLEID_ROSE = "928714654094602332";
    public static final String ROLEID_CHERRY = "928714721320923166";
    public static final String ROLEID_RUBY = "928714782691958816";

    public static final String ROLEID_SUMMERLOVE = "928715291880480828";
    public static final String ROLEID_HONEY = "928715304002015252";
    public static final String ROLEID_DAZE = "928715311161683969";
    public static final String ROLEID_BUZZ = "928715312612900884";

    public static final String ROLEID_LUSH = "928716047450796113";
    public static final String ROLEID_FERNY = "928716048939749426";
    public static final String ROLEID_CLOVER = "928716050424545340";

    public static final String ROLEID_SERPENT = "928717252830842961";
    public static final String ROLEID_STORM = "928717254219169823";
    public static final String ROLEID_PUDDLE = "928717254814752829";
    public static final String ROLEID_TSUNAMI = "928717255993339904";
    public static final String ROLEID_COSTAL = "928717257901748224";

    public static final String ROLEID_ECHO = "928718748695801856";
    public static final String ROLEID_FORTUNE = "928718749723422720";
    public static final String ROLEID_LAVENDER = "928718750587445308";

    public static final String ROLEID_DUSTYROSE = "928720908338741378";
    public static final String ROLEID_BLOSSOM = "928720909278261318";
    public static final String ROLEID_BLUSH = "928720909957730345";
    public static final String ROLEID_PEACH = "928720910918242388";

    public static final String ROLEID_NORI = "928720911421538374";
    public static final String ROLEID_COFFEE = "928721200568492153";
    public static final String ROLEID_WARMTH = "928721201034051624";
    public static final String ROLEID_COLD = "928721201793212436";
    public static final String ROLEID_CANVAS = "928721202531418243";

    public static final String EMOTE_VIVE = "vive:924444139565760532";
    public static final String EMOTE_INDEX = "index:924444139314114650";
    public static final String EMOTE_OCULUS = "oculus:924444139372826655";
    public static final String EMOTE_FULLBODY = "fullbody:924444139062452236";
    public static final String EMOTE_DESKTOP = "desktop";

    public static final String EMOTE_GITHUB = "github:956694339944333332";
    public static final String EMOTE_TWITTER = "twitter:956694339986272256";
    public static final String EMOTE_FACEBOOK = "facebook:956694339705253928";
    public static final String EMOTE_INSTAGRAM = "instagram:956694339692662836";
    public static final String EMOTE_DEVIANTART = "deviantart:956694339742990346";
    public static final String EMOTE_KOFI = "kofi:956694339596222486";
    public static final String EMOTE_PINTEREST = "pinterest:956694339822706759";
    public static final String EMOTE_TWITCH = "twitch:956694339709435924";
    public static final String EMOTE_REDDIT = "reddit:956694339885600838";
    public static final String EMOTE_TIKTOK = "tiktok:956694339784933396";
    public static final String EMOTE_TOYHOUSE = "toyhouse:956695361664192532";
    public static final String EMOTE_YOUTUBE = "youtube:956697058318880818";
    public static final String EMOTE_BATSTARE = "batstare:937908111602253834";
    public static final String EMOTE_GUMROAD = "gumroad:956706612033228861";
    public static final String EMOTE_DISCORD = "discord:956706611647369238";

 }