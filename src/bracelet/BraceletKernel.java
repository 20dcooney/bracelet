package bracelet;

/**
 * Kernel for Bracelet data-type, a structure using circular Double-Linked List
 * fundamentals.
 *
 * @author David Cooney
 */
public interface BraceletKernel<T> {

    /**
     * Adds an entry to the right of the current position of the pointer.
     *
     *
     * @param x
     *            The object to be added.
     * @updates this
     * @ensures this = [left-side of pointer] * x * [right-side of pointer]
     */
    void add(T x);

    /**
     * Removes the object to the right of the pointer.
     *
     * @requires |[right-side of pointer]| > 0
     *
     * @return [object in Bracelet]
     */
    T remove();

    /**
     * Advance the pointer one position to the left.
     *
     * @requires |[left-side of pointer]| > 0
     * @ensures |[left-side of pointer]| - 1 && |[left-side of pointer]| + 1
     */
    void movePointerLeft();

    /**
     * Advance the pointer one position to the right.
     *
     * @requires |[right-side of pointer]| > 0
     * @ensures |[left-side of pointer]| + 1 && |[left-side of pointer]| - 1
     */
    void movePointerRight();

    /**
     * Reports the length (amount of objects) in this.
     *
     * @ensures |this| = [amount of objects in this]
     * @return |this|
     */
    int length();

}
