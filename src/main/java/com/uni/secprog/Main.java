package com.uni.secprog;

import com.uni.secprog.builders.BuilderException;
import com.uni.secprog.loaders.*;
import com.uni.secprog.printers.StringPrinter;

import java.util.Objects;

public class Main {
    public static void main(String[] args) throws BuilderException, LoaderException {

        if (args.length == 0) {
            throw new RuntimeException("No file given\n\nUsage: tm.jar file [--remote]");
        }

        boolean remote = false;
        if (args.length > 1 && Objects.equals(args[1], "--remote")) {
            remote = true;
        }

        TuringMachineFactory factory = new TuringMachineFactory();
        TuringMachine tm = factory.build(remote, args[0]);
        StringPrinter printer = new StringPrinter();

        while (true) {
            tm.runStep();
            printer.printTape(tm.getTape());
        }
    }
}
