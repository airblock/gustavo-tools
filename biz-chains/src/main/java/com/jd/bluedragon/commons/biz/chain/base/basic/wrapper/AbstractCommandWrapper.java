package com.jd.bluedragon.commons.biz.chain.base.basic.wrapper;

import com.jd.bluedragon.commons.biz.chain.base.BizContext;

public abstract class AbstractCommandWrapper<T extends BizContext> extends CommandWrapper<T> {
    @Override
    public boolean postprocess(T context, Exception saveException) {
        return false;
    }

    @Override
    protected boolean doSupport(T context) {
        return false;
    }

    @Override
    protected void processBefore(T context) {

    }
}
