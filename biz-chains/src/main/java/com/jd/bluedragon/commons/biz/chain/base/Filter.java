package com.jd.bluedragon.commons.biz.chain.base;

public interface Filter<T extends BizContext> {
    boolean postprocess(T context, Exception saveException);
}
