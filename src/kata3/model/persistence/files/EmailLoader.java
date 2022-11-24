package kata3.model.persistence.files;

import kata3.model.Email;

import java.util.Iterator;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EmailLoader implements Loader<Email> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    private final Loader<String> loader;

    public EmailLoader(Loader<String> loader) {
        this.loader = loader;
    }

    @Override
    public Iterable<Email> items() {
        return this::createIterator;
    }

    private Iterator<Email> createIterator() {
        return new Iterator<>() {
            private final Iterator<String> iterator = loader.items().iterator();
            private String nextEmail = readNextEmail();

            @Override
            public boolean hasNext() {
                return nextEmail != null;
            }

            @Override
            public Email next() {
                String toRet = nextEmail;
                nextEmail = readNextEmail();
                return new Email(toRet);
            }

            private String readNextEmail() {
                Predicate<String> tester = EMAIL_PATTERN.asMatchPredicate();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (tester.test(next))
                        return next;
                }
                return null;
            }
        };
    }
}
