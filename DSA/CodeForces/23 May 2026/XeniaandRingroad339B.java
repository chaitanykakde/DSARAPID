import java.util.*;

public class XeniaandRingroad339B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int curr_house = 1;
        long time = 0;
        for (int i = 1; i <= m; i++) {
            int taskHouse = sc.nextInt();
            if (taskHouse > curr_house) {
                time += taskHouse - curr_house;
                curr_house = taskHouse;
            } else if (taskHouse < curr_house) {
                int newTime = n - curr_house + 1;
                newTime += taskHouse - 1;
                time += newTime;
                curr_house = taskHouse;

            }
        }
        System.out.println(time);
    }
}
