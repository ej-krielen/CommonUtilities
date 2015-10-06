package com.selflearning.ejk.commonutilities.unit.converter;

/**
 * Methods to convert units
 *
 * @author Erik-Jan Krielen ej.krielen@gmail.com
 * @since 6-10-2015
 */
public final class UnitConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 1.8 + 32);
    }

    public static double fahrenheitToCelcius(double fahrenheit) {
        return ((fahrenheit - 32) / 1.8);
    }

    //http://www.rapidtables.com/convert/index.htm
    //TODO add dollar/euro
    //TODO weight
    //TODO length
    //TODO color

}
