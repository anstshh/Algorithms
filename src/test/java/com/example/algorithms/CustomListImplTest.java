package com.example.algorithms;

import com.example.algorithms.customlist.CustomListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private final CustomListImpl stringList = new CustomListImpl();

    @BeforeEach
    void setUp() {
        stringList.add(Integer.valueOf("aa1"));
        stringList.add(Integer.valueOf("aa2"));
        stringList.add(Integer.valueOf("aa3"));
    }

    @Test
    void addCorrect() {
        assertEquals("bb4", stringList.add(Integer.valueOf("bb4")));
    }

    @Test
    void addNotExist() {
        assertThrows(NotExistException.class, () -> stringList.add(null));
    }

    @Test
    void testAddCorrect() {
        assertEquals("bb4", stringList.add(1, Integer.valueOf("bb4")));
    }

    @Test
    void testAddInCorrect() {
        assertThrows(NotExistException.class, () -> stringList.add(1, null));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.add(-1, Integer.valueOf("bb4")));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.add(3, Integer.valueOf("bb4")));
    }

    @Test
    void setCorrect() {
        assertEquals("bb4", stringList.set(1, Integer.valueOf("bb4")));
    }

    @Test
    void setInCorrect() {
        assertThrows(NotExistException.class, () -> stringList.set(1, null));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.set(-1, Integer.valueOf("bb4")));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.set(3, Integer.valueOf("bb4")));
    }

    @Test
    void removeCorrect() {
        assertEquals("aa3", stringList.remove(Integer.valueOf("aa3")));
    }

    @Test
    void removeInCorrect() {
        assertThrows(NotExistException.class, () -> stringList.remove(null));
        assertThrows(CustomNullPointerException.class, () -> stringList.remove(Integer.valueOf("bb4")));
    }

    @Test
    void testRemoveCorrect() {
        assertEquals("aa1", stringList.remove(0));
    }

    @Test
    void testRemoveInCorrect() {
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.remove(3));
    }

    @Test
    void contains() {
        assertTrue(stringList.contains(Integer.valueOf("aa1")));
        assertFalse(stringList.contains(Integer.valueOf("aa")));
    }

    @Test
    void indexOf() {
        assertEquals(0, stringList.indexOf(Integer.valueOf("aa1")));
        assertEquals(-1, stringList.indexOf(Integer.valueOf("aa")));
    }

    @Test
    void lastIndexOf() {
        assertEquals(0, stringList.lastIndexOf(Integer.valueOf("aa1")));
        assertEquals(-1, stringList.lastIndexOf(Integer.valueOf("aa")));
    }

    @Test
    void getCorrect() {
        assertEquals("aa2", stringList.get(1));
    }

    @Test
    void getInCorrect() {
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.get(-1));
        assertThrows(CustomIndexOutOfBoundsException.class, () -> stringList.get(3));
    }

    @Test
    void testEqualsCorrectTrue() {
        CustomListImpl extend = new CustomListImpl();
        extend.add(Integer.valueOf("aa1"));
        extend.add(Integer.valueOf("aa2"));
        extend.add(Integer.valueOf("aa3"));

        assertTrue(stringList.equals(extend));

    }

    @Test
    void testEqualsCorrectFalse() {
        CustomListImpl extend = new CustomListImpl();
        extend.add(Integer.valueOf("aa1"));

        assertFalse(stringList.equals(extend));
    }

    @Test
    void testEqualsInCorrect() {
        assertThrows(NotExistException.class, () -> stringList.equals(null));
    }

    @Test
    void size() {
        assertEquals(3, stringList.size());
    }

    @Test
    void isEmptyFasle() {
        assertFalse(stringList.isEmpty());
    }

    @Test
    void isEmptyTrue() {
        CustomListImpl actual = new CustomListImpl();

        assertTrue(actual.isEmpty());
    }

    @Test
    void clear() {
        stringList.clear();

        assertTrue(stringList.isEmpty());
    }

    @Test
    void toArray() {
        String[] extend = {"aa1", "aa2", "aa3"};

        assertArrayEquals(extend, stringList.toArray());
    }
}
