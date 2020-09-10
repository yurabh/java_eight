package java_eight.learn.date_and_time;

import java.time.*;
import java.time.chrono.IsoChronology;
import java.time.chrono.IsoEra;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class TestDateAndTime {

    public static void main(String[] args) {

        Date date = new Date(14, 2, 2018);

        final int year = date.getYear();

        final int day = date.getDay();

        final int month = date.getMonth();

        System.out.println("day: " + day);
        System.out.println("moth: " + month);
        System.out.println("year: " + year);


        LocalDate localDate = LocalDate.of(2014, Month.APRIL, 1);

        System.out.println("localDate: " + localDate.toString());

        LocalDate dateParse = LocalDate.parse("2014-03-18");

        int compareTo = dateParse.compareTo(localDate);

        System.out.println("compareTo localDates: " + compareTo);


        int dateYear = localDate.getYear();

        Month monthTwo = localDate.getMonth();

        int dayOfMonth = localDate.getDayOfMonth();

        int dayOfYear = localDate.getDayOfYear();


        System.out.println("DateYear: " + dateYear + " monthTwo: " + monthTwo + " dayOfMonth: " + dayOfMonth +
                " dayOfYear: " + dayOfYear);


        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int lengthOfYear = localDate.lengthOfYear();

        int lengthOfMonth = localDate.lengthOfMonth();

        int monthValue = localDate.getMonthValue();

        System.out.println("DayOfWeek: " + dayOfWeek + " lengthOfYear: " + lengthOfYear +
                " lengthOfMonth: " + lengthOfMonth + " monthValue: " + monthValue);

        IsoEra era = localDate.getEra();

        System.out.println("Era: " + era);

        IsoChronology chronology = localDate.getChronology();

        System.out.println("get Chronology: " + chronology);

        boolean leapYear = localDate.isLeapYear();

        int yearLocalDate = localDate.get(ChronoField.YEAR);

        int monthLocalDate = localDate.get(ChronoField.MONTH_OF_YEAR);

        int dayLocalDate = localDate.get(ChronoField.DAY_OF_MONTH);

        System.out.println("is leap year: " + leapYear);

        System.out.println("yearDate: " + yearLocalDate);

        System.out.println("moth of year: " + monthLocalDate);

        System.out.println("dayLocalDate: " + dayLocalDate);


        LocalDate localDateNow = LocalDate.now();

        LocalDate localDate2 = localDateNow.withDayOfMonth(3);

        LocalDate localDate3 = localDate2.withDayOfMonth(1);

        LocalDate localDate4 = localDate3.withYear(2000);

        System.out.println("localDateNow: " + localDateNow + " localDate2: " + localDate2 +
                " localDate3:" + localDate3 + " localDate4: " + localDate4);


        LocalDate with = localDate3.with(ChronoField.MONTH_OF_YEAR, 1);

        System.out.println("with moth: " + with);

        LocalDate withDayTuesday = localDateNow.with(nextOrSame(DayOfWeek.TUESDAY));

        System.out.println("with day of the week tuesday: " + withDayTuesday);

        LocalDate lastDayOfMouth = localDateNow.with(lastDayOfMonth());

        System.out.println("last day of moth : " + lastDayOfMouth);


        String isoLocalDateFormat = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("iso local format: " + isoLocalDateFormat);

        String basicLocalDateFormat = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);

        System.out.println("basic local date format: " + basicLocalDateFormat);


        LocalDate parseBasicIsoDate = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);

        System.out.println("parse basic iso date: " + parseBasicIsoDate);


        LocalDate parseIsoLocalDate = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("parse iso local date: " + parseIsoLocalDate);


        LocalTime localTime = LocalTime.of(23, 12, 11);

        LocalTime time = LocalTime.parse("13:45:20");

        int hour = localTime.getHour();

        int minute = localTime.getMinute();

        int second = localTime.getSecond();

        int nano = localTime.getNano();

        System.out.println("timOf(): " + localTime);

        System.out.println("time parse: " + time);

        System.out.println("hour: " + hour + " minute: " + minute + " second: " + second + " nano: " + nano);


        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("local date time now: " + localDateTime);

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH,
                18, 13, 45, 20);

        System.out.println("dateTimeTwo: " + dt1);

        LocalDateTime dt2 = LocalDateTime.of(localDate, time);

        System.out.println("dateTimeThree: " + dt2);

        LocalDateTime dt3 = localDate.atTime(13, 45, 20);

        System.out.println("dateTimeFour: " + dt3);

        LocalDateTime dt4 = localDate.atTime(time);

        System.out.println("dateTimeFive: " + dt4);

        LocalDateTime dt5 = time.atDate(localDate);

        System.out.println("dateTimeSix: " + dt5);

        LocalDate localDate12 = dt1.toLocalDate();

        System.out.println("Local date: " + localDate12);

        LocalTime localTime1 = dt2.toLocalTime();

        System.out.println("Local date2: " + localTime1);


        Instant instant = Instant.now();

        System.out.println("instant now: " + instant);

        Instant instantOne = Instant.ofEpochSecond(3);

        System.out.println("instantOfEpochSecond: " + instantOne);

        Instant instantTwo = Instant.ofEpochSecond(3, 0);

        System.out.println("instantOfEpochSecondTwo: " + instantTwo);

        Instant instantThree = Instant.ofEpochSecond(3, 1_000_000_000);

        System.out.println("instantOfEpochSecondThree: " + instantThree);


        Duration duration = Duration.between(localTime, time);

        Duration durationThree = Duration.between(instant, instantOne);

        Duration durationFour = Duration.ofMinutes(3);

        Duration durationFive = Duration.of(4, ChronoUnit.MINUTES);

        System.out.println("duration between time: " + duration);

        System.out.println("duration between instant: " + durationThree);

        System.out.println("duration ofMinutes: " + durationFour);

        System.out.println("duration of: " + durationFive);


        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));

        System.out.println("Period between: " + tenDays);

        Period periodDays = Period.ofDays(10);

        System.out.println("period days: " + periodDays);

        Period threeWeeks = Period.ofWeeks(3);

        System.out.println("period weeks: " + threeWeeks);

        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        System.out.println("Period two years six month one day: " + twoYearsSixMonthsOneDay);


        LocalDate localDateTwenty = LocalDate.of(2014, 11, 12);

        String newDateOne = localDateTwenty.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("new date iso local data format: " + newDateOne);

        String newDateTwo = localDateTwenty.format(DateTimeFormatter.BASIC_ISO_DATE);

        System.out.println("new date iso basic date format: " + newDateTwo);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dateNew = LocalDate.of(2014, 3, 18);

        String formattedDate = dateNew.format(formatter);

        LocalDate dateFormatter = LocalDate.parse(formattedDate, formatter);

        System.out.println("formatted date: " + dateFormatter);


        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern(
                "d. MMMM yyyy", Locale.ITALIAN);

        LocalDate dateFormatterItalian = LocalDate.of(2014, 3, 18);

        String formattedDateItalian = dateFormatterItalian.format(italianFormatter);

        LocalDate dateItalian = LocalDate.parse(formattedDateItalian, italianFormatter);

        System.out.println("parsed italian date: " + dateItalian);


        ZoneId romeZone = ZoneId.of("Europe/Rome");

        ZoneId zoneId = TimeZone.getDefault().toZoneId();

        System.out.println("zoneId: " + zoneId);

        LocalDate dateForZoneId = LocalDate.of(2014, Month.MARCH, 18);

        ZonedDateTime zdt1 = dateForZoneId.atStartOfDay(romeZone);

        System.out.println("zoneDateTime: " + zdt1);

        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);

        ZonedDateTime zdt2 = dateTime.atZone(romeZone);

        System.out.println("zoneDateTimeTwo: " + zdt2);
    }
}
