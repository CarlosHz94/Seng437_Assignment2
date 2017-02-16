package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest{

	private Range exampleRange;
	@BeforeClass 
	public static void setUpBeforeClass()
			throws Exception{}
	
	// Tests for getCentralValue
	
	@Test
	public void simpleZeroCentralValueTest(){		//Pass
		exampleRange= new Range(-1,1);
		assertEquals("The central value of -1 and 1 should 0", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test 
	public void centralPositiveValueTest(){			//Pass
		exampleRange = new Range(1,3);
		assertEquals("The central value of 1 and 3 should be 2", 2, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralNegativeValueTest(){			//Pass
		exampleRange = new Range(-3,-1);
		assertEquals("The central value of -3 and -1 should be -2", -2, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralFloatingPointValueTest(){	//Pass
		exampleRange = new Range(1,2);
		assertEquals("The central value of 1 and 2 should be 1.5", 1.5, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void singleValueRangeCentralValueTest(){	//Pass
		exampleRange = new Range(1,1);
		assertEquals("The central value of 1 and -1 should be 0", 1, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueMaxRangeTest(){		//Pass
		exampleRange = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
		assertEquals("IDk", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverMaxRangeTest(){	//Pass
		exampleRange = new Range(-Double.MAX_VALUE-1, Double.MAX_VALUE+1);
		assertEquals("The central value of 1 extra from the max double value should be 0", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverPositiveMaxRangeTest(){		//Fails
		exampleRange= new Range(-Double.MAX_VALUE, Double.MAX_VALUE+2);
		assertEquals("The central value should be 1", 1, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverNegativeMaxRangeTest(){		//Fails
		exampleRange = new Range(-Double.MAX_VALUE-2, Double.MAX_VALUE);
		assertEquals("The central value should be -1", -1, exampleRange.getCentralValue(), .000000001d);
	}
	
	
	@Test
	public void centralValueCloseToMaxRangeTest(){	//Pass
		exampleRange = new Range(-Double.MAX_VALUE+1, Double.MAX_VALUE-1);
		assertEquals("The central value should be 0", 0, exampleRange.getCentralValue(), .0000000001d);
	}
	
	@Test
	public void centralValueCloseToMaxRangeTest2(){		//Fails
		exampleRange = new Range(-Double.MAX_VALUE+3, Double.MAX_VALUE-1);
		assertEquals("The central value should be 1", 1, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueMaxIntegerTest(){		//Pass
		exampleRange = new Range(-Integer.MAX_VALUE, Integer.MAX_VALUE);
		assertEquals("The central value of max integer values should be 0", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test 
	public void centralValueOverMaxIntegerTest(){		//Fails
		exampleRange = new Range(-Integer.MAX_VALUE-1, Integer.MAX_VALUE+1);
		assertEquals("The central value of the 1 extra over the max integer shoudl be 0", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverPositiveIntegerMaxRangeTest(){		//Fails
		exampleRange = new Range(-Integer.MAX_VALUE, Integer.MAX_VALUE+2);
		assertEquals("The central value of should be 1", 1, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverNegativeIntegerMaxRangeTest(){		//Fails
		exampleRange = new Range(-Integer.MAX_VALUE-2, Integer.MAX_VALUE);
		assertEquals("The central value should be -1", -1, exampleRange.getCentralValue(), .000000001d);
	}
	
	
	@Test
	public void centralValueCloseToIntegerMaxRangeTest(){	//Pass
		exampleRange = new Range(-Integer.MAX_VALUE+1, Integer.MAX_VALUE-1);
		assertEquals("The central value should be 0", 0, exampleRange.getCentralValue(), .0000000001d);
	}
	
	@Test
	public void centralValueCloseToIntegerMaxRangeTest2(){	//Pass
		exampleRange = new Range(-Integer.MAX_VALUE+3, Integer.MAX_VALUE-1);
		assertEquals("The central value should be 1", 1, exampleRange.getCentralValue(), .000000001d);
	}
	
//**********************************************************
	//Upper Bound Tests
	
	@Test
	public void simpleGetUpperBoundTest(){		//Fails
		exampleRange = new Range(-1,1);
		assertEquals("The upper bound of this range should be 1", 1, exampleRange.getUpperBound(), .000000001d);
	}

	@Test
	public void positiveRangeGetUpperBoundTest(){		//Fails
		exampleRange= new Range(1,3);
		assertEquals("The upper bound of this range should be 3", 3, exampleRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void negativeRangeGetUpperBoundTest(){		//Fails
		exampleRange = new Range(-5, -2);
		assertEquals("The upper bound of this range should be -2", -2, exampleRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void singleValueRangeGetUpperBoundTest(){	//Pass
		exampleRange = new Range(1,1);
		assertEquals("The upper bound of this range should be 1", 1, exampleRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void maxUpperRangeGetUpperBoundTest(){		//Fails
		exampleRange = new Range(0, Double.MAX_VALUE);
		assertEquals("The upper bound of this range should be the max double value", Double.MAX_VALUE, exampleRange.getUpperBound(), .000000001d);
	}
	
	@Test 
	public void overMaxUpperRangeGetUpperBoundTest(){	//Fails
		exampleRange = new Range(0, Double.MAX_VALUE + 1);
		assertEquals("The upper bound of this range should be max double plus 1", Double.MAX_VALUE + 1, exampleRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void UnderMaxRangeGetUpperBOundTest(){		//Fails
		exampleRange = new Range(0, Double.MAX_VALUE - 1);
		assertEquals("The upper bound of this range should be max double minus 1", Double.MAX_VALUE - 1, exampleRange.getUpperBound(), .000000001d);
	}
	
//**********************************************************
	//Equals Tests
	
	@Test
	public void SimpleEqualsTest() { //passes
		Range exampleRange1 = new Range(-1,1);
		Range exampleRange2 = new Range(-1,1);
		boolean areSame = exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should be the equal",true,areSame);
	}
	
	@Test
	public void SimpleNotEqualsTest() { //passses
		Range exampleRange1 = new Range(-1,1);
		Range exampleRange2 = new Range(-600,-500);
		boolean areDifferent = !exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should not be equal",true,areDifferent);
	}
	
	@Test
	public void MaxRangeEqualTest() { //passes
		Range exampleRange1 = new Range(-Double.MAX_VALUE,Double.MAX_VALUE);
		Range exampleRange2 = new Range(-Double.MAX_VALUE,Double.MAX_VALUE);
		boolean areSame = exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should be equal",true,areSame);
	}
	
	@Test
	public void OverMaxRangeEqualTest() { //passes
		Range exampleRange1 = new Range(-Double.MAX_VALUE-1,Double.MAX_VALUE+1);
		Range exampleRange2 = new Range(-Double.MAX_VALUE-1,Double.MAX_VALUE+1);
		boolean areSame = exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should be equal",true,areSame);
	}
	
	@Test
	public void OverMaxRangeNotEqualTest() { //fails
		Range exampleRange1 = new Range(-Double.MAX_VALUE-1,Double.MAX_VALUE+1);
		Range exampleRange2 = new Range(-Double.MAX_VALUE-2,Double.MAX_VALUE+2);
		boolean areDifferent = !exampleRange1.equals(exampleRange2);
		assertEquals("The ranges should be equal",true,areDifferent);
	}
	
	@After
	public void tearDown()
		throws Exception{}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{}
	
	
}
