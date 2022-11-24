package kata3.model.persistence;

public interface Loader<T> {
    Iterable<T> items();
}
