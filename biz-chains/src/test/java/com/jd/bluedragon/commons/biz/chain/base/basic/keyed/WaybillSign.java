package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WaybillSign {
    INTERNATIONAL_DELIVERY("boardCross"),
    EC_SMALL_PACKAGE_DELIVERY("ec"),
    FBA("fba"),
    KeJie_SORTER("kejie");

    private String mark;
}
