package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest{

	private Range exampleRange;
	@BeforeClass public static void setUpBeforeClass()
	throws Exception{}
	
	
	@Test
	public void centralValue0() {
		exampleRange= new Range(-1,1);
		assertEquals("The central value of -1 and 1 should 0", 0, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test 
	public void centralPositiveValue(){
		exampleRange = new Range(1,3);
		assertEquals("The central value of 1 and 3 should be 2", 2, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralFloatingPointValue(){
		exampleRange = new Range(1,2);
		assertEquals("The central value of 1 and 2 should be 1.5", 1.5, exampleRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void centralMaxRangeTest(){
		exampleRange = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
		assertEquals("IDk", 0, exampleRange.getCentralValue(), .000000001d);
	}

	@After
	public void tearDown()
		throws Exception{}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{}
	
	
}
