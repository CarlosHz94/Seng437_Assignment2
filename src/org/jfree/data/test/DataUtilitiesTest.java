package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.*;

public class DataUtilitiesTest extends DataUtilities {
	Mockery mockingContext;
	Values2D values;

	@Before
	public void setup(){
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
	}

	/** 
	 * Tests for calculateColumnTotal
	 */

	@Test
	public void calculateColumnTotalForTwoPositiveValues() {	//Pass
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The result should be 10", 10.0, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalForTwoNegativeValues(){		//Pass
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-5.6));
				oneOf(values).getValue(1, 0);
				will(returnValue(-4.4));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The result should be -10", -10.0, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalForCloseToPositiveMaxDoubleValues(){	//Pass
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue((Double.MAX_VALUE/2)-1));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The result should be " +(Double.MAX_VALUE-1),Double.MAX_VALUE-1, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalAtMaxPositiveDoubleValues(){	//Pass
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The result should be " +Double.MAX_VALUE, Double.MAX_VALUE, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalPastMaxPositiveDoubleValues(){	//Pass
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(1+Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The result shoudl be " + (1+Double.MAX_VALUE), 1+Double.MAX_VALUE, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalForCloseToNegativeMaxDoubleValues(){	//Pass
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(1-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The result should be " + (1-Double.MAX_VALUE), 1-Double.MAX_VALUE, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalAtMaxNegativeDoubleValues(){	//Pass
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The result should be " + (-Double.MAX_VALUE), -Double.MAX_VALUE, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalPastMaxNegativeDoubleValues(){	//Pass
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(-1-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The result should be " + (-1-Double.MAX_VALUE), -1-Double.MAX_VALUE, result, .000000001d);
	}
	
	/**
	 * Tests for calculate row total
	 */
	
	@Test
	public void calculateRowTotalForTwoPositiveValues() {	//Fails
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The result should be 10", 10.0, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalForTwoNegativeValues(){	//Fails
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-5.6));
				oneOf(values).getValue(1, 0);
				will(returnValue(-4.4));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The result should be -10",-10.0, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalForCloseToPositiveMaxDoubleValues(){ 	//Fails
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue((Double.MAX_VALUE/2)-1));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The result should be " +(Double.MAX_VALUE-1), Double.MAX_VALUE-1, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalAtMaxPositiveDoubleValues(){	//Fails
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The result should be " + Double.MAX_VALUE, Double.MAX_VALUE, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalPastMaxPositiveDoubleValues(){		//Fails
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(1+Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The result shoudl be " + (1+Double.MAX_VALUE), 1+Double.MAX_VALUE, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalForCloseToNegativeMaxDoubleValues(){	//Fails
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(1-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The result should be " + (1-Double.MAX_VALUE), 1-Double.MAX_VALUE, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalAtMaxNegativeDoubleValues(){	//Fails
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The result should be " + (-Double.MAX_VALUE), -Double.MAX_VALUE, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalPastMaxNegativeDoubleValues(){		//Fails
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE/2));
				oneOf(values).getValue(1, 0);
				will (returnValue(-1-Double.MAX_VALUE/2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The result should be " + (-1-Double.MAX_VALUE),-1-Double.MAX_VALUE, result, .000000001d);
	}

	/**
	 * calling createNumberArray() function from DataUtility using five (an abitrary number) doubles
	 */
	@Test
	public void createNumberArrayWithFiveDoubles(){		//Fails
		//setup
		double[] data = {1.2,2.2,3.2,4.2,5.2};
		Number[] expecteds = {1.2,2.2,3.2,4.2,5.2};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray() function from DataUtility with null data
	 */
	@Test
	public void createNumberArrayWithNullData(){	//Pass
		//setup
		double[] data = null;
		try{
			Number[] actuals = DataUtilities.createNumberArray(data);
			fail();
		}catch (IllegalArgumentException e){
			assertTrue(true);
		}
	}

	/**
	 * calling createNumberArray() function from DataUtility with only 1 double in the array
	 */
	@Test
	public void createNumberArrayWithOneDouble(){		//Fails
		//setup
		double[] data = {1.2};
		Number[] expecteds = {1.2};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}


	/**
	 * calling createNumberArray() function from DataUtility by initializing data with a single int
	 */
	@Test
	public void createNumberArrayWithOneInt(){		//Fails
		//setup
		double[] data = {1};
		Number[] expecteds = {1.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray() function from DataUtility by initializing data with 10 ints
	 */
	@Test
	public void createNumberArrayWithTenInt(){		//Fails
		//setup
		double[] data = {0,1,2,3,4,5,6,7,8,9};
		Number[] expecteds = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray() function from DataUtility with negatives
	 */
	@Test
	public void createNumberArrayWithNegativeDoubles(){		//Fails
		//setup
		double[] data = {-1.3,2.3,0.0};
		Number[] expecteds = {-1.3,2.3,0.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling createNumberArray() function from DataUtility with max values for doubles mixed in data
	 */
	@Test
	public void createNumberArrayWithMaxValue(){	//Fails
		//setup
		double[] data = {1.2,Double.MAX_VALUE,-3.4};
		Number[] expecteds = {1.2,Double.MAX_VALUE,-3.4};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}


	/**
	 * calling createNumberArray() function from DataUtility with NaN mixed in data
	 */
	@Test
	public void createNumberArrayWithNaN(){		//Fails
		//setup
		double[] data = {1.2,3.4,Double.NaN, 2.0};
		try{
			Number[] actuals = DataUtilities.createNumberArray(data);
			fail("NaN was not detected");
		}catch (IllegalArgumentException e){
			assertTrue(true);
		}
	}

	/**
	 * calling createNumberArray() function from DataUtility with Double's Min value
	 */
	@Test
	public void createNumberArrayWithMinValue(){	//Fails
		//setup
		double[] data = {1.2,3.4,4.5,-1.2,Double.MIN_VALUE,3.2};
		Number[] expecteds = {1.2,3.4,4.5,-1.2,Double.MIN_VALUE,3.2};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * 0      3
	 * 1      4
	 * 2      5
	 */
	@Test
	public void getCummulativePercentagesWithThreeNumbers() {	//Fails
		//setup
		KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(data).getItemCount();
				will(returnValue(3));
				//simulates item # 1
				atLeast(1).of(data).getKey(0);
				will(returnValue(0));
				atLeast(1).of(data).getValue(0);
				will(returnValue(3));
				//simulates item # 2
				atLeast(1).of(data).getKey(1);
				will(returnValue(1));
				atLeast(1).of(data).getValue(1);
				will(returnValue(4));
				//simulates item # 3
				atLeast(1).of(data).getKey(2);
				will(returnValue(2));
				atLeast(1).of(data).getValue(2);
				will(returnValue(5));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		mockingContext.assertIsSatisfied();
		Number[] expecteds = {(3.0/(3.0+4.0+5.0)),((3.0+4.0)/(3.0+4.0+5.0)),1.0};
		Number[] actuals = {0.0,0.0,0.0};
		if(result.getItemCount() != 3) fail("Wrong amount of key returned");
		for(int index = 0; index < result.getItemCount(); index++){
			actuals[index] = result.getValue(index);
		}
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * 0      -3
	 * 1      4
	 * 2      5
	 */
	@Test
	public void getCummulativePercentagesWithMixedPositivesAndNegatives() {		//Fails
		//setup
		KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(data).getItemCount();
				will(returnValue(3));
				//simulates item # 1
				atLeast(1).of(data).getKey(0);
				will(returnValue(0));
				atLeast(1).of(data).getValue(0);
				will(returnValue(-3));
				//simulates item # 2
				atLeast(1).of(data).getKey(1);
				will(returnValue(1));
				atLeast(1).of(data).getValue(1);
				will(returnValue(4));
				//simulates item # 3
				atLeast(1).of(data).getKey(2);
				will(returnValue(2));
				atLeast(1).of(data).getValue(2);
				will(returnValue(5));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		mockingContext.assertIsSatisfied();
		Number[] expecteds = {((-3.0)/((-3.0)+4.0+5.0)),(((-3.0)+4.0)/((-3.0)+4.0+5.0)),1.0};
		Number[] actuals = {0.0,0.0,0.0};
		if(result.getItemCount() != 3) fail("Wrong amount of key returned");
		for(int index = 0; index < result.getItemCount(); index++){
			actuals[index] = result.getValue(index);
		}
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * 0      0
	 * 1      0
	 * 2      0
	 */
	@Test
	public void getCummulativePercentagesWithZeros() {		//Pass
		//setup
		KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(data).getItemCount();
				will(returnValue(3));
				//simulates item # 1
				atLeast(1).of(data).getKey(0);
				will(returnValue(0));
				atLeast(1).of(data).getValue(0);
				will(returnValue(0));
				//simulates item # 2
				atLeast(1).of(data).getKey(1);
				will(returnValue(1));
				atLeast(1).of(data).getValue(1);
				will(returnValue(0));
				//simulates item # 3
				atLeast(1).of(data).getKey(2);
				will(returnValue(2));
				atLeast(1).of(data).getValue(2);
				will(returnValue(0));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		mockingContext.assertIsSatisfied();
		Number[] expecteds = {Double.NaN,Double.NaN,Double.NaN};
		Number[] actuals = {0.0,0.0,0.0};
		if(result.getItemCount() != 3) fail("Wrong amount of key returned");
		for(int index = 0; index < result.getItemCount(); index++){
			actuals[index] = result.getValue(index);
		}
		assertArrayEquals(expecteds, actuals);
	}

	/**
	 * calling getCummulativePercentages() function from DataUtility using mocked KeyedValues.
	 * Mocking a normal set of keys and values as followed:
	 * key    value
	 * 0      -3
	 * 1      1
	 * 2      2
	 */
	@Test
	public void getCummulativePercentagesWithZeroSum() {	//Fails
		//setup
		KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(data).getItemCount();
				will(returnValue(3));
				//simulates item # 1
				atLeast(1).of(data).getKey(0);
				will(returnValue(0));
				atLeast(1).of(data).getValue(0);
				will(returnValue(-3));
				//simulates item # 2
				atLeast(1).of(data).getKey(1);
				will(returnValue(1));
				atLeast(1).of(data).getValue(1);
				will(returnValue(1));
				//simulates item # 3
				atLeast(1).of(data).getKey(2);
				will(returnValue(2));
				atLeast(1).of(data).getValue(2);
				will(returnValue(2));
			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		mockingContext.assertIsSatisfied();
		Number[] expecteds = {Double.NaN,Double.NaN,Double.NaN};
		Number[] actuals = {0.0,0.0,0.0};
		if(result.getItemCount() != 3) fail("Wrong amount of key returned");
		for(int index = 0; index < result.getItemCount(); index++){
			actuals[index] = result.getValue(index);
		}
		assertArrayEquals(expecteds, actuals);
	}

}