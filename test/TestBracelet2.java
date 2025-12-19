package bracelet;

public class TestBracelet2 {

    public static void main(String[] args) {

        Bracelet<Character> bracelet = new BraceletList<>();

        String charStr = "Hello there!";
        int count = charStr.length();

        for (int i = 0; i < count; i++) {
            bracelet.add(charStr.charAt(i));
        }

        for (int i = 0; i < bracelet.length(); i++) {

            System.out.println("Bracelet's pointer is currently pointing to: "
                    + bracelet.pollPointerPosition());

            bracelet.movePointerRight();

            //TODO - URGENT bug needs fixed with add method

        }

    }

}
