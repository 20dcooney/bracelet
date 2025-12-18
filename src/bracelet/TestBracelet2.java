package bracelet;

public class TestBracelet2 {

    public static void main(String[] args) {

        Bracelet<Character> bracelet = new BraceletList<>();

        String charStr = "Hello there!";
        int count = charStr.length();

        for (int i = 0; i < count; i++) {
            bracelet.add(charStr.charAt(i));
        }

        System.out.println(bracelet.toString());

        System.out.println("Polling front of the bracelet: " + bracelet.pollFront());

        System.out.println(bracelet.toString());

        System.out.println("Polling end of the bracelet: " + bracelet.pollEnd());

        System.out.println(bracelet.toString());

        char polling = bracelet.pollPosition(7);

        System.out.println("Polling position 7 of the bracelet: " + polling);

        System.out.println(bracelet.toString());

        bracelet.movePointerRight();

        System.out.println(bracelet.remove());

        System.out.println(bracelet.toString());

    }

}
