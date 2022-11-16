package com.airblock.commons.biz.chain.base.basic.keyed;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WaybillSign {
    // 国际快递
    INTERNATIONAL_DELIVERY("boardCross"),
    // 小包
    EC_SMALL_PACKAGE_DELIVERY("ec"),
    // FBA
    FBA("fba"),
    // 分拣机
    KeJie_SORTER("kejie");

    private String mark;
}
