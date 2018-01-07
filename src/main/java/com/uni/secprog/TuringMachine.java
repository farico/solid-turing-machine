package com.uni.secprog;

import com.uni.secprog.machine.Rule;
import com.uni.secprog.machine.Tape;

import java.util.List;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class TuringMachine {

    protected char state = '0';
    protected Tape tape;
    protected List<Rule> rules;

    public TuringMachine (char state, Tape tape, List<Rule> rules) {
        this.state = state;
        this.tape = tape;
        this.rules = rules;
    }

    public void runStep() {
        rules.forEach(rule -> {
            if (rule.state == state && rule.read == tape.getCharAtHead()) {
                tape.write(rule.write);
                if (rule.move == 'L') tape.head.moveLeft();
                else tape.head.moveRight();
                this.state = rule.nextState;
            }
        });
    }

    public Tape getTape() {
        return tape;
    }

}
