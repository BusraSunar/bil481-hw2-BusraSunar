package demo.junit_class_demo.grades;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.jfree.chart.JFreeChart;

import java.io.FileNotFoundException;

public class HistogramGeneratorTest {

    HistogramGenerator hg;
    HistogramMain hm=new HistogramMain();

    public HistogramGeneratorTest(){
        ChartIO chartIO=new ChartIO();
        hg=new HistogramGenerator(chartIO);
        //emin degilim
    }

	@Test
	public void test_generate_normal() {



	}
	@Test
    public void testCalcukateFreq(){
	    int [] grades ={1,2,2,3,3};
	    int [] freq={0,1,2,2,0,0,0,0,0,0,0};
	  for (int i=0;i<freq.length;i++)
	      assertEquals(freq[i],hg.calculateFrequencies(grades)[i]);

    }

	@Test
	public void testCreateChart(){
		int [] freq={0,1,2,2,0,0,0,0,0,0,0};
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries data = new XYSeries("random values");
		for (int i = 0; i < freq.length; i++) {
			data.add(i, freq[i]);
		}
		dataset.addSeries(data);
		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls
		JFreeChart chart = ChartFactory.createXYLineChart("Grades' Frequency", "grade", "frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		assertTrue(hg.createChart(freq).equals(chart));
	}
	//exportchartla generatehistogram larin testlerini yapamiyorm cunku writefile imin testi zaten yanlis
	@Test(expected = FileNotFoundException.class)
	public void histogramMainTest(){


	}


}
