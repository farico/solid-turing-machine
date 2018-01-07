package com.uni.secprog.builders;

import org.json.simple.parser.ParseException;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class BuilderException extends Exception {
    public BuilderException(ParseException e) {
        super(e);
    }
}
