package bracelet;

public class TestBracelet2 {

    public static void main(String[] args) {

        Bracelet<Integer> bracelet = new BraceletList<>();

        for (int i = 1; i <= 5; i++) {
            bracelet.add(i);
        }

        System.out.println(bracelet.toString());

        for (int i = 0; i < bracelet.length(); i++) {

            System.out.println("Bracelet's pointer is currently pointing to: "
                    + bracelet.pollPointerPosition());

            bracelet.movePointerRight();

        }

        System.out.println(bracelet.getClass());

    }

}
