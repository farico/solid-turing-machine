package com.uni.secprog.builders;

import com.uni.secprog.TuringMachine;

import java.util.stream.Stream;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public interface TuringMachineBuilder {
    TuringMachine build(Stream<String> lines);
}
