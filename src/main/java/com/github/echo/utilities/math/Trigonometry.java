package com.github.echo.utilities.math;

import com.github.echo.core.Main;

/**
 * Trigonometry Class of the EchoedMath Project
 *
 * @author EcheodAJ
 * @since April 2020
 *
 * @version 3.0
 */
public class Trigonometry {

    private static final double THRESHOLD = 1 * Math.pow(10, -8);

    /**
     * Sine Function
     *
     * Special Cases:
     *  If the argument is NaN or an infinity, then the result is NaN.
     *  If the argument is zero, then the result is a zero with the same sign as the argument.
     *
     * @param x numerical argument
     * @return sin(x)
     */
    public static double sin(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (Main.getConfig().getDegrees()) x = Math.toRadians(x);
        double rawResult = Math.sin(x);

        if (rawResult < THRESHOLD && rawResult > 0) return rawResult;
        else if (rawResult < THRESHOLD && rawResult < 0) return rawResult;
        else return rawResult;
    }

    /**
     * Cosine Function
     *
     * Special Cases:
     *  If the argument is NaN or an infinity, then the result is NaN.
     *
     * @param x numerical argument
     * @return cos(x)
     */
    public static double cos(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (Main.getConfig().getDegrees()) x = Math.toRadians(x);
        double rawResult = Math.cos(x);

        if (rawResult < THRESHOLD && rawResult > 0) return 0;
        else if (rawResult < THRESHOLD && rawResult < 0) return 0;
        else return rawResult;
    }

    /**
     * Tangent Function
     *
     * Special Cases:
     *  If the argument is NaN or an infinity, then the result is NaN.
     *  If the argument is zero, then the result is a zero with the same sign as the argument.
     *
     * @param x numerical argument
     * @return tan(x)
     */
    public static double tan(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (Main.getConfig().getDegrees()) x = Math.toRadians(x);
        double rawResult = Math.tan(x);

        if (rawResult < THRESHOLD && rawResult > 0) return 0;
        else if (rawResult < THRESHOLD && rawResult < 0) return 0;
        else return rawResult;
    }

    /**
     * Cosecant Function
     *
     * @param x numerical argument
     * @return csc(x)
     */
    public static double csc(double x) {
        return  1 / sin(x);
    }

    /**
     * Secant Function
     *
     * @param x numerical argument
     * @return sec(x)
     */
    public static double sec(double x) {
        return 1 / cos(x);
    }

    /**
     * Cotangent Function
     *
     * @param x numerical argument
     * @return cot(x)
     */
    public static double cot(double x) {
        return 1 / tan(x);
    }

    /**
     * Inverse Sine Function
     *
     * Special Cases:
     *  If the argument is NaN or its absolute value is greater than 1, then the result is NaN.
     *  If the argument is zero, then the result is a zero with the same sign as the argument.
     *
     * @param x numerical argument
     * @return asin(x)
     */
    public static double asin(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (Main.getConfig().getDegrees()) x = Math.toRadians(x);
        double rawResult = Math.asin(x);

        if (rawResult < THRESHOLD && rawResult > 0) return 0;
        else if (rawResult < THRESHOLD && rawResult < 0) return 0;
        else return rawResult;
    }

    /**
     * Inverse Cosine Function
     *
     * Special Cases:
     *  If the argument is NaN or its absolute value is greater than 1, then the result is NaN.
     *
     * @param x numerical argument
     * @return acos(x)
     */
    public static double acos(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (Main.getConfig().getDegrees()) x = Math.toRadians(x);
        double rawResult = Math.acos(x);

        if (rawResult < THRESHOLD && rawResult > 0) return 0;
        else if (rawResult < THRESHOLD && rawResult < 0) return 0;
        else return rawResult;
    }

    /**
     * Inverse Tangent Function
     *
     * Special Cases:
     *  If the argument is NaN, then the result is NaN.
     *  If the argument is zero, then the result is a zero with the same sign as the argument.
     *
     * @param x numerical argument
     * @return atan(x)
     */
    public static double atan(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (Main.getConfig().getDegrees()) x = Math.toRadians(x);
        double rawResult = Math.atan(x);

        if (rawResult < THRESHOLD && rawResult > 0) return 0;
        else if (rawResult < THRESHOLD && rawResult < 0) return 0;
        else return rawResult;
    }

    /**
     * Inverse Cosecant Function
     *
     * The identity is:
     *  acsc(x) = asin(1 / x)
     *
     * @param x numerical argument
     * @return acsc(x)
     */
    public static double acsc(double x) {
        return asin(1 / x);
    }

    /**
     * Inverse Secant Function
     *
     * The identity is:
     *  asec(x) = acos(1 / x)
     *
     * @param x numerical argument
     * @return asec(x)
     */
    public static double asec(double x) {
        return acos(1 / x);
    }

    /**
     * Inverse Cotangent Function
     *
     * The identity is:
     *  acot(x) = atan(1 / x)
     *
     * @param x numerical argument
     * @return acot(x)
     */
    public static double acot(double x) {
        return atan(1 / x);
    }

    /**
     * Hyperbolic Sine Function
     *
     * No special cases.
     *
     * @param x numerical argument
     * @return sinh(x)
     */
    public static double sinh(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (Main.getConfig().getDegrees()) x = Math.toRadians(x);
        double rawResult = Math.sinh(x);

        if (rawResult < THRESHOLD && rawResult > 0) return 0;
        else if (rawResult < THRESHOLD && rawResult < 0) return 0;
        else return rawResult;
    }

    /**
     * Hyperbolic Cosine Function
     *
     * No special cases.
     *
     * @param x numerical argument
     * @return cosh(x)
     */
    public static double cosh(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (Main.getConfig().getDegrees()) x = Math.toRadians(x);
        double rawResult = Math.cosh(x);

        if (rawResult < THRESHOLD && rawResult > 0) return 0;
        else if (rawResult < THRESHOLD && rawResult < 0) return 0;
        else return rawResult;
    }

    /**
     * Hyperbolic Tangent Function
     *
     * No special cases.
     *
     * @param x numerical argument
     * @return tanh(x)
     */
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (Main.getConfig().getDegrees()) x = Math.toRadians(x);
        double rawResult = Math.tanh(x);

        if (rawResult < THRESHOLD && rawResult > 0) return 0;
        else if (rawResult < THRESHOLD && rawResult < 0) return 0;
        else return rawResult;
    }

    /**
     * Hyperbolic Cosecant Function
     *
     * The identity is:
     *  csch(x) = 1 / sinh(x)
     *
     * Special Cases:
     *  If the argument is NaN, then the result is NaN.
     *  If the argument is zero, then the result is an infinity with the same sign as the argument.
     *  If the argument is positive infinity, then the result is +0.0.
     *  If the argument is negative infinity, then the result is -0.0.
     *
     * @param x numerical argument
     * @return csch(x)
     */
    public static double csch(double x) {
        return 1 / sinh(x);
    }

    /**
     * Hyperbolic Secant Function
     *
     * The identity is:
     *  sech(x) = 1 / cosh(x)
     *
     * Special Cases:
     *  If the argument is NaN, then the result is NaN.
     *  If the argument is an infinity (positive or negative), then the result is +0.0.
     *
     * @param x numerical argument
     * @return sech(x)
     */
    public static double sech(double x) {
        return 1 / cosh(x);
    }

    /**
     * Hyperbolic Cotangent Function
     *
     * The identity is:
     *  coth(x) = 1 / tanh(x)
     *
     * Special Cases:
     *  If the argument is NaN, then the result is NaN.
     *  If the argument is zero, then the result is an infinity with the same sign as the argument.
     *  If the argument is positive infinity, then the result is +1.0.
     *  If the argument is negative infinity, then the result is -1.0.
     *
     * @param x numerical argument
     * @return coth(x)
     */
    public static double coth(double x) {
        return 1 / tanh(x);
    }

    /**
     * Inverse Hyperbolic Sine Function
     *
     * The identity is:
     *  asinh(x) = ln(x + sqrt(x^2 + 1))
     *
     * Special Cases:
     *  If the argument is NaN, then the result is NaN.
     *  If the argument is infinite, then the result is an infinity with the same sign as the argument.
     *  If the argument is zero, then the result is a zero with the same sign as the argument.
     *
     * @param x numerical argument
     * @return asinh(x)
     */
    public static double asinh(double x) {
        return Logarithmic.ln(x + Math.sqrt(Math.pow(x, 2) + 1));
    }

    /**
     * Inverse Hyperbolic Cosine Function
     *
     * The identity is:
     *  acosh(x) = ln(x ± sqrt(x^2 - 1))
     * This function returns the positive branch.
     *
     * Special Cases:
     *  If the argument is NaN or less than one, then the result is NaN.
     *  If the argument is a positive infinity, then the result is (positive) infinity.
     *  If the argument is one, then the result is (positive) zero.
     *
     * @param x numerical argument
     * @return acosh(x)
     */
    public static double acosh(double x) {
        // Special case 1
        if (Double.isNaN(x) || x < 1) return Double.NaN;

            // Special case 2
        else if (Double.isInfinite(x) && x > 0) return Double.POSITIVE_INFINITY;

            // Special case 3
        else if (x == 1) return +0;

            // Identity
        else return Logarithmic.ln(x + Math.sqrt(Math.pow(x, 2) - 1));
    }

    /**
     * Inverse Hyperbolic Tangent
     *
     * The identity is:
     *  atanh(x) = (1/2)*ln((1 + x)/(1 - x))
     *
     * Special Cases:
     *  If the argument is NaN, an infinity, or has a modulus of greater than one, then the result is NaN.
     *  If the argument is plus or minus one, then the result is infinity with the same sign as the argument.
     *  If the argument is zero, then the result is a zero with the same sign as the argument.
     *
     * @param x numerical argument
     * @return atanh(x)
     */
    public static double atanh(double x) {
        // Special case 1
        if (Double.isNaN(x) || Double.isInfinite(x) || Math.abs(x) > 1) return Double.NaN;

            // Special case 2
        else if (x == -1) return Double.NEGATIVE_INFINITY;
        else if (x == 1) return Double.POSITIVE_INFINITY;

            // Special case 3
        else if (x == 0) return Double.POSITIVE_INFINITY;

        // Identity
        return (0.5) * (Logarithmic.ln((1 + x) / (1 - x)));
    }

    /**
     * Inverse Hyperbolic Cosecant Function
     *
     * The identity is:
     *  acsch(x) = ln((1 - sqrt(1 + x^2))/x) for x < 0
     *  acsch(x) = ln((1 + sqrt(1 + x^2))/x) for x > 0
     *
     * Special Cases:
     *  If the argument is NaN, then the result is NaN.
     *  If the argument is an infinity, then the result is zero with the same sign as the argument.
     *  If the argument is zero, then the result is infinity with the same sign as the argument.
     *
     * @param x numerical argument
     * @return acsch(x)
     */
    public static double acsch(double x) {
        // Special case 1
        if (Double.isNaN(x)) return Double.NaN;

            // Special case 2
        else if (Double.isInfinite(x)) return (x > 0) ? +0 : -0;

            // Special case 3
        else if (x == 0) return Double.POSITIVE_INFINITY;

            // Identity 2
        else if (x > 0) return Logarithmic.ln((1 + Math.sqrt(1 + Math.pow(x, 2))) / x);

            // Identity 1 (less than 0)
        else return Logarithmic.ln((1 - Math.sqrt(1 + Math.pow(x, 2))) / x);
    }

    /**
     * Inverse Hyperbolic Secant Function
     *
     * The identity is:
     *  asech(x) = ln((1 + sqrt(1 - x^2))/x).
     *
     * Special Cases:
     *  If the argument is NaN, less than zero, or greater than one, then the result is NaN.
     *  If the argument is zero, then the result is infinity with the same sign as the argument.
     *
     * @param x numerical argument
     * @return asech(x)
     */
    public static double asech(double x) {
        // Special case 1
        if (Double.isNaN(x) || x < 0 || x > 1) return Double.NaN;

            // Special case 2
        else if (Double.isInfinite(x)) return Double.POSITIVE_INFINITY;

            // Identity
        else return Logarithmic.ln((1 + Math.sqrt(1 - Math.pow(x, 2)) / x));
    }

    /**
     * Inverse Hyperbolic Cotangent Function
     *
     * The identity is:
     *  acoth(x) = (1/2)*ln((x + 1)/(x - 1))
     *
     * Special Cases:
     *  If the argument is NaN or a modulus of less than one, then the result is NaN.
     *  If the argument is an infinity, then the result is zero with the same sign as the argument.
     *  If the argument is plus or minus one, then the result is infinity with the same sign as the argument.
     *
     * @param x numerical argument
     * @return acoth(x)
     */
    public static double acoth(double x) {
        // Special case 1
        if (Double.isNaN(x) || Math.abs(x) < 1) return Double.NaN;

            // Special case 2
        else if (Double.isInfinite(x)) return (x > 0) ? +0 : -0;

            // Special case 3
        else if (x == -1) return Double.NEGATIVE_INFINITY;
        else if (x == 1) return Double.POSITIVE_INFINITY;

            // Identity
        else return (0.5) * (Logarithmic.ln((x + 1) / (x - 1)));
    }
}
