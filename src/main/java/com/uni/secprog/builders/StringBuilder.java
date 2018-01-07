package com.uni.secprog.builders;

import com.uni.secprog.TuringMachine;
import com.uni.secprog.machine.Head;
import com.uni.secprog.machine.Rule;
import com.uni.secprog.machine.Tape;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class StringBuilder implements TuringMachineBuilder {

    @Override
    public TuringMachine build(Stream<String> lines) {

        char[] tape;
        char state = '0';
        int headPosition;

        Iterator<String> iterator = lines.iterator();
        String firstLine = iterator.next();
        headPosition = Integer.parseInt(firstLine);
        String tapeLine = iterator.next();

        tape = new char[tapeLine.length()];
        for( int i=0; i < tapeLine.length(); i++) tape[i] = tapeLine.charAt(i);

        int ruleCount = 0;

        ArrayList<Rule> rules = new ArrayList<Rule>();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.trim().isEmpty()) continue;

            String[] tokens = line.split(" ");
            for (int i = 0; i < 5; i++) {
                rules.add(ruleCount, new Rule(tokens[0].charAt(0), tokens[1].charAt(0), tokens[2].charAt(0), tokens[3].charAt(0), tokens[4].charAt(0)));
            }
            ruleCount++;
        }

        return new TuringMachine(state, new Tape(new Head(headPosition), tape), rules);
    }
}
