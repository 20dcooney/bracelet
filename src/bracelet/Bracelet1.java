package bracelet;

/**
 * Implementation of BraceletKernel interface.
 *
 * A circular doubly-linked list.
 *
 * @param <T>
 *            The type of {@code Bracelet} entries
 *
 * @author David Cooney
 */
public class Bracelet1<T> implements BraceletKernel<T> {

    /**
     * Node class for doubly linked list nodes.
     */
    public final class Node {

        /**
         * Data in node.
         */
        public T data;

        /**
         * Previous node in doubly linked list, or null.
         */
        public Node prev;

        /**
         * Next node in doubly linked list, or null.
         */
        public Node next;

        /**
         * Compares this with another node to check for equality.
         *
         * @param n
         *            The node to be compared
         * @return [Equality of the two nodes]
         */
        public boolean equals(Node n) {
            boolean isEqual = true;

            try {

                if (!this.data.equals(n.data)) {
                    isEqual = false;
                }
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                if (this.data != null && n.data != null) {
                    isEqual = false;
                }
            }
            try {
                if (!this.next.data.equals(n.next.data)) {
                    isEqual = false;
                }
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                if (this.next.data != null && n.next.data != null) {
                    isEqual = false;
                }
            }
            try {
                if (!this.prev.data.equals(n.prev.data)) {
                    isEqual = false;
                }
            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
                if (this.prev.data != null && n.prev.data != null) {
                    isEqual = false;
                }
            }
            return isEqual;
            //TODO - potentially remove this method.
        }

    }

    public Node front;

    public Node end;

    public Node pointer;

    private int length;

    public Bracelet1() {
        this.createNewRep();
    }

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

        /*
         * TODO - Experiment with major ways to change the structure of this
         * loop. Removing the front and end nodes and directly connecting the
         * "front" and "end" will remove nullpointer issues.
         */
    }

    @Override
    public void add(T x) {

        //TODO - Fix this assertion
        /*
         * assert x.getClass().equals(this.getClass()) :
         * "Violation of: x is the same type as contained in this";
         */

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

        this.pointer = this.pointer.next;

    }

    @Override
    public void movePointerRight() {

        this.pointer = this.pointer.prev;

    }

    @Override
    public int length() {

        return this.length;
    }

}
