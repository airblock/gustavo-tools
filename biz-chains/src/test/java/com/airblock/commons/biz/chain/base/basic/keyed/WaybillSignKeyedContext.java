package com.airblock.commons.biz.chain.base.basic.keyed;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WaybillSignKeyedContext extends AbstractKeyedContext<WaybillSign> {

    private Object parameters;

    public WaybillSignKeyedContext(WaybillSign key) {
        super(key);
    }
}
