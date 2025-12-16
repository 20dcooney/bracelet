package bracelet;

public class Bracelet1<T> implements BraceletKernel<T> {

    /**
     * Node class for singly linked list nodes.
     */
    private final class Node {

        /**
         * Data in node.
         */
        private T data;

        /**
         * Previous node in doubly linked list, or null.
         */
        private Node prev;

        /**
         * Next node in doubly linked list, or null.
         */
        private Node next;

    }

    private Node front;

    private Node end;

    private Node pointer;

    private int length;

    public Bracelet1() {
        this.createNewRep();
    }

    private void createNewRep() {

        this.front = new Node();

        this.end = new Node();

        this.front.prev = this.end;

        this.end.next = this.front;

        this.pointer.prev = this.front;
        this.pointer.next = this.end;

        this.length = 0;
    }

    @Override
    public void add(T x) {

        assert x.getClass().equals(this.getClass())
                : "Violation of: x is the same type as contained in this";

        Node temp = new Node();

        temp.data = x;
        temp.prev = this.pointer.prev;
        temp.next = this.pointer.next;

        this.pointer.next = temp;

        this.length++;

    }

    @Override
    public T remove() {
        assert this.length > 0 : "Violation of: |this| > 0";

        Node removedNode = this.pointer.next;

        return null;
    }

    @Override
    public void removeEntry(T x) {
        // TODO Auto-generated method stub

    }

    @Override
    public void movePointerLeft() {
        // TODO Auto-generated method stub

    }

    @Override
    public void movePointerRight() {
        // TODO Auto-generated method stub

    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        return 0;
    }

}
