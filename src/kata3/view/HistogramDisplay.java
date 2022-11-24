package kata3.view;

import kata3.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class HistogramDisplay extends ApplicationFrame {

    private final Histogram<String> histogram;

    public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);

        this.histogram = histogram;

        this.setContentPane(createJPanel());

        this.pack();
    }

    public void execute() {
        setVisible(true);
    }

    public JPanel createJPanel() {
        JPanel jPanel = new ChartPanel(createChart(createDataSet()));

        jPanel.setPreferredSize(new Dimension(500, 400));

        return jPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset defaultCategoryDataset) {
        return ChartFactory.createBarChart(
                "Histograma JFreeChart",
                "Dominios email",
                "Nº de emails",
                defaultCategoryDataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
    }

    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (String key: histogram.keySet()) {
            dataset.addValue(
                    histogram.get(key),
                    "",
                    key
            );
        }

        return dataset;
    }
}
