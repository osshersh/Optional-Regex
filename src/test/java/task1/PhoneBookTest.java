package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    ArrayList<PhoneBook> list;


    @BeforeEach
    void init() {
        list = new ArrayList<>();
    }

    @Test
    void shouldSearchPersonInPhoneList() {
        PhoneBook person1 = new PhoneBook("Penny Smith", "Katowice");
        PhoneBook person2 = new PhoneBook("John Carter", "Gdansk");
        PhoneBook person3 = new PhoneBook("Ivan Ivanov", "Krakow");
        PhoneBook.addNewPerson(person1, list);
        PhoneBook.addNewPerson(person2, list);
        PhoneBook.addNewPerson(person3, list);

        assertEquals(person2, PhoneBook.searchPerson(list, "John Carter"));
    }

    @Test
    void shouldReturnNoSuchElementExceptionIfPersonIsNotPresentPhoneList() {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            PhoneBook.addNewPerson(new PhoneBook("John Carter", "Gdansk"), list);
            PhoneBook.searchPerson(list, "Test");
        });
        assertEquals("Person not found", exception.getMessage());
    }

    @Test
    void shouldAddNewPersonToPhoneBook() {
        PhoneBook phoneBook = new PhoneBook("John Smith", "Krakow");
        PhoneBook.addNewPerson(phoneBook, list);

        assertEquals(phoneBook, list.get(0));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionIfNameIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PhoneBook phoneBook = new PhoneBook("John Smith", "Krakow");
            PhoneBook.addNewPerson(phoneBook, list);
            PhoneBook.searchPerson(list, null);
        });
        assertEquals("Name is Null", exception.getMessage());
    }
}