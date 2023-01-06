package task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {
    Logger logger = new Logger();

    @Test
    void shouldReturnFalseIfValueIsNull() {
        Assertions.assertFalse(logger.isPasswordCorrect(null));
    }

    @ParameterizedTest
    @MethodSource("providePassword")
    void shouldReturnTrueWhenIsPassword(String password) {
        boolean isPassword = logger.isPasswordCorrect(password);
        Assertions.assertTrue(isPassword);
    }

    @ParameterizedTest
    @MethodSource("provideNotPassword")
    void shouldReturnFalseWhenIsNotPassword(String number) {
        assertFalse(logger.isPasswordCorrect(number));
    }


    private static Stream<Arguments> providePassword() {
        return Stream.of(
                Arguments.of("2022Rffkss"),
                Arguments.of("ss22ghrsW"),
                Arguments.of("ffkss19Wdd"),
                Arguments.of("21Rffkssr"),
                Arguments.of("21Rffkssr--"),
                Arguments.of("-W.ddd44dd"));
    }

    private static Stream<Arguments> provideNotPassword() {
        return Stream.of(
                Arguments.of("password"),
                Arguments.of("passwordE"),
                Arguments.of("Y4dhd"),
                Arguments.of("5674444447"),
                Arguments.of("4password"),
                Arguments.of("5paSsword2023"),
                Arguments.of("Konrad123!"),
                Arguments.of("23passWord"),
                Arguments.of("pa2023Word"));
    }
}