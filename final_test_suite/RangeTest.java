package org.jfree.data.test;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
  
    
 //----------------------------------------------------------------------------------------------------
 //This is where my test code begins for getLength()
    
    //this test verifies that the getLength():double function successfully returns the correct length 
    //between the range of two negative double numbers.
    //Test case [-4.0,-3.0]
    //Expected Length 1.0
    //Test Result:Passed. 
    @Test
    public void getLengthOfTwoNegativeInputs() {
    	exampleRange = new Range(-4.0,-3.0);
    	double actual = exampleRange.getLength();
        double expected = 1.0;
      	assertEquals("the range between the lower and upper bound is 1.0",expected,actual,.000000001d);
      }
      
    //this test verifies whether the getLength():double function successfully returns the correct range between
    //between the range of one negative double number, and 0  
    // Test case[-10.0,0]
    //Expected Length 10.0
    //Test Result: Passed.     
    @Test
    public void getLengthOfOneNegativeOneZero() {
    	  exampleRange = new Range(-10.0,0.0);
    	  double actual = exampleRange.getLength();
    	  double expected = 10.0;
    	  assertEquals("the range between the lower and upper bound is 10.0",expected,actual,.000000001d);
    }
             
    //this test verifies whether the getLength():double function successfully returns the correct range between
    //between the range of 0, and one positive double number  
    // Test case[0.0,140.0]
    //Expected Length 140.0
    //Test Result: Passed.     
	@Test
	public void getLengthOfOneZeroOnePositive() {
		exampleRange = new Range(0.0,140.0);
		double actual = exampleRange.getLength();
		double expected = 140.0;
		assertEquals("the range between the lower and upper bound is 140.0",expected,actual,.000000001d);
	}
	
	//this test verifies whether the getLength():double function successfully returns the correct range between
    //between the range of 0 and 0   
    // Test case[0.0,0.0]
    //Expected Length 0.0
    //Test Result:passed      
	@Test
	public void getLengthBetweenZeroes() {
		exampleRange = new Range(0.0,0.0);
		double actual = exampleRange.getLength();
		double expected = 0.0;
		assertEquals("the range between the lower and upper bound is 0.0",expected,actual,.000000001d);
	}

	
	
	//this test verifies whether the getLength():double function successfully returns the correct range between
    //between the range of two positive values 100.0 and 119.0   
    // Test case[100.0,119.0]
    //Expected Length 19.0
    //Test Result:passed      
	@Test
	public void getLengthBetweenTwoPositives() {
		exampleRange = new Range(100.0,119.0);
		double actual = exampleRange.getLength();
		double expected = 19.0;
		assertEquals("the range between the lower and upper bound is 19.0",expected,actual,.000000001d);
	}
    
	
	//this test verifies whether the getLength():double function successfully returns the correct range between extreme value UpperBound and another value 
    // Test case[-3.0,10000000000.0]
    //Expected Length 10000000003.0
    //Test Result:passed      
	@Test
	public void getLengthBetweenUpperBoundExtreme() {
		exampleRange = new Range(-3.0,10000000000.0);
		double actual = exampleRange.getLength();
		double expected = 10000000003.0;
		assertEquals("the range between the lower and upper bound is 10000000003.0",expected,actual,.000000001d);
	}
	
	
	
	//this test verifies whether the getLength():double function successfully returns the correct range between extreme value LowerBound and another value
    // Test case[-3333399999.0,-99999.0]
    //Expected Length 30000000003.0
    //Test Result:passed      
	@Test
	public void getLengthBetweenLowerBoundExtreme() {
		exampleRange = new Range(-3333399999.0,-99999.0);
		double actual = exampleRange.getLength();
		double expected = 3333300000.0;
		assertEquals("the range between the lower and upper bound is 3333300000.0",expected,actual,.000000001d);
	}
    
	
	//this test verifies whether the getLength():double function successfully returns the correct range between extreme values for both
	//the UpperBound and LowerBound
    // Test case[-999999999999999.0,999999999999999.0]
    //Expected Length 10000000003.0
    //Test Result:passed      
	@Test
	public void getLengthBetweenExtreme() {
		exampleRange = new Range(-999999999999999.0,999999999999999.0);
		double actual = exampleRange.getLength();
		double expected = 1999999999999998.0;
		assertEquals("the range between the lower and upper bound is 1999999999999998.0",expected,actual,.000000001d);
	}
	
	
	//this test verifies whether the getLength():double function returns NaN if Range is NaN
    // Test case [Double.NaN]
    //Expected Length Double.NaN
    //Test Result:passed      
	@Test
	public void getLengthBetweenNaNRange() {
		exampleRange = new Range(0.0,Double.NaN);
		double actual = exampleRange.getLength();
		double expected = Double.NaN;
		assertEquals("the range between the lower and upper bound is NaN",expected,actual,0.00001d);
	}
	
	//this test verifies whether the getLength():double function throws illegal Argument exception if lower bound is greater than upperbound
    // Test case 
    //Expected Length 
    //Test Result:throws illegal argument exception      
	@Test(expected=IllegalArgumentException.class)
	public void invalidRangeforGetRange() {
		exampleRange = new Range(0.0,-5.0);
		double actual = exampleRange.getLength();
		
	}
	
	
	//---------------------------------------This is where my code begins for contains()---------------------------
	
	
	
	//this test verifies whether the contains(double value):boolean returns true when the positive parameter is within the Range
	//Test case range [-400.0,400.0]  double val 200.0
	//Expected result: true
	//Test Result:Passed
	@Test
	public void containsPositiveValWithinRange() {
		Range exampleRange = new Range(-400.0, 400.0);
	    double val = 200.0;
	    boolean actual = exampleRange.contains(val);
	    assertSame("the value is within the range:  " + val, Boolean.TRUE, actual);
	}
	
	//this test verifies whether the contains(double value):boolean returns true when the negative parameter is within the Range
	//Test case range [-400.0,400.0]  double val -200.0
	//Expected result: true
	//Test Result:Passed
	@Test
	public void containsNegativeValWithinRange() {
		Range exampleRange = new Range(-400.0, 400.0);
	    double val = -200.0;
	    boolean actual = exampleRange.contains(val);
	    assertSame("the value is within the range:  " + val, Boolean.TRUE, actual);
	}
	
	//this test verifies whether the contains(double value):boolean returns true when value Zero is within the Range
	//Test case range [-400.0,400.0]  double val 0.0
	//Expected result: true
	//Test Result:Passed
	@Test
	public void containsZeroValWithinRange() {
		Range exampleRange = new Range(-400.0, 400.0);
	    double val = 0.0;
	    boolean actual = exampleRange.contains(val);
	    assertSame("the value is within the range:  " + val, Boolean.TRUE, actual);
	}
	
	//this test verifies whether the contains(double value):boolean returns false when value is out of the Range
	//Test case range [-400.0,400.0]  double val 500.0
	//Expected result: false
	//Test Result:Passed
	@Test
	public void containsValIsNotTrue() {
		Range exampleRange = new Range(-400.0, 400.0);
	    double val = 500.0;
	    boolean actual = exampleRange.contains(val);
	    assertSame("the value is within the range:  " + val, Boolean.FALSE, actual);
	}
	
	//this test verifies whether the contains(double value):boolean returns true when value is on the upper bound of the Range
	//Test case range [-10000.0,10000.0]  double val 10000.0
	//Expected result: True
	//Test Result:Passed
	@Test
	public void containsValOnUpperBound() {
		Range exampleRange = new Range(-10000.0, 10000.0);
	    double val = 10000.0;
	    boolean actual = exampleRange.contains(val);
	    assertSame("the value is within the range:  " + val, Boolean.TRUE, actual);
	}
	
	//this test verifies whether the contains(double value):boolean returns true when value is on the lower bound of the Range
	//Test case range [-9999999.0,0.0]  double val -9999999.0
	//Expected result: True
	//Test Result:Passed
	@Test
	public void containsValOnLowerBound() {
		Range exampleRange = new Range(-9999999.0, 0.0);
	    double val = -9999999.0;
	    boolean actual = exampleRange.contains(val);
	    assertSame("the value is within the range:  " + val, Boolean.TRUE, actual);
	}
	
	//this test verifies whether the contains(double value):boolean returns true when value is extremely high(positive) on the upper bound of the Range
	//Test case range [0.0,10000000000.0]  double val 10000000000.0
	//Expected result: True
	//Test Result:Passed
	@Test
	public void containsValOnExtremeUpperBound() {
		Range exampleRange = new Range(0.0, 10000000000.0);
	    double val = 10000000000.0;
	    boolean actual = exampleRange.contains(val);
	    assertSame("the value is within the range:  " + val, Boolean.TRUE, actual);
	}
	
	//this test verifies whether the contains(double value):boolean returns true when value is extremely low(negative) on the lower bound of the Range
	//Test case range [-10000000000.0,0.0]  double val -10000000000.0
	//Expected result: True
	//Test Result:Passed
	@Test
	public void containsValOnExtremeLowerBound() {
		Range exampleRange = new Range( -10000000000.0,0.0);
	    double val = -10000000000.0;
	    boolean actual = exampleRange.contains(val);
	    assertSame("the value is within the range:  " + val, Boolean.TRUE, actual);
	}
	

	
	@Test
	public void containsValInvalidInput() {
		Range exampleRange = new Range(-1000.0, 0.0);
		int val = -2000000;
		boolean check = exampleRange.contains(val);
		
		assertFalse("Value should not be contained in the range", check);
	}

//---------------This is where code for RangeToString tests begin--------------//
	
	// Range objects used for testing
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    private Range exampleRange5;

    // Set up resources needed before all tests (not used in this example)
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    // Set up the Range objects before each test
    @Before
    public void setUp() throws Exception {
        exampleRange1 = new Range(1.0, 1.0);
        exampleRange2 = new Range(5.0, 10.0);
        exampleRange3 = new Range(-10.0, -5.0);
        exampleRange4 = new Range(-5.0, 10.0);
        exampleRange5 = new Range(-1.0, 1.0);
    }

    // Test case: ToString for a range with similar bounds (Equivalence Class: Similar bounds)
    @Test
    public void toStringSimilarBounds() {
        // Parameters: None
        // Returns: String representation of the range
        // Passes: Yes, it returns "Range[1.0,1.0]
        assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
                "Range[1.0,1.0]", exampleRange1.toString());
        System.out.println(exampleRange1.toString());
    }

    // Test case: ToString for a range with positive bounds (Equivalence Class: Positive bounds)
    @Test
    public void toStringPositiveBounds() {
        // Parameters: None
        // Returns: String representation of the range
        // Passes: No because it returns "Range [7.5, 10.0]" where it should return ""Range [5.0, 10.0]"
        assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
                "Range[5.0,10.0]", exampleRange2.toString());
        System.out.println(exampleRange2.toString());
    }

    // Test case: ToString for a range with negative bounds (Equivalence Class: Negative bounds)
    @Test
    public void toStringNegativeBounds() {
        // Parameters: None
        // Returns: String representation of the range
        // Passes: No because it returns "Range [-7.5, -5.0]" where it should return "Range [-10.0, -5.0]"
        assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
                "Range[-10.0,-5.0]", exampleRange3.toString());
        System.out.println(exampleRange3.toString());
    }

    // Test case: ToString for a range with negative and positive bounds (Equivalence Class: Negative and Positive bounds, Boundary Value: Value near lower bound)
    @Test
    public void toStringNegativePositiveBounds() {
        // Parameters: None
        // Returns: String representation of the range
    	// Passes: No because it returns "Range [2.5, 10.0]" where it should return "Range [-5.0, 10.0]"
    	assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
                "Range[-5.0,10.0]", exampleRange4.toString());
        System.out.println(exampleRange4.toString());
    }
    
    
    // Test case: ToString for a base case range (Equivalence Class: Base case, Boundary Value: base case)
    @Test
    public void toStringBaseCase() {
        // Parameters: None
        // Returns: String representation of the range
    	// Passes: No because it returns "Range [0.0, 1.0]" where it should return "Range [-1.0, 1.0]"
        assertEquals("A String \"Range[lower,upper]\" where lower=lower range and upper=upper range.",
                "Range[-1.0,1.0]", exampleRange5.toString());
        System.out.println(exampleRange5.toString());
    }

    // Clean up resources after each test (not used in this example)
    @After
    public void tearDown() throws Exception {
    }

    // Clean up resources after all tests (not used in this example)
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }	
//-------------------This is where code for ConstrainTest begin--------//


    // Set up the Range object before each test
    @Before
    public void setsUp() throws Exception { 
        exampleRange = new Range(-1, 1);
    }

    // Set up any resources needed before all tests (not used in this example)
    @BeforeClass
    public static void setsUpBeforeClass() throws Exception {
    }

    // Test case: Constrain a value that is within the range (Equivalence Class: Values within the range)
    @Test
    public void constrainInRange() {
        // Parameters: 0 (value to be constrained)
        // Returns: 0 (the constrained value)
        // Passes: Yes
        assertEquals("Constrained value should be 0 for values within the range", 0, exampleRange.constrain(0), 0.0001d);
    }

    // Test case: Constrain a value equal to the upper bound of the range (Equivalence Class: Value equal to upper bound)
    @Test
    public void constrainUpperBound() {
        // Parameters: 1 (value to be constrained)
        // Returns: 1 (the constrained value)
        // Passes: Yes
        assertEquals("Constrained value should be 1 for values equal to the upper bound", 1, exampleRange.constrain(1), 0.0001d);
    }

    // Test case: Constrain a value equal to the lower bound of the range (Equivalence Class: Value equal to lower bound)
    @Test
    public void constrainLowerBound() {
        // Parameters: -1 (value to be constrained)
        // Returns: -1 (the constrained value)
        // Passes: Yes
        assertEquals("Constrained value should be -1 for values equal to the lower bound", -1, exampleRange.constrain(-1), 0.0001d);
    }

    // Test case: Constrain a value that is toward the lower bound of the range (Boundary Value: Value near lower bound)
    @Test
    public void constrainTowardLowerBound() {
        // Parameters: -6544.34 (value to be constrained)
        // Returns: -1 (the correctly constrained value)
        // Passes: No because it returns 0.0 where it should return -1.0
        assertEquals("Constrained value should be -1 for values toward the lower bound", -1, exampleRange.constrain(-6544.34), 0.0001d);
    }

    // Test case: Constrain a value that is toward the upper bound of the range (Boundary Value: Value near upper bound)
    @Test
    public void constrainTowardUpperBound() {
        // Parameters: 6544.34 (value to be constrained)
        // Returns: 1 (the correctly constrained value)
        // Passes: Yes
        assertEquals("Constrained value should be 1 for values toward the upper bound", 1, exampleRange.constrain(6544.34), 0.0001d);
    }
    
//-------This is where code for GetLowerBoundTests begin---------//
    
    /**
     * Test case to verify the correctness of the lower bound for two negative numbers.
     *
     * Test Strategy:
     * This test focuses on equivalence class testing with two negative numbers.
     *
     * Parameters:
     * - Example Range instance initialized with lower and upper bounds both set to -3 and -1.
     * 
     * Returns:
     * - The lower bound value, expecting -3.
     * 
     * Test status: 
     * Passed
     */
	
    @Test
    public void lowerBoundForTwoNegNumbers() {
    	final Range exampleRange = new Range(-3,-1);
    	assertEquals("The lower bound value of -3 and -1 should be -3",
    	-3, exampleRange.getLowerBound(), .000000001d);
    }
    /**
     * Test case to verify the correctness of the lower bound for two positive numbers.
     *
     * Test Strategy:
     * This test focuses on equivalence class testing with two positive numbers.
     *
     * Parameters:
     * - Example Range instance initialized with lower bound set to 1 and upper bound set to 10.
     * 
     * Returns:
     * - The lower bound value, expecting 1.
     * Test status: 
     * Passed
     */
    @Test
    public void lowerBoundForTwoPosNumbers() {
    	final Range exampleRange = new Range(1,10);
    	assertEquals("The lower bound value of 1 and 10 should be 1",
    	1, exampleRange.getLowerBound(), .000000001d);
    }
    /**
     * Test case to verify the correctness of the lower bound for extreme positive numbers.
     *
     * Test Strategy:
     * This test focuses on boundary class testing with an extreme positive number.
     *
     * Parameters:
     * - Example Range instance initialized with lower bound set to 9999999 and upper bound set to positive infinity.
     * 
     * Returns:
     * - The lower bound value, expecting 9999999.
     * 
     * Test status: 
     * Passed
     */
    @Test
    public void lowerBoundForExtremePosNumbers() {
    	final Range exampleRange = new Range(9999999,Double.POSITIVE_INFINITY);
    	assertEquals("The lower bound value of 9999999 and Positive Infinity should be 9999999 ",
    	9999999, exampleRange.getLowerBound(), .000000001d);
    }
    /**
     * Test case to verify the correctness of the lower bound for extreme negative numbers.
     *
     * Test Strategy:
     * This test focuses on boundary class testing with an extreme negative number
     *
     * Parameters:
     * - Example Range instance initialized with lower bound set to negative infinity and upper bound set to 10000000.
     * 
     * Returns:
     * - The lower bound value, expecting negative infinity.
     * 
     * Test status: 
     * Passed
     */
    @Test
    public void lowerBoundForExtremeNegNumbers() {
    	final Range exampleRange = new Range(Double.NEGATIVE_INFINITY,10000000);
    	assertEquals("The lower bound value of Negative Infinity and 10000000 should be Negative Infinity ",
    	Double.NEGATIVE_INFINITY, exampleRange.getLowerBound(), .000000001d);
    }
    
    //This is where invalid range is given to getLowerBound, which is lower>upper
    //should throw illegal argument exception error
    //pass
    @Test(expected = IllegalArgumentException.class)
    public void InvalidRangeForGetLowerBound() {
    	final Range exampleRange = new Range(10000000,Double.NEGATIVE_INFINITY);
    	
    }
    
//---------------------This is where code for combineTest begins--------//
    //Description:combines two null range, should result in null range
    //Expected Result : null
    //Test result: passed 
    @Test
    public void combineNullRange() {
    	Range exampleRange = null;
    	Range exampleRangeTwo = null;
    	assertNull("The combined Range is still null",Range.combine(exampleRange,exampleRangeTwo));
    	
    }
    
    
    //Description:combines one null range and a zero value
    //Expected Result : zero
    //Test result:Passed
    @Test
    public void combineOneNullOneZero() {
    	Range exampleRange = new Range(0.0,0.0);
    	Range exampleRangeTwo = null;
    	Range actual=  Range.combine(exampleRange, exampleRangeTwo);
    	Range expected =new Range(0.0,0.0);
    	assertEquals("The combined Range is 0.0 to 0.0",expected ,actual);
    	
    }
    
    //Description:combines two zeroes
    //Expected Result : zero
    //Test result:Passed
    @Test
    public void combineTwoZero() {
    	Range exampleRange = new Range(0.0,0.0);
    	Range exampleRangeTwo = new Range(0.0,0.0);
    	Range actual=  Range.combine(exampleRange, exampleRangeTwo);
    	Range expected =new Range(0.0,0.0);
    	assertEquals("The combined Range is 0.0",expected ,actual);
    	
    }
    
    //Description:combines two negative Ranges
    //Expected Result : (-90.0 , -1.0)
    //Test result:Passed
    @Test
    public void combineTwoNegatives() {
    	Range exampleRange = new Range(-10.0,-1.0);
    	Range exampleRangeTwo = new Range(-90.0,-10.0);
    	Range actual=  Range.combine(exampleRange, exampleRangeTwo);
    	Range expected =new Range(-90.0,-1.0);
    	assertEquals("The combined Range is -90.0 to -1.0",expected ,actual);
    	
    }
    
    //Description:combines two negative Ranges that overlap 
    //Expected Result : (-300.0,30.0)
    //Test result:Passed
    @Test
    public void combineTwoNegativeRangeThatOverlap() {
    	Range exampleRange = new Range(-100.0,30.0);
    	Range exampleRangeTwo = new Range(-300.0,-50.0);
    	Range actual=  Range.combine(exampleRange, exampleRangeTwo);
    	Range expected =new Range(-300.0,30.0);
    	assertEquals("The combined Range is -300.0 to 30.0",expected ,actual);
    	
    }
    

    //----------This is where test for CombineIgnoringNanTest begins --------//
    
    
    //Description:combines two negative Ranges where one has NAN value  
    //Expected Result : (-200.0,-50.0)
    //Test result:Passed
    @Test
    public void combineTwoNegativeRangeWithOneNan() {
    	double nanExample = 0.0 / 0.0;
    	Range exampleRange = new Range(-100.0,nanExample);
    	Range exampleRangeTwo = new Range(-200.0,-50.0);
    	Range actual=  Range.combineIgnoringNaN(exampleRange, exampleRangeTwo);
    	Range expected =new Range(-200.0,-50.0);
    	assertEquals("The combined Range is -200.0 to -50.0",expected ,actual);
    	
    }
    
    //Description:combines two negative Ranges where both Ranges has NAN value  
    //Expected Result : (-100.0,-50.0)
    //Test result:Passed
    @Test
    public void combineWithTwoNan() {
    	double nanExample = 0.0 / 0.0;
    	double nanExampleTwo = Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY;
    	Range exampleRange = new Range(nanExample,nanExample);
    	Range exampleRangeTwo = new Range(nanExampleTwo,nanExampleTwo);
    	Range actual=  Range.combineIgnoringNaN(exampleRange, exampleRangeTwo);
    	Range expected =null;
    	assertEquals("The combined Range is null as isNaN(l) and isNaN(u) evaluates to true returning null",expected ,actual);
    	
    }
    
    //Description:combines two negative Ranges where there is no Nan value
    //Expected Result : (-200.0,0.0)
    //Test result:Passed
    @Test
    public void combineTwoNegativeRangeWithNoNan() {
    	
    	Range exampleRange = new Range(-100.0,0.0);
    	Range exampleRangeTwo = new Range(-200.0,-50.0);
    	Range actual=  Range.combineIgnoringNaN(exampleRange, exampleRangeTwo);
    	Range expected =new Range(-200.0,0.0);
    	assertEquals("The combined Range is -200.0 to 0.0",expected ,actual);
    	
    }
    
    //Description:combines one null Range and one NaN
    //Expected Result : Passed
    //Test result:Passed
    @Test
    public void combineOneNullOneNan() {
    	
    	Range exampleRange = null;
    	Range exampleRangeTwo = new Range(Double.NaN,Double.NaN);
    	Range actual=  Range.combineIgnoringNaN(exampleRange, exampleRangeTwo);
    	Range expected =null;
    	assertEquals("Expect null due to first if condition",expected ,actual);
    	
    }
    
    //Description:combines one null Range and one not NaN
    //Expected Result : Passed
    //Test result:Passed
    @Test
    public void combineOneNullOneNotNan() {
    	
    	Range exampleRange = null;
    	Range exampleRangeTwo = new Range(-200.0,0.0);
    	Range actual=  Range.combineIgnoringNaN(exampleRange, exampleRangeTwo);
    	Range expected =new Range(-200.0,0.0);
    	assertEquals("Expects exampleRangeTwo to be returned",expected ,actual);
    	
    }
    //Description:combines one NaN Range and one Null Range
    //Expected Result : Passed
    //Test result:Passed
    @Test
    public void combineOneNanFirstOneNull() {
    	
    	Range exampleRange = new Range(Double.NaN,Double.NaN);
    	Range exampleRangeTwo = null;
    	Range actual=  Range.combineIgnoringNaN(exampleRange, exampleRangeTwo);
    	Range expected =null;
    	assertEquals("Expect null due to range2==null && range1.isNaNRange() if condition",expected ,actual);
    	
    }
    
    //Description:combines one not NaN Range and one Null Range
    //Expected Result : Passed
    //Test result:Passed
    @Test
    public void combineOneNanFirstOneNotNull() {
    	
    	Range exampleRange = new Range(-200.0,0.0);
    	Range exampleRangeTwo = null;
    	Range actual=  Range.combineIgnoringNaN(exampleRange, exampleRangeTwo);
    	Range expected =new Range(-200.0,0.0);
    	assertEquals("Expect exampleRange to be returned",expected ,actual);
    	
    }
    
    
    //-------This is where code for equals test begin -----//
    
    
    //Description:checking if equals differentiate null and Range object
    //Expected Result : False
    //Test result:Passed
    @Test
    public void isNotNull() {
    	
    	Range exampleRange = new Range(-100,100);
    	assertFalse("exampleRange should not be null",exampleRange.equals(null));
    	
    }
    
    //Description:checking if equals work on two Range objects
    //Expected Result : True
    //Test result:Passed
    @Test
    public void isEqual() {
    	
    	Range exampleRange = new Range(-100,100);
    	Range exampleRangeTwo = new Range(-100,100);
    	assertTrue("two Range objects have same range",exampleRange.equals(exampleRangeTwo));
    	
    }
    
    //Description:checking if equals fail on two Range objects with two different Range
    //Expected Result : False
    //Test result:Passed
    @Test
    public void isDifferent() {
    	
    	Range exampleRange = new Range(-100,100);
    	Range exampleRangeTwo = new Range(2000,10000);
    	assertFalse("two Range objects have different range",exampleRange.equals(exampleRangeTwo));
    	
    }
    
    //Description:checking if equals fail on two Range objects with same lowerBound and differentUpperbounds
    //Expected Result : False
    //Test result:Passed
    @Test
    public void isDifferentUpperBound() {
    	
    	Range exampleRange = new Range(-100,100);
    	Range exampleRangeTwo = new Range(-100,10000);
    	assertFalse("two Range objects have different range",exampleRange.equals(exampleRangeTwo));
    	
    }
    
    //Description:checking if equals fail on two Range objects with same upper-bound and differentLowerbounds
    //Expected Result : False
    //Test result:Passed
    @Test
    public void isDifferentLowerBound() {
    	
    	Range exampleRange = new Range(-400,10000);
    	Range exampleRangeTwo = new Range(-100,10000);
    	assertFalse("two Range objects have different range",exampleRange.equals(exampleRangeTwo));
    	
    }
    
    //----------This is where code for expand begins ---------------//
    
    //Description: checking if Expand throws illegalArgumentException on Null parameter as it says its not permitted
    //Expected Result: throws illegalArgumentException
    //test result: passed
    
    @Test(expected = IllegalArgumentException.class)
    public void testExpandWithNullRange() {
        Range.expand(null, 15.0, 90.0);
    }
    
    //Description: checking if Expand works on negative numbers on both margins
    //Expected Result: expand shrinks the range to 0,0
    //test result: passed
    @Test
    public void testExpandWithNegatives() {
        Range exampleRange = new Range (-100.0,100.0);
        Range exampleRangeTwo = Range.expand(exampleRange, -0.5, -0.5);
        assertEquals("the exampleRangeTwo should be 0.0,0.0",new Range(0.0,0.0),exampleRangeTwo);
    }
    
    //Description: checking if Expand works on positive numbers on both margins
    //Expected Result: expands the range to -200,200
    //test result: passed
    @Test
    public void testExpandWithPositives() {
        Range exampleRange = new Range (-100.0,100.0);
        Range exampleRangeTwo = Range.expand(exampleRange, 0.5, 0.5);
        assertEquals("the exampleRangeTwo should be -200.0,200.0",new Range(-200.0,200.0),exampleRangeTwo);
    }
    
    
  
    //Description: checking if Expand works on zero
    //Expected Result: expand does not affect the range
    //test result: passed
    @Test
    public void testExpandWithZeroes() {
        Range exampleRange = new Range (-100.0,100.0);
        Range exampleRangeTwo = Range.expand(exampleRange, 0.0, 0.0);
        assertEquals("the exampleRangeTwo should be -100.0,100.0",new Range(-100.0,100.0),exampleRangeTwo);
    }
    

    
    
    
    //-----------This is where code for expandToInclude test begins-------//
    
    //Description: checking if ExpandtoInclude creates a range accepting zero when null Range is passed as a parameter
    //Expected Result: range(0,0)
    //test result: passed
    @Test
    public void testExpandToIncludeWithNull() {
        Range exampleRange = Range.expandToInclude(null, 0.0);
        assertEquals("the exampleRangeTwo should be 0.0,0.0",new Range(0.0,0.0),exampleRange);
    }
    
    //Description: checking if ExpandtoInclude creates a new range when value is below the lower bound 
    //Expected Result: range(-200,100)
    //test result: passed
    @Test
    public void testExpandToIncludeWithValueBelowLowerBound() {
        Range exampleRange = new Range(-100.0,100.0);
        Range exampleRangeTwo = Range.expandToInclude(exampleRange, -200.0);
        assertEquals("the exampleRangeTwo should be -200.0,100.0",new Range(-200.0,100.0),exampleRangeTwo);
    }
    
    //Description: checking if ExpandtoInclude creates a new range when value is above the upper bound 
    //Expected Result: range(-100,200)
    //test result: passed
    @Test
    public void testExpandToIncludeWithValueAboveUpperBound() {
        Range exampleRange = new Range(-100.0,100.0);
        Range exampleRangeTwo = Range.expandToInclude(exampleRange, 200.0);
        assertEquals("the exampleRangeTwo should be -100.0,200.0",new Range(-100.0,200.0),exampleRangeTwo);
    }
    
    //Description: checking if ExpandtoInclude contains the value already in the range, it does not create a new range 
    //Expected Result: range(-100,100)
    //test result: passed
    @Test
    public void testExpandToIncludeWithValueWithinRange() {
        Range exampleRange = new Range(-100.0,100.0);
        Range exampleRangeTwo = Range.expandToInclude(exampleRange, 0.0);
        assertEquals("the exampleRangeTwo should be -100.0,100.0",new Range(-100.0,100.0),exampleRangeTwo);
    }
    
    //-----This is where code for getCentralValue test begins -------//
    
    
    //Description: checking if getCentralValue returns central value of the given range   
    //Expected Result: 0.0
    //test result: passed
    @Test
    public void getCentralValueOfGivenRange() {
        Range exampleRange = new Range(-100.0,100.0);
        double centralVal = exampleRange.getCentralValue();
        assertEquals("the central value should be 0.0",0.0,centralVal,0.0000001d);
    }
    
    //Description: checking if getCentralValue returns central value of the given range that has same lower and upper bounds   
    //Expected Result: 0.0
    //test result: passed
    @Test
    public void getCentralValueOfSameLowerAndUpperBounds() {
        Range exampleRange = new Range(0.0,0.0);
        double centralVal = exampleRange.getCentralValue();
        assertEquals("the central value should be 0.0",0.0,centralVal,0.0000001d);
    }
    
    
    
    //-----This is where code for getUpperBound test begins -------//
    
    
    
    //Description: checking if getUpperBound returns the upper bound correctly in a Range that has same lower and upper bounds
    //Expected Result: 0.0
    //test result: passed
    @Test
    public void getUpperBoundOfZeroLowerAndUpperBounds() {
        Range exampleRange = new Range(0.0,0.0);
        double upperBound = exampleRange.getUpperBound();
        assertEquals("the upperbound should be 0.0",0.0,upperBound,0.0000001d);
    }
    
    
    //Description: checking if getUpperBound returns the upper bound correctly in a Range that has both negative lower and upper bounds 
    //Expected Result: -1.0
    //test result: passed
    @Test
    public void getUpperBoundOfNegativeBounds() {
        Range exampleRange = new Range(-100.0,-1.0);
        double upperBound = exampleRange.getUpperBound();
        assertEquals("the upperbound should be -1.0",-1.0,upperBound,0.0000001d);
    }
    
    //Description: checking if getUpperBound returns the upper bound correctly in a Range that has both negative lower and positive upper bounds 
    //Expected Result: 100.0
    //test result: passed
    @Test
    public void getUpperBoundOfOneNegativeOnePositiveBounds() {
        Range exampleRange = new Range(-100.0,100.0);
        double upperBound = exampleRange.getUpperBound();
        assertEquals("the upperbound should be 100.0",100.0,upperBound,0.0000001d);
    }
    
    //Description: checking if getUpperBound returns the upper bound correctly in a Range that has both positive lower and positive upper bounds 
    //Expected Result: 200.0
    //test result: passed
    @Test
    public void getUpperBoundOfPositiveBounds() {
        Range exampleRange = new Range(100.0,200.0);
        double upperBound = exampleRange.getUpperBound();
        assertEquals("the upperbound should be 200.0",200.0,upperBound,0.0000001d);
    }
    
    //-------------This is where code for hash code test begins ------------//
    
    //Description: checking if provided hash code is consistent
    //Expected Result: passes 
    //test result: passed
    @Test
    public void checkConsistentHashCode() {
        int expectedHashCode = new Range(100.0,200.0).hashCode();
        int nextHashCode = new Range(100.0,200.0).hashCode();       
        assertEquals("the Hash code should remain consistent",expectedHashCode,nextHashCode);
    }
    
    //---------This is where code for test intersects(Range) test begin  ---// 
  
    
    //Description: checking if intersects return false when there is no overlap
    //Expected Result: false
    //test result: passed
    @Test
    public void intersectsNoOverlap() {
        Range exampleRange = new Range(100.0,200.0);
        Range exampleRangeTwo = new Range(0.0,0.0);
        boolean intersects = exampleRange.intersects(exampleRangeTwo);
        assertEquals("there is no intersection",false,intersects);
    }
    
    //Description: checking if intersects return false when there is overlap
    //Expected Result: True 
    //test result: passed
    @Test
    public void intersectsOverlap() {
        Range exampleRange = new Range(100.0,200.0);
        Range exampleRangeTwo = new Range(100.0,150.0);
        boolean intersects = exampleRange.intersects(exampleRangeTwo);
        assertEquals("there is  intersection",true,intersects);
    }
    
    //Description: checking if intersects return false when there is overlap on the edges
    //Expected Result: False
    //test result: passed
    @Test
    public void intersectsOverlapOnEdges() {
        Range exampleRange = new Range(100.0,200.0);
        Range exampleRangeTwo = new Range(200.0,250.0);
        boolean intersects = exampleRange.intersects(exampleRangeTwo);
        assertEquals("there is no intersection",false,intersects);
    }
    
    //Description: checking if intersects return true when there is overlap partially on each edge 
    //Expected Result: true
    //test result: passed
    @Test
    public void intersectsOverlapPartially() {
        Range exampleRange = new Range(50.0,130.0);
        Range exampleRangeTwo = new Range(100.0,200.0);
        boolean intersects = exampleRange.intersects(exampleRangeTwo);
        assertEquals("there is no intersection",true,intersects);
    }
    
    
    //----------This is where code for intersects(double b0, double b1) test begins -------------------//
    
    
    
    //Description: checking if intersects return true when there is overlap on the range given in intersects
    //Expected Result: true
    //test result: passed
    @Test
    public void intersectsOverlapBtwnTwoDouble() {
        Range exampleRange = new Range(50.0,130.0);
        boolean intersects = exampleRange.intersects(0.0,200.0);
        assertEquals("exampleRange is within intersectsRange ",true,intersects);
    }
    
    //Description: checking if intersects return false when there is no overlap on the range given in intersects
    //Expected Result: false
    //test result: passed
    @Test
    public void intersectsOverlapBtwnTwoDoubleNotRange() {
        Range exampleRange = new Range(50.0,130.0);
        boolean intersects = exampleRange.intersects(0.0,49.0);
        assertEquals("exampleRange has no intersect with 0.0-49.0 ",false,intersects);
    }
    
    

   
    
    //------------This is where code for isNaNRange test begins -----------------//
    
    
    //Description: checking when isNaNRange return false when only the lower is Double.NaN 
    //Expected Result: false
    //test result: Passed
    @Test
    public void isNaNOnLowerBound() {
        Range exampleRange = new Range(Double.NaN,0.0);
        boolean isNaN = exampleRange.isNaNRange();
        assertEquals("is NaN should be false ",false,isNaN);
    }
    
    //Description: checking when isNaNRange return true when both bounds are Double.NaN 
    //Expected Result: True
    //test result: Passed
    @Test
    public void isNaNOnBothBound() {
        Range exampleRange = new Range(Double.NaN,Double.NaN);
        boolean isNaN = exampleRange.isNaNRange();
        assertEquals("is NaN should be true ",true,isNaN);
    }
    
    //Description: checking when isNaNRange return false when only the upperbound is Double.NaN 
    //Expected Result: false
    //test result: Passed
    @Test
    public void isNaNOnUpperBound() {
        Range exampleRange = new Range(0.0,Double.NaN);
        boolean isNaN = exampleRange.isNaNRange();
        assertEquals("is NaN should be false ",false,isNaN);
    }
    
    
    //-------------This is where code for scale test begins ---------//
    
    //Description: checking when scale returns illegalargumentException when a null range is sent in as a parameter  
    //Expected Result: IllegalArgumentException thrown
    //test result: Passed
    @Test(expected=IllegalArgumentException.class)
    public void scaleNotNullPermitted() {
        Range exampleRange = null;
        Range.scale(exampleRange, 1.0);
    }
    
    //Description: checking when scale returns illegalargumentException when a negative scaling factor sent in as a parameter  
    //Expected Result: IllegalArgumentException thrown
    //test result: Passed
    @Test(expected=IllegalArgumentException.class)
    public void scaleNegativeFactorNotPermitted() {
        Range exampleRange = new Range(100.0,200.0);
        Range.scale(exampleRange, -1.0);
    }
    
    //Description: checking scale functions properly below 1  
    //Expected Result: Range(-90.0,90.0)
    //test result: Passed
    @Test
    public void scaleBelowOne() {
        Range exampleRange = new Range(-100.0,100.0);
        Range exampleTwo = Range.scale(exampleRange,0.9);
        assertEquals("exampleTwo should be -90.0 ~ 90.0 ",new Range(-90.0,90.0),exampleTwo);
    }
    
    //Description: checking scale functions properly above 1  
    //Expected Result: Range(-110.0,110.0)
    //test result: fails, gets -110.00000000000001 ,110.0000000000000001
    @Test
    public void scaleAboveOne() {
        Range exampleRange = new Range(-100.0,100.0);
        Range exampleTwo = Range.scale(exampleRange,1.1);
        
        double expectedLowerBound = -110.0;
        double expectedUpperBound = 110.0;
        
        double tolerance = 0.0001;
        
        assertEquals("Lower bound should be -110.0", expectedLowerBound, exampleTwo.getLowerBound(), tolerance);
        assertEquals("Upper bound should be 110.0", expectedUpperBound, exampleTwo.getUpperBound(), tolerance);
    }
    
  //-------------This is where code for shift(range base, double delta) test begins ---------//
  
    
    
    
    //Description: checking when shift returns illegalargumentException when range base is null
    //Expected Result: IllegalArgumentException thrown
    //test result: Passed
    @Test(expected=IllegalArgumentException.class)
    public void shiftWithNullRange() {
        Range exampleRange = null;
        Range.shift(exampleRange, -1.0);
    }
    
    
    //Description: checking when shifts zero has no effect on the current range 
    //Expected Result: Range(-100.0,100.0)
    //test result: Passed
    @Test
    public void shiftWithZeroDelta() {
        Range exampleRange = new Range(-100.0,100.0);
        Range exampleTwo = Range.shift(exampleRange, 0.0);
        assertEquals("exampleTwo should be the same ",new Range(-100.0,100.0),exampleTwo);
    }
    
    //Description: checking when shifts to negative side given a negative shift amount
    //Expected Result: Range(-100.0,100.0)
    //test result: Passed
    @Test
    public void shiftWithNegativeDelta() {
        Range exampleRange = new Range(-96.0,104.0);
        Range exampleTwo = Range.shift(exampleRange, -4.0);
        assertEquals("exampleTwo should be the same ",new Range(-100.0,100.0),exampleTwo);
    }
    
    //Description: checking when shifts to positive side given a positive shift amount
    //Expected Result: Range(-100.0,100.0)
    //test result: Passed
    @Test
    public void shiftWithPositiveDelta() {
        Range exampleRange = new Range(-104.0,96.0);
        Range exampleTwo = Range.shift(exampleRange, 4.0);
        assertEquals("exampleTwo should be the same ",new Range(-100.0,100.0),exampleTwo);
    }
    
    //-----------This is where code for shift(Range base,double delta, boolean allow ZeroCrossing test begins -------//
    
    

    //Description: checking when shift returns illegalargumentException when range base is null
    //Expected Result: IllegalArgumentException thrown
    //test result: Passed
    @Test(expected=IllegalArgumentException.class)
    public void shiftWithNullRangeWithZeroCrossingTrue() {
        Range exampleRange = null;
        Range.shift(exampleRange, -1.0,true);
    }
    
    //Description: checking when shift does not limit the bounds when allowzerocrossing is true 
    //Expected Result: Passes
    //test result: Passed
    @Test
    public void shiftWithZeroCrossingTrue() {
        Range exampleRange = new Range(-3.0,3.0);
        Range exampleRangeTwo = Range.shift(exampleRange, 100.0,true);
        assertEquals("exampleTwo should now have the range 97.0 to 103.0",new Range(97.0,103.0),exampleRangeTwo);
    }
    
    //Description: checking when shift does limit the upper bound when allowzerocrossing is false 
    //Expected Result: Passes
    //test result: Passed
    @Test
    public void shiftWithZeroCrossingFalseUpperBound() {
        Range exampleRange = new Range(-100.0,-3.0);
        Range exampleRangeTwo = Range.shift(exampleRange, 50.0,false);
        assertEquals("exampleTwo should now have the range -50.0  to 0.0",new Range(-50.0,0.0),exampleRangeTwo);
    }
    
    //Description: checking when shift does limit the lower bound when allowzerocrossing is false 
    //Expected Result: Passes
    //test result: Passed
    @Test
    public void shiftWithZeroCrossingFalseLowerBound() {
        Range exampleRange = new Range(3.0,100.0);
        Range exampleRangeTwo = Range.shift(exampleRange,-50.0,false);
        assertEquals("exampleTwo should now have the range 0.0  to 50.0",new Range(0.0,50.0),exampleRangeTwo);
    }
    
    //Description: checking when shift does limit borh bounds when allowzerocrossing is false 
    //Expected Result: Passes
    //test result: Passed
    @Test
    public void shiftWithZeroCrossingFalseBothBound() {
        Range exampleRange = new Range(3.0,100.0);
        Range exampleRangeTwo = Range.shift(exampleRange,-1000.0,false);
        assertEquals("exampleTwo should now have the range 0.0  to 0.0",new Range(0.0,0.0),exampleRangeTwo);
    }
    

    
    
    	/////////////// --------------------------------------- /////////////////
	
    	//      ADDITION OF NEW TEST CASES TO INCREASE MUTATION COVERAGE       //

    	/////////////// --------------------------------------- /////////////////
    
    
    

	@Test
	public void testBothBoundsNegative() {
	    Range range = new Range(-5, -1);
	    assertEquals(-3.0, range.getCentralValue(), 0.001);
	}
	
	@Test
	public void testBothBoundsPositive() {
	    Range range = new Range(1, 5);
	    assertEquals(3.0, range.getCentralValue(), 0.001);
	}
	
	@Test
	public void testOneBoundZero() {
	    Range range1 = new Range(-5, 0);
	    assertEquals(-2.5, range1.getCentralValue(), 0.001);
	    
	    Range range2 = new Range(0, 5);
	    assertEquals(2.5, range2.getCentralValue(), 0.001);
	}
	
	@Test
	public void testBothBoundsZero() {
	    Range range = new Range(0, 0);
	    assertEquals(0.0, range.getCentralValue(), 0.001);
	}
	
	// Test when both ranges are null
    @Test
    public void testCombine_BothRangesNull() {
        assertNull(Range.combine(null, null));
    }
    
    // Test when range1 is null and range2 is not null
    @Test
    public void testCombine_Range1Null_Range2NotNull() {
        Range range2 = new Range(1, 5);
        assertEquals(range2, Range.combine(null, range2));
    }
    
    // Test when range1 is not null and range2 is null
    @Test
    public void testCombine_Range1NotNull_Range2Null() {
        Range range1 = new Range(1, 5);
        assertEquals(range1, Range.combine(range1, null));
    }
    
    // Test when both ranges are not null
    @Test
    public void testCombine_BothRangesNotNull() {
        Range range1 = new Range(1, 3);
        Range range2 = new Range(4, 5);
        Range expected = new Range(1, 5);
        assertEquals(expected, Range.combine(range1, range2));
    }
    
 // Test hashCode method with different range values
    @Test
    public void testHashCode_DifferentRanges() {
        Range range1 = new Range(1, 5);
        Range range2 = new Range(1, 5);
        Range range3 = new Range(0, 4);
        
        assertEquals(range1.hashCode(), range2.hashCode()); // Equal ranges should have equal hash codes
        assertEquals(false, range1.hashCode() == range3.hashCode()); // Different ranges should have different hash codes
    }
    
    
    
    
    ////////////////////////////////////////////////////
    
    
    // CHANGED SOURCE CODE FOR THE FOLLOWING TESTS
    
    // CHANGED THE VISIBILITY OF MIN AND MAX TO PUBLIC
    
    ////////////////////////////////////////////////////
    
    @Test
    public void testMin_BothNaN() {
        assertEquals(Double.NaN, Range.min(Double.NaN, Double.NaN), 0.001);
    }
    
    @Test
    public void testMin_FirstNaN() {
        assertEquals(5.0, Range.min(Double.NaN, 5.0), 0.001);
    }
    
    @Test
    public void testMin_SecondNaN() {
        assertEquals(-3.0, Range.min(-3.0, Double.NaN), 0.001);
    }
    
    @Test
    public void testMin_NeitherNaN_FirstSmaller() {
        assertEquals(-3.0, Range.min(-3.0, 5.0), 0.001);
    }
    
    @Test
    public void testMin_NeitherNaN_SecondSmaller() {
        assertEquals(-3.0, Range.min(5.0, -3.0), 0.001);
    }
    
    @Test
    public void testMin_NeitherNaN_Equal() {
        assertEquals(5.0, Range.min(5.0, 5.0), 0.001);
    }
    
    @Test
    public void testMax_BothNaN() {
        assertEquals(Double.NaN, Range.max(Double.NaN, Double.NaN), 0.001);
    }
    
    @Test
    public void testMax_FirstNaN() {
        assertEquals(5.0, Range.max(Double.NaN, 5.0), 0.001);
    }
    
    @Test
    public void testMax_SecondNaN() {
        assertEquals(5.0, Range.max(5.0, Double.NaN), 0.001);
    }
    
    @Test
    public void testMax_NeitherNaN_FirstSmaller() {
        assertEquals(5.0, Range.max(-3.0, 5.0), 0.001);
    }
    
    @Test
    public void testMax_NeitherNaN_SecondSmaller() {
        assertEquals(5.0, Range.max(5.0, -3.0), 0.001);
    }
    
    @Test
    public void testMax_NeitherNaN_Equal() {
        assertEquals(5.0, Range.max(5.0, 5.0), 0.001);
    }
    
    
////////////////////////////////////////////////////
    
    
// CHANGED SOURCE CODE FOR THE FOLLOWING TESTS

// CHANGED THE VISIBILITY OF shiftWithNoZeroCrossing TO PUBLIC

////////////////////////////////////////////////////
    
    
    @Test
    public void testShiftWithNoZeroCrossing_PositiveValue_PositiveDelta() {
        assertEquals(5.0, Range.shiftWithNoZeroCrossing(3.0, 2.0), 0.001);
    }
    
    @Test
    public void testShiftWithNoZeroCrossing_PositiveValue_NegativeDelta() {
        assertEquals(1.0, Range.shiftWithNoZeroCrossing(3.0, -2.0), 0.001);
    }
    
    @Test
    public void testShiftWithNoZeroCrossing_PositiveValue_ZeroDelta() {
        assertEquals(3.0, Range.shiftWithNoZeroCrossing(3.0, 0.0), 0.001);
    }
    
    @Test
    public void testShiftWithNoZeroCrossing_NegativeValue_PositiveDelta() {
        assertEquals(-5.0, Range.shiftWithNoZeroCrossing(-3.0, -2.0), 0.001);
    }
    
    @Test
    public void testShiftWithNoZeroCrossing_NegativeValue_NegativeDelta() {
        assertEquals(-1.0, Range.shiftWithNoZeroCrossing(-3.0, 2.0), 0.001);
    }
    
    @Test
    public void testShiftWithNoZeroCrossing_NegativeValue_ZeroDelta() {
        assertEquals(-3.0, Range.shiftWithNoZeroCrossing(-3.0, 0.0), 0.001);
    }
    
    @Test
    public void testShiftWithNoZeroCrossing_ZeroValue_PositiveDelta() {
        assertEquals(2.0, Range.shiftWithNoZeroCrossing(0.0, 2.0), 0.001);
    }
    
    @Test
    public void testShiftWithNoZeroCrossing_ZeroValue_NegativeDelta() {
        assertEquals(-2.0, Range.shiftWithNoZeroCrossing(0.0, -2.0), 0.001);
    }
    
    @Test
    public void testShiftWithNoZeroCrossing_ZeroValue_ZeroDelta() {
        assertEquals(0.0, Range.shiftWithNoZeroCrossing(0.0, 0.0), 0.001);
    }
    
}
