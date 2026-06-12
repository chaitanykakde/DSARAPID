package LargeNumbers;

import java.math.*;

public class BigDecimalClass {
    public static void main(String[] args) {
        BigDecimal d = new BigDecimal("0.04");
        BigDecimal e = new BigDecimal("0.03");
        BigDecimal ans = d.subtract(e);
        System.out.println(ans.doubleValue());

        BigDecimal dd = new BigDecimal("482323420094.0849384934");
        BigDecimal ee = new BigDecimal("434234830.04930943");

        System.out.println(dd.add(ee));
        System.out.println(dd.subtract(ee));
        System.out.println(dd.divide(ee, 10, RoundingMode.HALF_DOWN));
        System.out.println(dd.multiply(ee));
        System.out.println(dd.pow(2));
        System.out.println(dd.negate());

    }
}
