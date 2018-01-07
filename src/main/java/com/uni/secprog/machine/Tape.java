package com.uni.secprog.machine;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class Tape {
    public char[] contents;
    public Head head;

    public Tape(Head head, char[] contents) {
        this.head = head;
        this.contents = contents;
    }

    public char getCharAtHead()
    {
        return contents[this.head.position];
    }

    public void write(char value)
    {
        contents[this.head.position] = value;
    }

}
