package task1;

import java.io.*;
import java.util.*;

public class PhoneBook implements Serializable {
    private Map<String, Person> persons;
    private String path;

    public PhoneBook(String path) {
        this.path = path;
        loadPhoneBookData(path);
    }

    public Map<String, Person> getPersons() {
        return persons;
    }

    public Person searchPerson(String name) {
        checkIsNull(name);

        if (persons.containsKey(name)) {
            return persons.get(name);
        }
        throw new NoSuchElementException("Person not found");
    }


    public void addNewPerson(Person person) {
        persons.put(person.getName(), person);
        write(path);
    }

    private void loadPhoneBookData(String path) {
        persons = new HashMap<>();
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            persons = (HashMap) objectInputStream.readObject();

        } catch (IOException e) {
            System.out.println("no data");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkIsNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Name is Null");
        }
    }

    private void write(String path) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(persons);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}