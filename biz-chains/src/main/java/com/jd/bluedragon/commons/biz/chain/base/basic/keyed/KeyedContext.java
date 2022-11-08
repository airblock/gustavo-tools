package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

import com.jd.bluedragon.commons.biz.chain.base.Context;

public interface KeyedContext<T extends Object> extends Context {

    T key();

}
