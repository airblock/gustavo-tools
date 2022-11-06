package com.jd.bluedragon.commons.biz.chain.base;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface Command<T extends BizContext> {

    Map<String, Command<BizContext>> commandMapper
            = new ConcurrentHashMap<>();

    default void markCommand(String key, Command<BizContext> command) {
        synchronized (commandMapper) {
            if (!commandMapper.containsKey(key)) {
                commandMapper.put(key, command);
            }
        }
    }

    default boolean postprocess(T context){
        return true;
    }

    default boolean doSupport(T context){
        return true;
    }

    boolean execute(T context) throws Exception;


}
