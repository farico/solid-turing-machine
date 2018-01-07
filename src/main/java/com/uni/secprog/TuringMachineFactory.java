package com.uni.secprog;

import com.uni.secprog.builders.Builder;
import com.uni.secprog.builders.BuilderException;
import com.uni.secprog.builders.TuringMachineBuilder;
import com.uni.secprog.loaders.FileLoader;
import com.uni.secprog.loaders.ILoader;
import com.uni.secprog.loaders.LoaderException;

import java.util.stream.Stream;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class TuringMachineFactory {
    public TuringMachine build(boolean remote, String source) throws LoaderException, BuilderException
    {
        FileLoader fl = new FileLoader();
        ILoader loader = fl.load(remote);
        Stream<String> lines = loader.load(source);

        Builder b = new Builder();
        TuringMachineBuilder builder = b.build(remote);
        return builder.build(lines);
    }
}
