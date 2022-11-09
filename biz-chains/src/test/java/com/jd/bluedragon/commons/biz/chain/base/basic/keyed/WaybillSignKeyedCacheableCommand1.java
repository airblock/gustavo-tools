package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

public class WaybillSignKeyedCacheableCommand1 extends KeyedCacheableCommand<WaybillSignKeyedContext> {

    public WaybillSignKeyedCacheableCommand1(String name) {
        super(name);
    }

    @Override
    protected boolean doExecute(WaybillSignKeyedContext context) throws Exception {
        System.out.println("invoking WaybillSignKeyedCommand1 by key = " + context.key());
        System.out.println("parameters= " + context.getParameters());
        return true;
    }
}
