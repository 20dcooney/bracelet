package bracelet;

/**
 * Bracelet interface.
 *
 * @param <T>
 *            The data type of the user's choosing.
 *
 * @author David Cooney
 */
public interface Bracelet<T> extends BraceletKernel<T> {

    void addToFront(T x);

    T removeFromFront();

    void addToEnd(T x);

    T removeFromEnd();

    T pollFront();

    T pollEnd();

    T pollPosition(int pos);

    void movePointerToFront();

    void movePointerToEnd();
}
