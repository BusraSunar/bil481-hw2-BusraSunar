package demo.junit_class_demo.grades;

import org.jfree.chart.JFreeChart;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Assert.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import java.io.File;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class ChartIOTest {

	ChartIO io = new ChartIO();

	@Test
	public void test_readFile_happyPath() {
		File file = new File(getClass().getClassLoader().getResource("grades_normal.csv").getFile());
		int[] arr=io.readFile(file.getAbsolutePath());

		int[] realArr={15,10,0};
		for (int i=0;i<arr.length;i++){
			assertEquals(arr[i],realArr[i]);
		}

	}

	@Test (expected = IllegalArgumentException.class)
	public void test_readFile_SadPath() {
		assertEquals( new IllegalArgumentException("File " + "asdasfdzad" + " does not exist"),io.readFile("asdasfdzad"));
	}

	@Test (expected = NumberFormatException.class)
	public void test_readFile_NumberFormat() {
		File file = new File(getClass().getClassLoader().getResource("grades_invalid.csv").getFile());
		io.readFile(file.getAbsolutePath());
		//neden numberformatexception almiyor anlamadim

	}
	@Mock
	JFreeChart jfc= Mockito.mock(JFreeChart.class);

	@Test (expected = IOException.class)
	public void testWriteFile(){

		File file = new File(getClass().getClassLoader().getResource("grades_invalid.csv").getFile());
		io.writeFile(file.getAbsolutePath(),jfc);


	}


}
