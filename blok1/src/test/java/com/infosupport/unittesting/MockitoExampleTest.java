package com.infosupport.unittesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.management.openmbean.InvalidOpenTypeException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoExampleTest {

    @Test
    public void mockitoDemo(){
        //mock creation
        List<String> mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("Hello");

        //using mock object
        var result = mockedList.add("one");

        mockedList.clear();

        System.out.println( mockedList.get(0));
        System.out.println( mockedList.get(1));

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void mockitoDemo2(){
        List<String> mockedList = mock(List.class);
        when(mockedList.get(intThat(index -> index % 2 == 0))).thenReturn("even");
        when(mockedList.get(intThat(index -> index % 2 == 1))).thenReturn("odd");

        System.out.println(mockedList.get(824569));
        System.out.println(mockedList.get(-6));
    }

    @Test
    public void mockitoDemo3(){
        List<String> mockedList = mock(List.class);

        var expectedException = new UnsupportedOperationException();
        doThrow(expectedException).when(mockedList).clear();

        var actualException = assertThrows(UnsupportedOperationException.class, () -> mockedList.clear());
        assertEquals(expectedException, actualException);
    }
}
