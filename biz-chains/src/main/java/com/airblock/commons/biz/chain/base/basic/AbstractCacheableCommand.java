package com.airblock.commons.biz.chain.base.basic;

import com.airblock.commons.biz.chain.base.CacheableCommand;
import com.airblock.commons.biz.chain.base.Context;

public abstract class AbstractCacheableCommand<T extends Context> implements CacheableCommand<T> {

    public AbstractCacheableCommand(String name) {
        markCommand(name, this);
    }
}
