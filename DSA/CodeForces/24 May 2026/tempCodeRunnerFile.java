import java.util.*;

public class SimonsandMakingItBeautiful2205A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // trak the max and small ugly element indexes
            int max = -1;
            int small = -1;
            int maxElement = -1;

            for (int i = 0; i < n; i++) {
                maxElement = Math.max(maxElement, arr[i]);
                if ((i + 1) == maxElement) {
                    // ugly index fount
                    // now need to see if the max is -1
                    if (max == -1 && small == -1) {
                        max = i;
                    } else if (small == -1) {
                        // this means we found the another bigger ugly index
                        small = max;
                        max = i;
                    } else {
                        // both are assigned already now just compare and assign
                        max = i;
                    }
                }

            }

            // now we have the biggest ugly index and the smallest ugly index
            // if max==-1 then there is no ugly index
            // if(max!=-1) and small==-1 then there is only one ugly index
            // if both !=-1 then we have the smallest and biggest ugly index

            // if there is 1 ugly index
            // if (max != -1 && small == -1) {
            // // now there is only one ugly index then just we can swap this
            // // note we need to swap this as this shoudl nto create the new ugly index
            // okay
            // // so
            // if (max > 0) {
            // swap(arr, max, 0);
            // } else {
            // swap(arr, max, arr.length - 1);
            // }
            // } else

            // nwo the next case that we have the 2 ugly indexes okay so what we acan do
            // swap them okay
            if (max != -1 && small != -1) {
                swap(arr, max, small);
            }
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int[] arr, int max, int i) {
        int temp = arr[max];
        arr[max] = arr[i];
        arr[i] = temp;
    }
}
