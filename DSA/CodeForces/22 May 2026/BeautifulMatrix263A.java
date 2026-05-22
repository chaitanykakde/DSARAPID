
import java.util.Scanner;

public class BeautifulMatrix263A {
    public static void main(String[] args) {
        int n = 5;
        int row = -1;
        int col = -1;
        Scanner sc = new Scanner(System.in);
        // check current position of the 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() == 1) {
                    row = i;
                    col = j;
                    break;
                }
            }

        }
        int count = 0;
        // now check for the row first to reach the 2nd row
        // while (row != 2) {
        // if (row < 2) {
        // row++;
        // } else {
        // row--;
        // }
        // count++;
        // }
        // // now check for the col to reach at index 2
        // while (col != 2) {
        // if (col < 2) {
        // col++;
        // } else {
        // col--;
        // }
        // count++;
        // }
        count += Math.abs(row - 2) + Math.abs(col - 2);
        System.out.println(count);
    }
}