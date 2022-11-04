package com.jd.bluedragon.commons.biz.chain.base;


public interface Command<T extends BizContext> {
    boolean execute(T context) throws Exception;

}
