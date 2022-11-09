package com.airblock.commons.biz.chain.base;


public interface Command<T extends Context> {

    default boolean postprocess(T context, Exception saveException){
        return true;
    }

    boolean execute(T context) throws Exception;
}