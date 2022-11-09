package com.jd.bluedragon.commons.biz.chain.base;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface Command<T extends Context> {

    default boolean postprocess(T context, Exception saveException){
        return true;
    }

    boolean execute(T context) throws Exception;
}