package com.uni.secprog;

import com.uni.secprog.builders.TuringMachineBuilder;
import com.uni.secprog.builders.StringFileBuilderTuring;
import com.uni.secprog.loaders.FileLoader;
import com.uni.secprog.printers.StringPrinter;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            throw new RuntimeException("No file given");
        }

        FileLoader loader = new FileLoader();
        Stream<String> instructions = loader.load(args[0]);

        // this should be refactored.
        TuringMachineBuilder builder = new StringFileBuilderTuring();
        TuringMachine tm = builder.build(instructions);

        StringPrinter printer = new StringPrinter();

        while (true) {
            tm.runStep();
            printer.printTape(tm.getTape());
        }
    }
}
