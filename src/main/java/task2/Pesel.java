package task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pesel {

    public boolean validatePesel(String idNumber) {
        if(idNumber == null){
            throw new NullPointerException("value can't be null");
        }
        Pattern pattern = Pattern.compile("\\b^\\d{11}\\b(?![-.+])");
        Matcher matcher = pattern.matcher(idNumber);
        return matcher.matches();
    }
}
