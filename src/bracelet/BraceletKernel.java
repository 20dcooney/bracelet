package bracelet;

/**
 * Kernel for Bracelet data-type, a structure using circular Double-Linked List
 * fundamentals.
 *
 * @param <T>
 *            The element type contained in the Bracelet
 *
 * @author David Cooney
 */
public interface BraceletKernel<T> {

    /**
     * Adds an entry to the right of the current position of the pointer.
     *
     * <p>
     * Updates this
     * </p>
     * <p>
     *
     * Ensures this = [left-side of pointer] * x * [right-side of pointer]
     * </p>
     *
     * @param x
     *            The object to be added.
     *
     */
    void add(T x);

    /**
     * Removes the object to the right of the pointer.
     *
     * <p>
     * Requires |[right-side of pointer]| is greater than 0
     * </p>
     *
     * @return [object in Bracelet]
     */
    T remove();

    /**
     * Advance the pointer one position to the left.
     * <p>
     * Requires |[left-side of pointer]| is greater than 0
     * </p>
     * <p>
     * Ensures |[left-side of pointer]| - 1 AND |[left-side of pointer]| + 1
     * </p>
     */
    void movePointerLeft();

    /**
     * Advance the pointer one position to the right.
     *
     * <p>
     * Requires |[right-side of pointer]| is greater than 0
     * </p>
     *
     * <p>
     * Ensures |[left-side of pointer]| + 1 AND |[left-side of pointer]| - 1
     * </p>
     */
    void movePointerRight();

    /**
     * Reports the length (amount of objects) in this.
     *
     * <p>
     * Ensures |this| = [amount of objects in this]
     * </p>
     *
     * @return |this|
     */
    int length();

    /**
     * Clears all objects from this.
     * <p>
     * Ensures this is empty
     * </p>
     */
    void clear();

}
