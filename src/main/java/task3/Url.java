package task3;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Url {
    public boolean isUrl(String url){
        String value = Optional.ofNullable(url).orElseThrow();
        Pattern urlChecker = Pattern.compile("^(http?|https)://[a-zA-Z.]+\\.\\w{2,3}");
        Matcher matcher = urlChecker.matcher(value);
        return matcher.matches();
    }
}
