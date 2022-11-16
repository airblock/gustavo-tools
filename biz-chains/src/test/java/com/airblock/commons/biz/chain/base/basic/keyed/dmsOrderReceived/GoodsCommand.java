package com.airblock.commons.biz.chain.base.basic.keyed.dmsOrderReceived;

import com.airblock.commons.biz.chain.base.basic.keyed.KeyedCacheableCommand;

public class GoodsCommand extends KeyedCacheableCommand<OrderReceiveContext> {
    public GoodsCommand(String name) {
        super(name);
    }

    @Override
    protected boolean doExecute(OrderReceiveContext context) throws Exception {
        return false;
    }
}
