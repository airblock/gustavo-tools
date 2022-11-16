package com.airblock.commons.biz.chain.base.basic.keyed.dmsOrderReceived;

import com.airblock.commons.biz.chain.base.basic.keyed.AbstractKeyedContext;
import com.airblock.commons.biz.chain.base.basic.keyed.KeyedContext;
import com.airblock.commons.biz.chain.base.basic.keyed.WaybillSign;

public class OrderReceiveContext extends AbstractKeyedContext<WaybillSign> {

    public OrderReceiveContext(WaybillSign key) {
        super(key);
    }
}
