package com.jd.bluedragon.commons.biz.chain.base.basic.wrapper;

import com.jd.bluedragon.commons.biz.chain.base.KeyedContext;
import com.jd.bluedragon.commons.biz.chain.base.Command;

public abstract class CommandWrapper<T extends KeyedContext> implements Command<T> {
    @Override
    public boolean postprocess(T context, Exception saveException) {
        return Command.super.postprocess(context, saveException);
    }

    @Override
    public boolean execute(T context) throws Exception {
        if (!doSupport(context)) {
            return false;
        }
        processBefore(context);
        return doExecute(context);
    }

    protected boolean doSupport(T context){
        return true;
    }

    protected abstract void processBefore(T context);

    protected abstract boolean doExecute(T context) throws Exception;
}