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
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Config class of the ECHO Community Discord Bot project
 *
 * @author ECHO
 * @since September 2021
 */
@SuppressWarnings("unused")
public class GumroadConfiguration {

    /**
     * File name constants
     */
    private final static String fileName = "gumroad.json";
    private final static String arrayName = "products";

    /**
     * Constructor for the Config Class
     */
    public GumroadConfiguration() {
        // Check if Configuration File exists.
        File f = new File(getFileName());
        if (!f.exists() || f.isDirectory()) {
            // Create file.
            FileUtilities.createConfigurationFile(getFileName(), getArrayName(), new JSONObject());
        }
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
     * Adds a new Gumroad product for the Bot to use.
     * @param productName name of the new product
     * @param productPermalink new product permalink for the Bot to use
     */
    public void addProduct(String productName, String productPermalink) {
        JSONObject jsonObj = FileUtilities.getJSONFileObject(fileName);
        jsonObj.put(productName, productPermalink);
        writeToFile(jsonObj);
    }

    /**
     * Retrieves a full list of registered products.
     * @return full list of registered products
     */
    public ArrayList<String> getProductNames() {
        ArrayList<String> list = new ArrayList<>();
        JSONArray jsonArray = FileUtilities.getJSONFileArray(getFileName());

        JSONObject jsonObject = FileUtilities.getJSONFileObject(getFileName());
        Iterator<String> keys = jsonArray.getJSONObject(0).keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (jsonObject.get(key) instanceof JSONArray) {
                JSONArray array = (JSONArray) jsonObject.get(key);
                JSONObject object = (JSONObject) array.get(0);
                Iterator<String> innerKeys = object.keys();
                while (innerKeys.hasNext()) {
                    String innerKey = innerKeys.next();
                    list.add(innerKey);
                }
            }
            else {
                list.add(key);
            }
        }

        return list;
    }
    /**
     * Retrieves permalink for a product.
     *
     * @return permalink for a product.
     */
    public String getPermalink(String avatar) {
        String permalink = FileUtilities.getValueByKey(getFileName(), avatar, getArrayName());

        if (permalink.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().warning("Failed to grab permalink.");
        }

        return permalink;
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
