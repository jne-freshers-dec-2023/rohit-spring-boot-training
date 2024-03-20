package com.demo.mockito.mokitodemo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    @Test
    void test()
    {
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(3);
        assertEquals(3,listMock.size());

    }

    @Test
    void multipleReturns()
    {
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(4).thenReturn(5);
        System.out.println(listMock.size());
        assertEquals(3,listMock.size());
        assertEquals(4,listMock.size());
        assertEquals(5,listMock.size());

    }
}
