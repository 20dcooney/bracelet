package bracelet;

import java.util.List;

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
     * @requires [x is in this]
     * @ensures this = [#this with x removed]
     *
     * @returns [Object data in the given node]
     */
    T removeEntry(T x);

    T removeNthNextItem(int n);

    List<T> flatten();

    T pollFront();

    T pollEnd();

    T pollPosition(int pos);

//    void movePointerToFront();
//
//    void movePointerToEnd();

}
