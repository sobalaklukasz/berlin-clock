package com.ubs.opsit.interviews.domain.bulbs;

/**
 * Created by Hosh on 2017-07-07.
 */
public enum RedBulb
{
    OFF("O"),
    ON("R");

    private String state;

    RedBulb(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }
}
