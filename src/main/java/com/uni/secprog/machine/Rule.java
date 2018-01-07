package com.uni.secprog.machine;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class Rule {
    public char state;
    public char read;
    public char write;
    public char move;
    public char nextState;

    public Rule(char state, char read, char write, char move, char nextState) {
        this.state = state;
        this.read = read;
        this.write = write;
        this.move = move;
        this.nextState = nextState;
    }
}
