package task6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Age {

    public int getAge(String date) {
        checkNull(date);
        LocalDate birthday = LocalDate.parse(date, getFormatDay());
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public String getDayOfBirthday(String date) {
        checkNull(date);
        LocalDate dayOfBirthday = LocalDate.parse(date, getFormatDay());
        return String.valueOf(dayOfBirthday.getDayOfWeek());
    }

    public int getWeekOfBirthday(String date) {
        checkNull(date);
        WeekFields week = WeekFields.of(Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(date, getFormatDay());
        return localDate.get(week.weekOfWeekBasedYear());
    }

    private DateTimeFormatter getFormatDay() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
    }

    private void checkNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Date is Null");
        }
    }
}
