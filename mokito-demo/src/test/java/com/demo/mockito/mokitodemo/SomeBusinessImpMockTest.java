package com.demo.mockito.mokitodemo;

import com.demo.mockito.mokitodemo.business.DataService;
import com.demo.mockito.mokitodemo.business.SomeBusinessImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class SomeBusinessImpMockTest {

    @Mock
    private DataService dataServicemock;

    @InjectMocks
    private SomeBusinessImp someBusinessImp;

    //you can used below unit test also

//    @Test
//    void findTheGreatestFromAllData_basicScenario()
//    {
//        DataService dataService=mock(DataService.class);
//        when(dataService.retrieveAllData()).thenReturn(new int [] {12,15,25});
//
//        SomeBusinessImp someBusinessImp=new SomeBusinessImp(dataService);
//
//        int result=someBusinessImp.findTheGreatestFromAll();
//        assertEquals(25,result);
//    }

    @Test
    void findTheGreatestFromAllData_oneValue()
    {
        when(dataServicemock.retrieveAllData()).thenReturn(new int [] {76,152});
        assertEquals(152,someBusinessImp.findTheGreatestFromAll());
    }



}
