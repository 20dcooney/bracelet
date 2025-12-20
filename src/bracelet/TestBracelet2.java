package bracelet;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> list = new ArrayList<>();

        System.out.println();

        System.out.println("Bracelet toString: " + bracelet.toString());
        System.out.println("List toString: " + list.toString());

        System.out.println();
        System.out.println("Flattening Bracelet into an ArrayList");
        System.out.println();

        list = bracelet.flatten();
        System.out.println("Bracelet toString: " + bracelet.toString());
        System.out.println("List toString: " + list.toString());
    }

}
