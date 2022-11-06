package com.jd.bluedragon.commons.biz.chain.base;


public interface Chain<T extends KeyedContext> extends Command<T> {

    void addCommand(Command<T> command);

    boolean execute(T context) throws Exception;


}
