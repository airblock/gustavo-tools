package com.airblock.commons.biz.chain.base.basic;


import com.airblock.commons.biz.chain.base.Command;
import com.airblock.commons.biz.chain.base.Context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface CacheableCommand<T extends Context> extends Command<T> {

    Map<String, CacheableCommand> commandMapper
            = new ConcurrentHashMap<>();

    default void markCommand(String key, CacheableCommand<T> command) {
        synchronized (commandMapper) {
            if (!commandMapper.containsKey(key)) {
                commandMapper.put(key, command);
            }
        }
    }

}