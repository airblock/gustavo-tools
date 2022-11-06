package com.jd.bluedragon.commons.biz.chain.base;

import java.util.Iterator;

public interface Catalog<T extends Object, K extends BizContext> {

    void addChain(T key, Chain<K> chain);

    Chain<K> getChain(T key);

    Iterator<T> getNames();
}