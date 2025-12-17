package bracelet;

import java.util.ArrayList;

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

    @Override
    public T pollPosition(int pos) {

        assert this.length() > 0 : "Violation of: |this| > 0";

        Node storeNode = this.storePosition();

        this.movePointerToFront();

        for (int i = 0; i < this.length(); i++) {
            this.pointer = this.pointer.next;
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

        String printString = "Items contained in bracelet: ";

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

    private Node storePosition() {

        return this.pointer;
    }

    @Override
    public T removeNthNextItem(int n) {

        assert this.length() > 0 : "Violation of: |this| > 0";

        Node storeNode = this.storePosition();

        for (int i = 0; i < this.length(); i++) {

            if (this.pointer.next.equals(this.end)) {
                this.pointer = this.pointer.next.next;
            } else {
                this.pointer = this.pointer.next;
            }
        }

        T returnObj = this.remove();
        this.pointer = storeNode;

        return returnObj;
    }

    @Override
    public ArrayList<T> flatten() {

        ArrayList<T> returnList = new ArrayList<>();

        this.movePointerToFront();

        for (int i = 0; i < this.length(); i++) {
            returnList.add(this.remove());
        }

        return returnList;
    }

}
