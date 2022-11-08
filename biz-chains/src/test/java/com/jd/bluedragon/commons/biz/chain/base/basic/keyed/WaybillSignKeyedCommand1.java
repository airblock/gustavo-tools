package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

public class WaybillSignKeyedCommand1 extends KeyedCommand<WaybillSignKeyedContext> {

    public WaybillSignKeyedCommand1(String name) {
        super(name);
    }

    @Override
    protected boolean doExecute(WaybillSignKeyedContext context) throws Exception {
        System.out.println("invoking WaybillSignKeyedCommand1 by key = " + context.key());
        System.out.println("parameters= " + context.getParameters());
        return true;
    }
}
