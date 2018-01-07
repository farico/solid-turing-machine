package com.uni.secprog.printers;

import com.uni.secprog.machine.Tape;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class StringPrinter implements IPrinter {

    public void printTape(Tape tape)
    {
        System.out.println("");
        for (int i = 0; i < tape.contents.length; i++) {
            System.out.print(tape.contents[i]);
        }
    }

}
