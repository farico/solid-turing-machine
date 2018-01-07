package com.uni.secprog.builders;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class Builder {
    public TuringMachineBuilder build(boolean remote)
    {
        if (remote) {
            return new JsonBuilder();
        }

        return new StringBuilder();
    }
}
