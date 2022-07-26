package zadanie1;

import exceptions.ObjectAddConditionFalse;
import org.junit.Test;
import org.junit.Before;
//import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ObjectContainerTest {
    private ObjectContainer<Person> peopleFromWarsaw;

    @Before
    public void init() {
        peopleFromWarsaw = new ObjectContainer<>(p -> p.getCity().equals("Warsaw"));
    }


    @Test
    public void shouldReturnTrueWhenObjectWasAdded() {
        peopleFromWarsaw.add(new Person("Jan", "Warsaw", 30));
    }

    @Test(expected = ObjectAddConditionFalse.class)
    public void shouldThrowObjectAddConditionFalseWhenConditionIsWrong() {
        peopleFromWarsaw.add(new Person("Waldek", "Monaco", 34));
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnNullPointerExceptionWhenObjectIsNull() {
        peopleFromWarsaw.add(null);
    }

    @Test
    public <T> void getWithFilter2() {
        Person p1 = new Person("Jan", "Warsaw", 30);
        Person p2 = new Person("Weronika", "Warsaw", 20);
        peopleFromWarsaw.add(p1);
        peopleFromWarsaw.add(p2);

        List<Person> expected = new ArrayList<>(List.of(p1));
        List<Person> actual = new ArrayList<>(peopleFromWarsaw.getWithFilter(p -> p.getName().endsWith("a")));

        assertNotEquals(expected.get(0), actual.get(0));
    }

    @Test
    public <T> void getWithFilter() {
        Person p1 = new Person("Jan", "Warsaw", 30);
        Person p2 = new Person("Weronika", "Warsaw", 20);
        peopleFromWarsaw.add(p1);
        peopleFromWarsaw.add(p2);

        List<Person> expected = new ArrayList<>(List.of(p2));
        List<Person> actual = new ArrayList<>(peopleFromWarsaw.getWithFilter(p -> p.getName().endsWith("a")));

        assertEquals(expected.get(0), actual.get(0));
    }

    @Test
    public void removeIf() {
    }

    @Test
    public void storeToFile() {
    }
}