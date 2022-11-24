package kata3;

import kata3.model.Email;
import kata3.model.Histogram;
import kata3.model.MailHistogramFactory;
import kata3.model.persistence.files.EmailLoader;
import kata3.model.persistence.files.FileLoader;
import kata3.view.HistogramDisplay;

import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Iterable<Email> entry = new EmailLoader(new FileLoader(new File("emails.txt"))).items();
        entry.forEach(System.out::println);

        Histogram<String> histogram = MailHistogramFactory.create(entry);

        SwingUtilities.invokeLater(() -> {
            HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM", histogram);
            histogramDisplay.execute();
        });
    }
}
