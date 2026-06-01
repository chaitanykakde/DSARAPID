import java.util.*;

public class SoftDrinking151A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bottles = sc.nextInt();
        int l = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int nl = sc.nextInt();
        int np = sc.nextInt();

        int tataldrinkforeach = (bottles * l) / n;
        int totalsaltforeach = p / n;
        int slicesForEach = (c * d) / n;
        int count = 0;
        while (tataldrinkforeach >= nl && totalsaltforeach >= np && slicesForEach >= 1) {
            totalsaltforeach -= np;
            tataldrinkforeach -= nl;
            slicesForEach -= 1;
            count++;

        }

        System.out.println(count);

    }
}
