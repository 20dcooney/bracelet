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

    @Test
    void testAddNextAndPrevNodes() {

        assertEquals(this.bracelet.pollPointerPosition(), "this");

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

}
