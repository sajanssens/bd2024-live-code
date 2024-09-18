package com.infosupport.h7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClientTest {

    private Client sut; // declaratie
    private List<Laptop> mockedList;

    @BeforeEach
    void setUp() {
        sut = new Client(); // initialisatie (1e x vullen)
        mockedList = mock(List.class);
        sut.setLaptops(this.mockedList);
    }

    // met 1, 2, 3, ... hoofdletters
    // zonder hoofdletter
    // cijfer
    // sql injection
    // ""
    // null

    @Test
    void givenANameWithOneCapitalLetterWhenThisNameIsSetOnAClientThenThisIsSuccessful() {
        // given / arrange
        String name = "Bram";

        // when / act
        sut.setName(name);

        // then / assert
        assertEquals(sut.getName(), "Bram");
    }

    @Test
    void givenANameWithTwoCapitalLettersWhenThisNameIsSetOnAClientThenThisNameIsNotSet() {
        // given / arrange
        String name = "BRam";

        // when / act
        sut.setName(name);

        // then / assert
        assertNull(sut.getName());
    }

    @Test
    void givenANameStartingWithSomethingElseThanLettersWhenThisNameIsSetOnAClientThenThisNameIsNotSet() {
        // given / arrange
        String name = "123Bram";

        // when / act
        sut.setName(name);

        // then / assert
        assertNull(sut.getName());
    }

    @Test
    void givenANameWithNoCapitalLettersWhenThisNameIsSetOnAClientThenThisNameIsNotSet() {
        // given / arrange
        String name = "bram";

        // when / act
        sut.setName(name);

        // then / assert
        assertNull(sut.getName());

        // same, with external library called AssertJ (needed in your pom):
        // assertThat(sut.getName()).isNull();
    }

    @Test
    void givenANullNameWhenThisNameIsSetOnAClientThenThisGivesAnException() {
        // given / arrange
        String name = null;

        //                                                  when / act:
        // then / assert
        assertThrows(IllegalArgumentException.class, () -> sut.setName(name));
    }

    @Test
    void givenAnEmptyNameWhenThisNameIsSetOnAClientThenThisGivesAnException() {
        // given / arrange
        String name = "";

        //                                                  when / act:
        // then / assert
        assertThrows(IllegalArgumentException.class, () -> sut.setName(name));
    }

    @Test
    void givenABlankNameWhenThisNameIsSetOnAClientThenThisGivesAnException() {
        // given / arrange
        String name = "    ";

        //                                                  when / act:
        // then / assert
        assertThrows(IllegalArgumentException.class, () -> sut.setName(name));
    }

    @Test
    void givenALaptopWhenTheLaptopIsAddedItSucceeds() {
        Laptop laptop = new Laptop("");
        sut.addLaptop(laptop);
        assertEquals(1, sut.getLaptops().size());
    }

    @Test
    void testTransferWithManualMock() {
        // given
        byte[] dataSource = {1, 2, 3};
        Laptop laptop1 = new Laptop("HP");
        laptop1.setData(dataSource);
        Laptop laptop2 = new Laptop("DELL");

        sut.setLaptops(new MockList<Laptop>());
        sut.addLaptop(laptop1);
        sut.addLaptop(laptop2);

        // when
        boolean result = sut.transferData(laptop1, laptop2);

        // then
        byte[] dataDest = laptop2.getData();
        assertTrue(result);
        for (int i = 0; i < dataSource.length; i++) {
            assertEquals(dataSource[i], dataDest[i]);
        }
    }

    @Test
    void testTransferWithMockito() {
        // given
        byte[] dataSource = {1, 2, 3};
        Laptop laptop1 = new Laptop("HP");
        laptop1.setData(dataSource);
        Laptop laptop2 = new Laptop("DELL");

        when(this.mockedList.indexOf(eq(laptop1))).thenReturn(0);
        when(this.mockedList.indexOf(eq(laptop2))).thenReturn(1);
        when(this.mockedList.indexOf(any())).thenReturn(10);

        sut.addLaptop(laptop1);
        sut.addLaptop(laptop2);

        // when
        boolean result = sut.transferData(laptop1, laptop2);

        // then
        byte[] dataDest = laptop2.getData();
        assertTrue(result);
        for (int i = 0; i < dataSource.length; i++) {
            assertEquals(dataSource[i], dataDest[i]);
        }

        verify(this.mockedList, times(2)).indexOf(any());
    }
}

class MockList<T> implements List<T> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override public boolean contains(Object o) {
        return false;
    }

    @Override public Iterator iterator() {
        return null;
    }

    @Override public Object[] toArray() {
        return new Object[0];
    }

    @Override public boolean add(Object o) {
        return true;
    }

    @Override public boolean remove(Object o) {
        return false;
    }

    @Override public boolean addAll(Collection c) {
        return false;
    }

    @Override public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override public void clear() {

    }

    @Override public T get(int index) {
        return null;
    }

    @Override public T remove(int index) {
        return null;
    }

    @Override public Object set(int index, Object element) {
        return null;
    }

    @Override public void add(int index, Object element) {

    }

    @Override public int indexOf(Object o) {
        return 0;
    }

    @Override public int lastIndexOf(Object o) {
        return 0;
    }

    @Override public ListIterator listIterator() {
        return null;
    }

    @Override public ListIterator listIterator(int index) {
        return null;
    }

    @Override public List subList(int fromIndex, int toIndex) {
        return List.of();
    }

    @Override public boolean retainAll(Collection c) {
        return false;
    }

    @Override public boolean removeAll(Collection c) {
        return false;
    }

    @Override public boolean containsAll(Collection c) {
        return false;
    }

    @Override public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
