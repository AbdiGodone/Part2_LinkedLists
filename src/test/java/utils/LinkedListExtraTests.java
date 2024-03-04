package utils;

import business.Song;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.ArrayList;

/**
 *
 * @author michelle
 */
public class LinkedListExtraTests {

    @Test
    public void add_to_the_end() {

        LinkedList list = new LinkedList();
        Song song1 = new Song("abdi", "giglle");
        Song song2 = new Song("abdi", "google");

        list.add(song1);

        int expected = 1;
        int result = list.size();
        assertEquals(expected, result);

        list.add(song2);
        int expectedResult = 2;
        assertEquals(expectedResult, list.size());
    }

    @Test
    public void add_different_artist() {
        LinkedList list = new LinkedList();
        Song song1 = new Song("abdi", "redemption");
        Song song2 = new Song("Abdul", "redemption1");

        list.add(song1);
        int expected = 1;
        assertEquals(expected, list.size());

        list.add(song2);

    }
}
