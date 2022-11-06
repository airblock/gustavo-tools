package com.jd.bluedragon.commons.biz.chain.base;

@FunctionalInterface
public interface ChainResolver<S, T extends KeyedContext> {

    Chain<T> resolve(S config);

}
