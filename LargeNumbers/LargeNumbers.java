import java.math.BigInteger;

public class LargeNumbers {
    public static void main(String[] args) {
        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(a);
        BigInteger B = BigInteger.valueOf(b);

        BigInteger C = new BigInteger("938432429384944904832394343343");

        // constants
        BigInteger D = BigInteger.TEN;

        // addition
        BigInteger s = A.add(B);
        System.out.println(C);

        // convert Biginteger to Int
        int x = A.intValue();

        BigInteger m = C.multiply(new BigInteger("3434334"));

        System.out.println(m);
        BigInteger add = m.add(A);
        BigInteger sub = m.subtract(A);
        BigInteger mul = m.multiply(A);
        BigInteger div = m.divide(A);
        BigInteger rem = m.remainder(A);

        System.out.println(add);
        System.out.println(sub);
        System.out.println(rem);

        if (m.compareTo(A) < 0) {
            System.out.println("A is smaller");
            System.out.println("M is Bigger");
        } else {
            System.out.println("A is Bigger");
            System.out.println("M is smaller");

        }

    }
}
