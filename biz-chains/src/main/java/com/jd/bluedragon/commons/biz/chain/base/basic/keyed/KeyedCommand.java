package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

import com.jd.bluedragon.commons.biz.chain.base.basic.AbstractCommand;

public abstract class KeyedCommand<T extends KeyedContext> extends AbstractCommand<T> {


    public KeyedCommand(String name) {
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