package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.domain.lamps.LampsRow;
import com.ubs.opsit.interviews.domain.lamps.RedLamp;
import com.ubs.opsit.interviews.domain.lamps.YellowLamp;

import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Hosh on 2017-07-07.
 */
class BerlinClock
{
    private final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final String OUTPUT_FORMAT = "" +
            "%S\r\n" +
            "%S\r\n" +
            "%S\r\n" +
            "%S\r\n" +
            "%S";

    private final LampsRow secondLamp = new LampsRow(Collections.singletonList(new YellowLamp()));
    private final LampsRow fiveHoursLamps = new LampsRow(Arrays.asList(new RedLamp(), new RedLamp(), new RedLamp(), new RedLamp()));
    private final LampsRow oneHourLamps = new LampsRow(Arrays.asList(new RedLamp(), new RedLamp(), new RedLamp(), new RedLamp()));
    private final LampsRow fiveMinutesLamps = new LampsRow(Arrays.asList(
            new YellowLamp(), new YellowLamp(), new RedLamp(),
            new YellowLamp(), new YellowLamp(), new RedLamp(),
            new YellowLamp(), new YellowLamp(), new RedLamp(),
            new YellowLamp(), new YellowLamp()));
    private final LampsRow oneMinuteLamps = new LampsRow(Arrays.asList(new YellowLamp(), new YellowLamp(), new YellowLamp(), new YellowLamp()));


    synchronized String getTime()
    {
        return String.format(OUTPUT_FORMAT, secondLamp, fiveHoursLamps, oneHourLamps, fiveMinutesLamps, oneMinuteLamps);
    }

    synchronized void setTime(String newTime)
    {
        TemporalAccessor raw = INPUT_FORMAT.parse(newTime);
        int hour = raw.query(LocalTime::from).getHour();
        Period period = raw.query(DateTimeFormatter.parsedExcessDays());
        if (period.equals(Period.ofDays(1)))
        {
            hour = 24;
        }
        int minute = raw.query(LocalTime::from).getMinute();
        int second = raw.query(LocalTime::from).getSecond();

        fiveHoursLamps.turnOnLamps(hour / 5);
        oneHourLamps.turnOnLamps(hour - (hour / 5) * 5);
        fiveMinutesLamps.turnOnLamps(minute / 5);
        oneMinuteLamps.turnOnLamps(minute - minute / 5 * 5);
        secondLamp.turnOnLamps(second % 2 == 0 ? 1 : 0);
    }
}
