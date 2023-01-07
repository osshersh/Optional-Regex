package task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PeselTest {
    Pesel pesel = new Pesel();

    @Test
    void shouldReturnTrueWhenValueIsPesel() {
        boolean isPesel = pesel.validatePesel("12345678901");
        assertTrue(isPesel);
    }

    @Test
    void shouldReturnExceptionWhenValueIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pesel.validatePesel(null);
        });
        assertEquals("Value can't be null", exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideIdNumberToCheck")
    void shouldReturnFalseWhenValueIsNotPesel(String idNumber) {
        boolean isPesel = pesel.validatePesel(idNumber);
        assertFalse(isPesel);
    }

    private static Stream<Arguments> provideIdNumberToCheck() {
        return Stream.of(
                Arguments.of("+1234567890y"),
                Arguments.of("-1234567890"),
                Arguments.of(".1234567890"),
                Arguments.of("1234567890."),
                Arguments.of("1234567890-"),
                Arguments.of("1234567890+"),
                Arguments.of("tusrusgkfss"),
                Arguments.of("123456789012"),
                Arguments.of("123456u8901"),
                Arguments.of("Y2345678901"));
    }
}