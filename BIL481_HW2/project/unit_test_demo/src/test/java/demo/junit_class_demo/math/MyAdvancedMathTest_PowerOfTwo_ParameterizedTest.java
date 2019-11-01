package demo.junit_class_demo.math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import demo.junit_class_demo.math.MyAdvancedMath;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * A test class that implements a Parameterized test
 * for the MyAdvancedMath powerOfTwo method, 
 * for demonstrating Unit Testing.
 */
@RunWith(Parameterized.class)
public class MyAdvancedMathTest_PowerOfTwo_ParameterizedTest {

	// the value is the id of each parameter
	@Parameter (value = 0)
	public int power;
	@Parameter (value = 1) //Or just @Parameter(1)
	public int result;

	MyAdvancedMath mam = new MyAdvancedMath();

	/*
	 * The following method generates the input values
	 * for the tests.
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{2,4},{3,8},{4,16}};

		return Arrays.asList(data);
	}

	/*
	 * A unit test that is executed for each pair of
	 * parameters.
	 */
	@Test
	public void testPowerOfTwoWithNormalCases() {
		assertEquals(result,mam.powerOfTwo(power));

	}
	@Test
	public void testPowerIsZero(){
		assertEquals(1,mam.powerOfTwo(0));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPowerRangeNegative(){
		mam.powerOfTwo(-1);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testPowerRange30plus(){
		mam.powerOfTwo(32);
	}


}
