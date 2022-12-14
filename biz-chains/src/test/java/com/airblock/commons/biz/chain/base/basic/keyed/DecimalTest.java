package com.airblock.commons.biz.chain.base.basic.keyed;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.regex.Pattern;

public class DecimalTest {

    @Test
    public void test1() {
        BigDecimal bigDecimal = new BigDecimal(1.50000);
        System.out.println(bigDecimal.scale());
        bigDecimal.setScale(10);
        System.out.println(bigDecimal.precision());
    }

    @Test
    public void test2() {
        double d = 123456789.1000;
        String format = "^([1-9]\\d*|0)(\\.\\d{1,3})?$";
        boolean matches = Pattern.matches(format, "0.1000");
        System.out.println(matches);
        BigDecimal bigDecimal = (new BigDecimal(d)).setScale(3, RoundingMode.HALF_UP);
        String x = bigDecimal.toString();
        System.out.println(x);
        System.out.println(Pattern.matches(format, x));
    }

}
