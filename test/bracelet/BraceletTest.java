package bracelet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BraceletTest {

    Bracelet<String> bracelet;
    Bracelet<String> expected;

    /**
     * Prepares two Bracelets for all test cases. Initializes
     * {@code this.bracelet} with a set of String elements, and initializes
     * {@code this.expected} as an empty Bracelet to be used as needed per test
     * case.
     */
    @BeforeEach
    void setUp() {
        this.bracelet = new BraceletList<>();

        this.bracelet.add("this");
        this.bracelet.add("is");
        this.bracelet.add("a");
        this.bracelet.add("test");

        this.expected = new BraceletList<>();
    }

    /**
     * Compares a pre-made {@code Bracelet} with a {@code Bracelet} that has had
     * its order altered by a method, to ensure that the {@code .next}
     * connections are equal.
     *
     * @param <T>
     *            The element type of the {@code Bracelet}s
     * @param expected
     *            Pre-made Bracelet that the test Bracelet intends to match
     * @param test
     *            Bracelet with an order altering method called upon it
     */
    private <T> void testNextConnections(Bracelet<T> expected, Bracelet<T> test) {

        expected.movePointerToFront();
        test.movePointerToFront();

        for (int i = 0; i < this.bracelet.length(); i++) {
            assertEquals(this.expected.pollPointerPosition(),
                    this.bracelet.pollPointerPosition());

            this.bracelet.movePointerRight();
            this.expected.movePointerRight();
        }

    }

    /**
     * Compares a pre-made {@code Bracelet} with a {@code Bracelet} that has had
     * its order altered by a method, to ensure that the {@code .prev}
     * connections are equal.
     *
     * @param <T>
     *            The element type of the {@code Bracelet}s
     * @param expected
     *            Pre-made Bracelet that the test Bracelet intends to match
     * @param test
     *            Bracelet with an order altering method called upon it
     */
    private <T> void testPrevConnections(Bracelet<T> expected, Bracelet<T> test) {

        expected.movePointerToEnd();
        test.movePointerToEnd();

        for (int i = 0; i < this.bracelet.length(); i++) {
            assertEquals(this.expected.pollPointerPosition(),
                    this.bracelet.pollPointerPosition());

            this.bracelet.movePointerLeft();
            this.expected.movePointerLeft();
        }
    }

    /**
     * Tests the overridden equals() method. Expects to return true for
     * {@code this.pointer} and a Bracelet with identical elements.
     */
    @Test
    void testEqualsOverride() {

        this.expected.add("this");
        this.expected.add("is");
        this.expected.add("a");
        this.expected.add("test");

        assertEquals(this.expected, this.bracelet);
    }

    /**
     * Tests the clear() method. Expects {@code this.bracelet} equality with an
     * empty bracelet.
     *
     */
    @Test
    void testClear() {

        this.bracelet.clear();

        assertEquals(this.expected.length(), this.bracelet.length());
        assertEquals(this.expected, this.bracelet);

    }

    /**
     * Tests the overridden toString() method when {@code this.bracelet}
     * contains more than 0 elements. Expects {@code this.bracelet.toString()}
     * equality with a String matching the expected output.
     */
    @Test
    void testToStringNonEmpty() {
        String expected = "[this, is, a, test]";

        assertEquals(expected, this.bracelet.toString());

    }

    /**
     * Tests the overridden toString() method when {@code this.bracelet}
     * contains 0 elements. Expects {@code this.bracelet.toString()} equality
     * with a String matching the expected output.
     */
    @Test
    void testToStringEmpty() {
        String expected = "[]";

        this.bracelet.clear();

        assertEquals(expected, this.bracelet.toString());

    }

    /**
     * Tests the flatten() method. Expects {@code this.bracelet.flatten()}
     * equality with an ArrayList matching the expected output.
     */
    @Test
    void testFlatten() {
        List<String> expected = new ArrayList<>();
        expected.add("this");
        expected.add("is");
        expected.add("a");
        expected.add("test");

        List<String> test = this.bracelet.flatten();

        assertEquals(expected, test);

    }

    @Test
    void testRemoveThrowsErrorWhenBraceletIsEmpty() {

        String expected = "Violation of: |this| > 0";

        this.bracelet.clear();

        AssertionError e = assertThrows(AssertionError.class,
                () -> this.bracelet.remove(),
                "Expecting AssertionError due to this.bracelet being empty during the call of remove()");

        assertEquals(expected, e.getMessage());
    }

    /**
     * Tests the remove() method. Expects removed element equality with a
     * pre-made element of the expected output. Expects {@code this.bracelet}
     * equality to a pre-made Bracelet of the expected elements. Expects
     * equality of {@code Node} connections in {@code this.bracelet} and the
     * pre-made Bracelet with the expected elements, for both the {@code next}
     * and {@code prev] connections.
     */
    @Test
    void testRemove() {

        final int pointerCount = 2;

        this.expected.add("this");
        this.expected.add("is");
        this.expected.add("test");

        String expectedRemovedElement = "a";

        for (int i = 0; i < pointerCount; i++) {
            this.bracelet.movePointerRight();
        }

        String testRemovedElement = this.bracelet.remove();

        assertEquals(expectedRemovedElement, testRemovedElement);
        assertEquals(this.expected, this.bracelet);

        this.testNextConnections(this.expected, this.bracelet);
        this.testPrevConnections(this.expected, this.bracelet);

    }

    /**
     * Tests the removeFromFront() method. Expects removed element equality with
     * a pre-made element of the expected output. Expects {@code this.bracelet}
     * equality to a pre-made Bracelet of the expected elements. Expects
     * equality of {@code Node} connections in {@code this.bracelet} and the
     * pre-made Bracelet with the expected elements, for both the {@code next}
     * and {@code prev] connections.
     */
    @Test
    void testRemoveFromFront() {

        this.expected.add("is");
        this.expected.add("a");
        this.expected.add("test");

        String expectedRemovedElement = "this";

        String testRemovedElement = this.bracelet.removeFromFront();

        assertEquals(expectedRemovedElement, testRemovedElement);
        assertEquals(this.expected, this.bracelet);

        this.testNextConnections(this.expected, this.bracelet);
        this.testPrevConnections(this.expected, this.bracelet);

    }

    /**
     * Tests the removeFromEnd() method. Expects removed element equality with a
     * pre-made element of the expected output. Expects {@code this.bracelet}
     * equality to a pre-made Bracelet of the expected elements. Expects
     * equality of {@code Node} connections in {@code this.bracelet} and the
     * pre-made Bracelet with the expected elements, for both the {@code next}
     * and {@code prev] connections.
     */
    @Test
    void testRemoveFromEnd() {

        this.expected.add("this");
        this.expected.add("is");
        this.expected.add("a");

        String expectedRemovedElement = "test";

        String testRemovedElement = this.bracelet.removeFromEnd();

        assertEquals(expectedRemovedElement, testRemovedElement);
        assertEquals(this.expected, this.bracelet);

        this.testNextConnections(this.expected, this.bracelet);
        this.testPrevConnections(this.expected, this.bracelet);

    }

    @Test
    void testRemoveEntry() {

        this.expected.add("this");
        this.expected.add("a");
        this.expected.add("test");

        String expectedRemovedElement = "is";

        String testRemovedElement = this.bracelet.removeEntry("is");

        assertEquals(expectedRemovedElement, testRemovedElement);
        assertEquals(this.expected, this.bracelet);

        this.testNextConnections(this.expected, this.bracelet);
        this.testPrevConnections(this.expected, this.bracelet);

    }

    @Test
    void testRemoveEntryThrowsErrorWhenRequestedElementIsNotInBracelet() {

        String expected = "Violation of: x is in this";

        AssertionError e = assertThrows(AssertionError.class,
                () -> this.bracelet.removeEntry("this element does not exist"),
                "Expecting AssertionError due to this.bracelet not containing the requested element given to removeEntry(T x)");

        assertEquals(expected, e.getMessage());

    }

    /**
     * Tests the removeNthNextItem() method. Expects removed element equality
     * with a pre-made element of the expected output. Expects
     * {@code this.bracelet} equality to a pre-made Bracelet of the expected
     * elements. Expects equality of {@code Node} connections in
     * {@code this.bracelet} and the pre-made Bracelet with the expected
     * elements, for both the {@code next} and {@code prev] connections.
     */
    @Test
    void testRemoveNthNextItem() {

        final int removalPosition = 15;

        this.expected.add("this");
        this.expected.add("is");
        this.expected.add("test");

        String expectedRemovedElement = "a";

        this.bracelet.movePointerToFront();
        String testRemovedElement = this.bracelet.removeNthNextItem(removalPosition);

        assertEquals(expectedRemovedElement, testRemovedElement);
        assertEquals(this.expected, this.bracelet);

        this.testNextConnections(this.expected, this.bracelet);
        this.testPrevConnections(this.expected, this.bracelet);
    }

    @Test
    void testRemoveNthNextItemThrowsErrorWhenNIsLessThanZero() {

        String expected = "Violation of: n > 0";

        AssertionError e = assertThrows(AssertionError.class,
                () -> this.bracelet.removeNthNextItem(-1),
                "Expecting AssertionError due to an integer less than 0 being provided to removeNthNextItem(int x)");

        assertEquals(expected, e.getMessage());

    }

}
