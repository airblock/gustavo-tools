package com.jd.bluedragon.commons.biz.chain.base.basic.keyed;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public abstract class AbstractKeyedContext<T extends Object> implements KeyedContext<T> {

    private AbstractKeyedContext() {
    }

    private T key;

    @Override
    public T key() {
        return key;
    }
}
