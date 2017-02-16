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
import org.junit.*;

public class DataUtilitiesTest extends DataUtilities {
	Mockery mockingContext;
	Values2D values;

	@Before
	public void setup(){
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
	}

	@Test
	public void calculateColumnTotalForTwoPositiveValues() {
		//setup
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		// exercise double result =
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(result, 10.0, .000000001d);
		// tear-down: NONE in this test method

	}

	@Test
	public void createNumberArrayWithFiveDoubles(){
		//setup
		double[] data = {1.2,2.2,3.2,4.2,5.2};
		Number[] expecteds = {1.2,2.2,3.2,4.2,5.2};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void createNumberArrayWithEmptyData(){
		//setup
		double[] data = null;
		try{
			Number[] actuals = DataUtilities.createNumberArray(data);
			fail();
		}catch (IllegalArgumentException e){
			assertTrue(true);
		}
	}

	@Test
	public void createNumberArrayWithOneDouble(){
		//setup
		double[] data = {1.2};
		Number[] expecteds = {1.2};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}


	@Test
	public void createNumberArrayWithOneInt(){
		//setup
		double[] data = {1};
		Number[] expecteds = {1.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}


	@Test
	public void createNumberArrayWithTenInt(){
		//setup
		double[] data = {0,1,2,3,4,5,6,7,8,9};
		Number[] expecteds = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void createNumberArrayWithNegativeDoubles(){
		//setup
		double[] data = {-1.3,2.3,0.0};
		Number[] expecteds = {-1.3,2.3,0.0};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void createNumberArrayWithMaxValue(){
		//setup
		double[] data = {1.2,Double.MAX_VALUE,-3.4};
		Number[] expecteds = {1.2,Double.MAX_VALUE,-3.4};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}


	@Test
	public void createNumberArrayWithNaN(){
		//setup
		double[] data = {1.2,3.4,Double.NaN};
		try{
			Number[] actuals = DataUtilities.createNumberArray(data);
			fail("NaN was not detected");
		}catch (IllegalArgumentException e){
			assertTrue(true);
		}
	}

	@Test
	public void createNumberArrayWithMinValue(){
		//setup
		double[] data = {1.2,3.4,4.5,-1.2,Double.MIN_VALUE,3.2};
		Number[] expecteds = {1.2,3.4,4.5,-1.2,Double.MIN_VALUE,3.2};
		//Execution
		Number[] actuals = DataUtilities.createNumberArray(data);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void getCummulativePercentagesWithThreeNumbers() {
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

	@Test
	public void getCummulativePercentagesWithMixedPositivesAndNegatives() {
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


	@Test
	public void getCummulativePercentagesWithZeros() {
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

	@Test
	public void getCummulativePercentagesWithZeroSum() {
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
