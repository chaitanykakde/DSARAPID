import java.util.*;

public class AntonandDanik734A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String in = sc.next();
        int anton = 0, danik = 0;
        for (char ch : in.toCharArray()) {
            if (ch == 'A') {
                anton++;

            } else {
                danik++;
            }
        }
        if (anton == danik) {
            System.out.println("Friendship");
        } else if (anton > danik) {
            System.out.println("Anton");
        } else {
            System.out.println("Danik");
        }
    }

}
