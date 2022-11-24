package kata3.model.persistence.files;

public interface Loader<T> {
    Iterable<T> items();
}
