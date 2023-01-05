package task5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logger {
    public boolean isPassword(String password) {
        Optional<String> check = Optional.ofNullable(password);
        if (check.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z]).{7,}");
        Matcher matcher = pattern.matcher(password);
        while (matcher.find()) {
            if (isFindCoincidence(matcher)) {
                return false;
            }
        }
        return matcher.matches();
    }

    private String getPresentYear() {
        String year;
        LocalDate presentDate = LocalDate.now();
        return year = String.valueOf(presentDate.getYear());
    }

    private String getPresentYearFormatted() {
        String year;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        return year = formatter.format(LocalDateTime.now());
    }

    private boolean isFindCoincidence(Matcher matcher) {
        String matcherString = matcher.group();
        return matcherString.contains(getPresentYear()) || matcherString.contains(getPresentYearFormatted());
    }
}
