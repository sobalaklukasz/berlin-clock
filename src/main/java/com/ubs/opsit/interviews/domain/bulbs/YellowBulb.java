package com.ubs.opsit.interviews.domain.bulbs;

/**
 * Created by Hosh on 2017-07-07.
 */
public enum YellowBulb
{
    OFF("O"),
    ON("Y");

    private String state;

    YellowBulb(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }


}
