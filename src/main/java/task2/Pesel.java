package task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pesel {

    public boolean validatePesel(String pesel) {
        if (pesel == null) {
            throw new IllegalArgumentException("Value can't be null");
        }
        Pattern pattern = Pattern.compile("\\b^\\d{11}\\b(?![-.+])");
        Matcher matcher = pattern.matcher(pesel);
        return matcher.matches();
    }
}
