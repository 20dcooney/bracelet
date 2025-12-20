package bracelet;

import java.util.ArrayList;

/**
 * A secondary implementation of Bracelet that allows for more flexibility with
 * adding, removing, and cycling through the bracelet.
 *
 * @param <T>
 *            The type of elements in this bracelet
 *
 * @author David Cooney
 */
public class BraceletList<T> extends Bracelet1<T> implements Bracelet<T> {

    @Override
    public void addToFront(T x) {

        Node storeNode = this.storePosition();

        this.movePointerToFront();
        this.add(x);

        this.pointer = storeNode;
    }

    @Override
    public T removeFromFront() {

        assert this.length() > 0 : "Violation of: |this| > 0";

        Node storeNode = this.storePosition();

        this.movePointerToFront();

        T returnObject = this.remove();

        this.pointer = storeNode;

        return returnObject;
    }

    @Override
    public void addToEnd(T x) {

        Node storeNode = this.storePosition();

        this.movePointerToEnd();
        this.pointer = this.pointer.prev;
        this.add(x);

        this.pointer = storeNode;
    }

    @Override
    public T removeFromEnd() {

        assert this.length() > 0 : "Violation of: |this| > 0";

        Node storeNode = this.storePosition();

        this.movePointerToEnd();
        this.pointer = this.pointer.prev.prev;

        T returnObject = this.remove();

        this.pointer = storeNode;

        return returnObject;
    }

    @Override
    public T removeEntry(T x) {

        assert this.length() > 0 : "Violation of: |this| > 0";

        T returnObj = null;

        Node storeNode = this.storePosition();
        this.movePointerToFront();

        for (int i = 0; i < this.length(); i++) {
            if (this.pointer.next.data.equals(x)) {
                returnObj = this.remove();
                break;
            } else {
                this.pointer = this.pointer.next;
            }
        }

        assert returnObj != null : "Violation of: x is in this";

        this.pointer = storeNode;

        return returnObj;

    }

    @Override
    public T pollFront() {

        assert this.length() > 0 : "Violation of: |this| > 0";

        Node storeNode = this.storePosition();

        this.movePointerToFront();

        T returnObject = this.pointer.next.data;

        this.pointer = storeNode;

        return returnObject;

    }

    @Override
    public T pollEnd() {

        assert this.length() > 0 : "Violation of: |this| > 0";

        Node storeNode = this.storePosition();

        this.movePointerToEnd();

        T returnObject = this.pointer.prev.data;

        this.pointer = storeNode;

        return returnObject;

    }

    /*
     * TODO - Change the name of current "pollPosition" to "pollNthPosition".
     *
     * Create a new "pollPosition" that polls the position to the right of the
     * pointer.
     */

    @Override
    public T pollPosition(int pos) {

        assert this.length() > 0 : "Violation of: |this| > 0";

        Node storeNode = this.storePosition();

        this.movePointerToFront();

        for (int i = 1; i < pos; i++) {
            this.movePointerRight();
        }

        if (this.pointer.next.data == null) {
            this.movePointerToFront();
        }

        T returnObj = this.pointer.next.data;
        this.pointer = storeNode;

        return returnObj;
    }

    @Override
    public T pollPointerPosition() {

        Node storeNode = this.storePosition();

        if (this.pointer.next.data == null) {
            this.movePointerToFront();
        }

        T returnObj = this.pointer.next.data;

        this.pointer = storeNode;

        return returnObj;
    }

    @Override
    public void movePointerToFront() {

        this.pointer = this.front;

    }

    @Override
    public void movePointerToEnd() {

        this.pointer = this.end;

    }

    @Override
    public String toString() {

        String printString = (this.length() > 0) ? "Items contained in bracelet: "
                : "This bracelet is currently empty.";

        this.movePointerToFront();

        for (int i = 0; i < this.length(); i++) {

            printString += this.pointer.next.data;

            if (this.length() - i > 1) {
                printString += ", ";
            }

            this.pointer = this.pointer.next;

        }
        return printString;
    }

    //TODO - Complete
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {

        boolean equal = false;

        if (this == o) {
            return true;
        }

        if (this.getClass() == o.getClass()) {
            //Cast should always successfully complete given getClass() is equal.
            equal = this.compareElements(this, (Bracelet<T>) o);
        }

        return equal;
    }

    private boolean compareElements(Bracelet<T> thisBracelet, Bracelet<T> o) {

        boolean equal = true;

        if (thisBracelet.length() != o.length()) {
            equal = false;
        } else {
            thisBracelet.movePointerToFront();
            o.movePointerToFront();

            for (int i = 0; i < thisBracelet.length(); i++) {
                if (!thisBracelet.pollPointerPosition().equals(o.pollPointerPosition())) {
                    equal = false;
                }
            }
        }

        return equal;
    }

    /**
     * Returns the {@code pointer}'s current position. Intended for storing the
     * current position in order to restore the {@code pointer} after performing
     * an action.
     *
     * @return [The current {@code pointer}]
     */
    private Node storePosition() {

        return this.pointer;
    }

    @Override
    public T removeNthNextItem(int n) {

        assert this.length() > 0 : "Violation of: |this| > 0";

        Node storeNode = this.storePosition();

        for (int i = 0; i < n - 1; i++) {
            this.movePointerRight();
        }

        T returnObj = this.remove();
        this.pointer = storeNode;

        return returnObj;
    }

    @Override
    public ArrayList<T> flatten() {

        ArrayList<T> returnList = new ArrayList<>();

        this.movePointerToFront();

        int count = this.length();

        for (int i = 0; i < count; i++) {
            returnList.add(this.remove());
        }

        return returnList;
    }

}
