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
        new Main().executeAll();
    }

    private Iterable<Email> entry;
    private Histogram<String> histogram;

    public void executeAll(){
        this.getInput();

        this.processInput();

        this.produceOutput();
    }

    public void getInput() {
        entry = new EmailLoader(new FileLoader(new File("emails.txt"))).items();
    }

    public void processInput() {
        histogram = MailHistogramFactory.create(entry);
    }

    public void produceOutput() {
        SwingUtilities.invokeLater(() -> {
            HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM", histogram);
            histogramDisplay.execute();
        });
    }
}
