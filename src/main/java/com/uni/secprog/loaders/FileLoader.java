package com.uni.secprog.loaders;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class FileLoader {
    public ILoader load(boolean remote) {
        if (remote) {
            return new RemoteFileLoader();
        }

        return new LocalFileLoader();
    }
}
