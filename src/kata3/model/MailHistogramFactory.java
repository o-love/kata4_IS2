package kata3.model;

public class MailHistogramFactory {

    public static Histogram<String> create(Iterable<Email> emails) {
        Histogram<String> histogram = new Histogram<>();

        for (Email email : emails) {
            histogram.increment(email.getDomain());
        }

        return histogram;
    }
}
