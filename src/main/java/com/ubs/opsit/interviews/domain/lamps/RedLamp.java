package com.ubs.opsit.interviews.domain.lamps;

import com.ubs.opsit.interviews.domain.bulbs.RedBulb;

/**
 * Created by Hosh on 2017-07-07.
 */
public class RedLamp implements Lamp
{
    private RedBulb redBulb = RedBulb.OFF;

    @Override
    public void turnOn()
    {
        redBulb = RedBulb.ON;
    }

    @Override
    public void turnOff()
    {
        redBulb = RedBulb.OFF;
    }

    @Override
    public String getState()
    {
        return redBulb.getState();
    }
}
