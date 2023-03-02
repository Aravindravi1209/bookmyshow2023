package com.bookmyshow2023.bookmyshow2023.exceptions;

import jdk.jshell.EvalException;

public class CityNotFoundException extends Exception {
    public CityNotFoundException(String message)
    {
        super(message);
    }
}
