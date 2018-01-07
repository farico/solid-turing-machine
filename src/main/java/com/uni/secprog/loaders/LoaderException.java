package com.uni.secprog.loaders;

import java.io.IOException;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class LoaderException extends Exception {
    public LoaderException(IOException e) {
        super(e);
    }
}
