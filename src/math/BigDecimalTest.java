package math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author zhangyong created on 2020/8/7
 **/
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("999.77");
        BigDecimal b = new BigDecimal("999.78");
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        System.out.println(a.add(b));
        System.out.println(new BigDecimal("9.9").equals(new BigDecimal("9.9")));
        System.out.println(new BigDecimal(1131424 / (60 * 60 * 1000)));
        System.out.println(BigDecimal.valueOf((double)1131424 / (double)(60 * 60 * 1000)));
        System.out.println(new BigDecimal(1131424).divide(new BigDecimal(60 * 60 * 1000), RoundingMode.HALF_EVEN));
        BigDecimal workTime = BigDecimal.valueOf((double)1131424 / (double)(60 * 60 * 1000));
        BigDecimal salaryAmount = BigDecimal.valueOf(111.23);
        BigDecimal realSalary = workTime.multiply(salaryAmount);
        System.out.println(realSalary);
        System.out.println(realSalary.setScale(2, RoundingMode.HALF_EVEN));



    }
}
