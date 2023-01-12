package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    String path = "C:\\HomeWorkJava\\Optional-Regex\\src\\main\\resources\\date.txt";

    @Test
    void shouldSearchPersonInPhoneList() {
        Person person1 = new Person("Penny Smith", "Katowice");
        Person person2 = new Person("John Carter", "Gdansk");
        Person person3 = new Person("Ivan Ivanov", "Krakow");
        PhoneBook phoneBook = new PhoneBook(path);
        phoneBook.addNewPerson(person1);
        phoneBook.addNewPerson(person2);
        phoneBook.addNewPerson(person3);

        assertEquals(person2, phoneBook.searchPerson("John Carter"));
    }

    @Test
    void shouldReturnNoSuchElementExceptionIfPersonIsNotPresentPhoneList() {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            Person person1 = new Person("Penny Smith", "Katowice");
            PhoneBook phoneBook = new PhoneBook(path);
            phoneBook.searchPerson("Test");
        });
        assertEquals("Person not found", exception.getMessage());
    }

    @Test
    void shouldAddNewPersonToPhoneBook() {
        Person person1 = new Person("Penny Smith", "Katowice");
        PhoneBook phoneBook = new PhoneBook(path);
        phoneBook.addNewPerson(person1);

        assertEquals(person1, phoneBook.getPersons().get("Penny Smith"));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionIfNameIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PhoneBook phoneBook = new PhoneBook(path);
            phoneBook.searchPerson(null);
        });
        assertEquals("Name is Null", exception.getMessage());
    }
}