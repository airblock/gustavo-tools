package com.airblock.commons.biz.chain.base;


public interface Chain<T extends Context> extends Command<T> {

    void addCommand(Command command);

    @Override
    boolean execute(T context) throws Exception;

}
