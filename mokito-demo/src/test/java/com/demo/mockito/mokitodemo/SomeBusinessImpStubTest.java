package com.demo.mockito.mokitodemo;

import com.demo.mockito.mokitodemo.business.DataService;
import com.demo.mockito.mokitodemo.business.SomeBusinessImp;
import org.junit.jupiter.api.Test;

//import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
//import com.de

public class SomeBusinessImpStubTest {


    @Test
    void testFindGreatestFromAllData_basicScenario()
    {
        SomeBusinessImpStub someBusinessImpStub=new SomeBusinessImpStub();
        SomeBusinessImp someBusinessImp=new SomeBusinessImp(someBusinessImpStub);
         int result=someBusinessImp.findTheGreatestFromAll();
         int expected=23;
         assertEquals(expected,result);
    }

}

class SomeBusinessImpStub implements DataService
{

    @Override
    public int[] retrieveAllData() {
        return new int[] {12,12,23};
    }
}