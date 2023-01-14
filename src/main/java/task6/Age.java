package task6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Optional;

public class Age {

    public int getAge(String date) {
        if(isNull(date)){
            return 0;
        }
        LocalDate birthday = LocalDate.parse(date, getFormatDay());
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public String getDayOfBirthday(String date) {
        if(isNull(date)){
            return "is null";
        }
        LocalDate dayOfBirthday = LocalDate.parse(date, getFormatDay());
        return String.valueOf(dayOfBirthday.getDayOfWeek());
    }

    public int getWeekOfBirthday(String date) {
       if(isNull(date)) {
           return 0;
       }
           WeekFields week = WeekFields.of(Locale.ENGLISH);
           LocalDate localDate = LocalDate.parse(date, getFormatDay());
           return localDate.get(week.weekOfWeekBasedYear());
    }
    private DateTimeFormatter getFormatDay() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
    }

    private boolean isNull(String value){
        Optional<String> checker = Optional.ofNullable(value);
        return checker.isEmpty();
    }
}
