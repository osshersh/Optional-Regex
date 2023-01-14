package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {
    Regex regex;

    @BeforeEach
    void init() {
        regex = new Regex();
    }

    @Test
    void shouldReturnExceptionWhenValueIsNull() {
        assertThrows(NoSuchElementException.class, () -> {
            regex.getFloatNumbers(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"4.43", "44.4", "0.2", "-2.33", "-2.3"})
    void shouldReturnFloatNumbers(String input) {
        Assertions.assertEquals(input, regex.getFloatNumbers(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"43", "--44.4", "+0.2", "p2.33", "99e", "-4", "4", "7.234243E-02"})
    void shouldReturnEmptyStringWhenNumberIsNotFloat(String input) {
        Assertions.assertEquals("", regex.getFloatNumbers(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "45", "300", "-0100", "-1"})
    void shouldReturnTotalNumbers(String expected) {
        Assertions.assertEquals(expected, regex.getTotalNumbers(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4r", "56.4", "0.4", "-2.89", "4e45", "7.234243E-02", "1.0001"}
    )
    void shouldReturnTrueWhenNumbersIsNotTotal(String input) {
        boolean isEmpty = regex.getTotalNumbers(input).isEmpty();
        Assertions.assertTrue(isEmpty);
    }

    @ParameterizedTest
    @MethodSource("provideScientificNumbers")
    void shouldReturnScientificNumbers(String number) {
        String scientificNumber = regex.getScientificNumbers(number);
        Assertions.assertEquals(scientificNumber, number);
    }

    @ParameterizedTest
    @MethodSource("provideNotScientificNumbers")
    void shouldReturnEmptyWhenNumberIsNotScientificNumbers(String number) {
        String scientificNumber = regex.getScientificNumbers(number);
        Assertions.assertEquals(scientificNumber, "");
    }

    private static Stream<Arguments> provideScientificNumbers() {
        return Stream.of(Arguments.of("7.234243E-02"),
                Arguments.of("7.234243E-2"),
                Arguments.of("1e+26"),
                Arguments.of("1e+2"),
                Arguments.of("-1e+2"),
                Arguments.of("-1e+24"),
                Arguments.of("-1.234e+07"),
                Arguments.of("-6.777777777777e+12"),
                Arguments.of("1.234e+07"));
    }

    private static Stream<Arguments> provideNotScientificNumbers() {
        return Stream.of(Arguments.of("7.234243E"),
                Arguments.of("126"),
                Arguments.of("1.89"),
                Arguments.of("--7.234243E-02"),
                Arguments.of("7.234243E-02--"),
                Arguments.of("74.234243E-02"),
                Arguments.of("7.234243E-023"),
                Arguments.of("hello-world"),
                Arguments.of("7.234243E-02y"),
                Arguments.of("-1.234e+07+"));
    }
}