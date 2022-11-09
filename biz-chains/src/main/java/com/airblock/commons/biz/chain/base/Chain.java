package com.airblock.commons.biz.chain.base;


public interface Chain<T extends Context> extends CacheableCommand<T> {

    void addCommand(CacheableCommand command);

    boolean execute(T context) throws Exception;

}
