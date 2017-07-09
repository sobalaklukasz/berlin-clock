package com.ubs.opsit.interviews.domain.lamps;

import com.ubs.opsit.interviews.domain.bulbs.YellowBulb;

/**
 * Created by Hosh on 2017-07-07.
 */
public class YellowLamp implements Lamp
{
    private YellowBulb yellowBulb = YellowBulb.OFF;

    @Override
    public synchronized void turnOn()
    {
        yellowBulb = YellowBulb.ON;
    }

    @Override
    public synchronized void turnOff()
    {
        yellowBulb = YellowBulb.OFF;
    }

    @Override
    public String getState()
    {
        return yellowBulb.getState();
    }
}
