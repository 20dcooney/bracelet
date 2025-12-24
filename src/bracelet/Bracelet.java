package bracelet;

import java.util.List;

/**
 * A circular double-linked list for generic data types. Bracelets are capable
 * of indefinitely looping upon themselves when performing actions that involve
 * cycling through the Bracelet. This can be done both from "left-to-right" and
 * "right-to-left".
 *
 * <p>
 * Bracelet does not require elements it contains to be unique. Therefore,
 * "duplicate" elements are capable of being added to a Bracelet.
 * </p>
 *
 * <p>
 * Bracelet functions as a series of nodes that contain their designated data,
 * the identity of the node ahead of it, and the identity of the node behind it.
 * Bracelet also contains a {@code pointer} node, which is not part of the
 * double-linked list itself, but tracks a node in the double-linked list. Core
 * functions such as adding and removing elements to the list are performed
 * around this {@code pointer} node. The {@code pointer} can be moved through
 * the list to perform methods at that point in the list.
 * </p>
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
     *
     * <p>
     * Ensures this = x * #this
     * </p>
     *
     * @param x
     *            The object to be added.
     *
     */
    void addToFront(T x);

    /**
     * Removes an object from the front of this.
     *
     * <p>
     * Requires |this| > 0
     * </p>
     * <p>
     *
     * Ensures this = [#this with front object removed]
     * </p>
     *
     * @return [front object]
     */
    T removeFromFront();

    /**
     * Adds an object to the end of this.
     * <p>
     * Ensures this = #this * x
     * </p>
     *
     * @param x
     *            The object to be added
     *
     */
    void addToEnd(T x);

    /**
     * Removes an object from the end of this.
     *
     * <p>
     * Requires |this| is greater than 0
     * </p>
     * <p>
     * Ensures this = [#this with end object removed]
     * </p>
     *
     * @return [end object]
     */
    T removeFromEnd();

    /**
     * Removes requested object from the Bracelet.
     *
     * {@code Bracelet} allows for duplicate elements to be contained with
     * itself. When calling upon {@code removeEntry(x)} to remove an element
     * with multiple appearances in {@code this}, the instance of the element
     * closest to the front of {@code this} will be removed.
     *
     * <p>
     * Requires [x is in this]
     * </p>
     * <p>
     * Requires |this| is greater than 0
     * </p>
     * <p>
     * Ensures this = [#this with x removed]
     * </p>
     *
     * @param x
     *            The object to be removed.
     *
     *
     * @return [Object data in the given node]
     */
    T removeEntry(T x);

    /**
     * Removes the object that is {@code n} objects away from the pointer's
     * current position. Capable of looping through the full {@code bracelet}.
     *
     * <p>
     * Requires |this| is greater than 0
     * </p>
     * <p>
     * Requires n is greater than 0
     * </p>
     * <p>
     * Ensures this = [#this with object n spaces away removed]
     * </p>
     *
     * @param n
     *            The distance from the object to be removed
     * @return [object n spaces away from pointer]
     */
    T removeNthNextItem(int n);

    /**
     * Converts the bracelet into an {@code ArrayList<T>}, where T is the object
     * type of the bracelet objects.
     *
     * <p>
     * Clears this
     * </p>
     * <p>
     * Ensures this is empty
     * </p>
     * <p>
     * Ensures {@code ArrayList<T>} contains all objects from #this
     * </p>
     *
     * @return [ArrayList containing objects from #this]
     */
    List<T> flatten();

    /**
     * Determines the object held at the front of this and returns it.
     *
     * <p>
     * Restores this
     * </p>
     * <p>
     * Ensures this = #this
     * </p>
     *
     * @return [Object at the front of this]
     */
    T pollFront();

    /**
     * Determines the object held at the end of this and returns it.
     *
     * <p>
     * Restores this
     * </p>
     * <p>
     * Ensures this = #this
     * </p>
     *
     * @return [Object at the end of this]
     */
    T pollEnd();

    /**
     * Determines the element held to the right of {@code pointer} node and
     * returns it.
     *
     * @return [Element to the right of the {@code pointer}]
     */
    T pollPointerPosition();

    /**
     * Determines the object held at the {@code pos} position of this and
     * returns it. Begins at index 1.
     * <p>
     * Restores this
     * </p>
     * <p>
     * Requires pos is less than or equal to |this| Ensures this = #this
     * </p>
     *
     * @param pos
     *            The position to poll from
     *
     * @return [Object at the end of this]
     */
    T pollPosition(int pos);

    /**
     * Moves the current pointer position to the Front node. The element to the
     * right of the pointer is the first element in the bracelet.
     */
    void movePointerToFront();

    /**
     * Moves the current pointer position to the End node. The element to the
     * left of the pointer is the last element in the bracelet.
     */
    void movePointerToEnd();

}
