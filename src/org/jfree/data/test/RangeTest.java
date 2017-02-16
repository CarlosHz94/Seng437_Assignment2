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
	
	//Tests for getUpperBound
	
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
	public void overMaxUpperRangeGetUpperBoundTest(){
		exampleRange = new Range(0, Double.MAX_VALUE + 1);
		assertEquals("The upper bound of this range should be max double plus 1", Double.MAX_VALUE + 1, exampleRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void UnderMaxRangeGetUpperBOundTest(){
		exampleRange = new Range(0, Double.MAX_VALUE - 1);
		assertEquals("The upper bound of this range should be max double minus 1", Double.MAX_VALUE - 1, exampleRange.getUpperBound(), .000000001d);
	}
	
	//Tests for expand
	
	@Test
	public void expandZeroTest(){		
		exampleRange = new Range(-1, 1);
		Range.expand(exampleRange, 0, 0);
		Range testRange = new Range(-1, 1);
		assertTrue("Range should be (-1,1)", testRange.equals(exampleRange));
	}
	
	@Test
	public void expandUpperBoundTest(){		
		exampleRange = new Range(0, 2);
		Range.expand(exampleRange, 0, 0.5);
		Range testRange = new Range(0, 3);
		assertTrue("Range should be (0,3)", testRange.equals(exampleRange));
	}
	
	@Test
	public void expandLowerBoundTest(){	
		exampleRange = new Range(0, 2);
		Range.expand(exampleRange, 0.5, 0);
		Range testRange = new Range(-1, 2);
		assertTrue("Range should be (-1,2)", testRange.equals(exampleRange));
	}
	
	@Test
	public void expandBothBoundsTest(){		
		exampleRange = new Range(2, 6);
		Range.expand(exampleRange, 0.25, 0.5);
		Range testRange = new Range(1, 8);
		assertTrue("Range should be (1,8)", testRange.equals(exampleRange));
	}
	
	@Test
	public void expandUpperBoundNegativeTest(){		
		exampleRange = new Range(0, 2);
		Range.expand(exampleRange, 0, -0.5);
		Range testRange = new Range(0, 1);
		assertTrue("Range should be (0,1)", testRange.equals(exampleRange));
	}
	
	@Test
	public void expandLowerBoundNegativeTest(){		
		exampleRange = new Range(0, 2);
		Range.expand(exampleRange, -0.5, 0);
		Range testRange = new Range(1, 2);
		assertTrue("Range should be (1,2)", testRange.equals(exampleRange));
	}
	
	@Test
	public void expandBothBoundsNegativeTest(){		
		exampleRange = new Range(0, 4);
		Range.expand(exampleRange, -0.25, -0.25);
		Range testRange = new Range(1, 3);
		assertTrue("Range should be (1,3)", testRange.equals(exampleRange));
	}
	
	//Tests for combine
	
	@Test
	public void combineSameRange(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, new Range(0,1)).equals(new Range(0,1)));
	}
	
	public void combineLargerUpperRangeFirstParam(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(new Range(0,2), exampleRange).equals(new Range(0,2)));
	}
	
	@Test
	public void combineLargerUpperRangeSecondParam(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, new Range(0,2)).equals(new Range(0,2)));
	}
	
	@Test
	public void combineLargerLowerRangeFirstParam(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(new Range(-1,0), exampleRange).equals(new Range(-1,1)));
	}
	
	@Test
	public void combineLargerLowerRangeSecondParam(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, new Range(-1,0)).equals(new Range(-1,1)));
	}
	
	@Test
	public void combineLargerRangeFirstParam(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(new Range(-1,2), exampleRange).equals(new Range(-1,2)));
	}
	
	@Test
	public void combineLargerRangeSecondParam(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, new Range(-1,2)).equals(new Range(-1,2)));
	}
	
	@Test
	public void combineBothNull(){
		exampleRange = null;
		assertNull(Range.combine(null, exampleRange));
	}
	
	@Test
	public void combineFirstNull(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(null, exampleRange).equals(new Range(0,1)));
	}
	
	@Test
	public void combineSecondNull(){
		exampleRange = new Range(0,1);
		assertTrue(Range.combine(exampleRange, null).equals(new Range(0,1)));
	}
	@After
	public void tearDown()
		throws Exception{}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{}
	
	
}
