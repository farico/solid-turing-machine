package com.uni.secprog.machine;

/**
 * Created by Aivaras Voveris on 2018-01-07.
 */
public class Head {
    public int position;

    public Head(int position)
    {
        this.position = position;
    }

    public void moveLeft()
    {
        position--;
    }

    public void moveRight()
    {
        position++;
    }
}
