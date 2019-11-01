package demo.junit_class_demo.math;

import org.junit.Test;

import demo.junit_class_demo.math.MyMath;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * An class that provides test cases for the 
 * "simple" math operations of the MyMath 
 * class, for demonstrating Unit Testing.
 * @author agkortzis (antonis.gkortzis@gmail.com)
 */
public class MyMathTest {
    MyMath mm = new MyMath();

    /*
     * A unit test that checks a valid positive input
     */
    @Test
    public void testGetSignShouldReturnPositive() {
        assertEquals(mm.checkSign(5),"positive");


    }

    /*
     * A unit test that checks a valid negative input
     */
    @Test
    public void testGetSignShouldReturnNegative() {
        assertEquals(mm.checkSign(-5),"negative");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldGetIllegalArgumentException(){
        mm.checkSign(0);

    }
    @Test
    public void reverseTest(){
        assertEquals(mm.reverseNumber(5),-5);
    }


}



