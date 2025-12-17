package bracelet;

/**
 * A test class for the Bracelet data type. This is a temporary test class, and
 * a more comprehensive and complete JUnit test class will be made in the
 * future.
 *
 * @author David Cooney
 */
public class TestBracelet {

    public static void main(String[] args) {

        Bracelet<String> bracelet = new BraceletList<>();

        bracelet.add("Hello");

        bracelet.add("Hi Mini!");

        bracelet.add("Hi Lynxsys!");

        System.out.println(bracelet.toString());

        String testingRemove = bracelet.removeFromEnd();

        System.out.println("Removed item: " + testingRemove);
        System.out.println(bracelet.toString());

        String stringToAddToEnd = "Hello Twin!";
        bracelet.addToEnd(stringToAddToEnd);
        System.out.println("Adding following item to end: " + stringToAddToEnd);
        System.out.println(bracelet.toString());

        Bracelet<Integer> numberBracelet = new BraceletList<>();

        for (int i = 1; i <= 10; i++) {
            numberBracelet.add(i);
        }

        System.out.println(numberBracelet.toString());

        for (int i = 1; i <= 3; i++) {
            numberBracelet.movePointerRight();
        }

        int removedItem = numberBracelet.removeNthNextItem(14);

        System.out.println("Removed item: " + removedItem);
        System.out.println(numberBracelet.toString());

    }
}
