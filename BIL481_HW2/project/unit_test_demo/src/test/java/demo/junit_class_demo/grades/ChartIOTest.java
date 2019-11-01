package demo.junit_class_demo.grades;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Assert.*;
import java.util.Arrays;

import java.io.File;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class ChartIOTest {

	ChartIO io = new ChartIO();
	//@Test
	/*public void test_readFile_happyPath() {

	}
	*/


	@Test (expected = IllegalArgumentException.class)
	public void test_readFile_SadPath() {
		assertEquals( new IllegalArgumentException("File " + "asdasfdzad" + " does not exist"),io.readFile("asdasfdzad"));
	}

	@Test (expected = NumberFormatException.class)
	public void test_readFile_NumberFormatEx() {
		File file = new File(getClass().getClassLoader().getResource("grades_invalid.csv").getFile());
		io.readFile(file.getAbsolutePath());
	}

	@Test
	public void test_readFile_Array() {



	}

}
