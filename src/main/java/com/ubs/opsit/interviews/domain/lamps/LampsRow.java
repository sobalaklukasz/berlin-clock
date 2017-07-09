package com.ubs.opsit.interviews.domain.lamps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hosh on 2017-07-08.
 */
public class LampsRow
{
    private final ArrayList<Lamp> row;

    public LampsRow(List<Lamp> lamps)
    {
        this.row = new ArrayList<>(lamps);
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(Lamp lamp : row)
        {
            stringBuilder.append(lamp.getState());
        }
        return stringBuilder.toString();
    }

    public void turnOnLamps(int numberOfLamps)
    {
        for(int i = 0; i< row.size(); i++)
        {
            if(i<numberOfLamps)
            {
                row.get(i).turnOn();
            }else
            {
                row.get(i).turnOff();
            }
        }
    }
}
