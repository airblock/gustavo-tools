package com.airblock.commons.biz.chain.base.basic.keyed.dmsOrderReceived;

import com.airblock.commons.biz.chain.base.basic.keyed.KeyedCacheableCommand;

public class ReportTableCommand extends KeyedCacheableCommand<OrderReceiveContext> {
    public ReportTableCommand(String name) {
        super(name);
    }

    @Override
    protected boolean doExecute(OrderReceiveContext context) throws Exception {
        return false;
    }
}
