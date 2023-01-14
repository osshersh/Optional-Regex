package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UrlTest {
    Url url;

    @BeforeEach
    void init() {
        url = new Url();
    }

    @Test
    void shouldReturnExceptionWhenValueIsNull() {
        assertThrows(NoSuchElementException.class, () -> {
            url.isUrl(null);
        });
    }

    @ParameterizedTest
    @MethodSource("provideUrlToCheck")
    void shouldTrueWhenValueIsUrl(String value) {
        boolean isUrl = url.isUrl(value);
        assertTrue(isUrl);
    }

    @ParameterizedTest
    @MethodSource("provideValueThatIsNotUrl")
    void shouldFalseWhenStringIsNotUrl(String value) {
        boolean isUrl = url.isUrl(value);
        assertFalse(isUrl);
    }

    private static Stream<Arguments> provideUrlToCheck() {
        return Stream.of(
                Arguments.of("https://mail.google.com"),
                Arguments.of("http://www.onet.pl"),
                Arguments.of("http://wiadmosci.onet.pl"),
                Arguments.of("http://onet.pl"));
    }

    private static Stream<Arguments> provideValueThatIsNotUrl() {
        return Stream.of(
                Arguments.of("https://mail.google.comy"),
                Arguments.of("https//mail.google.com"),
                Arguments.of("httpu://www.onet.pl"),
                Arguments.of("://wiadmosci.onet.pl"),
                Arguments.of("http://wiadmosci.onet"),
                Arguments.of("http:onet.pl"));
    }
}