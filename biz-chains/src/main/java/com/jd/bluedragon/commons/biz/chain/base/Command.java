package com.jd.bluedragon.commons.biz.chain.base;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface Command<T extends KeyedContext> {

    Map<String, Command<KeyedContext>> commandMapper
            = new ConcurrentHashMap<>();

    default void markCommand(String key, Command<KeyedContext> command) {
        synchronized (commandMapper) {
            if (!commandMapper.containsKey(key)) {
                commandMapper.put(key, command);
            }
        }
    }

    default boolean postprocess(T context, Exception saveException){
        return true;
    }

    boolean execute(T context) throws Exception;
}