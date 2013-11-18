package src.mn.mini.core.util;

import java.math.BigDecimal;


public class BigDecimalUtil {
    private static final int MAX_SCALE = 6;
    private static final int ROUND_MODE = BigDecimal.ROUND_HALF_UP;

    public BigDecimalUtil() {
        super();
    }

    public static boolean isZero(BigDecimal value) {
        if (value == null) {
            return true;
        }
        return isZero(value, MAX_SCALE);
    }

    public static boolean isZero(BigDecimal value, int scale) {
        return isZero(value, scale, ROUND_MODE);
    }

    public static boolean isZero(BigDecimal value, int scale, int roundMode) {
        value = value.setScale(scale, roundMode);
        return value.compareTo(BigDecimal.ZERO) == 0;
    }

    public static BigDecimal multiply(BigDecimal multiplier, BigDecimal multiplicand) {
        return multiply(multiplier, multiplicand, MAX_SCALE);
    }

    public static BigDecimal multiply(BigDecimal multiplier, BigDecimal multiplicand, int scale) {
        return multiply(multiplier, multiplicand, scale, ROUND_MODE);
    }

    public static BigDecimal multiply(BigDecimal multiplier, BigDecimal multiplicand, int scale, int roundMode) {
        if (multiplier == null || multiplicand == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal returnVal = multiplier.multiply(multiplicand);
        return returnVal.setScale(scale, roundMode);
    }

    public static BigDecimal divide(BigDecimal divident, BigDecimal divisor) {
        return divide(divident, divisor, MAX_SCALE);
    }

    public static BigDecimal divide(BigDecimal divident, BigDecimal divisor, int scale) {
        return divide(divident, divisor, scale, ROUND_MODE);
    }

    public static BigDecimal divide(BigDecimal divident, BigDecimal divisor, int scale, int roundMode) {
        if (divident == null || isZero(divisor, scale, roundMode)) {
            return BigDecimal.ZERO;
        }

        return divident.divide(divisor, scale, roundMode);
    }
}
