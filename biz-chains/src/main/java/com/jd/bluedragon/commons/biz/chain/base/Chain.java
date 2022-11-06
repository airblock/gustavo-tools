package com.jd.bluedragon.commons.biz.chain.base;


public interface Chain<T extends BizContext> extends Command<T> {

    void addCommand(Command<T> command);

    boolean execute(T context) throws Exception;


}
