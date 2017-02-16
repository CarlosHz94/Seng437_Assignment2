package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
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

	@Test
	public void calculateColumnTotalForTwoPositiveValues() {
		//setup
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
		// exercise double result =
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(result, 10.0, .000000001d);
		// tear-down: NONE in this test method	
	}
	
	@Test
	public void calculateColumnTotalForTwoNegativeValues(){
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
		assertEquals(result, -10.0, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalForCloseToMaxDoubleValues(){
		mockingContext.checking(new Expectations(){
			{
				oneOf(values).getRowCount();
				will()
			}
		});
	}

}