package task6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AgeTest {
    Age age = new Age();

    @ParameterizedTest
    @MethodSource("provideDateToGetAge")
    void shouldReturnAge(String date, int expected) {
        assertEquals(expected, age.getAge(date));
    }

    @Test
    void shouldReturnDayOfBirthday() {
        String day = String.valueOf(age.getDayOfBirthday("2023-01-06"));
        assertEquals("FRIDAY", day);
    }

    @Test
    void shouldReturnWeekOfBirthday() {
        int week = age.getWeekOfBirthday("2023-01-06");
        assertEquals(1, week);
    }

    @Test
    void shouldReturnExceptionWhenValueIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            age.getAge(null);
        });
        assertEquals("Date is Null", exception.getMessage());
    }

    private static Stream<Arguments> provideDateToGetAge() {
        return Stream.of(
                Arguments.of("1985-03-23", 38),
                Arguments.of("2000-03-23", 23),
                Arguments.of("1989-03-23", 34),
                Arguments.of("2020-03-23", 3),
                Arguments.of("1923-03-23", 100));
    }
}