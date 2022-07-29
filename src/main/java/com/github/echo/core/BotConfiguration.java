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

import com.github.echo.utilities.Constants;
import com.github.echo.utilities.FileUtilities;
import com.github.echo.utilities.exceptions.NoConfigurationFileException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;

/**
 * Config class of the ECHO Community Discord Bot project
 *
 * @author ECHO
 * @since September 2021
 */
@SuppressWarnings("unused")
public class BotConfiguration {

    /**
     * File name constants
     */
    private final static String fileName = "config.json";
    private final static String arrayName = "bot";

    /**
     * Constructor for the Config Class
     */
    public BotConfiguration() {
        // Check if Configuration File exists.
        File f = new File(getFileName());
        if (!f.exists() || f.isDirectory()) {
            // Create file.
            JSONObject object = new JSONObject();
            JSONArray array = new JSONArray();

            // Put default keys and values into the object.
            object.put(Constants.TOKEN_KEY, Constants.TOKEN_VALUE);
            object.put(Constants.PREFIX_KEY, Constants.PREFIX_VALUE);
            object.put(Constants.DEBUG_KEY, Constants.DEBUG_VALUE);
            object.put(Constants.GAME_STATUS_KEY, Constants.GAME_STATUS_VALUE);
            object.put(Constants.SHARDS_KEY, Constants.SHARDS_VALUE);

            FileUtilities.createConfigurationFile(getFileName(), getArrayName(), object);
        }

        // Check if Configuration File is usable.
        if (!checkConfigurationUsability()) {
            Main.getLog().error(
                    "Configuration File is not usable.",
                    new NoConfigurationFileException("Unusable configuration file. Please check the file at " + getFileName())
            );
            Main.shutdown(Constants.STATUS_CONFIG_UNUSABLE);
        }
    }

    /**
     * Checks usability of Configuration file.
     *
     * @return true if usable, false if not.
     */
    private boolean checkConfigurationUsability() {
        // Check critical values

        // If it's null, the method returns default
        // If it isn't the default, it was changed
        // This is the only code-breaking config.
        // Everything else can be the default value
        // and it will run fine.
        return !getToken().contains(Constants.TOKEN_VALUE);
    }

    /**
     * Adds a JSON Array to the Configuration File.
     *
     * @param obj JSONObject to add to file.
     */
    @SuppressWarnings("unused")
    private int writeToFile(JSONArray obj) {
        // Write to the file.
        return FileUtilities.writeToFile(obj, getFileName());
    }

    /**
     * Adds a JSON Object to the Configuration File.
     *
     * @param obj JSONObject to add to file.
     */
    protected int writeToFile(JSONObject obj) {
        // Write to the file.
        return FileUtilities.writeToFile(obj, getFileName());
    }

    /**
     * Retrieves the JSONObject to read the JSON File.
     *
     * @return JSONObject
     */
    @SuppressWarnings("unused")
    private JSONArray getJSONFile() {
        return FileUtilities.getJSONFileArray(fileName);
    }

    /**
     * Retrieves prefix for the Bot.
     *
     * @return prefix from Configuration.
     */
    public String getPrefix() {
        String prefix = FileUtilities.getValueByKey(getFileName(), Constants.PREFIX_KEY, getArrayName());

        if (prefix.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().warning("No need for a shutdown. Failed to grab prefix. Using default.");
            return Constants.PREFIX_VALUE;
        }

        return prefix;
    }

    /**
     * Sets a new prefix for the Bot to use.
     * @param newPrefix new prefix for the Bot to use
     */
    public void setPrefix(String newPrefix) {
        JSONObject object =  FileUtilities.getJSONFileObject(getFileName());
        object.put(Constants.PREFIX_KEY, newPrefix);

        writeToFile(object);
    }

    /**
     * Retrieves token for the Bot.
     *
     * @return token from Configuration.
     */
    public String getToken() {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.TOKEN_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No token found. Calling for shut down.");
            Main.getLog().error("No Token in Configuration File.", new NoConfigurationFileException("Unusable configuration file. No Token provided."));
            Main.shutdown(Constants.STATUS_NO_CONFIG);
            //return Constants.TOKEN_VALUE; // no actual use
        }

        return token;
    }

    /**
     * Retrieves debug status for the Bot.
     *
     * @return debug status from Configuration.
     */
    public boolean getDebug() {
        String debug = FileUtilities.getValueByKey(getFileName(), Constants.DEBUG_KEY, getArrayName());

        if (debug.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().warning("Failed to grab debug. Using default.");
            return Constants.DEBUG_VALUE.toLowerCase().contains("true");
        }

        return debug.toLowerCase().contains("true");
    }

    /**
     * Sets a new debug value for the Bot.
     * @param debug true if debug is on, false if not
     */
    public void setDebug(boolean debug) {
        JSONObject object =  FileUtilities.getJSONFileObject(getFileName());
        object.put(Constants.DEBUG_KEY, debug);

        writeToFile(object);
    }

    /**
     * Retrieves shards for the Bot.
     *
     * @return number of shards from Configuration.
     */
    public int getShards() {
        String shards = FileUtilities.getValueByKey(getFileName(), Constants.SHARDS_KEY, getArrayName());

        if (shards.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().warning("Failed to grab debug. Using default.");
            try {
                return Integer.parseInt(Constants.SHARDS_VALUE);
            }
            catch (NumberFormatException nfe) {
                Main.getLog().error("Could not parse Shard Count as an integer. Returning 0, regardless of default.", nfe);
                return 0;
            }
        }

        try {
            return Integer.parseInt(shards);
        }
        catch (NumberFormatException nfe) {
            Main.getLog().error("Could not parse Shard Count as an integer. Returning 0, regardless of default.", nfe);
            return 0;
        }
    }

    /**
     * Returns if the math mode is degrees or radians.
     * @return true if degrees, false if radians
     */
    public boolean getDegrees() {
        String debug = FileUtilities.getValueByKey(getFileName(), Constants.MATHMODE_KEY, getArrayName());

        if (debug.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("Failed to grab degrees. Using default.");
            return Constants.MATHMODE_VALUE.toLowerCase().contains("degrees");
        }

        return debug.toLowerCase().contains("degrees");
    }

    /**
     * Sets a new math mode value for the Bot.
     * @param degrees true if degrees, false if not
     */
    public void setDegrees(boolean degrees) {
        JSONObject object =  FileUtilities.getJSONFileObject(getFileName());

        String degreesString;
        if (degrees) degreesString = "degrees";
        else degreesString = "radians";

        object.put(Constants.MATHMODE_KEY, degreesString);

        writeToFile(object);
    }

    /**
     * Retrieves file name of the Configuration
     *
     * @return file name
     */
    public static String getFileName() {
        return fileName;
    }

    /**
     * Retrieves array name of the Configuration
     *
     * @return array name
     */
    public static String getArrayName() {
        return arrayName;
    }
}
