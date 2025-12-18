package bracelet;

import java.util.List;

/**
 * A circular double-linked list for generic data types. Bracelets are capable
 * of indefinitely looping upon themselves when performing actions that involve
 * cycling through the Bracelet. This can be done both from "left-to-right" and
 * "right-to-left".
 *
 * @param <T>
 *            The type of elements in this bracelet
 *
 * @author David Cooney
 */
public interface Bracelet<T> extends BraceletKernel<T> {

    /**
     * Adds an object to the front of this.
     *
     * @param x
     *            The object to be added
     * @ensures this = x * #this
     */
    void addToFront(T x);

    /**
     * Removes an object from the front of this.
     *
     * @requires |this| > 0
     * @ensures this = [#this with front object removed]
     *
     * @return [front object]
     */
    T removeFromFront();

    /**
     * Adds an object to the end of this.
     *
     * @param x
     *            The object to be added
     * @ensures this = #this * x
     */
    void addToEnd(T x);

    /**
     * Removes an object from the end of this.
     *
     * @requires |this| > 0
     * @ensures this = [#this with end object removed]
     * @return [end object]
     */
    T removeFromEnd();

    /**
     * Removes requested object from the Bracelet.
     *
     * @param x
     *            The object to be removed.
     * @requires [x is in this]
     * @requires |this| > 0
     * @ensures this = [#this with x removed]
     *
     * @returns [Object data in the given node]
     */
    T removeEntry(T x);

    /**
     * Removes the object that is {@code n} objects away from the pointer's
     * current position. Capable of looping through the full {@code bracelet}.
     *
     * @param n
     *            The distance from the object to be removed
     * @requires |this| > 0
     * @ensures this = [#this with object n spaces away removed]
     * @return [object n spaces away from pointer]
     */
    T removeNthNextItem(int n);

    /**
     * Converts the bracelet into an {@code ArrayList<T>}, where T is the object
     * type of the bracelet objects.
     *
     * @clears this
     * @ensures this = <>
     * @ensures {@code ArrayList<T>} contains all objects from #this
     * @return [ArrayList containing objects from #this]
     */
    List<T> flatten();

    /**
     * Determines the object held at the front of this and returns it.
     *
     * @restores this
     * @ensures this = #this
     * @return [Object at the front of this]
     */
    T pollFront();

    /**
     * Determines the object held at the end of this and returns it.
     *
     * @restores this
     * @ensures this = #this
     * @return [Object at the end of this]
     */
    T pollEnd();

    /**
     * Determines the object held at the {@code pos} position of this and
     * returns it. Begins at index 1.
     *
     * @param pos
     *            The position to poll from
     * @restores this
     * @requires pos <= |this|
     * @ensures this = #this
     * @return [Object at the end of this]
     */
    T pollPosition(int pos);

//    void movePointerToFront();
//
//    void movePointerToEnd();

}
