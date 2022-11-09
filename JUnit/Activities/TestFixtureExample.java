package junit.alchemy.activities;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class TestFixtureExample {
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("This is the setUp() method that runs once BEFORE all the test cases");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("This is the teardown() method that runs once AFTER all the test cases");
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("This is the setUp() method that runs BEFORE EVERY test case");
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("This is the setUp() method that runs AFTER EVERY test case");
    }

    @Test
    void test1() {
        System.out.println("This is test case 1");
    }

    @Test
    void test2() {
        System.out.println("This is test case 2");
    }

    @Test
    void test3() {
        System.out.println("This is test case 3");
    }
}