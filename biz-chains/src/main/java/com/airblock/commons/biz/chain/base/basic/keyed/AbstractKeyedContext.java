package com.airblock.commons.biz.chain.base.basic.keyed;

import lombok.AllArgsConstructor;

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
