/*
 * UnixTime.java
 * Created by Sassy on 11/05/15
 */

package com.blogspot.sassylog.unixtime;

public class UnixTime {
    private int unix_time;
    private static final int JAN_DAYS = 31;
    private static final int FEB_DAYS = 31 + 28;
    private static final int MAR_DAYS = 31 + 28 + 31;
    private static final int APR_DAYS = 31 + 28 + 31 + 30;
    private static final int MAY_DAYS = 31 + 28 + 31 + 30 + 31;
    private static final int JUN_DAYS = 31 + 28 + 31 + 30 + 31 + 30;
    private static final int JUL_DAYS = 31 + 28 + 31 + 30 + 31 + 30 + 31;
    private static final int AUG_DAYS = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
    private static final int SEP_DAYS = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
    private static final int OCT_DAYS = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
    private static final int NOV_DAYS = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
    private static final int DEC_DAYS = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31;

   public UnixTime() {
       unix_time = 0;
   }

   public UnixTime(int utime) {
       if (utime < 0) {
           unix_time = 0;
       } else {
           unix_time = utime;
       }
   }

   public void setUnixTime(int utime) {
       if (utime < 0) {
           unix_time = 0;
       } else {
           unix_time = utime;
       }
   }

   public int getUnixTime() {
       return unix_time;
   }

   public int getYear() {
       int accum_day = unix_time / 86400;
       int year = calcYear(accum_day);
       return year;
   }

   public int getMonth() {
       int accum_day = unix_time / 86400;
       int day = calcDays(accum_day);
       int year = calcYear(accum_day);
       return calcMonth(day, year);
   }

   public int getDay() {
       int accum_day = unix_time / 86400;
       int day = calcDays(accum_day);
       int year = calcYear(accum_day);
       return day + 1 - getMonthDays(calcMonth(day, year)-1, year);
   }

   static boolean calcUruu(int year) {
       boolean ok = false;
       if (year % 4 == 0) {
           ok = true;
           if ((year % 100 == 0) && ((year % 400 != 0))) {
               ok = false;
           }
       }
       return ok;
   }

   private int calcMonth(int day, int year) {
       int cond = calcUruu(year) ? 1 : 0;
       if (day < JAN_DAYS) {
           return 1;
       } else if (day < FEB_DAYS + cond) {
           return 2;
       } else if (day < MAR_DAYS + cond) {
           return 3;
       } else if (day < APR_DAYS + cond) {
           return 4;
       } else if (day < MAY_DAYS + cond) {
           return 5;
       } else if (day < JUN_DAYS + cond) {
           return 6;
       } else if (day < JUL_DAYS + cond) {
           return 7;
       } else if (day < AUG_DAYS + cond) {
           return 8;
       } else if (day < SEP_DAYS + cond) {
           return 9;
       } else if (day < OCT_DAYS + cond) {
           return 10;
       } else if (day < NOV_DAYS + cond) {
           return 11;
       } else if (day < DEC_DAYS + cond) {
           return 12;
       }
       assert false;
       return 0;
   }

   private int getMonthDays(int month, int year) {
       int cond = calcUruu(year) ? 1 : 0;
       switch(month) {
       case 1:
           return JAN_DAYS;
       case 2:
           return FEB_DAYS + cond;
       case 3:
           return MAR_DAYS + cond;
       case 4:
           return APR_DAYS + cond;
       case 5:
           return MAY_DAYS + cond;
       case 6:
           return JUN_DAYS + cond;
       case 7:
           return JUL_DAYS + cond;
       case 8:
           return AUG_DAYS + cond;
       case 9:
           return SEP_DAYS + cond;
       case 10:
           return OCT_DAYS + cond;
       case 11:
           return NOV_DAYS + cond;
       case 12:
           return DEC_DAYS + cond;
       default:
           assert false;
           return 0;
       }
   }
   
   private int calcYear(int days) {
       int i = 1970;
       while (calcUruu(i) ? days >= 366 : days >= 365) {
           if (calcUruu(i)) {
               days -= 366;
           } else {
               days -= 365;
           }
           i++;
       }
       return i;
   }
   
   private int calcDays(int days) {
       int i = 1970;
       while (calcUruu(i) ? days >= 366 : days >= 365) {
           if (calcUruu(i)) {
               days -= 366;
           } else {
               days -= 365;
           }
           i++;
       }
       return days;
   }

}
