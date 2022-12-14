package com.airblock.commons.biz.chain.base;

import java.util.Iterator;

public interface Catalog<T extends Object, K extends Context> {

    void addChain(T key, Chain<K> chain);

    Chain<K> getChain(T key);

    Iterator<T> getNames();

}