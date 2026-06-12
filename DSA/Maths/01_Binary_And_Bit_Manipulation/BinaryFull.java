
import java.util.*;
import java.util.logging.Filter;

class BinaryFull {

    public static String DecimalToBinaryBuiltIn(int n) {
        return Integer.toBinaryString(n);
    }

    public static String DecimalToBinary(int n) {
        String s = "";
        while (n > 0) {
            int rem = n % 2;
            s = rem + s;
            n = n / 2;
        }
        return s;
    }

    public static int BinaryToDecimal(String s) {
        int sum = 0;
        int pow = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int bit = s.charAt(i) - '0';
            sum += bit * Math.pow(2, pow);
            pow++;
        }

        return sum;

    }

    public static int BinaryToDecimalBuiltIn(String s) {
        int sum = 0;
        sum = Integer.parseInt(s, 2);
        return sum;
    }

    public static void MSBaLSBaBitCount(String s) {
        System.out.println("MSB:" + s.charAt(0));
        System.out.println("LSB:" + s.charAt(s.length() - 1));
        System.out.println("Set Bit Count :" + Integer.bitCount(Integer.parseInt(s, 2)));

    }

    // print the numbers which are the power of 2
    public static ArrayList PowerOf2Visual(int[] arr) {
        ArrayList<Integer> ans = new ArrayList();
        for (int x : arr) {
            String binary = Integer.toBinaryString(x);
            if (Integer.bitCount(x) == 1) {
                ans.add(x);
            }
        }
        return ans;
    }

    public static ArrayList PowerOf2Efficient(int[] arr) {
        ArrayList<Integer> ans = new ArrayList();
        for (int x : arr) {
            if ((x & (x - 1)) == 0) {
                ans.add(x);
            }
        }
        return ans;
    }

    public static void subsetsUsingBinary(int n) {
        ArrayList<ArrayList<Character>> sets = new ArrayList<>();
        String s = "ABC";
        for (int i = 0; i < (1 << n); i++) {
            sets.add(new ArrayList<Character>());
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sets.get(i).add(s.charAt(j));

                }
            }
        }
        for (ArrayList<Character> x : sets) {
            System.out.println(x);
        }
    }

    // subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }

        return ans;
    }

    public static int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = arr[i >> 1] + (i & 1);
        }
        return arr;
    }

    // Given two integers left and right that represent the
    // range [left, right], return the bitwise AND of all numbers in this range,
    // inclusive.
    public static int rangeBitwiseAnd(int left, int right) {
        int result = left;
        int shifts = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shifts++;
        }
        int ans = left << shifts;

        return ans;
    }

    public static int minFlips(int a, int b, int c) {
        int flips = 0;

        while (a > 0 || b > 0 || c > 0) {
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;

            if (aBit == 0 && bBit == 0) {
                flips++;
            }
            if (cBit == 1) {

            } else {
                flips = flips + aBit + bBit;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }

    public static void AllBitOperations(int n) {
        // get ith bit
        int i = 0;
        System.out.println((((n & (1 << i)) >> i)));

        // force ith bit to be 1
        System.out.println((n | (1 << i)));

        // force ith bit to be 0
        System.out.println(n);
        System.out.println((n & ~(1 << i)));

        // 4. TOGGLE ith BIT
        // 0 to 1 and 1 to 0
        System.out.println((n ^ (1 << 2)));

        // check even or odd
        if ((n & 1) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        // 6. MULTIPLY BY 2
        System.out.println((n << 1));
        // 7. DIVIDE BY 2
        System.out.println(n >> 1);

        // 8. CHECK POWER OF 2
        System.out.println((n & (n - 1)));

        // 9. REMOVE RIGHTMOST SET BIT
        System.out.println(n & (n - 1));

        // 10. EXTRACT RIGHTMOST SET BIT
        System.out.println(n & (-n));

        // 11. COUNT SET BITS
        int count = 0;
        int num = n;
        while (num > 0) {

            count += (num & 1);

            num >>= 1;
        }
        System.out.println(count);
        int a = 1;
        int b = 2;
        // 12. SWAP WITHOUT TEMP
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("A:" + a + " B:" + b);

        // 15. TURN OFF LOWEST SET BIT REPEATEDLY
        System.out.println(n = n & (n - 1));

        // 16. XOR IMPORTANT IDENTITIES
        // a ^ a =0
        // a ^0 =a
        // a^b =b^a
        // (a^b)^c =a^(b^c)

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 6, 8, 16, 32, 64, 100 };
        // decimal to binary
        // System.out.println("Decimal to Binary :"+DecimalToBinary(13));
        // System.out.println("Decimal to Binary Built In:"+DecimalToBinaryBuiltIn(13));

        // System.out.println("Binary to Decimal :"+BinaryToDecimal("1101"));
        // System.out.println("Binary to Decimal :"+BinaryToDecimalBuiltIn("1101"));
        // MSBaLSBaBitCount("1101");

        // System.out.println(PowerOf2Efficient(arr));
        // System.out.println(1<<5);
        // subsetsUsingBinary(3);
        // System.out.println(Arrays.toString(countBits(8)));
        /// System.out.println("Range Result:"+rangeBitwiseAnd(1, 2147483647));
        // System.out.println(minFlips(2, 6, 5));
        AllBitOperations(5);

    }
}