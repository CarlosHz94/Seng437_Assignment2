package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest{

	private Range exampleRange;
	@BeforeClass public static void setUpBeforeClass()
	throws Exception{}
	
	
	@Test
	public void simpleZeroCentralValueTest() {
		exampleRange= new Range(-1,1);
		assertEquals("The central value of -1 and 1 should 0", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test 
	public void centralPositiveValueTest(){
		exampleRange = new Range(1,3);
		assertEquals("The central value of 1 and 3 should be 2", 2, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralNegativeValueTest(){
		exampleRange = new Range(-3,-1);
		assertEquals("The central value of -3 and -1 should be -2", -2, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralFloatingPointValueTest(){
		exampleRange = new Range(1,2);
		assertEquals("The central value of 1 and 2 should be 1.5", 1.5, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void singleValueRangeCentralValueTest(){
		exampleRange = new Range(1,1);
		assertEquals("The central value of 1 and -1 should be 0", 1, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueMaxRangeTest(){
		exampleRange = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
		assertEquals("IDk", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverMaxRangeTest(){
		exampleRange = new Range(-Double.MAX_VALUE-1, Double.MAX_VALUE+1);
		assertEquals("The central value of 1 extra from the max double value should be 0", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverPositiveMaxRangeTest(){
		exampleRange= new Range(-Double.MAX_VALUE, Double.MAX_VALUE+2);
		assertEquals("The central value should be 1", 1, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverNegativeMaxRangeTest(){
		exampleRange = new Range(-Double.MAX_VALUE-2, Double.MAX_VALUE);
		assertEquals("The central value should be -1", -1, exampleRange.getCentralValue(), .000000001d);
	}
	
	
	@Test
	public void centralValueCloseToMaxRangeTest(){
		exampleRange = new Range(-Double.MAX_VALUE+1, Double.MAX_VALUE-1);
		assertEquals("The central value should be 0", 0, exampleRange.getCentralValue(), .0000000001d);
	}
	
	@Test
	public void centralValueCloseToMaxRangeTest2(){
		exampleRange = new Range(-Double.MAX_VALUE+3, Double.MAX_VALUE-1);
		assertEquals("The central value should be 1", 1, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueMaxIntegerTest(){
		exampleRange = new Range(-Integer.MAX_VALUE, Integer.MAX_VALUE);
		assertEquals("The central value of max integer values should be 0", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverMaxIntegerTest(){
		exampleRange = new Range(-Integer.MAX_VALUE-1, Integer.MAX_VALUE+1);
		assertEquals("The central value of the 1 extra over the max integer shoudl be 0", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverPositiveIntegerMaxRangeTest(){
		exampleRange = new Range(-Integer.MAX_VALUE, Integer.MAX_VALUE+2);
		assertEquals("The central value of should be 1", 1, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralValueOverNegativeIntegerMaxRangeTest(){
		exampleRange = new Range(-Integer.MAX_VALUE-2, Integer.MAX_VALUE);
		assertEquals("The central value should be -1", -1, exampleRange.getCentralValue(), .000000001d);
	}
	
	
	@Test
	public void centralValueCloseToIntegerMaxRangeTest(){
		exampleRange = new Range(-Integer.MAX_VALUE+1, Integer.MAX_VALUE-1);
		assertEquals("The central value should be 0", 0, exampleRange.getCentralValue(), .0000000001d);
	}
	
	@Test
	public void centralValueCloseToIntegerMaxRangeTest2(){
		exampleRange = new Range(-Integer.MAX_VALUE+3, Integer.MAX_VALUE-1);
		assertEquals("The central value should be 1", 1, exampleRange.getCentralValue(), .000000001d);
	}
	


	@After
	public void tearDown()
		throws Exception{}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{}
	
	
}
