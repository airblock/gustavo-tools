package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

public class WaybillSignKeyedCommand2 extends KeyedCommand<WaybillSignKeyedContext> {

    public WaybillSignKeyedCommand2(String name) {
        super(name);
    }

    @Override
    protected boolean doExecute(WaybillSignKeyedContext context) throws Exception {
        System.out.println("invoking WaybillSignKeyedCommand2 by key = " + context.key());
        return true;
    }
}
