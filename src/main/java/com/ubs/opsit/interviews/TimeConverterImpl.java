package com.ubs.opsit.interviews;

/**
 * Created by Hosh on 2017-07-08.
 */
public class TimeConverterImpl implements TimeConverter
{
    private final BerlinClock berlinClock = new BerlinClock();

    @Override
    public String convertTime(String aTime)
    {
        berlinClock.setTime(aTime);
        return berlinClock.getTime();
    }
}
