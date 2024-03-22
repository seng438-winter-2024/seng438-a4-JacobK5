package org.jfree.data.test;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import org.junit.*; 
import org.jmock.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;

public class DataUtilitiesTest extends DataUtilities {
//	
	//DataUtilities calculateColumnTotal tests
	
	@Test
    public void testSingleValueColumnTotal() {
        Mockery mocked = new Mockery();
        final Values2D values = mocked.mock(Values2D.class);
        mocked.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(1));
                one(values).getValue(0, 0);
                will(returnValue(3));

            }
        });
        assertEquals(DataUtilities.calculateColumnTotal(values, 0), 3, .000000001d);
    }

    @Test
    public void testDoubleValueColumnTotal() {
        Mockery mocked = new Mockery();
        final Values2D values = mocked.mock(Values2D.class);
        mocked.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(2));
            }
        });
        assertEquals(DataUtilities.calculateColumnTotal(values, 0), 5, .000000001d);
    }

    @Test
    public void testMultipleValueColumnTotal() {
        Mockery mocked = new Mockery();
        final Values2D values = mocked.mock(Values2D.class);
        mocked.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(4));
                one(values).getValue(0, 0);
                will(returnValue(3));
                one(values).getValue(1, 0);
                will(returnValue(2));
                one(values).getValue(2, 0);
                will(returnValue(3));
                one(values).getValue(3, 0);
                will(returnValue(2));
            }
        });
        assertEquals(DataUtilities.calculateColumnTotal(values, 0), 10, .000000001d);
    }

    @Test
    public void testEmptyColumnTotal() {
        Mockery mocked = new Mockery();
        final Values2D values = mocked.mock(Values2D.class);
        mocked.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(0));
            }
        });
        assertEquals(DataUtilities.calculateColumnTotal(values, 0), 0, .000000001d);
    }
	 
    private static Values2D values;

    @BeforeClass
    public static void setUpCustomMatrix() throws Exception {
        Mockery mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getRowCount();
                will(returnValue(4));
                allowing(values).getColumnCount();
                will(returnValue(4));

                one(values).getValue(0, 0);
                will(returnValue(2.5));
                one(values).getValue(0, 1);
                will(returnValue(3.5));
                one(values).getValue(0, 2);
                will(returnValue(5.5));
                one(values).getValue(0, 3);
                will(returnValue(4.5));

                one(values).getValue(1, 0);
                will(returnValue(6.5));
                one(values).getValue(1, 1);
                will(returnValue(2.5));
                one(values).getValue(1, 2);
                will(returnValue(3.5));
                one(values).getValue(1, 3);
                will(returnValue(4.5));

                one(values).getValue(2, 0);
                will(returnValue(7.5));
                one(values).getValue(2, 1);
                will(returnValue(3.5));
                one(values).getValue(2, 2);
                will(returnValue(1.5));
                one(values).getValue(2, 3);
                will(returnValue(2.5));

                one(values).getValue(3, 0);
                will(returnValue(8.5));
                one(values).getValue(3, 1);
                will(returnValue(4.5));
                one(values).getValue(3, 2);
                will(returnValue(5.5));
                one(values).getValue(3, 3);
                will(returnValue(3.5));
            }
        });
    }

    @Test
    public void calculateRowTotal_RowWithinBounds() {
        double result = DataUtilities.calculateRowTotal(values, 2);
        assertEquals("Total for Row 2 is", 15.0, result, .000000001d);
    }

    @Test
    public void calculateRowTotal_BoundaryRow() {
        double result = DataUtilities.calculateRowTotal(values, 3);
        assertEquals("Total for Row 3 is", 22.0, result, .000000001d);
    }



    @Test(expected = IllegalArgumentException.class)
    public void calculateRowTotal_NullArgument() {
        DataUtilities.calculateRowTotal(null, 1);
    }
	    
	
    private double[] exampleDoubleArray;
    private double[][] exampleDoubleArray2D;

    @Test
    public void testNumberArrayCreation_NonNullArray() {
        exampleDoubleArray = new double[] {1.5, -2.0, -3.2, -4.8, 5.4};
        Number[] actualNumberArray = DataUtilities.createNumberArray(exampleDoubleArray);
        assertNotNull("Ensure non-null array creation", actualNumberArray);
    }
    
    @Test
    public void testNumberArrayCreation_PositiveNumbers() {
        exampleDoubleArray = new double[] {1.1, 2.2, 3.3, 4.4, 5.5};
        Number[] expectedNumberArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Number[] actualNumberArray = DataUtilities.createNumberArray(exampleDoubleArray);
        assertArrayEquals("Array with positive numbers", expectedNumberArray, actualNumberArray);
    }
    
    @Test
    public void testNumberArrayCreation_NegativeNumbers() {
        exampleDoubleArray = new double[] {-1.0, -2.0, -3.0, -4.0, -5.0};
        Number[] expectedNumberArray = {-1.0, -2.0, -3.0, -4.0, -5.0};
        Number[] actualNumberArray = DataUtilities.createNumberArray(exampleDoubleArray);
        assertArrayEquals("Array with negative numbers", expectedNumberArray, actualNumberArray);
    }
    


    @Test
    public void testNumberArrayCreation_WithZeros() {
        exampleDoubleArray = new double[] {0.0, 0.0, 0.0, 0.0};
        Number[] expectedNumberArray = {0.0, 0.0, 0.0, 0.0};
        Number[] actualNumberArray = DataUtilities.createNumberArray(exampleDoubleArray);
        assertArrayEquals("Array with zeros", expectedNumberArray, actualNumberArray);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNumberArrayCreation_NullArray() throws IllegalArgumentException {
        DataUtilities.createNumberArray(null);
    }
    
    @Test 
    public void testNumberArrayCreation_EmptyArray() {
        exampleDoubleArray = new double[] {};
        Number[] expectedNumberArray = {};
        Number[] actualNumberArray = DataUtilities.createNumberArray(exampleDoubleArray);
        assertArrayEquals("Empty array creation", expectedNumberArray, actualNumberArray);
    }
	    
	    
	    
	//TESTING createNumberArray2D()
	   
    
    @Test
    public void testNumberArray2DCreation_PositiveNumbers() {
        exampleDoubleArray2D = new double[][] {{1.2, 2.3, 3.4, 4.5, 5.6},{1.3, 3.2, 9.1}};
        Number[][] expectedNumberArray2D = {{1.2, 2.3, 3.4, 4.5, 5.6},{1.3, 3.2, 9.1}};
        Number[][] actualNumberArray2D = DataUtilities.createNumberArray2D(exampleDoubleArray2D);
        assertArrayEquals("2D array with positive numbers", expectedNumberArray2D, actualNumberArray2D);
    }
    
    @Test
    public void testNumberArray2DCreation_NegativeNumbers() {
        exampleDoubleArray2D = new double[][] {{-1.1, -2.2, -3.3, -4.4, -5.5},{-1.3, -3.2, -9.1}};
        Number[][] expectedNumberArray2D = {{-1.1, -2.2, -3.3, -4.4, -5.5},{-1.3, -3.2, -9.1}};
        Number[][] actualNumberArray2D = DataUtilities.createNumberArray2D(exampleDoubleArray2D);
        assertArrayEquals("2D array with negative numbers", expectedNumberArray2D, actualNumberArray2D);
    }
    


    @Test
    public void testNumberArray2DCreation_WithZeros() {
        exampleDoubleArray2D = new double[][] {{0.0, 0.0, 0.0, 0.0}, {0.0, 0.0}};
        Number[][] expectedNumberArray2D = {{0.0, 0.0, 0.0, 0.0}, {0.0, 0.0}};
        Number[][] actualNumberArray2D = DataUtilities.createNumberArray2D(exampleDoubleArray2D);
        assertArrayEquals("2D array with zeros", expectedNumberArray2D, actualNumberArray2D);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNumberArray2DCreation_NullArray() throws IllegalArgumentException {
        DataUtilities.createNumberArray2D(null);
    }
    
    @Test 
    public void testNumberArray2DCreation_EmptyArray() {
        exampleDoubleArray2D = new double[][] {{}, {}};
        Number[][] expectedNumberArray2D = {{}, {}};
        Number[][] actualNumberArray2D = DataUtilities.createNumberArray2D(exampleDoubleArray2D);
        assertArrayEquals("Empty 2D array creation", expectedNumberArray2D, actualNumberArray2D);
    }
	
	
//DataUtilities getCumulativePercentage test
	
    @Test
	public void getCumulativePercentagesForFirstValue() {
		/**
	     * Test case to verify the correctness of the cumulative percentage calculation for the first value.
	     * This test focuses on testing equivalence classes
	     * Parameters:
		 *
	     * 5,9 and 2 are the values passed
	     * 
	     * Returns:
	     * The cumulative percentage value for the first key-value pair, 
	     * expecting 0.3125
	     * 
	     * Test Status:
	     * Failed. Returns 0.4545 instead of 0.3125
	     */
		Mockery keyedValuesMock = new Mockery();
		//Mock KeyValues instance
		final KeyedValues data = keyedValuesMock.mock(KeyedValues.class);
		
		keyedValuesMock.checking(new Expectations() {{
			atLeast(1).of(data).getItemCount();
			will(returnValue((3)));
			
			allowing(data).getValue(0);
			will(returnValue(5));
			allowing(data).getValue(1);
			will(returnValue(9));
			allowing(data).getValue(2);
			will(returnValue(2));
			
			allowing(data).getKey(0);
			will(returnValue(0));
			allowing(data).getKey(1);
			will(returnValue(1));
			allowing(data).getKey(2);
			will(returnValue(2));
			
		}});
		//Perform test
		KeyedValues Result = DataUtilities.getCumulativePercentages(data);
		//Verify the result
		assertEquals("The value at index 0 should be 0.3125", 0.3125, Result.getValue(0));
	}

	
	 /**
     * Test case to verify the correctness of the cumulative percentage calculation for the last value.
     * This test focuses on testing equivalence class
     * Parameters:
     * 5,9 and 2 are passed to the method
     * 
     * Returns:
     * - The cumulative percentage value for the last key-value pair, expecting 1.0
     * 
     * Test status:
     * Failed. Returns 1.4545 instead of 1.0
     */
	@Test
	public void getCumulativePercentageShouldBeOneHundredPercent() {
		
		Mockery keyedValuesMock = new Mockery();
		final KeyedValues data = keyedValuesMock.mock(KeyedValues.class);
		
		
		keyedValuesMock.checking(new Expectations() {{
			atLeast(1).of(data).getItemCount();
			will(returnValue((3)));
			
			allowing(data).getValue(0);
			will(returnValue(5));
			allowing(data).getValue(1);
			will(returnValue(9));
			allowing(data).getValue(2);
			will(returnValue(2));
			
			allowing(data).getKey(0);
			will(returnValue(0));
			allowing(data).getKey(1);
			will(returnValue(1));
			allowing(data).getKey(2);
			will(returnValue(2));
			
		}});
		
		
		KeyedValues Result = DataUtilities.getCumulativePercentages(data);
		assertEquals("The value at index 2 should be 1.0", 1.0, Result.getValue(2));
	}
	
	
	 /**
     * Test case to verify the correctness of the cumulative percentage calculation for 0 input.
     * This test ensures boundary class testing with 0 as an input
     * Parameters:
     * 0 passed to the method.
     * 
     * Returns:
     * - An empty KeyedValues instance, indicating 0 items
     * 
     * Test Status :
     * Passed. 
     *
     */
	
	@Test
	public void getCumulativePercentageForEmptyInputShouldBeZero() {
	    Mockery keyedValuesMock = new Mockery();
	    final KeyedValues data = keyedValuesMock.mock(KeyedValues.class);
	    
	    keyedValuesMock.checking(new Expectations() {{
	        atLeast(1).of(data).getItemCount();
	        will(returnValue(0)); // Set the item count to 0 for an empty input
	        
	    }});
	    
	    KeyedValues Result = DataUtilities.getCumulativePercentages(data);
	    assertEquals("The result should be an empty KeyedValues instance", 
	                 0, Result.getItemCount());
	}
	
	/**
     * Test case to verify the behavior of the method when a null object is passed in for the first parameter.
     * This test ensures boundary class testing with null input
     * Parameters:
     * - Mocked KeyedValues instance set to null
     * 
     * Returns:
     * - Expects an IllegalParameterException to be thrown
     * 
     * Test Status:
     * Passed.
     */
	
	@Test (expected = IllegalArgumentException.class)
	public void getCumulativePercentageNullDataObject() {
	DataUtilities.getCumulativePercentages(null);
	}
	

	
	@Test
	public void testGetCumulativePercentagesWithNegativeValue() {
			Mockery keyedValuesMock = new Mockery();

			 final KeyedValues values = keyedValuesMock.mock(KeyedValues.class);

			keyedValuesMock.checking(new Expectations() {

		        {
		        	allowing(values).getItemCount();
					will(returnValue(3));
					allowing(values).getValue(0);
					will(returnValue(5));
					allowing(values).getValue(1);
					will(returnValue(-9));
					allowing(values).getValue(2);
					will(returnValue(2));
					allowing(values).getKey(0);
					will(returnValue(1));
					allowing(values).getKey(1);
					will(returnValue(2));
					allowing(values).getKey(2);
					will(returnValue(3));
		        }

		    });

			KeyedValues result = DataUtilities.getCumulativePercentages(values);
			 assertEquals("The value for index 0", -2.5, result.getValue(0));

		}
	

	//  Test for DataUtilities clone(double[][] source)
	@Test 
	public void testDoubleArr() {
	    double[][] arr = {{2, 4, 6},{4, 10, 12}};
	    assertArrayEquals(arr, DataUtilities.clone(arr));
	}
	
	//Test for equals
	@Test
	public void testEquality() {
	    double[][] first = {{2,4,6}, {8,10,12}};
	    double[][] second = {{2,4,6}, {8,10,12}};
	    boolean actual = DataUtilities.equal(first, second);
	    assertEquals(true, actual);
	}
	



      
	@Test 
	public void testColumnTotalNoRows() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(0));
	            
	        }
	    });
	    assertEquals(DataUtilities.calculateColumnTotal(values, 0), 0, .000000001d);
	}
	
	@Test 
	public void testColumnTotalWithNullValue() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            
	        }
	    });
	    assertEquals(DataUtilities.calculateColumnTotal(values, 0), 0, .000000001d);
	}
	
	@Test
	public void testColumnTotalWithNegativeRows() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(-1));
	            one(values).getValue(0, 0);
	            will(returnValue(2));
	            
	        }
	    });
	    assertEquals(DataUtilities.calculateColumnTotal(values, 0), 0, .000000001d);
	}
	
	@Test
	public void testColumnTotalWithNegativeRowsAndNullValue() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(-1));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            
	        }
	    });
	    assertEquals(DataUtilities.calculateColumnTotal(values, 0), 0, .000000001d);
	}
	
	//DataUtilities calculateColumnTotal(int[]) tests
	
	@Test
	public void testColumnTotalShortArrayRows() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(0));
	            
	        }
	    });
	    
	    int[] i = {};
	    assertEquals(DataUtilities.calculateColumnTotal(values, 0, i), 0, .000000001d);
	}
	
	@Test
	public void testColumnTotalOutOfBounds() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(1));
	            
	        }
	    });
	    
	    int[] i = {2};
	    assertEquals(DataUtilities.calculateColumnTotal(values, 0, i), 0, .000000001d);
	}
	
	@Test
	public void testColumnTotalValidRowsLessRowCount() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	        	allowing(values).getRowCount();
	            will(returnValue(4));
	            allowing(values).getValue(0, 0);
	            will(returnValue(1.0));
	            allowing(values).getValue(1, 0);
	            will(returnValue(2.0));
	            allowing(values).getValue(2, 0);
	            will(returnValue(3.0));
	            allowing(values).getValue(3, 0);
	            will(returnValue(4.0));
	            
	        }
	    });
	    
	    int[] i = {0, 0, 0};
	    assertEquals(DataUtilities.calculateColumnTotal(values, 0, i), 3, .000000001d);
	}
	
	@Test
	public void testColumnTotalValidRowsIntWithNullValue() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            one(values).getValue(1, 0);
	            will(returnValue(1.0));
	            one(values).getValue(2, 0);
	            will(returnValue(1.0));
	            
	        }
	    });
	    
	    int[] i = {0, 1};
	    assertEquals(DataUtilities.calculateColumnTotal(values, 0, i), 1, .000000001d);
	}

  	
	
	@Test
    public void testRowTotalNoRows() {
    	//setup
    	Mockery mocked = new Mockery();
    	final Values2D values = mocked.mock(Values2D.class);
    	mocked.checking(new Expectations() {
    		{
    			one(values).getColumnCount();
    			will(returnValue(0));
    			
    		}
    	}
    			);
    	
    	assertEquals(DataUtilities.calculateRowTotal(values, 0), 0, .000000001d);
    }
	
	@Test
	public void testRowTotalWithNullValue() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            
	        }
	    });
	    assertEquals(DataUtilities.calculateRowTotal(values, 0), 0, .000000001d);
	}

	@Test
	public void testRowTotalWithNegativeRows() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(-1));
	            one(values).getValue(0, 0);
	            will(returnValue(1));
	            
	        }
	    });
	    assertEquals(DataUtilities.calculateRowTotal(values, 0), 0, .000000001d);
	}

	@Test
	public void testRowTotalWithNegativeRowsAndNullValue() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(-1));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            
	        }
	    });
	    assertEquals(DataUtilities.calculateRowTotal(values, 0), 0, .000000001d);
	}

	//Test Rows with int
	@Test
	public void testRowTotalShortArrayRows() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(0));
	            
	        }
	    });
	    
	    int[] i = {};
	    assertEquals(DataUtilities.calculateRowTotal(values, 0, i), 0, .000000001d);
	}

	@Test
	public void testRowTotalNegative() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(-1));
	            
	        }
	    });
	    
	    int[] i = {};
	    assertEquals(DataUtilities.calculateRowTotal(values, 0, i), 0, .000000001d);
	}

	@Test
	public void testRowTotalOutOfBounds() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(1));
	            
	        }
	    });
	    
	    int[] i = {1};
	    assertEquals(DataUtilities.calculateRowTotal(values, 0, i), 0, .000000001d);
	}

	@Test
	public void testRowTotalValidRowsLessRowCount() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            allowing(values).getColumnCount();
	            will(returnValue(4));
	            allowing(values).getValue(0, 0);
	            will(returnValue(1.0));
	            allowing(values).getValue(0, 1);
	            will(returnValue(2.0));
	            allowing(values).getValue(0, 2);
	            will(returnValue(3.0));
	            allowing(values).getValue(0, 3);
	            will(returnValue(4.0));
	            
	        }
	    });
	    
	    int[] i = {0, 0, 0};
	    assertEquals(DataUtilities.calculateRowTotal(values, 0, i), 3, .000000001d);
	}

	@Test
	public void testRowTotalValidRowsIntWithNullValue() {
	    Mockery mocked = new Mockery();
	    final Values2D values = mocked.mock(Values2D.class);
	    mocked.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            one(values).getValue(0, 1);
	            will(returnValue(1.0));
	            one(values).getValue(0, 2);
	            will(returnValue(1.0));
	            
	        }
	    });
	    
	    int[] i = {0, 1};
	    assertEquals(DataUtilities.calculateRowTotal(values, 0, i), 1, .000000001d);
	}
	
	
	
	/////////////// --------------------------------------- /////////////////
	
	//      ADDITION OF NEW TEST CASES TO INCREASE MUTATION COVERAGE       //
	
	/////////////// --------------------------------------- /////////////////
	
	
	
	
	@Test
	public void testFirstNull() {
	    double[][] first = null;
	    double[][] second = {{2,4,6}, {8,10,12}};
	    boolean actual = DataUtilities.equal(first, second);
	    assertEquals(false, actual);
	}
	
	@Test
	public void testSecondNull() {
	    double[][] first = {{2,4,6}, {8,10,12}};
	    double[][] second = null;
	    boolean actual = DataUtilities.equal(first, second);
	    assertEquals(false, actual);
	}
	
	@Test
	public void testBothNull() {
	    double[][] first = null;
	    double[][] second = null;
	    boolean actual = DataUtilities.equal(first, second);
	    assertEquals(true, actual);
	}
	
	@Test
	public void testInequality() {
	    double[][] first = {{2,4,6}, {8,10,12}};
	    double[][] second = {{2,4,6}, {8,10}};
	    boolean actual = DataUtilities.equal(first, second);
	    assertEquals(false, actual);
	}
	
	@Test
	public void testDifferentLength() {
	    double[][] first = {{2,4,6}};
	    double[][] second = {{2,4,6}, {8,10}};
	    boolean actual = DataUtilities.equal(first, second);
	    assertEquals(false, actual);
	}
	
	
	@Test 
	public void testDoubleArrNull() {
	    double[][] arr = {{},{}};
	    assertArrayEquals(arr, DataUtilities.clone(arr));
	}


	
  @Test
  public void testNumberArray2DCreation_MixedNumbers() {
      exampleDoubleArray2D = new double[][] {{-1.1, 2.2, 3.3, -4.4, 5.5}, {1.1, -2.2, -3.3, 4.4}};
      Number[][] expectedNumberArray2D = {{-1.1, 2.2, 3.3, -4.4, 5.5}, {1.1, -2.2, -3.3, 4.4}};
      Number[][] actualNumberArray2D = DataUtilities.createNumberArray2D(exampleDoubleArray2D);
      assertArrayEquals("2D array with mixed positive and negative numbers", expectedNumberArray2D, actualNumberArray2D);
  }
	
	
	
  @Test
  public void testNumberArrayCreation_MixedNumbers() {
      exampleDoubleArray = new double[] {-1.1, 2.2, 3.3, -4.4, 5.5};
      Number[] expectedNumberArray = {-1.1, 2.2, 3.3, -4.4, 5.5};
      Number[] actualNumberArray = DataUtilities.createNumberArray(exampleDoubleArray);
      assertArrayEquals("Array with mixed positive and negative numbers", expectedNumberArray, actualNumberArray);
  }
	
	
  @Test
  public void testNumberArray2DCreation_NonNullArray() {
      exampleDoubleArray2D = new double[][] {{1.1, -2.2, -3.3, -4.4, 5.5}, {3.1, 1.3}};
      Number[][] actualNumberArray2D = DataUtilities.createNumberArray2D(exampleDoubleArray2D);
      assertNotNull("Ensure non-null 2D array creation", actualNumberArray2D);
  }
		    
}