package com.demo.junit;

import com.demo.junit.math.MyMath;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JunitApplicationTests {

	private MyMath myMath=new MyMath();

	@Test
	public void test2()
	{

		assertEquals(0,myMath.calculateSum(new int[]{}));
	}

	@Test
	void contextLoads() {

		int [] a={1,2,3};

		MyMath myMath=new MyMath();
		int result=myMath.calculateSum(a);
		System.out.println(result);
		int expectedResult=6;
		assertEquals(expectedResult,result);


	}

	//Assert Methods

	@Test
	void Methods()
	{

		Boolean a=true;
		Boolean b=false;
		assertTrue(a);
		assertFalse(b);
		assertEquals(4,4,"Good");
//		assertEquals( new int [] {1,2,3}, new int [] {1,2,3});
	}



}
