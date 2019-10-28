package grades;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Assert.*;

import static junit.framework.TestCase.assertEquals;

public class ChartIOTest {
	
	ChartIO io = new ChartIO();
	@Test
	public void test_readFile_happyPath() {
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_readFile_SadPath() {
		io.readFile("asdasfdzad");
		assertEquals( new IllegalArgumentException("File " + "asdasfdzad" + " does not exist"),io.readFile("asdasfdzad"));
	}
	
	
}
