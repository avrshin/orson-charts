/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, by Object Refinery Limited.
 * 
 */

package com.orsoncharts.demo;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.orsoncharts.ChartPanel3D;
import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.axis.NumberTickSelector;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.KeyedValues;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.renderer.category.StandardCategoryColorSource;

/**
 * A demo of a 3D line chart.
 */
public class LineChart3DDemo1 extends JFrame {

    /**
     * Creates a new test app.
     *
     * @param title  the frame title.
     */
    public LineChart3DDemo1(String title) {
        super(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(createDemoPanel());
    }

    /**
     * Returns a panel containing the content for the demo.  This method is
     * used across all the individual demo applications to allow aggregation 
     * into a single "umbrella" demo (OrsonChartsDemo).
     * 
     * @return A panel containing the content for the demo.
     */
    public static JPanel createDemoPanel() {
        DemoPanel content = new DemoPanel(new BorderLayout());
        content.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        CategoryDataset3D dataset = createDataset();
        Chart3D chart = Chart3DFactory.createLineChart(
                "Web Browser Market Share", 
                "Source: http://gs.statcounter.com", dataset, null, null, 
                "Market Share (%)");
        CategoryPlot3D plot = (CategoryPlot3D) chart.getPlot();
        plot.setDimensions(new Dimension3D(18, 8, 4));
        plot.getRowAxis().setVisible(false);
        NumberAxis3D valueAxis = (NumberAxis3D) plot.getValueAxis();
        valueAxis.setTickSelector(new NumberTickSelector(true));
        plot.getRenderer().setColorSource(new StandardCategoryColorSource(
                Colors.getColors1()));
        chart.setViewPoint(ViewPoint3D.createAboveViewPoint(30));
        ChartPanel3D chartPanel = new ChartPanel3D(chart);
        content.setChartPanel(chartPanel);
        chartPanel.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        content.add(new DisplayPanel3D(chartPanel));
        return content;
    }
  
    /**
     * Creates a sample dataset (hard-coded for the purpose of keeping the
     * demo self-contained - in practice you would normally read your data
     * from a file, database or other source).
     * 
     * @return A sample dataset.
     */
    private static CategoryDataset3D createDataset() {
        StandardCategoryDataset3D dataset = new StandardCategoryDataset3D();
        dataset.addSeriesAsRow("Safari", createSafariData());
        dataset.addSeriesAsRow("Firefox", createFirefoxData());
        dataset.addSeriesAsRow("Internet Explorer", createInternetExplorerData());
        dataset.addSeriesAsRow("Chrome", createChromeData());
        return dataset;
    }

    private static KeyedValues createChromeData() {
        DefaultKeyedValues series = new DefaultKeyedValues();
        series.put("Jan-12", 0.2840);
        series.put("Feb-12", 0.2984);
        series.put("Mar-12", 0.3087);
        series.put("Apr-12", 0.3123);
        series.put("May-12", 0.3243);
        series.put("Jun-12", 0.3276);
        series.put("Jul-12", 0.3381);
        series.put("Aug-12", 0.3359);
        series.put("Sep-12", 0.3421);
        series.put("Oct-12", 0.3477);
        series.put("Nov-12", 0.3572);
        series.put("Dec-12", 0.3642);

        series.put("Jan-13", 0.3652);
        series.put("Feb-13", 0.3709);
        series.put("Mar-13", 0.3807);
        series.put("Apr-13", 0.3915);
        series.put("May-13", 0.4138);
        series.put("Jun-13", 0.4268);
        return series;
    }

    private static KeyedValues createFirefoxData() {
        DefaultKeyedValues series = new DefaultKeyedValues();
        series.put("Jan-12", 0.2478);
        series.put("Feb-12", 0.2488);
        series.put("Mar-12", 0.2498);
        series.put("Apr-12", 0.2487);
        series.put("May-12", 0.2555);
        series.put("Jun-12", 0.2456);
        series.put("Jul-12", 0.2373);
        series.put("Aug-12", 0.2285);
        series.put("Sep-12", 0.2240);
        series.put("Oct-12", 0.2232);
        series.put("Nov-12", 0.2237);
        series.put("Dec-12", 0.2189);
        series.put("Jan-13", 0.2142);
        series.put("Feb-13", 0.2134);
        series.put("Mar-13", 0.2087);
        series.put("Apr-13", 0.2006);
        series.put("May-13", 0.1976);
        series.put("Jun-13", 0.2001);
        return series;
    }

    private static KeyedValues createInternetExplorerData() {
        DefaultKeyedValues series = new DefaultKeyedValues();
        series.put("Jan-12", 0.3745);
        series.put("Feb-12", 0.3575);
        series.put("Mar-12", 0.3481);
        series.put("Apr-12", 0.3407);
        series.put("May-12", 0.3212);
        series.put("Jun-12", 0.3231);
        series.put("Jul-12", 0.3204);
        series.put("Aug-12", 0.3285);
        series.put("Sep-12", 0.3270);
        series.put("Oct-12", 0.3208);
        series.put("Nov-12", 0.3123);
        series.put("Dec-12", 0.3078);
        series.put("Jan-13", 0.3069);
        series.put("Feb-13", 0.2982);
        series.put("Mar-13", 0.2930);
        series.put("Jun-13", 0.2544);
        series.put("May-13", 0.2772);
        series.put("Apr-13", 0.2971);
        return series;
    }
//
    private static KeyedValues createSafariData() {
        DefaultKeyedValues series = new DefaultKeyedValues();
        series.put("Jan-12", 0.0662);
        series.put("Feb-12", 0.0677);
        series.put("Mar-12", 0.0672);
        series.put("Apr-12", 0.0713);
        series.put("May-12", 0.0709);
        series.put("Jun-12", 0.0700);
        series.put("Jul-12", 0.0712);
        series.put("Aug-12", 0.0739);
        series.put("Sep-12", 0.0770);
        series.put("Oct-12", 0.0781);
        series.put("Nov-12", 0.0783);
        series.put("Dec-12", 0.0792);
        series.put("Jan-13", 0.0830);
        series.put("Feb-13", 0.0860);
        series.put("Mar-13", 0.0850);
        series.put("Apr-13", 0.0800);
        series.put("May-13", 0.0796);
        series.put("Jun-13", 0.0839);
        return series;
    }
    
    /**
     * Starting point for the app.
     *
     * @param args  command line arguments (ignored).
     */
    public static void main(String[] args) {
        LineChart3DDemo1 app = new LineChart3DDemo1(
                "OrsonCharts: LineChart3DDemo1.java");
        app.pack();
        app.setVisible(true);
    }
}

