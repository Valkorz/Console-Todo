package com.behavior;
import java.time.LocalDateTime;

public class DateTime {
    public int day, month, year, hour, minute;
    private static int currentDay, currentMonth, currentYear, currentHour, currentMinute;

    public DateTime(int day, int month, int year, int hour, int minute){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public static DateTime TimeUntil(DateTime dateTime){
        DateTime.GetCurrent();
        return new DateTime(dateTime.day - DateTime.currentDay, dateTime.month - DateTime.currentMonth, 
        dateTime.year - DateTime.currentYear, dateTime.hour - DateTime.currentHour, dateTime.minute - DateTime.currentMinute);
    }

    public static float HoursUntil(DateTime dateTime){
        DateTime dT = DateTime.TimeUntil(dateTime);
        return dT.day * 24 + dT.month * 730 + dT.year * 8760 + dT.hour + ((dT.minute * 100) / 60);
    }
    
    private static void GetCurrent(){
        DateTime.currentDay = LocalDateTime.now().getDayOfMonth();
        DateTime.currentMonth = LocalDateTime.now().getMonth().getValue();
        DateTime.currentYear = LocalDateTime.now().getYear();
        DateTime.currentHour = LocalDateTime.now().getHour();
        DateTime.currentMinute = LocalDateTime.now().getMinute();
    }

}
