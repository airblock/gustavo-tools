package com.jd.bluedragon.commons.biz.chain.base.basic;

import com.jd.bluedragon.commons.biz.chain.base.CacheableCommand;
import com.jd.bluedragon.commons.biz.chain.base.Context;

public abstract class AbstractCacheableCommand<T extends Context> implements CacheableCommand<T> {

    public AbstractCacheableCommand(String name) {
        markCommand(name, this);
    }
}
