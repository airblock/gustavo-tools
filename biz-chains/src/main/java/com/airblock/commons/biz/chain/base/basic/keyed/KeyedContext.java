package com.airblock.commons.biz.chain.base.basic.keyed;

import com.airblock.commons.biz.chain.base.Context;

public interface KeyedContext<T extends Object> extends Context {
    T key();
}
