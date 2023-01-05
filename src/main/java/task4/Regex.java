package task4;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public String getFloatNumbers(String value) {
        checkNull(value).orElseThrow();
        return getPattern("(?<![-.+\\w])-?\\d+\\.\\d+\\b(?![-.+])", value).trim();
    }

    public String getTotalNumbers(String value) {
        checkNull(value).orElseThrow();
        return getPattern("(?<![-.+\\w])-?\\b\\d+\\b(?![-+.])", value).trim();
    }

    public String getScientificNumbers(String value) {
        checkNull(value).orElseThrow();
        return getPattern("(?<![\\d\\w\\.])(?<![-+])-?\\d(\\.\\w+[-+]\\d{1,2}\\b)(?![-+])|(?<![\\d\\w\\.])(?<![-+])(-?\\d\\w\\+\\d{1,2}\\b)(?![-+])", value).trim();
    }

    private String getPattern(String regex, String value) {
        StringBuilder find = new StringBuilder();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            find.append(" ").append(matcher.group());
        }
        return find.toString();
    }

    private Optional<String> checkNull(String string) {
        return Optional.ofNullable(string);
    }
}
