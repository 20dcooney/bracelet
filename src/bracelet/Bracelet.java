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

    /**
     * Removes requested object from the Bracelet.
     *
     * @param x
     *            The object to be removed.
     * @ensures this = [#this with x removed]
     */
    void removeEntry(T x);

    T pollFront();

    T pollEnd();

    T pollPosition(int pos);

    void movePointerToFront();

    void movePointerToEnd();
}
