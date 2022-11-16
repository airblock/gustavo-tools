package com.airblock.commons.biz.chain.base.basic.keyed;

import org.junit.Test;

import java.math.BigDecimal;

public class DecimalTest {

    @Test
    public void test1() {
        BigDecimal bigDecimal = new BigDecimal(1.50000);
        System.out.println(bigDecimal.scale());
        bigDecimal.setScale(10);
        System.out.println(bigDecimal.precision());
    }

}
