package com.ubs.opsit.interviews;

import java.text.ParseException;

/**
 * Created by Hosh on 2017-07-07.
 */
public class Main
{
    public static void main(String[] args) throws ParseException
    {
        TimeConverter timeConverter = new TimeConverterImpl();
        System.out.println(timeConverter.convertTime("24:00:00"));
    }
}