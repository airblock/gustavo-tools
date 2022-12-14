package com.airblock.commons.biz.chain.base.basic.keyed;

public class WaybillSignKeyedCacheableCommand2 extends KeyedCacheableCommand<WaybillSignKeyedContext> {

    public WaybillSignKeyedCacheableCommand2(String name) {
        super(name);
    }

    @Override
    protected boolean doExecute(WaybillSignKeyedContext context) throws Exception {
        System.out.println("invoking WaybillSignKeyedCommand2 by key = " + context.key());
        return true;
    }
}
