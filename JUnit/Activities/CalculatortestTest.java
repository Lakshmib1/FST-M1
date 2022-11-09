package junit.alchemy.activities;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatortestTest {
	private Calculator calculator;
	 
    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }
 
    @Test
   // @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }
    
    @Test
    void addNumbers() {
                
        // Assertion
        assertEquals(3, calculator.add(1, 2)); // Passes
        assertNotEquals(3, calculator.add(1, 2)); // Fails
    }
}
