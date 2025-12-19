package bracelet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BraceletTest {

    Bracelet<String> bracelet;

    @BeforeEach
    void setUp() {
        this.bracelet = new BraceletList<>();

        this.bracelet.add("this");
        this.bracelet.add("is");
        this.bracelet.add("a");
        this.bracelet.add("test");
    }

    @Test
    void testAddNextAndPrevNodes() {

        assertEquals(this.bracelet.pollPointerPosition(), "this");

    }

}
