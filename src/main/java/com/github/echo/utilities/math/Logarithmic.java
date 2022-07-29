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
package com.github.echo.utilities.math;

/**
 * Logarithmic Class of the EchoedMath project
 *
 * @author EchoedAJ
 * @since May 2020
 *
 * @version 1.5
 */
@SuppressWarnings("unused")
public class Logarithmic {

    /**
     * Natural log (base e)
     *
     * @param x number to calculate ln() of
     * @return ln(x)
     */
    public static double ln(double x) {
        return Math.log(x);
    }

    /**
     * Log (base 10)
     *
     * @param x number to calculate log() of
     * @return log(x)
     */
    public static double log(double x) {
        return Math.log10(x);
    }

    /**
     * Log (custom base)
     *
     * The identity is:
     *  logb(x) = log(x)/log(b)
     *
     * @param x number to calculate logb() of
     * @return logb(x)
     */
    public static double logBase(double x, double base) {
        return log(x) / log(base);
    }

}
