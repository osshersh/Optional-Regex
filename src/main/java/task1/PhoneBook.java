package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PhoneBook implements Serializable {
    private String name;
    private String phoneNumber;
    private String address;

    public PhoneBook(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public static PhoneBook searchPerson(ArrayList<PhoneBook> phoneBookList, String name) {
        checkIsNull(name);
        checkEmptyList(phoneBookList);
        for (PhoneBook phoneBook : phoneBookList) {
            if (phoneBook.name.equals(name)) {
                return phoneBook;
            }
        }
        throw new NoSuchElementException("Person not found");
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void addNewPerson(PhoneBook phoneBook, List<PhoneBook> phoneBookList) {
        phoneBookList.add(phoneBook);
        write(phoneBookList);
    }

    private static void checkEmptyList(ArrayList<PhoneBook> list) {
        if (list.isEmpty()) {
            read(list);
        }
    }

    private static void checkIsNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Name is Null");
        }
    }

    private static void read(ArrayList<PhoneBook> phoneBooks) {
        File file = new File("C:\\HomeWorkJava\\Optional-Regex\\src\\main\\resources\\date.txt");

        try (FileInputStream fileInputStream = new FileInputStream(file.getPath());
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ) {
            while (fileInputStream.available() != 0) {
                Object obj = objectInputStream.readObject();
                phoneBooks.add((PhoneBook) obj);
            }

        } catch (IOException e) {
            throw new RuntimeException("No data");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(List<PhoneBook> phoneBooks) {
        File file = new File("C:\\HomeWorkJava\\Optional-Regex\\src\\main\\resources\\date.txt");
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file.getPath()));
            for (PhoneBook phoneBook : phoneBooks) {

                outputStream.writeObject(phoneBook);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }
}