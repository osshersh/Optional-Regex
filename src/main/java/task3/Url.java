package task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Url {
    public boolean isUrl(String url) {
        if (url == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        Pattern urlChecker = Pattern.compile("^(http?|https)://[a-zA-Z.]+\\.\\w{2,3}");
        Matcher matcher = urlChecker.matcher(url);
        return matcher.matches();
    }
}
