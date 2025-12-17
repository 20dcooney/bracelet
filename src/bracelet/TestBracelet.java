package bracelet;

/**
 * A test class for the Bracelet data type.
 *
 * @author David Cooney
 */
public class TestBracelet {

    public static void main(String[] args) {

        Bracelet<String> bracelet = new BraceletList<>();

        bracelet.add("Hello");

        bracelet.add("Hi Mini!");

        bracelet.add("Hi Lynxsys!");
    }
}
