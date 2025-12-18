package bracelet;

/**
 * Implementation of BraceletKernel interface.
 *
 * A circular double-linked list.
 *
 * @param <T>
 *            The type of {@code Bracelet} entries
 *
 * @author David Cooney
 */
public class Bracelet1<T> implements BraceletKernel<T> {

    /**
     * Node class for bracelet nodes.
     */
    public final class Node {

        /**
         * Data in node.
         */
        public T data;

        /**
         * Previous node in bracelet, or null.
         */
        public Node prev;

        /**
         * Next node in bracelet, or null.
         */
        public Node next;

    }

    /**
     * Smart node that signifies the beginning of the bracelet. {front}'s data
     * value will always be null.
     */
    public Node front;

    /**
     * Smart node that signifies the ending of the bracelet. {end}'s data value
     * will always be null.
     */
    public Node end;

    /**
     * Smart node that acts as a reference point for actions performed on the
     * bracelet. Actions are performed to the [right-side] of the pointer.
     *
     */
    public Node pointer;

    /**
     * The amount of {@code Object}s stored in the bracelet. The {front}, {end},
     * and {pointer} smart nodes are not a part of this value.
     */
    private int length;

    /**
     * No arguments constructor.
     */
    public Bracelet1() {
        this.createNewRep();
    }

    /**
     * Initializes all necessary Nodes and variables for a new representation of
     * bracelet.
     */
    private void createNewRep() {

        this.front = new Node();
        this.end = new Node();

        //Links the front and end
        this.front.next = this.end;
        this.end.prev = this.front;

        //Creates the "repeating loop" with the front and end
        this.front.prev = this.end;
        this.end.next = this.front;

        this.pointer = this.front;

        this.length = 0;
    }

    @Override
    public void add(T x) {

        Node nodeToAdd = new Node();
        nodeToAdd.data = x;

        nodeToAdd.prev = this.pointer;
        nodeToAdd.next = this.pointer.next;

        this.pointer.next.prev = nodeToAdd;
        this.pointer.next = nodeToAdd;

        this.pointer = this.pointer.next;

        this.length++;

    }

    @Override
    public T remove() {
        assert this.length > 0 : "Violation of: |this| > 0";

        T returnObj = this.pointer.next.data;

        this.pointer.next.next.prev = this.pointer;
        this.pointer.next = this.pointer.next.next;

        this.length--;

        return returnObj;
    }

    @Override
    public void movePointerLeft() {

        this.pointer = this.pointer.prev;
        if (this.pointer.data == null) {
            this.pointer = this.pointer.prev.prev;
        }

    }

    @Override
    public void movePointerRight() {

        this.pointer = this.pointer.next;
        if (this.pointer.data == null) {
            this.pointer = this.pointer.next.next;
        }

    }

    @Override
    public int length() {

        return this.length;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

}
