import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factIterative(new BigInteger("234567")));
    }

    public static BigInteger fact(BigInteger n) {
        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return n.multiply(fact(n.subtract(BigInteger.ONE)));
    }

    public static BigInteger factIterative(BigInteger n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n.intValue(); i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
