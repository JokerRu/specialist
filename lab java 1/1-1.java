package com.company;

public class Main {

    public static void main(String[] args) {
	// Конвертор дня года в месяц и число
        int year = 2022;
        int dayNum = 365;
        int [] daysInMonths={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
        String []months={"January","February","March","April","May","June","July","August","September","October","November","December"};
        int monthNum = 0;
        boolean isLeapYear = (year%4==0) && (year%100!=0 || year%400==0);
        for (int days : daysInMonths) {
            if (isLeapYear && days == 28) ++days;
            if (dayNum<=days) break;
            dayNum -= days;
            monthNum++;
        }
        System.out.printf("%d %s \n", dayNum, months[monthNum]);
    }
}
