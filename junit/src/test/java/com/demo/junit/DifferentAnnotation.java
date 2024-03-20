package com.demo.junit;

import org.junit.jupiter.api.*;

public class DifferentAnnotation {

        @BeforeAll
        static void beforeAllTest()
        {
            System.out.println("Before all");
        }

        @BeforeEach
        void before()
        {
            System.out.println("brfore Each");
        }

        @Test
        void test1()
        {
            System.out.println("from test1");
        }

        @Test
        void test2()
        {
            System.out.println("from test2");
        }

        @Test
        void test3()
        {
            System.out.println("from test3");
        }

        @Test
        void test4()
        {
            System.out.println("from test4");
        }

        @AfterEach
        void after()
        {
            System.out.println("After Each");
        }

        @AfterAll
        static void afterAll()
        {
            System.out.println("After All");
        }

}
