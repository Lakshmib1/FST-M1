package junit.alchemy.activities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;



public class Practise {

		@Test
		void iterablesEqual() {
		    final List<String> list = Arrays.asList("orange", "mango", "banana");
		    final List<String> expected = Arrays.asList("banana", "mango", "orange");
		    // Sort array
		    Collections.sort(list);
		    
		    // Assertion
		    
		    assertIterableEquals(expected, list); //Pass
		}
		
		

	}


