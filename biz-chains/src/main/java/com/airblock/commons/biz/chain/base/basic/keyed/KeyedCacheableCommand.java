package com.airblock.commons.biz.chain.base.basic.keyed;

import com.airblock.commons.biz.chain.base.basic.AbstractCacheableCommand;

public abstract class KeyedCacheableCommand<T extends KeyedContext> extends AbstractCacheableCommand<T> {
    public KeyedCacheableCommand(String name) {
        super(name);
    }
    @Override
    public boolean postprocess(T context, Exception saveException) {
        return true;
    }
    @Override
    public boolean execute(T context) throws Exception {
        if (!doSupport(context)) {
            return false;
        }
        return doExecute(context);
    }
    protected boolean doSupport(T context){
        return true;
    }
    protected abstract boolean doExecute(T context) throws Exception;
}
