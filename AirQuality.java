import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.util.HashMap;

public class AirQuality {
    HashMap<String, Double> airQualityMap = new HashMap<>();
    String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    double[] PM25 = {12.5, 15.2, 18.3, 11.4, 20.0, 25.3, 30.5};

    public void populateAirQuality() {
        for (int i = 0; i < days.length; i++) {
            airQualityMap.put(days[i], PM25[i]);
        }
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < days.length; i++) {
            dataset.addValue(PM25[i], "PM2.5", days[i]);
        }
        return dataset;
    }

    public void showChart() {
        JFreeChart chart = ChartFactory.createBarChart(
            "Weekly Air Quality Report",  // Main title
            "Day of Week",                // X-axis label
            "PM2.5 (µg/m³)",              // Y-axis label
            createDataset()               // Proper dataset type
        );

        ChartFrame frame = new ChartFrame("Air Quality Dashboard", chart);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AirQuality aq = new AirQuality();
        aq.populateAirQuality();
        aq.showChart();
    }
}

