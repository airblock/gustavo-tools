package com.jd.bluedragon.commons.biz.chain.base.basic.wrapper;

import com.jd.bluedragon.commons.biz.chain.base.BizContext;
import com.jd.bluedragon.commons.biz.chain.base.Command;
import com.jd.bluedragon.commons.biz.chain.base.Filter;

public abstract class CommandWrapper<T extends BizContext> implements Command<T>, Filter<T> {
    @Override
    public boolean execute(T context) throws Exception {
        if (!doSupport(context)) {
            return false;
        }
        processBefore(context);
        return doExecute(context);
    }

    protected abstract boolean doSupport(T context);

    protected abstract void processBefore(T context);

    protected abstract boolean doExecute(T context) throws Exception;
}