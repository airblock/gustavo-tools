package com.jd.bluedragon.commons.biz.chain.base;


public interface Chain<T extends Context> extends Command<T> {

    void addCommand(Command command);

    boolean execute(T context) throws Exception;

}
