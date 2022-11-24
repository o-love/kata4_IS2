package kata3.model.persistence.files;

import kata3.model.persistence.Loader;

import java.io.*;
import java.util.Iterator;

public class FileLoader implements Loader<String> {

    private final File file;

    public FileLoader(File file) {
        this.file = file;
    }

    @Override
    public Iterable<String> items() {
        return this::createIterator;
    }

    private Iterator<String> createIterator() {
        return new Iterator<>() {
            final BufferedReader bufferedReader = createBufferedReader();
            String nextLine = readNext();

            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public String next() {
                String toRet = nextLine;
                nextLine = readNext();
                return toRet;
            }

            private String readNext() {
                try {
                    return bufferedReader.readLine();
                } catch (IOException e) {
                    return null;
                }
            }
        };
    }

    private BufferedReader createBufferedReader() {
        try {
            return new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            return (BufferedReader) BufferedReader.nullReader();
        }
    }

}


